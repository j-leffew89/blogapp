package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post;
import org.springframework.web.bind.annotation.*;

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
    private Post getPostById(@PathVariable Long id) {

        if (id == 1) {
            return new Post(1L, "Harry Potter", "People");
        } else {
            return null;
        }
    }

    @PostMapping(value = "/post")
    private void createPost(@RequestBody Post newPost) {
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
    }

    @PutMapping("{/{id}}")
    private void updatePost(@PathVariable Long id, @RequestBody Post newPost){
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
    }

    @DeleteMapping("{id}")
    private void deleteDelete(@PathVariable Long id){
        System.out.println("The Id Deleted was " + id);
    }

}
