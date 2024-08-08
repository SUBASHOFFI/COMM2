package com.gift.website.service;



import com.gift.website.Modal.Comment;
import com.gift.website.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment addComment(Comment comment) {
        comment.setTimestamp(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    public List<Comment> viewAllComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> viewComment(Long commentId) {
        return commentRepository.findById(commentId);
    }

    public Comment editComment(Long commentId, Comment updatedComment) {
        return commentRepository.findById(commentId)
            .map(comment -> {
                comment.setContent(updatedComment.getContent());
                comment.setTimestamp(LocalDateTime.now());
                return commentRepository.save(comment);
            }).orElseGet(() -> {
                updatedComment.setId(commentId);
                updatedComment.setTimestamp(LocalDateTime.now());
                return commentRepository.save(updatedComment);
            });
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
