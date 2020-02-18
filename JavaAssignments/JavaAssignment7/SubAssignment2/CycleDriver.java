/*
Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle.
Add a balance( ) method to Unicycle and Bicycle, but not to Tricycle.
Create instances of all three types and upcast them to an array of Cycle.
Try to call balance( ) on each element of the array and observe the results.
Downcast and call balance( ) and observe what happens.
 */
public class CycleDriver {
    public static void main(String args[]){
        //UPCASTING
        Unicycle unicycle=new Unicycle();
        Bicycle bicycle=new Bicycle();
        Tricycle tricycle=new Tricycle();
        Cycle[] cycles=new Cycle[3];
        cycles[0]=(Cycle)unicycle;
        cycles[1]=(Cycle)bicycle;
        cycles[2]=(Cycle)tricycle;
        for(int i=0;i<3;i++){
            //cycles[i].balance();   CANNOT DO THIS AS THERE IS NO balance() METHOD IN CYCLE CLASS
        }
        //DOWNCASTING
        Cycle cycle=new Cycle();
        Cycle[] cycles1=new Cycle[3];
        cycles1[0]=(Unicycle)cycle;
        cycles1[1]=(Bicycle)cycle;
        cycles1[2]=(Tricycle)cycle;
        for(int i=0;i<3;i++){
           // cycles1[i].balance();  CANNOT DO THIS AS THERE IS NO balance() METHOD IN CYCLE CLASS
        }

    }
}
