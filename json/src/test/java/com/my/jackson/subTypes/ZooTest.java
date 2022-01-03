package com.my.jackson.subTypes;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@Slf4j
public class ZooTest {

    @Test
    public void whenSerializingPolymorphic_thenCorrect() throws IOException {
        Dog dog = new Dog("lacy");
        Zoo zoo = new Zoo(dog);
        String result = new ObjectMapper().writeValueAsString(zoo);
        log.info(result);
        assertThat(result, containsString("type"));
        assertThat(result, containsString("dog"));
    }

    @Test
    public void whenDeserializingPolymorphic_thenCorrect() throws IOException {
        String json = "{\"animal\":{\"name\":\"lacy\",\"type\":\"cat\"}}";
        Zoo zoo = new ObjectMapper().readValue(json, Zoo.class);
        log.info(zoo.toString());
        assertEquals("lacy", zoo.getAnimal().name);
        assertEquals(Cat.class, zoo.getAnimal().getClass());
    }

    @Test
    public void whenDeserializingPolymorphicFroFile_thenCorrect() throws IOException {
        File json = new File("src/test/resources/jackson/zoo/entity.json");
        Zoo zoo = new ObjectMapper().readValue(json, Zoo.class);
        log.info(zoo.toString());
        assertEquals("lacy", zoo.getAnimal().getName());
        assertEquals(Cat.class, zoo.getAnimal().getClass());
    }
}
