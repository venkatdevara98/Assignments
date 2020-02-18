package assignment7.cycle;

public class Bicycle implements Cycle {
    @Override
    public void move() {
       System.out.println("Bicycle is moving");
    }

    @Override
    public int getNumberOfWheels() {
        return 2;
    }
}
