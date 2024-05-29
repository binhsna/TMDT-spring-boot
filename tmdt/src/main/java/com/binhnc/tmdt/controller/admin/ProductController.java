package com.binhnc.tmdt.controller.admin;

import com.binhnc.tmdt.model.Category;
import com.binhnc.tmdt.model.Product;
import com.binhnc.tmdt.service.CategoryService;
import com.binhnc.tmdt.service.ProductService;
import com.binhnc.tmdt.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    StorageService storageService;

    @GetMapping("/product")
    public String index(Model model) {
        List<Product> list = this.productService.getAll();
        model.addAttribute("list", list);
        return "admin/product/index";
    }

    @GetMapping("/add-product")
    public String add(Model model) {
        Product product = new Product();
        List<Category> listCategory = this.categoryService.getAll();
        model.addAttribute("product", product);
        model.addAttribute("listCategory", listCategory);
        return "admin/product/add";
    }

    @PostMapping("/add-product")
    public String save(@ModelAttribute("product") Product product, @RequestParam("fileImage") MultipartFile file) {
        //xu ly upload anh
        this.storageService.store(file);
        String fileName = file.getOriginalFilename();
        product.setImage(fileName);
        if (this.productService.create(product))
            return "redirect:/admin/product";
        else
            return "redirect:/admin/product/add";
    }

    @GetMapping("/edit-product/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        Product product = this.productService.findById(id);
        List<Category> listCategory = this.categoryService.getAll();
        model.addAttribute("product", product);
        model.addAttribute("listCategory", listCategory);
        return "admin/product/edit";
    }

    @PostMapping("/edit-product")
    public String edit(@ModelAttribute("product") Product product, @RequestParam("fileImage") MultipartFile file) {
        this.storageService.store(file);
        String fileName = file.getOriginalFilename();
        product.setImage(fileName);
        if (this.productService.update(product)) {
            ;
        }
        return "redirect:/admin/product";
    }

    @GetMapping("/delete-product/{id}")
    public String edit(@PathVariable("id") Integer id) {
        if (this.productService.delete(id)) {
            ;
        }
        return "redirect:/admin/product";
    }
}
