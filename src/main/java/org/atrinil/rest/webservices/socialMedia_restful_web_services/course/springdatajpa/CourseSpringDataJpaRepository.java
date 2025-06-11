package org.atrinil.rest.webservices.socialMedia_restful_web_services.course.springdatajpa;

import org.atrinil.rest.webservices.socialMedia_restful_web_services.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);
}
