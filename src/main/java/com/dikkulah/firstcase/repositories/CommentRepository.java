package com.dikkulah.firstcase.repositories;

import com.dikkulah.firstcase.entity.Comment;
import com.dikkulah.firstcase.entity.Product;
import com.dikkulah.firstcase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentsByProduct(Product product);

    List<Comment> findCommentsByUser(User user);

    @Query("select a from Comment a where a.product= :product " +
            "and a.commentDate >= (cast(:startingDateTime as timestamp)) " +
            "and a.commentDate <= (cast(:endingDateTime as timestamp))")
    List<Comment> findCommentsByProductBetweenDates(@Param("product") Product product,
                                                    @Param("startingDateTime") LocalDateTime startingDateTime,
                                                    @Param("endingDateTime") LocalDateTime endingDateTime);

    @Query("select a from Comment a where a.user = :user " +
            "and a.commentDate >= (cast(:startingDateTime as timestamp)) " +
            "and a.commentDate <= (cast(:endingDateTime as timestamp))")
    List<Comment> findCommentsByUserBetweenDates(@Param("user") User user,
                                                 @Param("startingDateTime") LocalDateTime startingDateTime,
                                                 @Param("endingDateTime") LocalDateTime endingDateTime);
}
