package com.my.jackson.customAnnotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

@Slf4j
public class CustomEntityWithAnnotationInsideTest {
    @Test
    public void whenSerializingUsingCustomAnnotation_thenCorrect() throws JsonProcessingException {
        CustomEntity bean = new CustomEntity(1, new Date(), "John", "Doe", null);
        String result = new ObjectMapper().writeValueAsString(bean);
        log.info("CustomEntity {}", bean);
        log.info(result);
        assertThat(result, containsString("Doe"));
        assertThat(result, containsString("1"));
        assertThat(result, not(containsString("address")));
    }
}
