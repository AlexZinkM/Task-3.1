package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
@Table(name = "users", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 20, message = "От 2 до 20 знаков")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private byte age;


    public User() {}

    @Override
    public String toString() {
        return "Пользователь №" + (id) + ": " + lastName  + " " + firstName +
                ", возраст " + age;
    }
}


