package com.my.patterns.behavior.chane;

import java.util.concurrent.TimeUnit;

public class StartHandler extends AbstractHandler implements HandlerInterface {

    public StartHandler(String data) {
        this.data = data;
        handler = new NextHandler();
    }

    @Override
    public void business() {
        data.concat(TimeUnit.DAYS.name());
    }

    @Override
    public void setNext() {
        handler.business();
    }
}
