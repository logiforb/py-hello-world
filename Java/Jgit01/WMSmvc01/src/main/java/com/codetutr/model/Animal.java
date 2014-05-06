
package com.codetutr.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Animal {

    @NotNull @Min(13)
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Animal() {
    }
    
    public Animal(int age) {
        this.age = age;
    }

}
