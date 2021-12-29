package com.my.patterns.creating.builder.entity;

import java.util.Objects;

public class Docs {
    private String foundation;
    private String walls;
    private String roof;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Docs docs = (Docs) o;
        return Objects.equals(foundation, docs.foundation) && Objects.equals(walls, docs.walls) && Objects.equals(roof, docs.roof);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foundation, walls, roof);
    }

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public String getWalls() {
        return walls;
    }

    public void setWalls(String walls) {
        this.walls = walls;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }
}
