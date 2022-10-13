package com.davialeixo.workshopmongodb.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Document
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    private String email;

}
