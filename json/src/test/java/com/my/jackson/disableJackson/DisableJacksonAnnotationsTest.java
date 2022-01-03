package com.my.jackson.disableJackson;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

@Slf4j
public class DisableJacksonAnnotationsTest {
    @Test
    public void whenDisablingAllAnnotations_thenAllDisabled() throws IOException {
        Entity entity = new Entity(1, null, null, 18, new Date());
        log.info("Entity: {}", entity);
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(entity);
        log.info("Json: {}", result);

        mapper = new ObjectMapper().disable(MapperFeature.USE_ANNOTATIONS);
        result = mapper.writeValueAsString(entity);
        log.info("Json: {}", result);
        assertThat(result, containsString("1"));
        assertThat(result, containsString("name"));
    }
}
