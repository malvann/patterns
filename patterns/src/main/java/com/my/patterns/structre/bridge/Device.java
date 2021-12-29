package com.my.patterns.structre.bridge;

public interface Device {
    void setEnable(boolean enable);
    int getVolume();
    void setVolume(int percent);
    int getChannel();
    void setChannel(int channel);
}
