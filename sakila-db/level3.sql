use sakila;
-- 1 Viết truy vấn SQL để trả về thời lượng thuê trung bình cho từng tổ hợp diễn viên
--  và danh mục trong cơ sở dữ liệu, ngoại trừ các diễn viên chưa xuất hiện trong bất kỳ bộ phim nào trong category.


-- 2Viết truy vấn SQL để trả về tên của tất cả các diễn viên đã xuất hiện trong phim có xếp hạng 'R' và dài hơn 2 giờ, nhưng chưa bao giờ xuất hiện trong phim có xếp hạng 'G'.
	select*from film;
SELECT 
    CONCAT(a.first_name, ' ', a.last_name) AS ho_ten
FROM
    actor a
        JOIN
    film_actor fa ON a.actor_id = fa.actor_id
        JOIN
    film f ON f.film_id = fa.film_id
WHERE
    f.rating LIKE 'R' AND f.length > 120
        AND f.rating NOT LIKE 'G'
GROUP BY a.actor_id;

-- 3 Viết truy vấn SQL để trả về tên của tất cả khách hàng đã thuê hơn 10 phim trong một giao dịch, cùng với số lượng phim họ đã thuê và tổng phí thuê.
select*from rental;
SELECT 
    CONCAT(c.first_name, ' ', c.last_name) AS customer_name,
    COUNT(r.rental_id) AS SL,
    SUM(p.amount) AS amount
FROM
    customer c
        JOIN
    rental r ON c.customer_id = r.customer_id
        JOIN
    payment p ON r.rental_id = p.rental_id
GROUP BY c.customer_id , customer_name
HAVING sl > 10;
-- 4 Viết câu truy vấn SQL trả về tên tất cả khách hàng đã thuê từng phim trong một danh mục, cùng với tổng số phim đã thuê và tổng phí thuê
select*from film_category;
-- tổng số phim trong doanh muck
WITH CategoryFilmCounts AS (
    SELECT 
        fc.category_id,
        COUNT(DISTINCT f.film_id) AS total_films_in_category
    FROM 
        film_category fc
    JOIN 
        film f ON fc.film_id = f.film_id
    GROUP BY 
        fc.category_id
),
-- số lượng phim được thuê và tổng phí thuê cho mỗi khách hàng trong danh mục
CustomerFilmCounts AS (
    SELECT 
        c.customer_id,
        fc.category_id,
        COUNT(DISTINCT r.inventory_id) AS films_rented_in_category,
        SUM(p.amount) AS total_rental_fee
    FROM 
        customer c
    JOIN 
        rental r ON c.customer_id = r.customer_id
    JOIN 
        inventory i ON r.inventory_id = i.inventory_id
    JOIN 
        film f ON i.film_id = f.film_id
    JOIN 
        film_category fc ON f.film_id = fc.film_id
    JOIN 
        payment p ON r.rental_id = p.rental_id
    GROUP BY 
        c.customer_id, fc.category_id
)
SELECT 
    c.customer_id,
    CONCAT(c.first_name, ' ', c.last_name) AS customer_name,
    cfc.category_id,
    cfc.films_rented_in_category AS total_films_rented_in_category,
    cfc.total_rental_fee
FROM 
    customer c
JOIN 
    CustomerFilmCounts cfc ON c.customer_id = cfc.customer_id
JOIN 
    CategoryFilmCounts cfcnt ON cfc.category_id = cfcnt.category_id
WHERE 
    cfc.films_rented_in_category = cfcnt.total_films_in_category;

-- 5Viết một truy vấn SQL để trả về tiêu đề của tất cả các phim trong cơ sở dữ liệu đã	 được cùng một khách hàng thuê nhiều lần trong một ngày,
--  cùng với tên của những khách hàng đã thuê chúng và số lần chúng được thuê.
SELECT 
    f.title AS film_title,
    CONCAT(c.first_name, ' ', c.last_name) AS customer_name,
    r.rental_date,
    COUNT(r.rental_id) AS rental_count
FROM
    rental r
        JOIN
    inventory i ON r.inventory_id = i.inventory_id
        JOIN
    film f ON i.film_id = f.film_id
        JOIN
    customer c ON r.customer_id = c.customer_id
GROUP BY f.title , customer_name , r.rental_date
HAVING COUNT(r.rental_id) >= 1;

-- 6 Viết một truy vấn SQL để trả về tên của tất cả các diễn viên đã xuất hiện trong ít
--  nhất một bộ phim với mọi diễn viên khác trong cơ sở dữ liệu, cùng với số lượng phim họ xuất hiện cùng nhau
SELECT 
    CONCAT(a1.first_name, ' ', a1.last_name) AS actor1,
    CONCAT(a2.first_name, ' ', a2.last_name) AS actor2,
    COUNT(DISTINCT fa1.film_id) AS number_films
FROM
    actor a1
        JOIN
    film_actor fa1 ON a1.actor_id = fa1.actor_id
        JOIN
    film_actor fa2 ON fa1.film_id = fa2.film_id
        AND fa1.actor_id <> fa2.actor_id
        JOIN
    actor a2 ON fa2.actor_id = a2.actor_id
GROUP BY actor1 , actor2;
-- 7Viết truy vấn SQL để trả về tên của tất cả khách hàng đã thuê ít nhất
--  một phim từ mỗi danh mục trong cơ sở dữ liệu, cùng với số lượng phim được thuê từ mỗi danh mục


-- tạo bảng tìm số lượng thuê phim từng danh mục
WITH cte_1 AS (
    SELECT
        c.customer_id,
        c.first_name,
        c.last_name,
        ct.name AS category_name,
        COUNT(DISTINCT r.rental_id) AS num_films_rented
    FROM
        customer c
    JOIN
        rental r ON c.customer_id = r.customer_id
    JOIN
        inventory i ON r.inventory_id = i.inventory_id
    JOIN
        film_category fc ON i.film_id = fc.film_id
    JOIN
        category ct ON fc.category_id = ct.category_id
    GROUP BY
        c.customer_id,
        c.first_name,
        c.last_name,
        ct.name
),
-- bảng tìm tổng số phim
cte_2 AS (
    SELECT
        ct.name AS category_name,
        COUNT(DISTINCT f.film_id) AS total_films_in_category
    FROM
        category ct
    JOIN
        film_category fc ON ct.category_id = fc.category_id
    JOIN
        film f ON fc.film_id = f.film_id
    GROUP BY
        ct.name
)
SELECT
    cte_1.customer_id,
    cte_1.first_name,
    cte_1.last_name,
    cte_1.category_name,
    cte_1.num_films_rented,
    cte_2.total_films_in_category
FROM
    cte_1 
JOIN
    cte_2  ON cte_1.category_name = cte_2.category_name
ORDER BY
    cte_1.customer_id, cte_1.category_name;
    
-- 8 		thực hiện một truy vấn SQL để trả về tiêu đề của tất cả các phim trong cơ sở dữ liệu đã
--  được thuê hơn 100 lần nhưng chưa bao giờ được thuê bởi bất kỳ khách hàng nào đã thuê phim có xếp hạng 'G'.
select*from rental;

SELECT DISTINCT
    f.title
FROM
    film f
        JOIN
    inventory i ON f.film_id = i.film_id
        JOIN
    rental r ON i.inventory_id = r.inventory_id
        JOIN
    customer c ON r.customer_id = c.customer_id
        JOIN
    film_category fc ON f.film_id = fc.film_id
        JOIN
    category cat ON fc.category_id = cat.category_id
WHERE
    f.film_id NOT IN (SELECT DISTINCT
            f2.film_id
        FROM
            film f2
                JOIN
            inventory i2 ON f2.film_id = i2.film_id
                JOIN
            rental r2 ON i2.inventory_id = r2.inventory_id
                JOIN
            customer c2 ON r2.customer_id = c2.customer_id
                JOIN
            film_category fc2 ON f2.film_id = fc2.film_id
                JOIN
            category cat2 ON fc2.category_id = cat2.category_id
        WHERE
            cat2.name = 'G')
GROUP BY f.title
HAVING COUNT(DISTINCT r.rental_id) > 100;

-- 9 Viết truy vấn SQL để trả về tên của tất cả khách hàng đã thuê phim thuộc danh mục mà họ chưa từng thuê trước đó và cũng chưa bao giờ thuê phim dài hơn 3 giờ.
SELECT DISTINCT
    c.first_name, c.last_name
FROM
    customer c
        JOIN
    rental r ON c.customer_id = r.customer_id
        JOIN
    inventory i ON r.inventory_id = i.inventory_id
        JOIN
    film f ON i.film_id = f.film_id
        JOIN
    film_category fc ON f.film_id = fc.film_id
WHERE
    fc.category_id IN (
    -- lấy phim thuộc danh mục khách hàngh chưa thuê
    SELECT 
            fc2.category_id
        FROM
            film_category fc2
        WHERE
            fc2.film_id IN (
            -- lấy danh sác các phim mà chưa thuê
            SELECT 
                    i2.film_id
                FROM
                    inventory i2
                WHERE
                    i2.inventory_id NOT IN (SELECT DISTINCT
                            r2.inventory_id
                        FROM
                            rental r2)))
        AND f.length <= 180;       
        
        select inventory_id from rental;
        select inventory_id from inventory;
  
  --    10    Viết một truy vấn SQL để trả về tên của tất cả các diễn viên đã xuất hiện trong một bộ phim có xếp hạng 'PG-13' và dài hơn 2 giờ,
  -- đồng thời cũng đã xuất hiện trong một bộ phim có xếp hạng 'R' và thời lượng dưới 90 phút
        select*from film;
        -- điền kiện 1
WITH cte1 AS (
    SELECT distinct CONCAT(a1.first_name, ' ', a1.last_name) AS name_actor1
    FROM actor a1
    JOIN film_actor fa1 ON a1.actor_id = fa1.actor_id
    JOIN film f1 ON fa1.film_id = f1.film_id
    WHERE f1.rating LIKE 'PG-13' AND f1.length > 120
),
 -- điền kiện 2
cte2 AS (
    SELECT distinct CONCAT(a2.first_name, ' ', a2.last_name) AS name_actor2
    FROM actor a2
    JOIN film_actor fa2 ON a2.actor_id = fa2.actor_id
    JOIN film f2 ON fa2.film_id = f2.film_id
    WHERE f2.rating LIKE 'R' AND f2.length < 90
)
SELECT cte1.name_actor1 AS matching_actor_name
FROM cte1
JOIN cte2 ON cte1.name_actor1 = cte2.name_actor2;


