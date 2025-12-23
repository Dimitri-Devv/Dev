package fr.dawan.springcore.beans;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class User {

    private final String name;
    
    private String password;
    
}
