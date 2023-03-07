package com.example.springcrud.SpringCRUD.service;

import com.example.springcrud.SpringCRUD.dto.ProductSpecificationDTO;
import com.example.springcrud.SpringCRUD.entity.Product;
import com.example.springcrud.SpringCRUD.repo.ProductRepo;
import com.example.springcrud.SpringCRUD.specification.ProductSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

//    Constructor Dependency injection
    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product createProduct(Product product) {
        product = productRepo.save(product);
        return product;
    }

    @Override
    public Product getById(Long id) {
        Product product = productRepo.findById(id).orElseThrow(()->new RuntimeException("Product Not Found"));
        return product;

    }

    @Override
    public List<Product> getAll() {
        List<Product> products = productRepo.findAll().stream().collect(Collectors.toList());
        return products;
    }

    @Override
    public Product updateProduct(Product product) {
        Product p = getById(product.getId());
        product.setId(p.getId());
        productRepo.save(product);
        return product;

    }

    @Override
    public void deleteById(Long id) {
            productRepo.deleteById(id);
    }

    @Override
    public Page<Product> productSpecification(ProductSpecificationDTO productSpecificationDTO) {
        Pageable pageable = PageRequest.of(productSpecificationDTO.getPageNo(),
                productSpecificationDTO.getLimit()
                );
        Page<Product> products = productRepo.findAll(new ProductSpecification(productSpecificationDTO,productRepo),pageable);

        List<Product> productList = products.getContent();

        Page<Product> productPage = new PageImpl<Product>(productList.stream().toList(),products.getPageable(),products.getTotalElements());



        return productPage;
    }
}
