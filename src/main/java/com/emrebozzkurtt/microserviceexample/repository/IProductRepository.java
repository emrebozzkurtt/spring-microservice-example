package com.emrebozzkurtt.microserviceexample.repository;

import com.emrebozzkurtt.microserviceexample.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query("from Product order by createTime asc ")
    List<Product> findByPriceGreaterThan();
}
