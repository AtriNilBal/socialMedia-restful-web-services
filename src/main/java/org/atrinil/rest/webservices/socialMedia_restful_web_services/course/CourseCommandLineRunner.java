package org.atrinil.rest.webservices.socialMedia_restful_web_services.course;

import org.atrinil.rest.webservices.socialMedia_restful_web_services.course.jdbc.CourseJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learning Python", "Kiril Eremenko"));
        repository.insert(new Course(2, "Learning Javascript", "FreeCodeCamp"));
        repository.insert(new Course(3, "Learning Java", "Tim Buchalka"));

        repository.deleteById(1l);
        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));
    }
}