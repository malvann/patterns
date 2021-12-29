package com.my.jackson.zoo;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@JsonTypeName("dog")
@ToString
public class Dog extends Animal {
    private double barkVolume;

    public Dog(String name) {
        this.name = name;
    }
}
