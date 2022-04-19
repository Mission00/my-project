package com.example.demo.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.awt.print.Book;
import java.util.List;


@ToString
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String head;
    private String face;

}
