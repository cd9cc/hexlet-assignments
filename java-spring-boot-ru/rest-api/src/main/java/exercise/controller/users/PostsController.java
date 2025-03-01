package exercise.controller.users;

import java.util.List;

import exercise.dto.PostRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
class PostsController {
    private final List<Post> posts = Data.getPosts();

    @GetMapping("/users/{userId}/posts")
    private List<Post> getPosts(@PathVariable Integer userId) {
        return posts.stream().filter(p -> p.getUserId() == userId).toList();
    }

    @PostMapping("/users/{userId}/posts")
    private ResponseEntity<Post> createPost(@PathVariable Integer userId, @RequestBody PostRequest postDto) {
        var post = new Post();
        post.setUserId(userId);
        post.setBody(postDto.body());
        post.setTitle(postDto.title());
        post.setSlug(postDto.slug());
        posts.add(post);
        return ResponseEntity.status(201).body(post);
    }
}
// END
