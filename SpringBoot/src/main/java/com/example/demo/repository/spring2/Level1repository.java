package com.example.demo.repository.spring2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Level1repository {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public List<String> bai1() {
        String sql = "SELECT \n" +
                "    CONCAT(c.first_name, ' ', c.last_name)\n" +
                "FROM\n" +
                "    actor c";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public List<String> bai2() {
        String sql = "SELECT \n" +
                "    title, rental_rate, replacement_cost\n" +
                "FROM\n" +
                "    film;";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public List<String> bai3() {
        String sql = "SELECT \n" +
                "    f.title, COUNT(r.rental_id) AS rentals\n" +
                "FROM\n" +
                "    film f\n" +
                "        JOIN\n" +
                "    inventory i ON f.film_id = i.film_id\n" +
                "        JOIN\n" +
                "    rental r ON i.inventory_id = r.inventory_id\n" +
                "GROUP BY title\n" +
                "ORDER BY rentals DESC\n" +
                "LIMIT 5";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public List<String> bai4() {
        String sql = "SELECT \n" +
                "    c.name AS category_name,\n" +
                "    AVG(DATEDIFF(return_date, rental_date)) AS AVG\n" +
                "FROM\n" +
                "    category c\n" +
                "        JOIN\n" +
                "    film_category fc ON c.category_id = fc.category_id\n" +
                "        JOIN\n" +
                "    film f ON fc.film_id = f.film_id\n" +
                "        JOIN\n" +
                "    inventory i ON f.film_id = i.film_id\n" +
                "        JOIN\n" +
                "    rental r ON i.inventory_id = r.inventory_id\n" +
                "GROUP BY c.name\t" +
                ";";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public List<String> bai5() {
        String sql = "c.last_name, a.address, a.address2\n" +
                "FROM\n" +
                "    customer c\n" +
                "        JOIN\n" +
                "    address a ON c.address_id = a.address_id\n" +
                "        JOIN\n" +
                "    rental r ON c.customer_id = r.customer_id\n" +
                "WHERE\n" +
                "    YEAR(r.rental_date) = '2006'\n" +
                "        AND MONTH(r.rental_date) = '2'";
        return jdbcTemplate.queryForList(sql, String.class);
    }


    public List<String> bai6() {
        String sql = "SELECT \n" +
                "    s.store_id, a.address, SUM(p.amount) AS revenue2005\n" +
                "FROM\n" +
                "    store s\n" +
                "        JOIN\n" +
                "    address a ON s.address_id = a.address_id\n" +
                "        JOIN\n" +
                "    staff sf ON s.store_id = sf.store_id\n" +
                "        JOIN\n" +
                "    payment p ON sf.staff_id = p.staff_id\n" +
                "WHERE\n" +
                "    YEAR(p.payment_date) = '2006'\n" +
                "GROUP BY s.store_id , a.address";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public List<String> bai7() {
        String sql = "SELECT \n" +
                "    CONCAT(a.first_name, ' ', a.last_name) AS NAME\n" +
                "FROM\n" +
                "    actor a\n" +
                "        JOIN\n" +
                "    film_actor fa ON a.actor_id = fa.actor_id\n" +
                "GROUP BY a.actor_id\n" +
                "HAVING COUNT(fa.actor_id) > 20;";
        return jdbcTemplate.queryForList(sql, String.class);
    }


    public List<String> bai8() {
        String sql = "SELECT \n" +
                "    f.description, f.rating, f.length\n" +
                "FROM\n" +
                "    film f\n" +
                "WHERE\n" +
                "    f.rating LIKE 'PG-13' AND f.length > 120";
        return jdbcTemplate.queryForList(sql, String.class);
    }

}
