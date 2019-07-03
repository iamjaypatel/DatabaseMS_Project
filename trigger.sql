
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

CREATE OR REPLACE FUNCTION total_pts() RETURNS TRIGGER AS
$$
BEGIN

END;
$$ LANGUAGE PLPGSQL;

DROP TRIGGER IF EXISTS total_pts_trig ON boutique_coffee.customer;
CREATE TRIGGER total_pts_trig
    AFTER UPDATE
    ON boutique_coffee.purchase
    FOR EACH ROW
EXECUTE PROCEDURE total_pts();
