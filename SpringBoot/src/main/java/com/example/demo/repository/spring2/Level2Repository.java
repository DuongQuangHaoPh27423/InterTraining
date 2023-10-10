package com.example.demo.repository.spring2;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Level2Repository {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public List<String> bai1() {
        String query = "SELECT \n" +
                "    CONCAT(c.first_name, ' ', c.last_name) AS name,\n" +
                "    COUNT(p.amount) AS amount\n" +
                "FROM\n" +
                "    customer c\n" +
                "        JOIN\n" +
                "    payment p ON c.customer_id = p.customer_id\n" +
                "GROUP BY c.customer_id\n" +
                "ORDER BY amount DESC\n" +
                "LIMIT 10";
        return jdbcTemplate.queryForList(query, String.class);
    }

    public List<String> bai2() {
        String query = "SELECT \n" +
                "    c.customer_id,\n" +
                "    CONCAT(c.first_name, ' ', c.last_name) AS name,\n" +
                "    c.email\n" +
                "FROM\n" +
                "    customer c\n" +
                "WHERE\n" +
                "    NOT EXISTS( SELECT \n" +
                "            c.category_id\n" +
                "        FROM\n" +
                "            category c\n" +
                "        WHERE\n" +
                "            NOT EXISTS( SELECT \n" +
                "                    NULL\n" +
                "                FROM\n" +
                "                    rental r\n" +
                "                        JOIN\n" +
                "                    inventory i ON r.inventory_id = i.inventory_id\n" +
                "                        JOIN\n" +
                "                    film_category fc ON i.film_id = fc.film_id\n" +
                "                WHERE\n" +
                "                    r.customer_id = c.customer_id\n" +
                "                        AND fc.category_id = c.category_id))";
        return jdbcTemplate.queryForList(query, String.class);
    }

    public List<String> bai3() {
        String query = "SELECT \n" +
                "    f.title\n" +
                "FROM\n" +
                "    film f\n" +
                "        JOIN\n" +
                "    inventory i ON f.film_id = i.film_id\n" +
                "        JOIN\n" +
                "    rental r ON r.inventory_id = i.inventory_id\n" +
                "WHERE\n" +
                "    return_date IS NULL\n" +
                "GROUP BY f.title";
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

    public List<String> bai6() {
        String query = "SELECT \n" +
                "    CONCAT(a.first_name, ' ', a.last_name) AS ho_ten,\n" +
                "    SUM(f.rental_rate) AS total_revenue\n" +
                "FROM\n" +
                "    actor a\n" +
                "        JOIN\n" +
                "    film_actor fa ON a.actor_id = fa.actor_id\n" +
                "        JOIN\n" +
                "    film f ON f.film_id = fa.film_id\n" +
                "GROUP BY a.actor_id\n" +
                "ORDER BY total_revenue DESC";
        return jdbcTemplate.queryForList(query, String.class);
    }

    public List<String> bai7() {
        String query = "SELECT \n" +
                "    CONCAT(a.first_name, ' ', a.last_name) AS ho_ten\n" +
                "FROM\n" +
                "    actor a\n" +
                "        JOIN\n" +
                "    film_actor fa ON a.actor_id = fa.actor_id\n" +
                "        JOIN\n" +
                "    film f ON f.film_id = fa.film_id\n" +
                "WHERE\n" +
                "    f.rating LIKE 'R'\n" +
                "        AND f.rating NOT LIKE 'G'\n" +
                "GROUP BY a.actor_id";
        return jdbcTemplate.queryForList(query, String.class);
    }

    public List<String> bai8() {
        String query = "SELECT DISTINCT\n" +
                "    f.film_id,\n" +
                "    f.title,\n" +
                "    COUNT(DISTINCT r.customer_id) AS customer_rentals\n" +
                "FROM\n" +
                "    film f\n" +
                "        JOIN\n" +
                "    inventory i ON f.film_id = i.film_id\n" +
                "        JOIN\n" +
                "    rental r ON i.inventory_id = r.inventory_id\n" +
                "GROUP BY f.film_id\n" +
                "HAVING COUNT(DISTINCT r.customer_id) > 50\n" +
                "   AND COUNT(r.rental_id) = COUNT(DISTINCT r.rental_id);";
        return jdbcTemplate.queryForList(query, String.class);
    }

    public List<String> bai9() {
        String query = "SELECT DISTINCT\n" +
                "    CONCAT(c.first_name, ' ', c.last_name) AS name\n" +
                "FROM\n" +
                "    customer c\n" +
                "        JOIN\n" +
                "    rental r ON c.customer_id = r.customer_id\n" +
                "        JOIN\n" +
                "    inventory i ON r.inventory_id = i.inventory_id\n" +
                "        JOIN\n" +
                "    film_category fc ON i.film_id = fc.film_id\n" +
                "        JOIN\n" +
                "    category cat ON fc.category_id = cat.category_id\n" +
                "WHERE\n" +
                "-- tim phim khach da thue va loai bo\n" +
                "    cat.category_id NOT IN (SELECT \n" +
                "            fc2.category_id\n" +
                "        FROM\n" +
                "            rental r2\n" +
                "                JOIN\n" +
                "            inventory i2 ON r2.inventory_id = i2.inventory_id\n" +
                "                JOIN\n" +
                "            film_category fc2 ON i2.film_id = fc2.film_id\n" +
                "        WHERE\n" +
                "            r2.customer_id = c.customer_id);\n";
        return jdbcTemplate.queryForList(query, String.class);
    }

    public List<String> bai10() {
        String query = "SELECT \n" +
                "    film.title\n" +
                "FROM\n" +
                "    film\n" +
                "WHERE\n" +
                "    film.film_id NOT IN (SELECT DISTINCT\n" +
                "            f.film_id\n" +
                "        FROM\n" +
                "            film f\n" +
                "        WHERE\n" +
                "            f.film_id NOT IN (SELECT DISTINCT\n" +
                "                    f1.film_id\n" +
                "                FROM\n" +
                "                    film f1\n" +
                "                        JOIN\n" +
                "                    inventory i ON f1.film_id = i.film_id\n" +
                "                        JOIN\n" +
                "                    rental r ON i.inventory_id = r.inventory_id\n" +
                "                        JOIN\n" +
                "                    customer c ON r.customer_id = c.customer_id\n" +
                "                        JOIN\n" +
                "                    film_category fc ON f1.film_id = fc.film_id\n" +
                "                        JOIN\n" +
                "                    category cat ON fc.category_id = cat.category_id\n" +
                "                WHERE\n" +
                "                    cat.name = 'Action'));";
        return jdbcTemplate.queryForList(query, String.class);
    }
}
