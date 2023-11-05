package com.example.k2k_project.Service.Impl;

import com.example.k2k_project.Data.CommentDto;
import com.example.k2k_project.Entity.Comment;
import com.example.k2k_project.Repository.CommentRepository;
import com.example.k2k_project.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment getComment(int id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent()) {
            return comment.get();
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void changeComment(int id, CommentDto CommentDto) {
        Optional<Comment> selected_comment = commentRepository.findById(id);
        Comment comment;
        if (selected_comment.isPresent()) {
            comment = selected_comment.get();
            comment.setDetail(comment.getDetail());
            commentRepository.save(comment);
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<Comment> findComments() {
        return commentRepository.findAll();
    }

    @Override
    public void deleteComment(int id) {
        Optional<Comment> selectedComment = commentRepository.findById(id);
        if (selectedComment.isPresent()) {
            commentRepository.deleteById(id);
        }
        else {
            throw new EntityNotFoundException();
        }
    }
}
