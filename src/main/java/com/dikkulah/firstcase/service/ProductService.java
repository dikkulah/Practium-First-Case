package com.dikkulah.firstcase.service;

import com.dikkulah.firstcase.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    //todo Son kullanma tarihi geçmiş ürünleri listeleyen bir metot yazınız.

    //todo Son kullanma tarihi geçmemiş ürünleri listeleyen bir metot yazınız. (Son kullanma tarihi boş olanlar da gelmeli.)

}
