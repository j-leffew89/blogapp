package com.codeup.blogapp.web;

import com.codeup.blogapp.data.category.CategoriesRepository;
import com.codeup.blogapp.data.category.Category;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/categories", headers = "Accept=application/json", produces = "application/json")
public class CategoriesController {


    private final CategoriesRepository categoriesRepository;

    public CategoriesController(CategoriesRepository catRepo){
        this.categoriesRepository = catRepo;

    }

    @GetMapping
    private List<Category> getCategories(){
        return categoriesRepository.findAll();

    }

    @GetMapping("/{id}")
    private Category getPostsByCategory(@PathVariable Long id){
        return categoriesRepository.findById(id).get();
    }

    @GetMapping("/findByName")
    private Category findByName(@RequestParam String name){
        return categoriesRepository.findByName(name);
    }

}
