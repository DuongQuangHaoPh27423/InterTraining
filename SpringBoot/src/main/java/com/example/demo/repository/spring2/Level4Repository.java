package com.example.demo.repository.spring2;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Level4Repository {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public void bai1() {
        String sql = "UPDATE film \n" +
                "SET \n" +
                "    rental_rate = rental_rate * 1.1\n" +
                "WHERE\n" +
                "    film_id IN (SELECT \n" +
                "            film_id\n" +
                "        FROM\n" +
                "            (SELECT \n" +
                "                f.film_id\n" +
                "            FROM\n" +
                "                film f\n" +
                "            JOIN inventory i ON f.film_id = i.film_id\n" +
                "            JOIN rental r ON i.inventory_id = r.inventory_id\n" +
                "            GROUP BY f.film_id\n" +
                "            HAVING COUNT(r.rental_id) > 100) AS subquery);";

        jdbcTemplate.queryForList(sql, String.class);
    }

    public void bai2() {
        String sql = "UPDATE film \n" +
                "SET \n" +
                "    length = length * 1.05\n" +
                "WHERE\n" +
                "    film_id IN (SELECT \n" +
                "            film_id\n" +
                "        FROM\n" +
                "            (SELECT \n" +
                "                f.film_id\n" +
                "            FROM\n" +
                "                film f\n" +
                "            JOIN inventory i ON f.film_id = i.film_id\n" +
                "            JOIN rental r ON i.inventory_id = r.inventory_id\n" +
                "            GROUP BY f.film_id\n" +
                "            HAVING COUNT(r.rental_id) > 5) AS subquery)";
        jdbcTemplate.queryForList(sql, String.class);
    }

    public void bai3() {
        String sql = "UPDATE film \n" +
                "SET \n" +
                "    film.rental_rate = film.rental_rate * 1.2\n" +
                "WHERE\n" +
                "    film_id IN (SELECT \n" +
                "            film_id\n" +
                "        FROM\n" +
                "            (SELECT \n" +
                "                f.film_id\n" +
                "            FROM\n" +
                "                film f\n" +
                "            JOIN film_category fa ON f.film_id = fa.film_id\n" +
                "            JOIN category c ON fa.category_id = c.category_id\n" +
                "            WHERE\n" +
                "                c.name = 'Action'\n" +
                "                    AND f.release_year = 2006) AS subquery1)";
        jdbcTemplate.queryForList(sql, String.class);
    }

    public void bai4() {
        String sql = "UPDATE customer \n" +
                "SET \n" +
                "    customer.email = CONCAT(customer.email, ' ', 'Horror')\n" +
                "WHERE\n" +
                "    customer.customer_id IN (SELECT DISTINCT\n" +
                "            r.customer_id\n" +
                "        FROM\n" +
                "            rental r\n" +
                "                JOIN\n" +
                "            inventory i ON r.inventory_id = i.inventory_id\n" +
                "                JOIN\n" +
                "            film f ON i.film_id = f.film_id\n" +
                "                JOIN\n" +
                "            film_category fc ON f.film_id = fc.film_id\n" +
                "                JOIN\n" +
                "            category c ON fc.category_id = c.category_id\n" +
                "        WHERE\n" +
                "            c.name = 'Horror'\n" +
                "                AND YEAR(r.rental_date) = 2005\n" +
                "                AND MONTH(r.rental_date) = 8)";
        jdbcTemplate.queryForList(sql, String.class);
    }

    public void bai5() {
        String sql = "UPDATE film \n" +
                "SET \n" +
                "    rental_rate = LEAST(rental_rate * 1.05, 4.00)\n" +
                "WHERE\n" +
                "    film_id IN (SELECT \n" +
                "            film_id\n" +
                "        FROM\n" +
                "            (SELECT \n" +
                "                f.film_id\n" +
                "            FROM\n" +
                "                film f\n" +
                "            JOIN inventory i ON f.film_id = i.film_id\n" +
                "            JOIN rental r ON i.inventory_id = r.inventory_id\n" +
                "            GROUP BY f.film_id\n" +
                "            HAVING COUNT(r.rental_id) > 10) AS subquery2)";
        jdbcTemplate.queryForList(sql, String.class);
    }

    public void bai6() {
        String sql = "UPDATE film \n" +
                "SET \n" +
                "    film.rental_rate = 3.5\n" +
                "WHERE\n" +
                "    film.rating = 'PG-13'\n" +
                "        AND film.length > 120";
        jdbcTemplate.queryForList(sql, String.class);
    }

    public void bai7() {
        String sql = "UPDATE film \n" +
                "SET \n" +
                "    rental_duration = length\n" +
                "WHERE\n" +
                "    film_id IN (SELECT \n" +
                "            f.film_id\n" +
                "        FROM\n" +
                "            film f\n" +
                "                JOIN\n" +
                "            film_category fc ON f.film_id = fc.film_id\n" +
                "                JOIN\n" +
                "            category c ON fc.category_id = c.category_id\n" +
                "        WHERE\n" +
                "            c.name = 'Sci-Fi'\n" +
                "                AND YEAR(f.release_year) = 2010)";
        jdbcTemplate.queryForList(sql, String.class);
    }

    public void bai8() {
        String sql = "UPDATE address ad \n" +
                "SET \n" +
                "    ad.address = CONCAT(address, ',', 'samecity')\n" +
                "WHERE\n" +
                "    ad.address_id IN (SELECT \n" +
                "            address_id\n" +
                "        FROM\n" +
                "            (SELECT \n" +
                "                a.address_id\n" +
                "            FROM\n" +
                "                address a\n" +
                "            JOIN customer c1 ON a.address_id = c1.address_id\n" +
                "            JOIN customer c2 ON c1.customer_id = c2.customer_id\n" +
                "            WHERE\n" +
                "                c1.last_name = c2.last_name\n" +
                "                    AND c1.customer_id <> c2.customer_id) AS ctequery3)";
        jdbcTemplate.queryForList(sql, String.class);
    }

    public void bai9() {
        String sql = "UPDATE film \n" +
                "SET \n" +
                "    film.rental_rate = rental_rate * 0.85\n" +
                "WHERE\n" +
                "    film.film_id IN (SELECT \n" +
                "\n" +
                "            film_id\n" +
                "        FROM\n" +
                "            (SELECT \n" +
                "                f.film_id\n" +
                "            FROM\n" +
                "                film f\n" +
                "            JOIN film_category fc ON f.film_id = fc.film_id\n" +
                "            JOIN category c ON fc.category_id = c.category_id\n" +
                "            WHERE\n" +
                "                c.name = 'Comedy'\n" +
                "                    AND release_year >= 2005) AS ctequery4)";
        jdbcTemplate.queryForList(sql, String.class);
    }

    public void bai10() {
        String sql = "UPDATE film \n" +
                "SET \n" +
                "    rental_rate = 1.5\n" +
                "WHERE\n" +
                "    film_id IN (SELECT \n" +
                "            film_id\n" +
                "        FROM\n" +
                "            (SELECT \n" +
                "                f.film_id\n" +
                "            FROM\n" +
                "                film f\n" +
                "            WHERE\n" +
                "                f.rating = 'G' AND f.length < 60) AS cte)";
        jdbcTemplate.queryForList(sql, String.class);
    }
}
