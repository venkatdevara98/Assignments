package assignment7.cycle;

public class CycleFactory {
    public Cycle getCycle(String cycleType){
        if(cycleType.equals("Unicycle")){
            return new Unicycle();
        }
        else if(cycleType.equals("Bicycle")){
            return new Bicycle();
        }
        if(cycleType.equals("Tricycle")){
            return new Tricycle();
        }
        return null;
    }
}
