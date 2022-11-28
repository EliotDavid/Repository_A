package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.serivce.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("addProduct")
    public String addProduct()
    {
        return "addproduct";
    }

    @PostMapping("addProduct")
    public String addImage(MultipartFile file, ProductDto dto) throws Exception
    {
        productService.save(file, dto);
        return "redirect:/";
    }
}
