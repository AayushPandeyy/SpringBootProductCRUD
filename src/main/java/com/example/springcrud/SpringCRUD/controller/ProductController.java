package com.example.springcrud.SpringCRUD.controller;

import com.example.springcrud.SpringCRUD.dto.ProductSpecificationDTO;
import com.example.springcrud.SpringCRUD.entity.Product;
import com.example.springcrud.SpringCRUD.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Product product){
        Product p = productService.createProduct(product);
        return ResponseEntity.ok(p);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Product> productList = productService.getAll();
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        Product product = productService.getById(id);
        return ResponseEntity.ok(product);
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        Product p = productService.updateProduct(product);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        productService.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

    @PostMapping("/filter")
    public ResponseEntity<?> specification(@RequestBody ProductSpecificationDTO productSpecificationDTO){
        Page<Product> productPage = productService.productSpecification(productSpecificationDTO);
        return ResponseEntity.ok(productPage);
    }


}
