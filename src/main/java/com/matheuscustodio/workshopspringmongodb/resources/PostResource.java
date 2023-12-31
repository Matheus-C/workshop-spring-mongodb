package com.matheuscustodio.workshopspringmongodb.resources;

import com.matheuscustodio.workshopspringmongodb.domain.Post;
import com.matheuscustodio.workshopspringmongodb.resources.util.URL;
import com.matheuscustodio.workshopspringmongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "text", defaultValue = "") String text,
                                                 @RequestParam(value = "min", defaultValue = "") String min,
                                                 @RequestParam(value = "max", defaultValue = "") String max){
        text = URL.decodeParam(text);
        LocalDate minDate = URL.convertDate(min, LocalDate.of(2000, 1, 1));
        LocalDate maxDate = URL.convertDate(max, LocalDate.now());
        List<Post> list = service.fullSearch(text, minDate, maxDate);
        return ResponseEntity.ok().body(list);
    }

}
