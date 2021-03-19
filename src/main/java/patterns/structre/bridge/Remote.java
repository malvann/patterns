package patterns.structre.bridge;

public class Remote {
    private Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public void off(){
        device.setEnable(false);
    }

    public void volumeUp(){
        int current = device.getVolume();
        device.setVolume(current+1);
    }

    public void volumeDown(){
        int current = device.getVolume();
        device.setVolume(current-1);
    }
    public void channelUp(){
        int current = device.getChannel();
        device.setChannel(current+1);
    }

    public void channelDown(){
        int current = device.getChannel();
        device.setChannel(current+1);
    }
}
