package com.estsoft.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostContent {
    private int userId;
    private int id;
    private String title;
    private String body;

    @Override
    public String toString() {
        return id + ", " + title + "\n" ;
    }
}
