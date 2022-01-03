package com.my.jackson.customAnnotation;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@CustomAnnotation
@Getter
@AllArgsConstructor
@ToString
public class CustomEntity {
    private int id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm")
    private Date creationDate;
    private String name;
    private String lastName;
    private String address;
}
