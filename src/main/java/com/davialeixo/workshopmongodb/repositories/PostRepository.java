package com.davialeixo.workshopmongodb.repositories;

import com.davialeixo.workshopmongodb.domain.Post;
import com.davialeixo.workshopmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);

}
