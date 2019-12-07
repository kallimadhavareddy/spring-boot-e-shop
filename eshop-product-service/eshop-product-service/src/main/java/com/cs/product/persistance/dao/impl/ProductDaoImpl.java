package com.cs.product.persistance.dao.impl;

import com.cs.product.exception.ProductNotFound;
import com.cs.product.persistance.dao.ProductDao;
import com.cs.product.persistance.entity.Product;
import com.cs.product.persistance.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductDaoImpl implements ProductDao {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDaoImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow(()-> new ProductNotFound(String.format("Product with id %s not exists!", id)));
    }

    @Override
    public void deleteProductById(int id) {

    }
}
