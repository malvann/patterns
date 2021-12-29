package com.my.patterns.creating.builder.impl;

import com.my.patterns.creating.builder.Builder;
import com.my.patterns.creating.builder.entity.House;
import com.my.patterns.creating.builder.entity.Element;

public class HouseBuilder  implements Builder<House> {
    private House house;

    @Override
    public void reset() {
        house = new House();
    }

    @Override
    public void setFoundation() {
        house.setFoundation(Element.FOUNDATION);
    }

    @Override
    public void setWalls() {
        house.setWalls(Element.WALLS);
    }

    @Override
    public void setRoof() {
        house.setRoof(Element.ROOF);
    }

    @Override
    public House getResult() {
        return house;
    }
}
