package com.my.patterns.structre.flyweight.flyweight;

import java.util.ArrayList;
import java.util.List;

public class FactoryOfTrees {
    static List<TreeType> typesList = new ArrayList<>();

    static TreeType getTreeType(String name, String color){
        return typesList.stream().filter(t -> t.color.equals(color)).filter(t -> t.name.equals(name))
                .findAny().orElse(new TreeType(name, color));
    }
}
