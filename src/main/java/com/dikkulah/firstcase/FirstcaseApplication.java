package com.dikkulah.firstcase;


import com.dikkulah.firstcase.entity.Product;
import com.dikkulah.firstcase.entity.User;
import com.dikkulah.firstcase.service.CommentService;
import com.dikkulah.firstcase.service.ProductService;
import com.dikkulah.firstcase.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
@Slf4j
public class FirstcaseApplication implements CommandLineRunner {
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(FirstcaseApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        User ufuk = new User();
        ufuk.setName("ufuk");
        ufuk.setLastName("Dikkülah");
        ufuk.setPhone("05536633774");
        ufuk.setEmail("dikkulah@gmail.com");
        log.info(userService.createUser(ufuk).toString());

        Product samsung = new Product();
        samsung.setName("Samsung");
        samsung.setPrice(BigDecimal.TEN);
        samsung.setExpirationDate(LocalDate.of(2022,9,3));
        productService.addProduct(samsung);

        Product lg = new Product();
        lg.setName("LG");
        lg.setPrice(BigDecimal.TEN);
        lg.setExpirationDate(LocalDate.of(2022,9,12));
        productService.addProduct(lg);

        Product apple = new Product();
        apple.setName("Apple");
        apple.setPrice(BigDecimal.TEN);
        apple.setExpirationDate(null);
        productService.addProduct(apple);

        log.info(productService.getExpiredProducts().toString());

        log.info(productService.getNonExpiredProducts().toString());
    }
}
