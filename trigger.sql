-- need a trigger to update the total points on insert into BuyCoffee
-- formula:
-- points_added = (BuyCoffee.Purchase_Quantity) * (BuyCoffee->Coffee.RewardPoints) * (BuyCoffee->Purchase->Customer->MemberLevel.Booster_Factor)
-- points_spent = (BuyCoffee.Redeem_Quantity) * (BuyCoffee->Coffee.RedeemPoints)
--
-- if (BuyCoffee->Purchase->HasPromotion->PromoteFor.CoffeeID == BuyCoffee.CoffeeID) > 0
-- and (BuyCoffee->Purchase->Purchase_Time) within promotion dates
-- then points_added *= 2
--
-- points_change = points_added - points_spent
-- (BuyCoffee->Purchase->Customer.Total_Points) += points_change
CREATE OR REPLACE FUNCTION points_change() RETURNS TRIGGER AS
$$
DECLARE
    boost      FLOAT;
    rewards    INT;
    redeems    INT;
    isPromoted INT;
    added      FLOAT;
    delta      INT;
    prev       INT;
    customer   INT;
BEGIN

    -- get necessary values for computation
    SELECT m.booster_factor
    INTO boost
    FROM (SELECT NEW.*) i
             NATURAL INNER JOIN boutique_coffee.purchase
             NATURAL INNER JOIN boutique_coffee.customer
             NATURAL INNER JOIN boutique_coffee.memberlevel AS m;

    SELECT c.reward_points, c.redeem_points
    INTO rewards, redeems
    FROM (SELECT NEW.*) i
         NATURAL INNER JOIN boutique_coffee.coffee AS c;

    SELECT count(promo.coffee_id)
    INTO isPromoted
    FROM (SELECT NEW.*) i
             NATURAL INNER JOIN boutique_coffee.purchase as purch
             NATURAL INNER JOIN boutique_coffee.haspromotion
             NATURAL INNER JOIN boutique_coffee.promotefor as promo
             NATURAL INNER JOIN boutique_coffee.promotion as p
             WHERE purch.purchase_time < p.end_date AND purch.purchase_time > p.start_date;

    -- compute change in points
    added := (NEW.purchase_quantity * rewards * boost);

    SELECT c.total_points
    INTO prev
    FROM (SELECT NEW.*) i
        NATURAL INNER JOIN boutique_coffee.customer as c;

    IF isPromoted > 0 THEN
        added := added * 2;
    END IF;

    delta := CAST(added as INT) - (NEW.redeem_quantity * redeems);

    IF delta < -1 * prev THEN
        SELECT p.customer_id
        INTO customer
        FROM (SELECT NEW.*) i
            NATURAL INNER JOIN boutique_coffee.purchase as p;

        RAISE EXCEPTION USING
            errcode = 'PTLOW',
            message = FORMAT('Purchase %s of coffee %s requires that customer %s spend %s points, but they only have %s', NEW.purchase_id, NEW.coffee_id, customer, delta, prev),
            hint = 'reduce the value of the Redeem_Quantity column';
    END IF;

    -- update table with requisite data
    UPDATE boutique_coffee.customer AS c
    SET total_points = total_points + delta
    FROM (SELECT NEW.*) i
             NATURAL INNER JOIN boutique_coffee.purchase as p
             where c.customer_id = p.customer_id;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS adjust_points_insert ON boutique_coffee.buycoffee;
CREATE TRIGGER adjust_points_insert
    AFTER INSERT
    ON boutique_coffee.buycoffee
    FOR EACH ROW
EXECUTE PROCEDURE points_change();