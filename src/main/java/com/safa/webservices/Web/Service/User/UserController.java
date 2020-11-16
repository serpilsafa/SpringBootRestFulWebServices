package com.safa.webservices.Web.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){
        //Best practise
        //if you return an id that is not, you will see 200 Ok and blank body with 'return userDaoService.findOne(id);'
        //But you should see 404 not founded message there do you should write class that is RuntimeException
        User user = userDaoService.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id - "+id);
        }

        return userDaoService.findOne(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser = userDaoService.save(user);

        //Best practise
        //It should return 201 created code. in blow code can be return 201 request code.
        //If you don't write down this code blog you will see 200 OK request code.
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
