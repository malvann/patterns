package com.my.jackson.filter;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@JsonFilter("myFilter")
public class BeanWithFilter {
    private int id;
    private String name;
    private String lastName;
    private int age;
}
