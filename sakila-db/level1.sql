-- 1 Viết một truy vấn SQL để trả về họ và tên của tất cả các tác nhân trong cơ sở dữ liệu.
		SELECT 
    CONCAT(c.first_name, ' ', c.last_name)
FROM
    actor c;
  -- 2  actor cả về tiêu đề của tất cả các bộ phim trong cơ sở dữ liệu, cùng với giá thuê và chi phí thay thế của chúng
SELECT 
    title, rental_rate, replacement_cost
FROM
    film;
-- -- 3Viết truy vấn SQL để trả về 5 bộ phim được thuê nhiều nhất trong cơ sở dữ liệu, cùng với số lần chúng được thuê.

SELECT 
    f.title, COUNT(r.rental_id) AS rentals
FROM
    film f
        JOIN
    inventory i ON f.film_id = i.film_id
        JOIN
    rental r ON i.inventory_id = r.inventory_id
GROUP BY title
ORDER BY rentals DESC
LIMIT 5;
-- 4 Viết truy vấn SQL để trả về thời lượng thuê trung bình cho từng danh mục phim trong cơ sở dữ liệu.
SELECT 
    c.name AS category_name,
    AVG(DATEDIFF(return_date, rental_date)) AS AVG
FROM
    category c
        JOIN
    film_category fc ON c.category_id = fc.category_id
        JOIN
    film f ON fc.film_id = f.film_id
        JOIN
    inventory i ON f.film_id = i.film_id
        JOIN
    rental r ON i.inventory_id = r.inventory_id
GROUP BY c.name	
;
-- 5 Viết truy vấn SQL trả về tên và địa chỉ của tất cả khách hàng đã thuê phim trong tháng 1 năm 2022
SELECT 
    c.last_name, a.address, a.address2
FROM
    customer c
        JOIN
    address a ON c.address_id = a.address_id
        JOIN
    rental r ON c.customer_id = r.customer_id
WHERE
    YEAR(r.rental_date) = '2006'
        AND MONTH(r.rental_date) = '2';
                
-- 6 Viết truy vấn SQL để trả về doanh thu do mỗi cửa hàng trong cơ sở dữ liệu tạo ra cho năm 2021
SELECT 
    s.store_id, a.address, SUM(p.amount) AS revenue2005
FROM
    store s
        JOIN
    address a ON s.address_id = a.address_id
        JOIN
    staff sf ON s.store_id = sf.store_id
        JOIN
    payment p ON sf.staff_id = p.staff_id
WHERE
    YEAR(p.payment_date) = '2006'
GROUP BY s.store_id , a.address;
-- 7 Viết một truy vấn SQL để trả về tên của tất cả các diễn viên đã xuất hiện trong hơn 20 bộ phim trong cơ sở dữ liệu. 
select*from film_actor;
select*from actor;
SELECT 
    CONCAT(a.first_name, ' ', a.last_name) AS NAME
FROM
    actor a
        JOIN
    film_actor fa ON a.actor_id = fa.actor_id
GROUP BY a.actor_id
HAVING COUNT(fa.actor_id) > 20;

-- 8 Viết truy vấn SQL để trả về tiêu đề của tất cả các phim trong cơ sở dữ liệu có xếp hạng 'PG-13' và dài hơn 120 phút
	SELECT 
    f.description, f.rating, f.length
FROM
    film f
WHERE
    f.rating LIKE 'PG-13' AND f.length > 120
    ;














