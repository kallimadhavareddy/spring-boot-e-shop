package com.cs.shopping.client;

import com.cs.shopping.data.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "eshop-product-client")
@Service
public interface ProductClient {
    @GetMapping("/productCatalog/{productId}")
    Product findProductById(@PathVariable("productId") int productId);
}
