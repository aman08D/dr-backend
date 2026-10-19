package com.dr.backend.interfaces;

import com.dr.backend.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    List<Product>getAllProducts();
    Product getProductById(Long id);

    // filter Method

    List<Product>filterProduct(String productType, String category ,String  subCategory);
     void deleteProduct(Long id);
}
