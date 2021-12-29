package com.my.jackson.filter;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@JsonFilter("myFilter")
public class BeanWithFilter {
    public int id;
    public String name;
}
