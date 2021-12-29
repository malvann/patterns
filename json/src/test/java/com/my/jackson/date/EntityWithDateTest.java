package com.my.jackson.date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@Slf4j
public class EntityWithDateTest {
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    @Test
    public void whenSerializingUsingJsonSerialize_thenCorrect() throws JsonProcessingException, ParseException {
        String toParse = "20-12-2014 02:30:00";
        Date date = formatter.parse(toParse);
        EntityWithDate entity = new EntityWithDate("party", date, new Date());
        String result = new ObjectMapper().writeValueAsString(entity);
        log.info(result);
        assertThat(result, containsString(toParse));
    }

    @Test
    public void whenDeserializingUsingJsonDeserialize_thenCorrect() throws JsonProcessingException {
        String json = "{\"name\":\"party\",\"eventDate\":\"20-12-2014 02:30:00\",\"autoFormatDay\":\"29-12-2021 10:06:01\"}";
        EntityWithDate event = new ObjectMapper().readerFor(EntityWithDate.class).readValue(json);
        log.info(event.toString());
        assertEquals("20-12-2014 02:30:00", formatter.format(event.getEventDate()));
    }
}
