
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
CREATE FUNCTION points_change() RETURNS TRIGGER AS $$
    DECLARE
        boost FLOAT;
        rewards INT;
        redeems INT;
        isPromoted INT;
        added FLOAT;
        delta INT;
    BEGIN
        -- get necessary values for computation
        SELECT m.booster_factor INTO boost
        FROM NEW
            NATURAL INNER JOIN boutique_coffee.purchase
            NATURAL INNER JOIN boutique_coffee.customer
            NATURAL INNER JOIN boutique_coffee.memberlevel AS m;

        SELECT c.reward_points, c.redeem_points INTO rewards, redeems
        FROM NEW
            NATURAL INNER JOIN boutique_coffee.coffee AS c;

        SELECT count(promo.coffee_id) INTO isPromoted
        FROM NEW
            NATURAL INNER JOIN boutique_coffee.purchase
            NATURAL INNER JOIN boutique_coffee.haspromotion
            NATURAL INNER JOIN boutique_coffee.promotefor as promo;

        -- compute change in points
        added := (NEW.purchase_quantity * rewards * boost);

        IF isPromoted > 0 THEN
            added := added * 2;
        END IF;

        delta := CAST(added as INT) - (NEW.redeem_quantity * redeems);


        -- update table with requisite data
        UPDATE boutique_coffee.customer AS c
            SET total_points = total_points + delta
        FROM NEW
            NATURAL INNER JOIN boutique_coffee.purchase as p
            WHERE p.customer_id = c.customer_id;

        RETURN NEW;
    END;
    $$ LANGUAGE plpgsql;

CREATE TRIGGER adjust_points
    AFTER INSERT ON boutique_coffee.buycoffee
        FOR EACH ROW EXECUTE PROCEDURE points_change(NEW);