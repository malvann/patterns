package com.my.patterns.behavior.command;

public class Editor {
    private String text;

    public String getSelection(){
        return text;
    }

    public void setSelection(String text){
        this.text = text;
    }

    public void deleteSelection(){
        text = null;
    }
}
