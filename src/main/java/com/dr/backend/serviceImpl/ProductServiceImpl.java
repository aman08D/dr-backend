package com.dr.backend.serviceImpl;

import com.dr.backend.interfaces.ProductService;
import com.dr.backend.model.Product;
import com.dr.backend.repo.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl  implements ProductService {
    @Autowired
    private ProductsRepo productsRepo;
    @Override
    public Product createProduct(Product product) {
        if(product.getIsAvailable()==null){
               product.setIsAvailable(true);
        }
        if(product.getPrice() < 0){
            throw new IllegalArgumentException("Price can't be negative");
        }


          return productsRepo.save(product);

    }

    @Override
    public List<Product> getAllProducts() {

        return productsRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productsRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public List<Product> filterProduct(String productType, String category, String subCategory) {
        if (productType != null && category != null && subCategory != null) {
            return productsRepo.findByProductTypeIgnoreCaseAndCategoryIgnoreCaseAndSubCategoryIgnoreCase(productType, category, subCategory);


        }
        // Scenario 2: Type + Category
        if (productType != null && category != null) {
            return productsRepo.findByProductTypeIgnoreCaseAndCategoryIgnoreCase(productType, category);
        }

        // Scenario 3: Category + SubCategory
        if (category != null && subCategory != null) {
            return productsRepo.findByCategoryIgnoreCaseAndSubCategoryIgnoreCase(category, subCategory);
        }

        // Scenario 4: Individual Filters
        if (productType != null) {
            return productsRepo.findByProductTypeIgnoreCase(productType);
        }
        if (category != null) {
            return productsRepo.findByCategoryIgnoreCase(category);
        }
        if (subCategory != null) {
            return productsRepo.findBySubCategoryIgnoreCase(subCategory);
        }

        // Fallback: Koi filter nahi toh saare products
        return productsRepo.findAll();

    }



    @Override
    public void deleteProduct(Long id) {
        productsRepo.deleteById(id);
    }
}
