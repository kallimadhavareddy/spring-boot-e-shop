package com.cs.product.persistance.dao;



import com.cs.product.persistance.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductDao {
    Product createProduct(Product customer);
    List<Product> allProducts();
    Product getProductById(int id);
    void deleteProductById(int id);
}
