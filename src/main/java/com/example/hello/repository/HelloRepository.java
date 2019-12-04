package com.example.hello.repository;

import com.example.hello.model.Hello;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<Hello, Long> {
    Hello findByName(String user_name);
}
