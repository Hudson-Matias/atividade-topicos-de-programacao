package com.example.h2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.lang.model.element.Name;

@AllArgsConstructor
@Getter
@Entity
@Table(name = "tb_book")
@Setter
public class Book {

    @Id
    private Long id;
    private String name;
    private String autor;
}
