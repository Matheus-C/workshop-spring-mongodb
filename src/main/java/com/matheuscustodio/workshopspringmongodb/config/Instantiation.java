package com.matheuscustodio.workshopspringmongodb.config;

import com.matheuscustodio.workshopspringmongodb.domain.Post;
import com.matheuscustodio.workshopspringmongodb.domain.User;
import com.matheuscustodio.workshopspringmongodb.dto.AuthorDTO;
import com.matheuscustodio.workshopspringmongodb.repository.PostRepository;
import com.matheuscustodio.workshopspringmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository repoUser;
    @Autowired
    private PostRepository repoPost;

    @Override
    public void run(String... args) throws Exception {
        repoUser.deleteAll();
        repoPost.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        repoUser.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, LocalDate.parse("21/03/2018", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, LocalDate.parse("23/03/2018", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        repoPost.saveAll(Arrays.asList(post1, post2));
    }
}
