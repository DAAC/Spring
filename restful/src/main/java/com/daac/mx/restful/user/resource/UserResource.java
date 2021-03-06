package com.daac.mx.restful.user.resource;

import com.daac.mx.restful.user.dao.User;
import com.daac.mx.restful.user.exception.UserNotFoundException;
import com.daac.mx.restful.user.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;
    private User user;


    @GetMapping(path = "/users")
    public List<User> retreiveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public Resource retrieveUser(@PathVariable Integer id) {
        User user = userDaoService.findOne(id);
        if (user == null)
            throw new UserNotFoundException("id-" + id);
        Resource resource = new Resource<User>(user);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retreiveAllUsers());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User userSaved = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(userSaved.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public void DeleteUser(@PathVariable Integer id) {
        User user = userDaoService.deleteById(id);
        if (user == null)
            throw new UserNotFoundException("id-" + id);
    }

}
