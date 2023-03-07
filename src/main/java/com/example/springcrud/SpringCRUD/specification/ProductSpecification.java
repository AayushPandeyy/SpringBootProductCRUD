package com.example.springcrud.SpringCRUD.specification;

import com.example.springcrud.SpringCRUD.dto.ProductSpecificationDTO;
import com.example.springcrud.SpringCRUD.entity.Product;
import com.example.springcrud.SpringCRUD.repo.ProductRepo;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecification implements Specification<Product> {

    private final ProductSpecificationDTO productSpecificationDTO;

    private final ProductRepo productRepo;

    public ProductSpecification(ProductSpecificationDTO productSpecificationDTO, ProductRepo productRepo) {
        this.productSpecificationDTO = productSpecificationDTO;
        this.productRepo = productRepo;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Path<String> name = root.get("name");
        Path<Boolean> inStock = root.get("inStock");

        final List<Predicate> predicateList = new ArrayList<>();

        if(!StringUtils.isEmpty(productSpecificationDTO.getName())){
            predicateList.add(criteriaBuilder.like(criteriaBuilder.lower(name), "%"+productSpecificationDTO.getName().toLowerCase()+"%"));
        }
        if(productSpecificationDTO.getInStock()!=null){
            predicateList.add(criteriaBuilder.equal(inStock,productSpecificationDTO.getInStock()));
        }

        return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
    }
}
