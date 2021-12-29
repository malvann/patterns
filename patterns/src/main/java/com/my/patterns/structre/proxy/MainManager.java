package com.my.patterns.structre.proxy;

public class MainManager implements ManagerInterface{
    private ManagerInterface manager;

    public MainManager(ManagerInterface manager) {
        this.manager = manager;
    }

    @Override
    public void operation1() {

    }

    @Override
    public void operation2() {

    }

    @Override
    public void operation3() {

    }
}
