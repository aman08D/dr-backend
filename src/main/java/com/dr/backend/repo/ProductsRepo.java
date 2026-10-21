package com.dr.backend.repo;

import com.dr.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepo extends JpaRepository<Product,Long> {
    // for Single Filter
    List<Product>findByProductTypeIgnoreCase(String productType);
    List<Product> findByCategoryIgnoreCase(String category);
    List<Product> findBySubCategoryIgnoreCase(String subCategory);


    // 2. Double Level Combination Filters

    List<Product>findByProductTypeIgnoreCaseAndCategoryIgnoreCase(String productType ,String category);
    List<Product> findByCategoryIgnoreCaseAndSubCategoryIgnoreCase(String category, String subCategory);

    // 3. COMPLETE 3-LEVEL FILTER (Ultra Fast SQL Execution 🔥)

    List<Product> findByProductTypeIgnoreCaseAndCategoryIgnoreCaseAndSubCategoryIgnoreCase(
            String productType, String category, String subCategory
    );



}
