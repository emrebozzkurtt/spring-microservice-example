package com.emrebozzkurtt.microserviceexample.controller;

import com.emrebozzkurtt.microserviceexample.model.Product;
import com.emrebozzkurtt.microserviceexample.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product") //pre-path
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping(value = "/addProduct")
    private ResponseEntity<?> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/deleteProduct/{id}")
    private ResponseEntity<?> addProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/products")
    private ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(productService.findAllProduct());
    }
/*
    @GetMapping(value = "/productsGreater")
    private ResponseEntity<?> getAllProductsPriceGreaterThan(){
        return ResponseEntity.ok(productService.findByPriceGreaterThan());
    }

 */
}
