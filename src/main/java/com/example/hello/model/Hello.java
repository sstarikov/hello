package com.example.hello.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "hello")

public class Hello {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

//    @NotBlank
//    @Size(min = 3, max = 20)
    @Column(nullable = false, unique = true)
    private String name;


    @Column()
    public Date date_of_birth;

    public Hello() {}

    public Hello(String name, Date date_of_birth) {
        this.name = name;
        this.date_of_birth = date_of_birth;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
