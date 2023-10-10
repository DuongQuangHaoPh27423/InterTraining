package com.example.demo.repository.spring2;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Level3Repository {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public List<String> bai1() {
        String query = "SELECT \n" +
                "    CONCAT(a.first_name, ' ', a.last_name) AS ho_ten\n" +
                "FROM\n" +
                "    actor a\n" +
                "        JOIN\n" +
                "    film_actor fa ON a.actor_id = fa.actor_id\n" +
                "        JOIN\n" +
                "    film f ON f.film_id = fa.film_id\n" +
                "WHERE\n" +
                "    f.rating LIKE 'R' AND f.length > 120\n" +
                "        AND f.rating NOT LIKE 'G'\n" +
                "GROUP BY a.actor_id";
        return jdbcTemplate.queryForList(query, String.class);
    }

    public List<String> bai2() {
        String query = "SELECT \n" +
                "    CONCAT(c.first_name, ' ', c.last_name) AS customer_name,\n" +
                "    COUNT(r.rental_id) AS SL,\n" +
                "    SUM(p.amount) AS amount\n" +
                "FROM\n" +
                "    customer c\n" +
                "        JOIN\n" +
                "    rental r ON c.customer_id = r.customer_id\n" +
                "        JOIN\n" +
                "    payment p ON r.rental_id = p.rental_id\n" +
                "GROUP BY c.customer_id , customer_name\n" +
                "HAVING sl > 10";
        return jdbcTemplate.queryForList(query, String.class);
    }

    public List<String> bai3() {
        String query = "WITH CategoryFilmCounts AS (\n" +
                "    SELECT \n" +
                "        fc.category_id,\n" +
                "        COUNT(DISTINCT f.film_id) AS total_films_in_category\n" +
                "    FROM \n" +
                "        film_category fc\n" +
                "    JOIN \n" +
                "        film f ON fc.film_id = f.film_id\n" +
                "    GROUP BY \n" +
                "        fc.category_id\n" +
                "),\n" +
                "-- số lượng phim được thuê và tổng phí thuê cho mỗi khách hàng trong danh mục\n" +
                "CustomerFilmCounts AS (\n" +
                "    SELECT \n" +
                "        c.customer_id,\n" +
                "        fc.category_id,\n" +
                "        COUNT(DISTINCT r.inventory_id) AS films_rented_in_category,\n" +
                "        SUM(p.amount) AS total_rental_fee\n" +
                "    FROM \n" +
                "        customer c\n" +
                "    JOIN \n" +
                "        rental r ON c.customer_id = r.customer_id\n" +
                "    JOIN \n" +
                "        inventory i ON r.inventory_id = i.inventory_id\n" +
                "    JOIN \n" +
                "        film f ON i.film_id = f.film_id\n" +
                "    JOIN \n" +
                "        film_category fc ON f.film_id = fc.film_id\n" +
                "    JOIN \n" +
                "        payment p ON r.rental_id = p.rental_id\n" +
                "    GROUP BY \n" +
                "        c.customer_id, fc.category_id\n" +
                ")\n" +
                "SELECT \n" +
                "    c.customer_id,\n" +
                "    CONCAT(c.first_name, ' ', c.last_name) AS customer_name,\n" +
                "    cfc.category_id,\n" +
                "    cfc.films_rented_in_category AS total_films_rented_in_category,\n" +
                "    cfc.total_rental_fee\n" +
                "FROM \n" +
                "    customer c\n" +
                "JOIN \n" +
                "    CustomerFilmCounts cfc ON c.customer_id = cfc.customer_id\n" +
                "JOIN \n" +
                "    CategoryFilmCounts cfcnt ON cfc.category_id = cfcnt.category_id\n" +
                "WHERE \n" +
                "    cfc.films_rented_in_category = cfcnt.total_films_in_category";
        return jdbcTemplate.queryForList(query, String.class);
    }

    public List<String> bai4() {
        String query = "WITH \n" +
                "    category_counts AS (\n" +
                "        SELECT COUNT(DISTINCT category_id) AS total_categories\n" +
                "        FROM category\n" +
                "    ),\n" +
                "    \n" +
                "    actor_category_counts AS (\n" +
                "        SELECT\n" +
                "            a.actor_id,\n" +
                "            COUNT(DISTINCT fc.category_id) AS actor_categories\n" +
                "        FROM\n" +
                "            actor a\n" +
                "            JOIN film_actor fa ON a.actor_id = fa.actor_id\n" +
                "            JOIN film_category fc ON fa.film_id = fc.film_id\n" +
                "        GROUP BY\n" +
                "            a.actor_id\n" +
                "    )\n" +
                "    \n" +
                "SELECT\n" +
                "    CONCAT(a.first_name, ' ', a.last_name) AS ho_ten\n" +
                "FROM\n" +
                "    actor a\n" +
                "    JOIN actor_category_counts acc ON a.actor_id = acc.actor_id\n" +
                "    JOIN category_counts cc ON acc.actor_categories = cc.total_categories;\n" +
                "    ";
        return jdbcTemplate.queryForList(query, String.class);
    }

    public List<String> bai5() {
        String query = "SELECT \n" +
                "    f.title AS film_title,\n" +
                "    CONCAT(c.first_name, ' ', c.last_name) AS customer_name,\n" +
                "    r.rental_date,\n" +
                "    COUNT(r.rental_id) AS rental_count\n" +
                "FROM\n" +
                "    rental r\n" +
                "        JOIN\n" +
                "    inventory i ON r.inventory_id = i.inventory_id\n" +
                "        JOIN\n" +
                "    film f ON i.film_id = f.film_id\n" +
                "        JOIN\n" +
                "    customer c ON r.customer_id = c.customer_id\n" +
                "GROUP BY f.title , customer_name , r.rental_date\n" +
                "HAVING COUNT(r.rental_id) >= 1;";
        return jdbcTemplate.queryForList(query, String.class);
    }

    public List<String> bai6() {
        String query = "SELECT \n" +
                "    CONCAT(a1.first_name, ' ', a1.last_name) AS actor1,\n" +
                "    CONCAT(a2.first_name, ' ', a2.last_name) AS actor2,\n" +
                "    COUNT(DISTINCT fa1.film_id) AS number_films\n" +
                "FROM\n" +
                "    actor a1\n" +
                "        JOIN\n" +
                "    film_actor fa1 ON a1.actor_id = fa1.actor_id\n" +
                "        JOIN\n" +
                "    film_actor fa2 ON fa1.film_id = fa2.film_id\n" +
                "        AND fa1.actor_id <> fa2.actor_id\n" +
                "        JOIN\n" +
                "    actor a2 ON fa2.actor_id = a2.actor_id\n" +
                "GROUP BY actor1 , actor2";
        return jdbcTemplate.queryForList(query, String.class);
    }

    public List<String> bai7() {
        String query = "WITH cte_1 AS (\n" +
                "    SELECT\n" +
                "        c.customer_id,\n" +
                "        c.first_name,\n" +
                "        c.last_name,\n" +
                "        ct.name AS category_name,\n" +
                "        COUNT(DISTINCT r.rental_id) AS num_films_rented\n" +
                "    FROM\n" +
                "        customer c\n" +
                "    JOIN\n" +
                "        rental r ON c.customer_id = r.customer_id\n" +
                "    JOIN\n" +
                "        inventory i ON r.inventory_id = i.inventory_id\n" +
                "    JOIN\n" +
                "        film_category fc ON i.film_id = fc.film_id\n" +
                "    JOIN\n" +
                "        category ct ON fc.category_id = ct.category_id\n" +
                "    GROUP BY\n" +
                "        c.customer_id,\n" +
                "        c.first_name,\n" +
                "        c.last_name,\n" +
                "        ct.name\n" +
                "),\n" +
                "-- bảng tìm tổng số phim\n" +
                "cte_2 AS (\n" +
                "    SELECT\n" +
                "        ct.name AS category_name,\n" +
                "        COUNT(DISTINCT f.film_id) AS total_films_in_category\n" +
                "    FROM\n" +
                "        category ct\n" +
                "    JOIN\n" +
                "        film_category fc ON ct.category_id = fc.category_id\n" +
                "    JOIN\n" +
                "        film f ON fc.film_id = f.film_id\n" +
                "    GROUP BY\n" +
                "        ct.name\n" +
                ")\n" +
                "SELECT\n" +
                "    cte_1.customer_id,\n" +
                "    cte_1.first_name,\n" +
                "    cte_1.last_name,\n" +
                "    cte_1.category_name,\n" +
                "    cte_1.num_films_rented,\n" +
                "    cte_2.total_films_in_category\n" +
                "FROM\n" +
                "    cte_1 \n" +
                "JOIN\n" +
                "    cte_2  ON cte_1.category_name = cte_2.category_name\n" +
                "ORDER BY\n" +
                "    cte_1.customer_id, cte_1.category_name;";
        return jdbcTemplate.queryForList(query, String.class);
    }

    public List<String> bai8() {
        String query = "SSELECT DISTINCT\n" +
                "    f.title\n" +
                "FROM\n" +
                "    film f\n" +
                "        JOIN\n" +
                "    inventory i ON f.film_id = i.film_id\n" +
                "        JOIN\n" +
                "    rental r ON i.inventory_id = r.inventory_id\n" +
                "        JOIN\n" +
                "    customer c ON r.customer_id = c.customer_id\n" +
                "        JOIN\n" +
                "    film_category fc ON f.film_id = fc.film_id\n" +
                "        JOIN\n" +
                "    category cat ON fc.category_id = cat.category_id\n" +
                "WHERE\n" +
                "    f.film_id NOT IN (SELECT DISTINCT\n" +
                "            f2.film_id\n" +
                "        FROM\n" +
                "            film f2\n" +
                "                JOIN\n" +
                "            inventory i2 ON f2.film_id = i2.film_id\n" +
                "                JOIN\n" +
                "            rental r2 ON i2.inventory_id = r2.inventory_id\n" +
                "                JOIN\n" +
                "            customer c2 ON r2.customer_id = c2.customer_id\n" +
                "                JOIN\n" +
                "            film_category fc2 ON f2.film_id = fc2.film_id\n" +
                "                JOIN\n" +
                "            category cat2 ON fc2.category_id = cat2.category_id\n" +
                "        WHERE\n" +
                "            cat2.name = 'G')\n" +
                "GROUP BY f.title\n" +
                "HAVING COUNT(DISTINCT r.rental_id) > 100;\n";
        return jdbcTemplate.queryForList(query, String.class);
    }

    public List<String> bai9() {
        String query = "SELECT DISTINCT\n" +
                "    c.first_name, c.last_name\n" +
                "FROM\n" +
                "    customer c\n" +
                "        JOIN\n" +
                "    rental r ON c.customer_id = r.customer_id\n" +
                "        JOIN\n" +
                "    inventory i ON r.inventory_id = i.inventory_id\n" +
                "        JOIN\n" +
                "    film f ON i.film_id = f.film_id\n" +
                "        JOIN\n" +
                "    film_category fc ON f.film_id = fc.film_id\n" +
                "WHERE\n" +
                "    fc.category_id IN (\n" +
                "    -- lấy phim thuộc danh mục khách hàngh chưa thuê\n" +
                "    SELECT \n" +
                "            fc2.category_id\n" +
                "        FROM\n" +
                "            film_category fc2\n" +
                "        WHERE\n" +
                "            fc2.film_id IN (\n" +
                "            -- lấy danh sác các phim mà chưa thuê\n" +
                "            SELECT \n" +
                "                    i2.film_id\n" +
                "                FROM\n" +
                "                    inventory i2\n" +
                "                WHERE\n" +
                "                    i2.inventory_id NOT IN (SELECT DISTINCT\n" +
                "                            r2.inventory_id\n" +
                "                        FROM\n" +
                "                            rental r2)))\n" +
                "        AND f.length <= 180;       \n" +
                "        \n" +
                "        select inventory_id from rental;\n" +
                "        select inventory_id from inventory;";
        return jdbcTemplate.queryForList(query, String.class);
    }

    public List<String> bai10() {
        String query = "WITH cte1 AS (\n" +
                "    SELECT distinct CONCAT(a1.first_name, ' ', a1.last_name) AS name_actor1\n" +
                "    FROM actor a1\n" +
                "    JOIN film_actor fa1 ON a1.actor_id = fa1.actor_id\n" +
                "    JOIN film f1 ON fa1.film_id = f1.film_id\n" +
                "    WHERE f1.rating LIKE 'PG-13' AND f1.length > 120\n" +
                "),\n" +
                " -- điền kiện 2\n" +
                "cte2 AS (\n" +
                "    SELECT distinct CONCAT(a2.first_name, ' ', a2.last_name) AS name_actor2\n" +
                "    FROM actor a2\n" +
                "    JOIN film_actor fa2 ON a2.actor_id = fa2.actor_id\n" +
                "    JOIN film f2 ON fa2.film_id = f2.film_id\n" +
                "    WHERE f2.rating LIKE 'R' AND f2.length < 90\n" +
                ")\n" +
                "SELECT cte1.name_actor1 AS matching_actor_name\n" +
                "FROM cte1\n" +
                "JOIN cte2 ON cte1.name_actor1 = cte2.name_actor2;\n";
        return jdbcTemplate.queryForList(query, String.class);
    }
}
