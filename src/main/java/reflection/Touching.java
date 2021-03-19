package reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MyCustom{
    private static String STATIC;
    public String name;
    private int age;

    public MyCustom() { }

    public MyCustom(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public MyCustom(String name) {
        this.name = name;
    }

    public void printData(){
        System.out.println(name + " " + age);
    }
}

class MySecond extends MyCustom{
    private String smth;

    public MySecond(String name, int age, String smth) {
        super(name, age);
        this.smth = smth;
    }
}
