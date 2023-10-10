use sakila;
-- Viết truy vấn SQL để cập nhật giá thuê của tất cả các phim trong cơ sở dữ liệu đã được thuê hơn 100 lần, đặt giá thuê mới cao hơn 10% so với giá hiện tại.
	UPDATE film 
	SET 
		rental_rate = rental_rate * 1.1
	WHERE
		film_id IN (SELECT 
				film_id
			FROM
				(SELECT 
					f.film_id
				FROM
					film f
				JOIN inventory i ON f.film_id = i.film_id
				JOIN rental r ON i.inventory_id = r.inventory_id
				GROUP BY f.film_id
				HAVING COUNT(r.rental_id) > 100) AS subquery);
-- 2.Viết truy vấn SQL để cập nhật thời lượng thuê của tất cả các phim trong cơ sở dữ liệu đã được thuê hơn 5 lần, đặt thời lượng mới dài hơn 5% so với thời lượng hiện tại.
UPDATE film 
SET 
    length = length * 1.05
WHERE
    film_id IN (SELECT 
            film_id
        FROM
            (SELECT 
                f.film_id
            FROM
                film f
            JOIN inventory i ON f.film_id = i.film_id
            JOIN rental r ON i.inventory_id = r.inventory_id
            GROUP BY f.film_id
            HAVING COUNT(r.rental_id) > 5) AS subquery);
-- 3 Viết truy vấn SQL để cập nhật giá thuê của tất cả các phim thuộc danh mục 'Hành động' được phát hành trước năm 2005, đặt giá thuê mới cao hơn 20% so với giá hiện tại
select*from film;

UPDATE film 
SET 
    film.rental_rate = film.rental_rate * 1.2
WHERE
    film_id IN (SELECT 
            film_id
        FROM
            (SELECT 
                f.film_id
            FROM
                film f
            JOIN film_category fa ON f.film_id = fa.film_id
            JOIN category c ON fa.category_id = c.category_id
            WHERE
                c.name = 'Action'
                    AND f.release_year = 2006) AS subquery1);

-- 4 Viết truy vấn SQL để cập nhật địa chỉ email của tất cả khách hàng đã thuê phim thuộc danh mục 'Kinh dị' trong tháng 10 năm 2022,
-- --  đặt địa chỉ email mới là sự kết hợp giữa địa chỉ email hiện tại của họ và chuỗi 'kinh dị' 

select*from rental;
UPDATE customer 
SET 
    customer.email = CONCAT(customer.email, ' ', 'Horror')
WHERE
    customer.customer_id IN (SELECT DISTINCT
            r.customer_id
        FROM
            rental r
                JOIN
            inventory i ON r.inventory_id = i.inventory_id
                JOIN
            film f ON i.film_id = f.film_id
                JOIN
            film_category fc ON f.film_id = fc.film_id
                JOIN
            category c ON fc.category_id = c.category_id
        WHERE
            c.name = 'Horror'
                AND YEAR(r.rental_date) = 2005
                AND MONTH(r.rental_date) = 8);

-- 5.Viết truy vấn SQL để cập nhật giá thuê của tất cả phim trong cơ sở dữ liệu đã được hơn 10 khách hàng thuê,
--  đặt giá mới cao hơn 5% so với giá hiện tại, nhưng không cao hơn 4,00 USD.
select*from rental;
UPDATE film 
SET 
    rental_rate = LEAST(rental_rate * 1.05, 4.00)
WHERE
    film_id IN (SELECT 
            film_id
        FROM
            (SELECT 
                f.film_id
            FROM
                film f
            JOIN inventory i ON f.film_id = i.film_id
            JOIN rental r ON i.inventory_id = r.inventory_id
            GROUP BY f.film_id
            HAVING COUNT(r.rental_id) > 10) AS subquery2);

-- 6. Viết truy vấn SQL để cập nhật giá thuê của tất cả phim trong cơ sở dữ liệu có xếp hạng 'PG-13' và thời lượng hơn 2 giờ, đặt giá mới là 3,50 USD.
UPDATE film 
SET 
    film.rental_rate = 3.5
WHERE
    film.rating = 'PG-13'
        AND film.length > 120;
-- Viết truy vấn SQL để cập nhật thời lượng thuê của tất cả các phim trong danh mục 'Sci-Fi' được phát hành vào năm 2010,
--  đặt thời lượng mới bằng với thời lượng của phim tính bằng phút.

UPDATE film 
SET 
    rental_duration = length
WHERE
    film_id IN (SELECT 
            f.film_id
        FROM
            film f
                JOIN
            film_category fc ON f.film_id = fc.film_id
                JOIN
            category c ON fc.category_id = c.category_id
        WHERE
            c.name = 'Sci-Fi'
                AND YEAR(f.release_year) = 2010);

-- Viết truy vấn SQL để cập nhật địa chỉ của tất cả khách hàng sống trong cùng thành phố với một khách hàng khác có cùng họ,
-- đặt địa chỉ mới là địa chỉ nối của địa chỉ hiện tại của họ và chuỗi 'samecity'
select*from address;
UPDATE address ad 
SET 
    ad.address = CONCAT(address, ',', 'samecity')
WHERE
    ad.address_id IN (SELECT 
            address_id
        FROM
            (SELECT 
                a.address_id
            FROM
                address a
            JOIN customer c1 ON a.address_id = c1.address_id
            JOIN customer c2 ON c1.customer_id = c2.customer_id
            WHERE
                c1.last_name = c2.last_name
                    AND c1.customer_id <> c2.customer_id) AS ctequery3);

-- --  Viết truy vấn SQL để cập nhật giá thuê của tất cả các phim thuộc danh mục 'Hài kịch' được phát hành vào năm 2005 trở đi,
--  đặt giá thuê mới thấp hơn 15% so với giá hiện tại.

UPDATE film 
SET 
    film.rental_rate = rental_rate * 0.85
WHERE
    film.film_id IN (SELECT 

            film_id
        FROM
            (SELECT 
                f.film_id
            FROM
                film f
            JOIN film_category fc ON f.film_id = fc.film_id
            JOIN category c ON fc.category_id = c.category_id
            WHERE
                c.name = 'Comedy'
                    AND release_year >= 2005) AS ctequery4);

-- Viết truy vấn SQL để cập nhật giá thuê của tất cả các phim trong cơ sở dữ liệu có xếp hạng 'G'
--  và thời lượng dưới 1 giờ, đặt giá mới là 1,50 USD
	UPDATE film 
	SET 
		rental_rate = 1.5
	WHERE
		film_id IN (SELECT 
				film_id
			FROM
				(SELECT 
					f.film_id
				FROM
					film f
				WHERE
					f.rating = 'G' AND f.length < 60) AS cte);











