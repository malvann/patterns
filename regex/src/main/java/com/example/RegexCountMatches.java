package com.example;

import java.util.regex.Pattern;

public class RegexCountMatches {
    long countMatch(String pattern, String source){
        Pattern p = Pattern.compile(pattern);
        return p.matcher(source).results().count();
    }
}
