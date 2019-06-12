package dungeon;

public class Torch {
    private int battery;

    public Torch(int battery) {
        this.battery = battery;
    }

    public void blink() {
        battery--;
    }

    public int getBattery() {
        return battery;
    }

}
