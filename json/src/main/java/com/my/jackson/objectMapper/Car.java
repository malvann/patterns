package com.my.jackson.objectMapper;

import lombok.*;

import java.util.Date;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String color;
    private String type;
    private Date date;
}
