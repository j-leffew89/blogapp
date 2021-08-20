package com.codeup.blogapp.data.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, Long> {

//    Post findByTitle(String email);
}
