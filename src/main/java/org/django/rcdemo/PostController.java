package org.django.rcdemo;

import org.django.rcdemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/getPosts")
    List<Map<String,Object>> getAllPosts(){
        return   postService.getPosts();
    }

    @GetMapping("/getPostsById/{id}")
    Map<String,Object>getPostByid(@PathVariable int id ){
        return   postService.getPostsById(id);
    }

    @PostMapping("/insertPosts")
    Map<String,Object>insertPost(@RequestBody Map<String,Object> payload ){
        return   postService.insertPosts(payload);
    }

    @PutMapping("/updatePosts/{id}")
    Map<String,Object>updatePost(@RequestBody Map<String,Object> payload , @PathVariable int id  ){
        return   postService.updatePosts(payload, id );
    }

    @DeleteMapping("/deletePosts/{id}")
    Map<String,Object>deletePosts( @PathVariable int id  ){
        return   postService.deletePost( id );
    }
}
