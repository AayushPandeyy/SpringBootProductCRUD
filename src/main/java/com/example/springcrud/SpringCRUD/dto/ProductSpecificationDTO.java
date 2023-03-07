package com.example.springcrud.SpringCRUD.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductSpecificationDTO extends PaginationDTO{
    private String name;
    private Boolean inStock;

}
