package com.matheuscustodio.workshopspringmongodb.services;

import com.matheuscustodio.workshopspringmongodb.domain.User;
import com.matheuscustodio.workshopspringmongodb.dto.UserDTO;
import com.matheuscustodio.workshopspringmongodb.repository.UserRepository;
import com.matheuscustodio.workshopspringmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> user = repo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO obj){
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }
}
