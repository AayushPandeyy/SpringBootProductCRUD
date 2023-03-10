package com.example.springcrud.SpringCRUD.repo;

import com.example.springcrud.SpringCRUD.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> , JpaSpecificationExecutor<Product> {
}
