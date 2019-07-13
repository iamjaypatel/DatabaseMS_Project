CREATE OR REPLACE FUNCTION boutique_coffee.top_stores(k INT, x INT) RETURNS TABLE(store_id INT) AS $$
    BEGIN
        RETURN QUERY SELECT top.store_id
        FROM (SELECT totals.store_id, rank() OVER (ORDER BY totals.revenue DESC) as rank

            FROM (SELECT p.store_id, sum(p.price) AS revenue

                FROM (
                    SELECT purchase.store_id, sum(buycoffee.purchase_quantity * coffee.price) as price
                    FROM boutique_coffee.purchase
                        NATURAL INNER JOIN boutique_coffee.buycoffee
                        NATURAL INNER JOIN boutique_coffee.coffee
                        WHERE purchase.purchase_time + 30 * x * INTERVAL '1 day' >= NOW()::date
                        GROUP BY purchase.purchase_id
                ) AS p -- holds store and total price for each purchase in past x months
                GROUP BY p.store_id

            ) AS totals -- totals holds store id and

        ) AS top
        WHERE rank <= k;
    END $$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION boutique_coffee.top_customers(k INT, x INT) RETURNS TABLE(customer_id INT) AS $$
    BEGIN
        RETURN QUERY SELECT top.customer_id
        FROM (SELECT totals.customer_id, rank() OVER (ORDER BY totals.revenue DESC) as rank

            FROM (SELECT p.customer_id, sum(p.price) AS revenue

                FROM (
                    SELECT purchase.customer_id, sum(buycoffee.purchase_quantity * coffee.price) as price
                    FROM boutique_coffee.purchase
                        NATURAL INNER JOIN boutique_coffee.buycoffee
                        NATURAL INNER JOIN boutique_coffee.coffee
                        WHERE purchase.purchase_time + 30 * x * INTERVAL '1 day' >= NOW()::date
                        GROUP BY purchase.purchase_id
                ) AS p -- holds store and total price for each purchase in past x months
                GROUP BY p.customer_id

            ) AS totals -- totals holds store id and

        ) AS top
        WHERE rank <= k;
    END $$ LANGUAGE plpgsql;
