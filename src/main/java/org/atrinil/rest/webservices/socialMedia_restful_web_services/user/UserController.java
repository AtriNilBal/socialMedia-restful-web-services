package org.atrinil.rest.webservices.socialMedia_restful_web_services.user;

import jakarta.validation.Valid;
import org.atrinil.rest.webservices.socialMedia_restful_web_services.user.exception.UserAlreadyCreatedException;
import org.atrinil.rest.webservices.socialMedia_restful_web_services.user.exception.UserNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

    @GetMapping("/users")
    public List<User> getUsers() {
        return service.retrieveAllUsers();
    }

    //add a link http://localhost:8080/users/{id}..replace id with the actual id
    //Entity Model
    //WebMvcLinkBuilder
    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User retrieveUser = service.getUser(id);
        if(Objects.nonNull(retrieveUser)) {
            EntityModel<User> entityModel = EntityModel.of(retrieveUser);
            WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).getUsers());
            entityModel.add(link.withRel("all_users"));
            return entityModel;
        }
        else
            throw new UserNotFoundException(String.format("id = %d", id));
    }

    /***
     * return uri of the new user so that client call the uri to check saved user details
     * created method of ResponseEntity accepts URI as parameter
     * example - /users/4 => /users , user.getId()
     * **/

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);

        if(Objects.isNull(savedUser)) {
            throw new UserAlreadyCreatedException(user.toString());
        } else {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
            return ResponseEntity.created(location).build();
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }
}
