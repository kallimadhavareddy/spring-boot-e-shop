package com.cs.product.presentation.resource;

import com.cs.product.persistance.entity.Product;
import com.cs.product.process.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductResource {
    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/productCatalogs")
    public List<Product> getProductCatalog(){
        return productService.getAllProducts();
    }

    @PostMapping("/productCatalog")
    public Product createProductCatalog(Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/productCatalog")
    public Product getProductCatalog(@RequestParam final int productId){
        return productService.getProduct(productId);
    }

    @DeleteMapping("/productCatalog")
    public void deleteProductCatalog(@RequestParam final int productId){
        productService.deleteProduct(productId);
    }
}
