
package com.codetutr.model;

import com.codetutr.validator.FidoString;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Animal {

    @NotNull @Min(13)
    private int age;

    @FidoString
    private String name;
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Animal() {
    }
    
    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

}
