package com.my.jackson.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

@Slf4j
public class BeanWithFilterTest {
    @Test
    public void whenSerializingUsingJsonFilter_thenCorrect() throws JsonProcessingException {
        BeanWithFilter bean = new BeanWithFilter(1, "John", "Doe", 20);
        log.info("Bean: {}", bean);
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("myFilter", SimpleBeanPropertyFilter.filterOutAllExcept("name", "lastName"));
        String result = new ObjectMapper().writer(filters).writeValueAsString(bean);
        log.info("result: {}",result);
        assertThat(result, containsString("John"));
        assertThat(result, not(containsString("id")));
    }
}
