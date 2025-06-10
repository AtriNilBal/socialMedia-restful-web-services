package org.atrinil.rest.webservices.socialMedia_restful_web_services.course.jdbc;

import org.atrinil.rest.webservices.socialMedia_restful_web_services.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private String INSERT_QUERY = """
            INSERT INTO course(id, name, author) VALUES (?,?,?);
            """;

    private String DELETE_QUERY = """
            DELETE FROM course WHERE id = ?;
            """;

    private String SELECT_QUERY = """
            SELECT * FROM course WHERE id = ?; 
            """;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
