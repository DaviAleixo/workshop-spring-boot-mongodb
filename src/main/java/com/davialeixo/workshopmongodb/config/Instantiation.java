package com.davialeixo.workshopmongodb.config;

import com.davialeixo.workshopmongodb.domain.Post;
import com.davialeixo.workshopmongodb.domain.User;
import com.davialeixo.workshopmongodb.repositories.PostRepository;
import com.davialeixo.workshopmongodb.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@RequiredArgsConstructor
@Configuration
public class Instantiation implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null,
                sdf.parse("21/03/2018")
                ,"Partiu viagem!"
                ,"Vou viajar para Sao Paulo. Abraços!"
        ,maria);

        Post post2 = new Post(null,
                sdf.parse("23/03/2018")
                ,"Bom dia!"
                ,"Acordei feliz hoje!"
        ,maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));

    }
}
