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
    public void deleteById(String id){
        repo.findById(id);
        repo.deleteById(id);
    }

    public User update (User newObj){
        var oldObj = repo.findById(newObj.getId());
        oldObj.ifPresent(user -> updateData(newObj, user));

        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());

    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }


}
