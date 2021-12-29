package com.my.jackson.composit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.my.jackson.composit.CompositeEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@Slf4j
public class CompositeEntityTest {

    @Test
    public void whenSerializingUsingJsonAnyGetter_thenCorrect()
            throws JsonProcessingException {
        CompositeEntity entity = new CompositeEntity("Entity");
        entity.add("attr1", "val1");
        entity.add("attr2", "val2");
        String result = new ObjectMapper().writeValueAsString(entity);
        log.info(entity.toString());
        log.info(result);
        assertThat(result, containsString("attr1"));
        assertThat(result, containsString("val1"));
    }

    @Test
    public void whenSerializingUsingJsonRootName_thenCorrect() throws JsonProcessingException {
        CompositeEntity user = new CompositeEntity("John");
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String result = mapper.writeValueAsString(user);
        log.info(result);
        assertThat(result, containsString("John"));
        assertThat(result, containsString("Composite"));
    }

    @Test
    public void whenDeserializingUsingJsonAnySetter_thenCorrect() throws IOException {
        String json = "{\"name\":\"My bean\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";
        CompositeEntity bean = new ObjectMapper().readValue(json, CompositeEntity.class);
        log.info(bean.toString());
        assertEquals("My bean", bean.getName());
        assertEquals("val2", bean.getProperties().get("attr2"));
    }

    @Test
    public void whenDeserializingUsingJsonSetter_thenCorrect() throws JsonProcessingException {
        String json = "{\"name\":\"John\"}";
        CompositeEntity bean = new ObjectMapper().readerFor(CompositeEntity.class).readValue(json);
        log.info(bean.toString());
        assertEquals("John", bean.getName());
    }
}