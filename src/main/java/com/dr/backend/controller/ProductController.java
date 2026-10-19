package com.dr.backend.controller;

import com.dr.backend.interfaces.ProductService;
import com.dr.backend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
 private ProductService productService;
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product saved =productService.createProduct(product);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // 3. Get Single Product By ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    // 4. 🔥 DYNAMIC 3-LEVEL FILTER API (GET)
    // Example: /api/products/filter?type=SCHOOL_PRODUCT&category=UNIFORM&subCategory=TIE
    @GetMapping("/filter")
    public ResponseEntity<List<Product>> filterProducts(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String subCategory
    ) {
        List<Product> products = productService.filterProduct(type, category, subCategory);
        return ResponseEntity.ok(products);
    }
    // 5. Delete Product (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully with ID: " + id);
    }


}
