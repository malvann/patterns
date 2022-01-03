package com.my.jackson.objectMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

@Slf4j
public class ObjMapperTest {
    @Test
    public void whenSerialise_thenContainsTrue() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String jsonString = "{\"color\":\"Black\",\"type\":\"Fiat\",\"year\":\"1970\"}";
        Car car = objectMapper.readValue(jsonString, Car.class);
        log.info("Car: {}", car);
        JsonNode jsonNodeTree = objectMapper.readTree(jsonString);
        JsonNode jsonNodeYear = jsonNodeTree.get("year");
        assertEquals("1970", jsonNodeYear.asText());
    }

    @Test(expected = UnrecognizedPropertyException.class)
    public void whenSerialise_thenThrowsEUnrecognizedPropertyException() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        String jsonString = "{\"color\":\"Black\",\"type\":\"Fiat\",\"owner\":\"Bob\"}";
        objectMapper.readValue(jsonString, Car.class);
    }

    @Test
    public void customSerialise_thenTrue() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("CustomCarSerializer", new Version(1, 0, 0, null, null, null));
        module.addSerializer(Car.class, new CarSerializer());
        mapper.registerModule(module);
        Car car = new Car("yellow", "renault", null);
        String carJson = mapper.writeValueAsString(car);
        log.info("Car: {}", car);
        log.info("Json: {}", carJson);
        assertThat(carJson, containsString("car_brand"));
        assertThat(carJson, containsString("renault"));
    }

    @Test
    public void customDeserialize_thenTrue() throws JsonProcessingException {
        var json = "{\"color\":\"Black\",\"type\":\"BMW\"}";
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("CustomCarDeserializer", new Version(1, 0, 0, null, null, null));
        module.addDeserializer(Car.class, new CarDeserializer());
        mapper.registerModule(module);
        Car car = mapper.readValue(json, Car.class);
        log.info("Car: {}", car);
        assertEquals("Black", car.getColor());
        assertNull(car.getType());
    }

    @Test
    public void objectMapperSerialize_withDateFormat() throws JsonProcessingException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        ObjectMapper objectMapper = new ObjectMapper().setDateFormat(df);
        Date date = new Date();
        Car car = new Car("yellow", "renault", date);
        String result = objectMapper.writeValueAsString(car);
        log.info("Json: {}", result);
        String strDate = df.format(date);
        assertThat(result, containsString(strDate));
    }
}
