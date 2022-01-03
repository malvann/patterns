package com.my.jackson.backRef;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ItemWithRef {
    public int id;
    public String itemName;
    @JsonManagedReference
    public UserWithRef owner;
}
