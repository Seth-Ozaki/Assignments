package com.seth.test.services;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.seth.test.models.Product;
import com.seth.test.repositories.ProductRepository;
@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    private ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Product addProduct(Product product, MultipartFile file) throws IOException {
        product.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        return productRepository.save(product);
    }
    public Optional<Product> getProduct(Long id){
        return productRepository.findById(id);
    }
}