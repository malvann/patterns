package com.my.jackson.identity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserWithIdentity {
    private int id;
    private String name;
    private List<ItemWithIdentity> userItems = new ArrayList<>();

    public UserWithIdentity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addItem(ItemWithIdentity item) {
        userItems.add(item);
    }
}
