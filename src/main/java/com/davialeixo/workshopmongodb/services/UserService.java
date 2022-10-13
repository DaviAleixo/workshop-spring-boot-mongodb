package com.davialeixo.workshopmongodb.services;

import com.davialeixo.workshopmongodb.domain.User;
import com.davialeixo.workshopmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();

    }
}
