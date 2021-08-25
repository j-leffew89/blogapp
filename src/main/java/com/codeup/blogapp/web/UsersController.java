package com.codeup.blogapp.web;

import com.codeup.blogapp.data.user.User;
import com.codeup.blogapp.data.user.UsersRepository;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json", produces = "application/json")

public class UsersController {

    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @GetMapping
    private List<User> getUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("/{id}")
    private User getUserById(@PathVariable Long id){
        return usersRepository.getById(id);
    }

    @GetMapping("/findByUsername")
    private User getUserByUsername(@RequestParam String username){
        return usersRepository.findByUsername(username);
    }
    @GetMapping("/findByEmail")
    private User getUserByEmail(@RequestParam String email){
        System.out.println(email);
        return usersRepository.findByEmail(email).get();
    }

    @PostMapping
    private void createUser(@RequestBody User newUser) {
        usersRepository.save(newUser);
    }

    @PutMapping("{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User user){
        usersRepository.save(user);
    }

    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id){
        System.out.println("Deleting user with ID: " + id);
        usersRepository.deleteById(id);
    }

    @PutMapping("/{id}/updatePassword")
    private void updatePassword
            (@PathVariable Long id, @RequestParam(required = false)
                    String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword){
        User user = usersRepository.getById(id);
        user.setPassword(newPassword);
        usersRepository.save(user);

    }
}
