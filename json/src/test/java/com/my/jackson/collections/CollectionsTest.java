package com.my.jackson.collections;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.Map;

@Slf4j
public class CollectionsTest {

    @Test
    public void listTest() throws JsonProcessingException {
        String json = "[{\"color\":\"Black\",\"type\":\"BMW\"},{\"color\":\"Red\",\"type\":\"FIAT\"}]";
        List<Car> listCar = new ObjectMapper().readValue(json, new TypeReference<>(){});
        log.info("List: {}", listCar);
    }

    @Test
    public void mapTest() throws JsonProcessingException {
        String json = "{\"white\":{\"color\":\"white\",\"type\":\"KIA\"},\"black\":{\"color\":\"black\",\"type\":\"FIAT\"}}";
        Map<String, Object> map = new ObjectMapper().readValue(json, new TypeReference<>(){});
        log.info("Map: {}", map);
    }
}
