package com.matheuscustodio.workshopspringmongodb.services;

import com.matheuscustodio.workshopspringmongodb.domain.Post;
import com.matheuscustodio.workshopspringmongodb.domain.User;
import com.matheuscustodio.workshopspringmongodb.dto.UserDTO;
import com.matheuscustodio.workshopspringmongodb.repository.PostRepository;
import com.matheuscustodio.workshopspringmongodb.repository.UserRepository;
import com.matheuscustodio.workshopspringmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> user = repo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
