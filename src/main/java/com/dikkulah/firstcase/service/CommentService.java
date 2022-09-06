package com.dikkulah.firstcase.service;

import com.dikkulah.firstcase.entity.Comment;
import com.dikkulah.firstcase.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;


    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    //TODO Bir ürüne ait yorumları listeleyen bir metot yazınız.

    //todo Verilen tarih aralıklarında belirli bir ürüne yapılmış olan yorumları gösteren bir metot yazınız.

    //todo Bir kullanıcının yapmış olduğu yorumları listeleyen bir metot yazınız.

    //todo Bir kullanıcının belirli tarihler aralığında yapmış olduğu yorumları gösteren bir metot yazınız.

}
