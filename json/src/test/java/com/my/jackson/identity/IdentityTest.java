package com.my.jackson.identity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

@Slf4j
public class IdentityTest {
    @Test
    public void whenSerializingUsingJsonIdentityInfo_thenCorrect() throws JsonProcessingException {
        UserWithIdentity user = new UserWithIdentity(1, "John");
        ItemWithIdentity item = new ItemWithIdentity(2, "book", user);
        user.addItem(item);
        String result = new ObjectMapper().writeValueAsString(item);
        log.info("user: {}",user);
        log.info("item: {}",item);
        log.info("result: {}",result);
        assertThat(result, containsString("book"));
        assertThat(result, containsString("John"));
        assertThat(result, containsString("userItems"));
    }
}
