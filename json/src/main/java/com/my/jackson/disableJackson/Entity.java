package com.my.jackson.disableJackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
public class Entity {
    private int id;
    private String lastName;
    private String name;
    private int age;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private Date date;
}
