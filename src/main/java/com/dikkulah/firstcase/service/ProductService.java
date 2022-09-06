package com.dikkulah.firstcase.service;

import com.dikkulah.firstcase.entity.Product;
import com.dikkulah.firstcase.repositories.ProductRepository;
import com.dikkulah.firstcase.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public Product addProduct(Product product) {
        log.info("Ürün Eklendi");
        return productRepository.save(product);
    }
    //todo Son kullanma tarihi geçmiş ürünleri listeleyen bir metot yazınız.
    public List<Product> getExpiredProducts(){
        log.info("Son Kullanma Tarihi Geçmiş Ürünler");
        return productRepository.findProductsExpired();
    }
    //TODO Son kullanma tarihi geçmemiş ürünleri listeleyen bir metot yazınız. (Son kullanma tarihi boş olanlar da gelmeli.)
    public List<Product> getNonExpiredProducts(){
        log.info("Son Kullanma Tarihi Geçmemiş veya Olmayan Ürünler");
        return productRepository.findProductsNonExpired();
    }


}
