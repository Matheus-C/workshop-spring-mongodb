package com.matheuscustodio.workshopspringmongodb.resources;

import com.matheuscustodio.workshopspringmongodb.domain.User;
import com.matheuscustodio.workshopspringmongodb.dto.UserDTO;
import com.matheuscustodio.workshopspringmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x->new UserDTO(x)).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = service.findById(id);
        UserDTO dto = new UserDTO(user);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO){
        User obj = service.fromDTO(objDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
