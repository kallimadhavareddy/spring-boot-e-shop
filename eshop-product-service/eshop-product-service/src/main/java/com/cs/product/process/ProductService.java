package com.cs.product.process;

import com.cs.product.persistance.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
    void deleteProduct(int productId);
    Product getProduct(int productId);
}
