package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.post.Post;
import com.codeup.blogapp.data.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {

    @GetMapping
    private List<Post> getPosts() {

        User user = new User( "testy");
        List<Category> categories = new ArrayList<>(){{
            add(new Category(1L, "Spring Boot"));
            add(new Category(2L, "Why JS"));
        }};
        return new ArrayList<>() {
            {
                add(new Post(1L, "Harry Potter", "people", user, categories));
                add(new Post(2L, "Lord of the Ring", "Other people", user, categories));
                add(new Post(3L, "Avengers", "A few more people", user, categories));

            }
        };
    }

    @GetMapping("/{id}")
    private Post getPostById(@PathVariable Long id) {

        User user = new User(1L, "testy", "testy@test.com", "test123", null);

        if (id == 1) {
            return new Post(1L, "Harry Potter", "People", user, null);
        } else {
            return null;
        }
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost) {
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
        System.out.println(newPost.getCategories());
    }

    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post newPost){
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
        System.out.println(id);
    }

    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id){
        System.out.println("The Id Deleted was " + id);
    }

}

