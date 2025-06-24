package com.seth.test.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.seth.test.models.Product;
import com.seth.test.services.ProductService;
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    // Add a product UI
    @GetMapping("/add")
    public String addProductUI(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }
    // Add a product API
    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product, @RequestParam("imageFile") MultipartFile imageFile) throws IOException, IOException {
        productService.addProduct(product, imageFile);
        return "redirect:/get-products";
    }
    //Get all Products
    @GetMapping("/get-products")
    public String listProducts(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "get-products";
    }
    //Get Image using product ID
    @GetMapping(value = "/{productId}/image")
    public ResponseEntity<byte[]> getProductImage(@PathVariable Long productId) {
        Optional<Product> productOptional = productService.getProduct(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            byte[] imageBytes = java.util.Base64.getDecoder().decode(product.getImage());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new byte[0], HttpStatus.NOT_FOUND);
        }
    }
}