package com.codeup.blogapp.web;

import com.codeup.blogapp.data.post.Post;
import com.codeup.blogapp.data.post.PostsRepository;
import com.codeup.blogapp.data.user.User;
import com.codeup.blogapp.data.user.UsersRepository;
import com.codeup.blogapp.services.EmailService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json", produces = "application/json")
public class PostController {

    private final PostsRepository postsRepository;
    private final EmailService emailService;
    private final UsersRepository usersRepository;

    public PostController(PostsRepository postsRepository, EmailService emailService, UsersRepository usersRepository){
        this.postsRepository = postsRepository;
        this.emailService = emailService;
        this.usersRepository = usersRepository;
    }

    @GetMapping
    private List<Post> getPosts() {
        return postsRepository.findAll();
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id) {
    return postsRepository.findById(id).get();
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost, OAuth2Authentication auth) {
        String email = auth.getName();
        User user = usersRepository.findByEmail(email).get();
        newPost.setUser(user);
        postsRepository.save(newPost);
        emailService.prepareAndSend(newPost, "subject: test email", "this is a test email");
    }

    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post postToUpDate){
        System.out.println("Updating post with id: " + id);
        System.out.println(postToUpDate.getTitle());
        System.out.println(postToUpDate.getContent());
        System.out.println(id);
        postsRepository.save(postToUpDate);
    }

    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id){
        System.out.println("The Id Deleted was " + id);
        postsRepository.deleteById(id);
    }
}

