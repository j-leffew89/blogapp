package com.codeup.blogapp.web;


import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/categories", headers = "Accept=application/json")
public class CategoriesController {

    List<Category> categories = new ArrayList<>(){{
        add(new Category(1L, "Sports"));
        add(new Category(2L, "Family"));
        add(new Category(3L, "Food"));
        add(new Category(4L,"Drama"));
    }};

    @GetMapping
    private List<Category> getCategories() {
        return categories;
    }

}
