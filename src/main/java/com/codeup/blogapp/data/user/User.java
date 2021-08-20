package com.codeup.blogapp.data.user;


import com.codeup.blogapp.data.post.Post;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 50)
    private String password;

    private Role role = Role.USER;
    private Collection<Post> post;

    public enum Role{USER, ADMIN};

    public User(long id, String username, String email,
                String password, Collection<Post> post) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.post = post;
    }

    public User(String username){
        this.username = username;
    }

    public User(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Collection<Post> getPost() {
        return post;
    }

    public void setPost(Collection<Post> post) {
        this.post = post;
    }
}
