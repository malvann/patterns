package com.my.jackson.ref;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

@Slf4j
public class RerTest {
    @Test
    public void whenSerializingUsingJacksonReferenceAnnotation_thenCorrect() throws JsonProcessingException {
        UserWithRef user = new UserWithRef(1, "John");
        ItemWithRef item = new ItemWithRef(2, "book", user);
        user.addItem(item);
        String result = new ObjectMapper().writeValueAsString(item);
        log.info("user: {}", user);
        log.info("item: {}", item);
        log.info("result: {}", result);
        assertThat(result, containsString("book"));
        assertThat(result, containsString("John"));
        assertThat(result, not(containsString("userItems")));
    }
}
