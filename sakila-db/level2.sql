use  sakila;
 -- 1.Viết truy vấn SQL để trả về 10 khách hàng hàng đầu đã tạo ra nhiều doanh thu nhất cho cửa hàng
 -- , bao gồm tên của họ và tổng doanh thu được tạo ra.
SELECT 
    CONCAT(c.first_name, ' ', c.last_name) AS name,
    COUNT(p.amount) AS amount
FROM
    customer c
        JOIN
    payment p ON c.customer_id = p.customer_id
GROUP BY c.customer_id
ORDER BY amount DESC
LIMIT 10;

-- 2.Viết truy vấn SQL để trả về tên và thông tin liên hệ của tất cả khách hàng đã thuê phim thuộc tất cả các danh mục trong cơ sở dữ liệu.
SELECT 
    c.customer_id,
    CONCAT(c.first_name, ' ', c.last_name) AS name,
    c.email
FROM
    customer c
WHERE
    NOT EXISTS( SELECT 
            c.category_id
        FROM
            category c
        WHERE
            NOT EXISTS( SELECT 
                    NULL
                FROM
                    rental r
                        JOIN
                    inventory i ON r.inventory_id = i.inventory_id
                        JOIN
                    film_category fc ON i.film_id = fc.film_id
                WHERE
                    r.customer_id = c.customer_id
                        AND fc.category_id = c.category_id));
-- 3.Viết truy vấn SQL để trả về tiêu đề của tất cả các phim trong cơ sở dữ liệu đã được thuê ít nhất một lần nhưng chưa bao giờ được trả lại.
select*from rental;
SELECT 
    f.title
FROM
    film f
        JOIN
    inventory i ON f.film_id = i.film_id
        JOIN
    rental r ON r.inventory_id = i.inventory_id
WHERE
    return_date IS NULL
GROUP BY f.title;

-- 4. Viết một truy vấn SQL để trả về tên của tất cả các diễn viên đã xuất hiện trong ít nhất một bộ phim ở mỗi danh mục trong cơ sở dữ liệu.
WITH 
    -- Đếm số danh mục duy nhất
    -- distinct không trùng 
    category_counts AS (
        SELECT COUNT(DISTINCT category_id) AS total_categories
        FROM category
    ),
    
    -- Đếm số danh mục duy nhất cho mỗi diễn viên
    actor_category_counts AS (
        SELECT
            a.actor_id,
            COUNT(DISTINCT fc.category_id) AS actor_categories
        FROM
            actor a
            JOIN film_actor fa ON a.actor_id = fa.actor_id
            JOIN film_category fc ON fa.film_id = fc.film_id
        GROUP BY
            a.actor_id
    )
    
SELECT
    CONCAT(a.first_name, ' ', a.last_name) AS ho_ten
FROM
    actor a
    JOIN actor_category_counts acc ON a.actor_id = acc.actor_id
    JOIN category_counts cc ON acc.actor_categories = cc.total_categories;
    
    
-- 5.Viết truy vấn SQL để trả về tên của tất cả	
-- khách hàng đã thuê cùng một bộ phim nhiều lần trong một giao dịch, cùng với số lần họ đã thuê bộ phim đó                        
  
  
  -- 6. Viết truy vấn SQL để trả về tổng doanh thu do mỗi diễn viên tạo ra trong cơ sở dữ liệu, dựa trên phí thuê phim mà họ đã xuất hiện
SELECT 
    CONCAT(a.first_name, ' ', a.last_name) AS ho_ten,
    SUM(f.rental_rate) AS total_revenue
FROM
    actor a
        JOIN
    film_actor fa ON a.actor_id = fa.actor_id
        JOIN
    film f ON f.film_id = fa.film_id
GROUP BY a.actor_id
ORDER BY total_revenue DESC;
	

-- 7 Viết một truy vấn SQL để trả về tên của tất cả các diễn viên đã xuất hiện
--  trong ít nhất một bộ phim có xếp hạng 'R', nhưng chưa bao giờ xuất hiện trong một bộ phim có xếp hạng 'G'.                        
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
    f.rating LIKE 'R'
        AND f.rating NOT LIKE 'G'
GROUP BY a.actor_id;

--   8   Viết truy vấn SQL để trả về tiêu đề của tất cả các phim trong 
-- cơ sở dữ liệu đã được hơn 50 khách hàng thuê nhưng chưa bao giờ được cùng một khách hàng thuê nhiều lần
select*from rental;

SELECT  
    f.film_id,
    f.title,
    COUNT(DISTINCT r.customer_id) AS customer_rentals
FROM
    film f
        JOIN
    inventory i ON f.film_id = i.film_id
        JOIN
    rental r ON i.inventory_id = r.inventory_id
GROUP BY f.film_id
HAVING COUNT(DISTINCT r.customer_id) > 50
   AND COUNT(r.rental_id) = COUNT(DISTINCT r.rental_id);

 -- 9 Viết truy vấn SQL để trả về tên của tất cả khách hàng đã thuê phim từ danh mục mà họ chưa từng thuê trước đó.                        
SELECT DISTINCT
    CONCAT(c.first_name, ' ', c.last_name) AS name
FROM
    customer c
        JOIN
    rental r ON c.customer_id = r.customer_id
        JOIN
    inventory i ON r.inventory_id = i.inventory_id
        JOIN
    film_category fc ON i.film_id = fc.film_id
        JOIN
    category cat ON fc.category_id = cat.category_id
WHERE
-- tim phim khach da thue va loai bo
    cat.category_id NOT IN (SELECT 
            fc2.category_id
        FROM
            rental r2
                JOIN
            inventory i2 ON r2.inventory_id = i2.inventory_id
                JOIN
            film_category fc2 ON i2.film_id = fc2.film_id
        WHERE
            r2.customer_id = c.customer_id);

    
    
    
   --  10 Viết một truy vấn SQL để trả về tiêu đề của tất cả các phim trong cơ sở dữ liệu
   -- đã được thuê bởi mọi khách hàng đã từng thuê phim thuộc danh mục 'Action'.
    select*from inventory;
SELECT 
    film.title
FROM
    film
WHERE
    film.film_id NOT IN (SELECT DISTINCT
            f.film_id
        FROM
            film f
        WHERE
            f.film_id NOT IN (SELECT DISTINCT
                    f1.film_id
                FROM
                    film f1
                        JOIN
                    inventory i ON f1.film_id = i.film_id
                        JOIN
                    rental r ON i.inventory_id = r.inventory_id
                        JOIN
                    customer c ON r.customer_id = c.customer_id
                        JOIN
                    film_category fc ON f1.film_id = fc.film_id
                        JOIN
                    category cat ON fc.category_id = cat.category_id
                WHERE
                    cat.name = 'Action'));
    

    
    
    
    
    
    
    
    
    
    
    
    
                        