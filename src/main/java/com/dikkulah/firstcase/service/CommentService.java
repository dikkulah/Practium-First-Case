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

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {
    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private static final  String USER_NOT_FOUND = "Böyle bir kullanıcı mevcut değil.";
    private static  final String PRODUCT_NOT_FOUND = "Böyle bir ürün mevcut değil.";

    @Transactional
    public Comment addComment(Long userId,Long productId,String comment) {
        log.info("Yorum Eklendi.");
        Comment newComment = new Comment();
        newComment.setCommentDate(LocalDateTime.now());
        newComment.setUser(userRepository.findById(userId).orElseThrow(() -> new RuntimeException(USER_NOT_FOUND)));
        newComment.setProduct(productRepository.findById(productId).orElseThrow(() -> new RuntimeException(PRODUCT_NOT_FOUND)));
        newComment.setCommentText(comment);
        return commentRepository.save(newComment);
    }

    //Bir ürüne ait yorumları listeleyen bir metot yazınız.

    public List<Comment> getCommentsOfProductById(Long productId) {
        log.info("Ürünün Tüm Yorumları");
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException(PRODUCT_NOT_FOUND));
        return commentRepository.findCommentsByProduct(product);
    }


    //Verilen tarih aralıklarında belirli bir ürüne yapılmış olan yorumları gösteren bir metot yazınız.
    public List<Comment> getCommentsOfProductByBetweenTwoDates(Long productId, LocalDateTime startingDateTime, LocalDateTime endingDateTime) {
        log.info("Ürünün İki Tarih Arasındaki Yorumları");
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException(PRODUCT_NOT_FOUND));
        return commentRepository.findCommentsByProductBetweenDates(product,startingDateTime,endingDateTime);
    }

    // Bir kullanıcının yapmış olduğu yorumları listeleyen bir metot yazınız.
    public List<Comment> getCommentsOfUserByUserId(Long userId) {
        log.info("Kullanıcının Tüm Yorumları");
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException(USER_NOT_FOUND));
        return commentRepository.findCommentsByUser(user);
    }


    //Bir kullanıcının belirli tarihler aralığında yapmış olduğu yorumları gösteren bir metot yazınız.
    public List<Comment> getCommentsOfUserByBetweenTwoDates(Long userId, LocalDateTime startingDateTime, LocalDateTime endingDateTime) {
        log.info("Kullanıcının İki Tarih Arasındaki Yorumları");
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException(USER_NOT_FOUND));
        return commentRepository.findCommentsByUserBetweenDates(user,startingDateTime,endingDateTime);
    }

}
