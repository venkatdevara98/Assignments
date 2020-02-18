package assignment7.cycle;

public class Tricycle implements Cycle {
    @Override
    public void move() {
       System.out.println("Tricycle is moving");
    }

    @Override
    public int getNumberOfWheels() {
        return 3;
    }
}
