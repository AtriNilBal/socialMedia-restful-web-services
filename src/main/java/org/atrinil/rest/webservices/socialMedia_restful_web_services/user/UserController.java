package org.atrinil.rest.webservices.socialMedia_restful_web_services.user;

import jakarta.validation.Valid;
import org.atrinil.rest.webservices.socialMedia_restful_web_services.user.exception.UserAlreadyCreatedException;
import org.atrinil.rest.webservices.socialMedia_restful_web_services.user.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

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
    public User retrieveUser(@PathVariable int id) {
        User retrieveUser = service.getUser(id);
        if(Objects.nonNull(retrieveUser))
            return retrieveUser;
        else
            throw new UserNotFoundException(String.format("id = %d", id));
    }

    /***
     * return uri of the new user so that client call the uri to check saved user details
     * created method of ResponseEntity accepts URI as parameter
     * example - /users/4 => /users , user.getId()
     * **/

    @PostMapping(value = "/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);

        if(Objects.isNull(savedUser)) {
            throw new UserAlreadyCreatedException(user.toString());
        } else {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
            return ResponseEntity.created(location).build();
        }
    }

    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }
}
