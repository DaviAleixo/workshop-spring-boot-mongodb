package com.davialeixo.workshopmongodb.dto;

import com.davialeixo.workshopmongodb.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDTO  implements Serializable {

    private String id;
    private String name;

    public AuthorDTO(User obj){
        id = obj.getId();
        name = obj.getName();
    }
}
