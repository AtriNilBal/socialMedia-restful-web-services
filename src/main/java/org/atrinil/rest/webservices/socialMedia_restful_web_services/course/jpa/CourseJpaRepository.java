package org.atrinil.rest.webservices.socialMedia_restful_web_services.course.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.atrinil.rest.webservices.socialMedia_restful_web_services.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CourseJpaRepository extends JpaRepository<Course, Long> {
}
