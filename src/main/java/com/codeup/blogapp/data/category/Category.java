package com.codeup.blogapp.data.category;

import com.codeup.blogapp.data.post.Post;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            targetEntity = Post.class)
    @JoinTable(
            name="post_category",
            joinColumns = {@JoinColumn(name = "category_id",nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "post_id", nullable = false, updatable = false)},
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT)
    )
    private Collection<Post> post;

    public Category(){
    }

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Post> getPost() {
        return post;
    }

    public void setPost(Collection<Post> post) {
        this.post = post;
    }
}
