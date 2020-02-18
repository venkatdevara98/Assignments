package assignment7.cycle;

public class Unicycle implements Cycle {

    @Override
    public void move() {
          System.out.println("Unicycle is moving");
    }

    @Override
    public int getNumberOfWheels() {
        return 1;
    }
}
