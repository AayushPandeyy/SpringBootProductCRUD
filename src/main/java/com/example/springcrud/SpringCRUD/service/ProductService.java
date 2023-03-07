package com.example.springcrud.SpringCRUD.service;

import com.example.springcrud.SpringCRUD.dto.ProductSpecificationDTO;
import com.example.springcrud.SpringCRUD.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {


    Product createProduct(Product product);

    Product getById(Long id);

    List<Product> getAll();

    Product updateProduct(Product product);

    void deleteById(Long id);

    Page<Product> productSpecification(ProductSpecificationDTO productSpecificationDTO);




}
