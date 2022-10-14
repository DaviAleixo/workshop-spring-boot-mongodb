package com.davialeixo.workshopmongodb.services;

import com.davialeixo.workshopmongodb.domain.User;
import com.davialeixo.workshopmongodb.dto.UserDTO;
import com.davialeixo.workshopmongodb.repositories.UserRepository;
import com.davialeixo.workshopmongodb.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();

    }

    public User findById(String id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ObjectNotFoundException("Objeto não encontrado"));
    }
    public User insert(User obj){
        return repo.insert(obj);
    }
    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }


}
