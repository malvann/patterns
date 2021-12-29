package com.my.jackson.composit;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
@NoArgsConstructor
@JsonRootName(value = "Composite")
public class CompositeEntity {
    private String name;
    private final Map<String, String> properties = new HashMap<>();

    public CompositeEntity(String name) {
        this.name = name;
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    public String getName() {
        return name;
    }

    @JsonAnySetter
    public void add(String key, String val) {
        properties.put(key, val);
    }
}
