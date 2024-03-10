package com.example;

public class LeftRightAligning {

    public static String padRight(String s, int n) {
        return "%-".concat(String.valueOf(n)).concat("s").formatted(s);
    }

    public static String padLeft(String s, int n) {
        return "%".concat(String.valueOf(n)).concat("s").formatted(s);
    }

    public static void main(String[] args) {
        System.out.println(padRight("Howto", 20) + "*");
        System.out.println(padLeft("Howto", 20) + "*");
    }
}
