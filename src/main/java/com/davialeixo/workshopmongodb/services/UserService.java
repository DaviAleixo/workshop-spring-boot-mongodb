package com.davialeixo.workshopmongodb.services;

import com.davialeixo.workshopmongodb.domain.User;
import com.davialeixo.workshopmongodb.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();

    }
}
