package exercise.controller;

import exercise.model.Comment;
import exercise.model.Post;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import exercise.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

// BEGIN
@RestController
@RequestMapping("/comments")
public class CommentsController {

    private final CommentRepository commentRepository;

    public CommentsController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("")
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable long id) {
        var comment = commentRepository.findById(id);
        return comment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<Comment> create(Comment post) {
        var saved = commentRepository.save(post);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> update(@PathVariable long id, @RequestBody Comment post) {
        post.setId(id);
        var saved = commentRepository.save(post);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        commentRepository.deleteById(id);
        return ResponseEntity.ok("");
    }
}
// END
