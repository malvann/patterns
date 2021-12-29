package com.my.patterns.creating.builder.entity;

import java.util.Objects;

public class House {
    Element foundation;
    Element walls;
    Element roof;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return foundation == house.foundation && walls == house.walls && roof == house.roof;
    }

    @Override
    public int hashCode() {
        return Objects.hash(foundation, walls, roof);
    }

    public Element getFoundation() {
        return foundation;
    }

    public void setFoundation(Element foundation) {
        this.foundation = foundation;
    }

    public Element getWalls() {
        return walls;
    }

    public void setWalls(Element walls) {
        this.walls = walls;
    }

    public Element getRoof() {
        return roof;
    }

    public void setRoof(Element roof) {
        this.roof = roof;
    }
}
