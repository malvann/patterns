package com.my.jackson.ignoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Item {
    private String name;
    private String id;
    private User owner;
}
