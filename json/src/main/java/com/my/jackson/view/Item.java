package com.my.jackson.view;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Item {
    @JsonView(Views.Public.class)
    public int id;
    @JsonView(Views.Public.class)
    public String itemName;
    @JsonView(Views.Internal.class)
    public String ownerName;
}
