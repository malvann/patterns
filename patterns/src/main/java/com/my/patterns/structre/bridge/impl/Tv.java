package com.my.patterns.structre.bridge.impl;

import com.my.patterns.structre.bridge.Device;

public class Tv implements Device {
    @Override
    public void setEnable(boolean enable) {

    }

    @Override
    public int getVolume() {
        return 0;
    }

    @Override
    public void setVolume(int percent) {

    }

    @Override
    public int getChannel() {
        return 0;
    }

    @Override
    public void setChannel(int channel) {

    }
}
