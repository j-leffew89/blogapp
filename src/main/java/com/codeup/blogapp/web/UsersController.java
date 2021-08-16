package com.codeup.blogapp.web;


import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")

public class UsersController {

    @GetMapping
    private List<User> getUsers() {
        return new ArrayList<>() {
            {
                add(new User(1L, "amadoIII", "amadoiii@gmail.com","amado@III"));
                add(new User(1L, "richardL", "richardL@gmail.com","RichardL"));
                add(new User(1L, "PrachiP", "prachiP@gmail.com","PrachiP"));
            }
        };
    }

    @GetMapping("/{id}")
    private User getUserById(@PathVariable Long id){

        if (id == 1){
            return new User(1L, "amadoIII", "amadoiii@gmail.com","amado@III");
        }else{
            return null;
        }
    }

    @PostMapping
    private void createUser(@RequestBody User newUser) {
        System.out.println(newUser.getUsername());
        System.out.println(newUser.getEmail());
        System.out.println(newUser.getId());
        System.out.println(newUser.getPassword());
    }

    @PutMapping("{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User newUser){
        System.out.println(newUser.getUsername());
        System.out.println(newUser.getEmail());
        System.out.println(id);
    }

    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id){
        System.out.println("The Id Deleted was " + id);

    }
}
