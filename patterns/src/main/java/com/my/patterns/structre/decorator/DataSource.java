package com.my.patterns.structre.decorator;

public interface DataSource {
    void write(String data);
    String read();
}
