package com.example.k2k_project.Service;

import com.example.k2k_project.Data.CommentDto;
import com.example.k2k_project.Entity.Comment;

import java.util.List;

public interface CommentService {
    Comment getComment(long id);
    void saveComment(Comment comment);
    void changeComment(long id, CommentDto CommentDto);
    List<Comment> findComments();
    void deleteComment(long id);
}
