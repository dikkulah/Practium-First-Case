package com.dikkulah.firstcase.repositories;

import com.dikkulah.firstcase.entity.Comment;
import com.dikkulah.firstcase.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findCommentsByProduct(Product product);

}
