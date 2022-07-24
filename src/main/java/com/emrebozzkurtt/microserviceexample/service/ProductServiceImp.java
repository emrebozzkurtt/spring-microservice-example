package com.emrebozzkurtt.microserviceexample.service;

import com.emrebozzkurtt.microserviceexample.model.Product;
import com.emrebozzkurtt.microserviceexample.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImp implements IProductService{

    private final IProductRepository productRepository;

    public ProductServiceImp(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product){
        product.setCreateTime(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public  void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllProduct(){
        List<Product> products = productRepository.findAll();
        return products;
    }
    /*
    @Override
    public List<Product> findByPriceGreaterThan(){
        List<Product> products = productRepository.findByPriceGreaterThan();
        return products;
    }

     */
}
