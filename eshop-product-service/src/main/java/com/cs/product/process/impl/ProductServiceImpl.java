package com.cs.product.process.impl;

import com.cs.product.persistance.dao.ProductDao;
import com.cs.product.persistance.entity.Product;
import com.cs.product.process.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }


    @Override
    public Product createProduct(Product product) {
        return productDao.createProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.allProducts();
    }

    @Override
    public Product getProduct(int productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public void deleteProduct(int productId) {
        productDao.deleteProductById(productId);
    }


}
