package com.my.jackson.ignore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.jackson.ignoreType.Customer;
import com.my.jackson.ignoreType.Item;
import com.my.jackson.ignoreType.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

@Slf4j
public class IgnoreTypeClassTest {
    @Test
    public void whenSerializingUsingMixInAnnotation_thenCorrect() throws JsonProcessingException {
        Item item = new Item("Lee", UUID.randomUUID().toString(), new User());
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(item);
        log.info("Item: {}", item);
        log.info("Json: {}", result);
        assertThat(result, containsString("owner"));

        //it's important to create new ObjectMapper()!!
        mapper = new ObjectMapper().addMixIn(User.class, Customer.class);
        result = mapper.writeValueAsString(item);
        log.info("Json: {}", result);
        assertThat(result, not(containsString("owner")));
    }

    @Test
    public void checkJsonIgnoreId() throws JsonProcessingException {
        Item item = new Item("Lee", UUID.randomUUID().toString(), new User());
        String result = new ObjectMapper().writeValueAsString(item);
        log.info("Item: {}", item);
        log.info("Json: {}", result);
        assertThat(result, not(containsString("id")));
    }
}
