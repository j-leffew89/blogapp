package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {

    @GetMapping
    private List<Post> getPosts() {
        return new ArrayList<>() {
            {
                add(new Post(1L, "Harry Potter", "people"));
                add(new Post(2L, "Lord of the Ring", "Other people"));
                add(new Post(3L, "Avengers", "A few more people"));

            }
        };
    }

    @GetMapping("/{id}")
    private Post getPostById(@PathVariable int id){
        ArrayList<Post> posts = new ArrayList<>() {
            {
                add(new Post(1L, "Harry Potter", "people"));
                add(new Post(2L, "Lord of the Ring", "Other people"));
                add(new Post(3L, "Avengers", "A few more people"));

            }
        };

        return posts.get(id);
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost){
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
    }

}
