package com.dikkulah.firstcase.repositories;

import com.dikkulah.firstcase.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select a from Product a where a.expirationDate < CURRENT_DATE ")
    List<Product> findProductsExpired();

    @Query("select a from Product a where a.expirationDate >= CURRENT_DATE or a.expirationDate is null ")
    List<Product> findProductsNonExpired();

}
