package com.example.springcrud.SpringCRUD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "products")
public class Product {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_price")
    private Double price;

    @Column(name = "product_desc")
    private String description;

    @Column(name = "in_stock")
    private Boolean inStock;


}
