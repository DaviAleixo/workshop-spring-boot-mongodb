package com.davialeixo.workshopmongodb.resources;

import com.davialeixo.workshopmongodb.domain.Post;
import com.davialeixo.workshopmongodb.resources.util.URL;
import com.davialeixo.workshopmongodb.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/posts")
@RequiredArgsConstructor
public class PostResources {
    private final PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = findByTitle(text).getBody();
        return ResponseEntity.ok().body(list);

    }
}
