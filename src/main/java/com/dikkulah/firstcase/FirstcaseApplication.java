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
import java.time.LocalDateTime;

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

        User fatih = new User();
        fatih.setName("fatih");
        fatih.setLastName("Yılmaz");
        fatih.setPhone("05536633774");
        fatih.setEmail("fatih@gmail.com");
        log.info(userService.createUser(fatih).toString());

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


        commentService.addComment(1L,1L,"yorum 1");




        log.info(productService.getExpiredProducts().toString());

        log.info(productService.getNonExpiredProducts().toString());

        log.info(commentService.getCommentsOfUserByBetweenTwoDates(1L, LocalDateTime.of(2021,5,5,5,5),LocalDateTime.of(2025,5,5,10,10)).toString());

        log.info(commentService.getCommentsOfProductByBetweenTwoDates(1L, LocalDateTime.of(2021,5,5,5,5),LocalDateTime.of(2023,5,5,5,5)).toString());

        log.info(commentService.getCommentsOfUserByUserId(1L).toString());

        log.info(commentService.getCommentsOfProductById(1L).toString());

    }
}
