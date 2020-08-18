package com.example.demo.pojo;

import lombok.Data;

import java.util.List;

@Data
public class MainMenu {

    private int id;
    private String title;
    private String path;
    private List<SubMenu> sList;
}
