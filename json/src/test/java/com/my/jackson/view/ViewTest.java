package com.my.jackson.view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

@Slf4j
public class ViewTest {

    @Test
    public void whenSerializingUsingJsonView_thenCorrect() throws JsonProcessingException {
        Item item = new Item(2, "book", "John");
        String result = new ObjectMapper().writerWithView(Views.Public.class).writeValueAsString(item);
        log.info(item.toString());
        log.info(result);
        assertThat(result, containsString("boo"));
        assertThat(result, containsString("2"));
        assertThat(result, not(containsString("John")));
    }
}
