package com.gift.website.Controller;


import com.gift.website.Modal.Comment;
import com.gift.website.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/forum")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        Comment newComment = commentService.addComment(comment);
        return ResponseEntity.ok(newComment);
    }

    @GetMapping("/getAllComments")
    public ResponseEntity<List<Comment>> viewAllComments() {
        List<Comment> comments = commentService.viewAllComments();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/getComment")
    public ResponseEntity<Optional<Comment>> viewComment(@RequestParam Long commentId) {
        Optional<Comment> comment = commentService.viewComment(commentId);
        return ResponseEntity.ok(comment);
    }

    @PutMapping("/editComment/{commentId}")
    public ResponseEntity<Comment> editComment(@PathVariable Long commentId, @RequestBody Comment updatedComment) {
        Comment comment = commentService.editComment(commentId, updatedComment);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("/deleteComment/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok().build();
    }
}
