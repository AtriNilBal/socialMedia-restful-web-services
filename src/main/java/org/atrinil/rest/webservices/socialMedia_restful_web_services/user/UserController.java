package org.atrinil.rest.webservices.socialMedia_restful_web_services.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserDaoService service;

    public UserController(UserDaoService service) {
        this.service = service;
    }

    // /getUsers
    // /getUser
    // /createUser
    // /deleteUser

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return service.retrieveAllUsers();
    }

    @GetMapping(value = "/users/{id}")
    public User getUser(@PathVariable int id) {
        return service.retrieveUser(id);
    }

    @PostMapping(value = "/users")
    public void createUser(@RequestBody User user) {
        service.save(user);
    }
}
