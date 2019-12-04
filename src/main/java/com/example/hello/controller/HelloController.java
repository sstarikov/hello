package com.example.hello.controller;

import com.example.hello.model.Hello;
//import com.example.hello.service.HelloService;
import com.example.hello.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private HelloRepository helloRepository;

//    @Autowired
//    private HelloService helloService;


    @GetMapping("/hello/{userName}")
    public String getUser(@PathVariable String userName) {
        return "Hello " + userName + "! Your birthday is " + helloRepository.findByName(userName).getDate_of_birth();
    }


    @PutMapping("/hello/{userName}")
    public ResponseEntity<String> updateUser(@PathVariable String userName,
                                             @Valid @RequestBody Hello helloRequest) {

        if (helloRepository.findByName(userName) == null) {
            Hello storedHello = new Hello(userName,helloRequest.getDate_of_birth());
            storedHello = helloRepository.save(storedHello);
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        } else {
            Hello storedHello = helloRepository.findByName(userName);
            storedHello.setDate_of_birth(helloRequest.getDate_of_birth());
            storedHello = helloRepository.save(storedHello);
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
    }
}
