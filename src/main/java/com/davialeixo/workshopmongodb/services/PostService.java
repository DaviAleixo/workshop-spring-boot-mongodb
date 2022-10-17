package com.davialeixo.workshopmongodb.services;
import com.davialeixo.workshopmongodb.domain.Post;
import com.davialeixo.workshopmongodb.domain.User;
import com.davialeixo.workshopmongodb.repositories.PostRepository;
import com.davialeixo.workshopmongodb.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repo;

    public Post findById(String id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle (String text){
        return repo.findByTitleContainingIgnoreCase(text);
    }


}

