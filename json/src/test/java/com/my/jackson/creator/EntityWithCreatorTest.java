package com.my.jackson.creator;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@Slf4j
public class EntityWithCreatorTest {
    @Test
    public void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {
        String json = "{\"id\":1,\"theName\":\"Entity\"}";
        EntityWithCreator entity = new ObjectMapper().readerFor(EntityWithCreator.class).readValue(json);
        log.info(entity.toString());
        assertEquals("Entity", entity.name);
    }
}
