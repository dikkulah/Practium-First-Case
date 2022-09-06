package com.dikkulah.firstcase.service;

import com.dikkulah.firstcase.entity.Comment;
import com.dikkulah.firstcase.entity.Product;
import com.dikkulah.firstcase.entity.User;
import com.dikkulah.firstcase.repositories.CommentRepository;
import com.dikkulah.firstcase.repositories.ProductRepository;
import com.dikkulah.firstcase.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {
    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Comment addComment() {
        log.info("Yorum Eklendi.");
        return null;
    }

    //TODO Bir ürüne ait yorumları listeleyen bir metot yazınız.

    public List<Comment> getCommentsOfProductById(Long productId) {
        log.info("Bir Ürünün Tüm Yorumları");
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Bu id de bir ürün yok"));
        return commentRepository.findCommentsByProduct(product);
    }


    //todo Verilen tarih aralıklarında belirli bir ürüne yapılmış olan yorumları gösteren bir metot yazınız.
    public List<Comment> getCommentsOfProductByBetweenTwoDates(Long productId, LocalDate startingDate, LocalDate endingDate) {
        log.info("Bir Ürünün İki Tarih Arasındaki Yorumları");

        return null;
    }

    //todo Bir kullanıcının yapmış olduğu yorumları listeleyen bir metot yazınız.
    public List<Comment> getCommentsOfUserByUserId(Long userId) {
        log.info("Kullanıcının Tüm Yorumları");
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Bu id de bir kullanıcı yok."));
        return commentRepository.findCommentsByUser(user);
    }


    //todo Bir kullanıcının belirli tarihler aralığında yapmış olduğu yorumları gösteren bir metot yazınız.
    public List<Comment> getCommentsOfUserByBetweenTwoDates() {
        log.info("Kullanıcının İki Tarih Arasındaki Yorumları");
        return null;
    }

}
