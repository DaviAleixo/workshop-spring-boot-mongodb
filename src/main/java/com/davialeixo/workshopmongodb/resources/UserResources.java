package com.davialeixo.workshopmongodb.resources;

import com.davialeixo.workshopmongodb.domain.User;
import com.davialeixo.workshopmongodb.services.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserResources {


    private final UserService service;

    @GetMapping
    public ResponseEntity <List<User> >findAll () {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
