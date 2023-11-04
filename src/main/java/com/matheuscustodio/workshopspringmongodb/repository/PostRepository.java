package com.matheuscustodio.workshopspringmongodb.repository;

import com.matheuscustodio.workshopspringmongodb.domain.Post;
import com.matheuscustodio.workshopspringmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContainingIgnoreCase(String text);
}
