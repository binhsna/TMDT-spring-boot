package com.binhnc.tmdt.controller.admin;

import com.binhnc.tmdt.model.Category;
import com.binhnc.tmdt.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public String index(Model model, @Param("keyword") String keyword) {
        List<Category> list = this.categoryService.getAll();
        if (keyword != null) {
            list = this.categoryService.searchCategory(keyword);
            model.addAttribute("keyword", keyword);
        }
        model.addAttribute("list", list);
        return "admin/category/index";
    }

    @GetMapping("/add-category")
    public String add(Model model) {
        Category category = new Category();
        category.setCategoryStatus(true);
        model.addAttribute("category", category);
        return "admin/category/add";
    }

    @PostMapping("/add-category")
    public String save(@ModelAttribute("category") Category category) {
        if (this.categoryService.create(category))
            return "redirect:/admin/category";
        else
            return "redirect:/admin/category/add";
    }

    @GetMapping("/edit-category/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        Category category = this.categoryService.findById(id);
        model.addAttribute("category", category);
        return "admin/category/edit";
    }

    @PostMapping("/edit-category")
    public String edit(@ModelAttribute("category") Category category) {
        if (this.categoryService.update(category)) {
            ;
        }
        return "redirect:/admin/category";
    }

    @GetMapping("/delete-category/{id}")
    public String edit(@PathVariable("id") Integer id) {
        if (this.categoryService.delete(id)) {
            ;
        }
        return "redirect:/admin/category";
    }
}
