package com.example.lesson3.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class Singleton {
    private HashMap<String,Integer> singletonHashmap;
}
