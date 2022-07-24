package com.emrebozzkurtt.microserviceexample.service;

import com.emrebozzkurtt.microserviceexample.model.Product;

import java.util.List;

public interface IProductService {
    Product saveProduct(Product product);

    void deleteProduct(Long id);

    List<Product> findAllProduct();

   // List<Product> findByPriceGreaterThan();
}
