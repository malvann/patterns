package com.my.jackson.zoo;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//IMPORTANT!! it U want not to have: com.fasterxml.jackson.databind.exc.InvalidDefinitionException:
// Cannot construct instance of `com.my.jackson.zoo.Zoo` no Creators, like default construct, exist): cannot deserialize
// from Object value (no delegate- or property-based Creator)
// at [Source: (File); line: 1, column: 2] use @NoArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Zoo {
    private Animal animal;

    public Zoo(Dog dog) {
        this.animal = dog;
    }

    @JsonAnySetter
    public void setAnimal(Animal animal){
        this.animal = animal;
    }
}
