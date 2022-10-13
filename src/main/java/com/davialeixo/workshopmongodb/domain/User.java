package com.davialeixo.workshopmongodb.domain;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User implements Serializable {

    private String id;
    private String name;
    private String email;

}
