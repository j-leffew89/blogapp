package com.codeup.blogapp.web;


import com.codeup.blogapp.data.post.Post;
import com.codeup.blogapp.data.user.User;
import com.codeup.blogapp.data.user.UsersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")

public class UsersController {

    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

//    User user = new User(1L, "testy", "testy@test.com", "test123", null);
//
//    List<Post> post = new ArrayList<>(){{
//        add(new Post(1L, "testy1", "Testy1", null, null));
//        add(new Post(2L, "testy2", "Testy2", null, null));
//        add(new Post(3L, "testy3", "Testy3", null, null));
//    }};


    @GetMapping
    private List<User> getUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("/{id}")
    private User getUserById(@PathVariable Long id){
        return usersRepository.getById(id);
    }

    @GetMapping("{username}")
    private User getUserByUsername(@PathVariable String username){
        System.out.println(username);
        return usersRepository.findByUsername(username);
    }

    @GetMapping("{email}")
    private User getUserByEmail(@PathVariable String email){
        System.out.println(email);
        return usersRepository.findByEmail(email);
    }

    @PostMapping
    private void createUser(@RequestBody User newUser) {
        System.out.println(newUser.getUsername());
        System.out.println(newUser.getEmail());
        System.out.println(newUser.getPassword());
        usersRepository.save(newUser);
    }

    @PutMapping("{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User user){
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(id);
        usersRepository.save(user);
    }

    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id){
        System.out.println("Deleting user with ID: " + id);
        usersRepository.deleteById(id);
    }
}
