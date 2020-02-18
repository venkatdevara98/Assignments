/*
Create a Cycle interface, with implementations Unicycle, Bicycle and Tricycle.
 Create factories for each type of Cycle, and code that uses these factories.
 */
package assignment7.cycle;

import java.util.Scanner;

public class CycleDriver {
    public static void main(String args[]){
        CycleFactory cycleFactory=new CycleFactory();
        System.out.println("Enter the name of cycle you want to create : \n 'Unicycle' to create Unicycle \n " +
                "'Bicycle' to create Bicycle \n 'Tricycle' to create Tricycle ");
        Scanner scanner=new Scanner(System.in);
        String cycleName=scanner.nextLine();
        Cycle cycle=cycleFactory.getCycle(cycleName);
        System.out.println("Number of wheels in "+cycleName+" are "+cycle.getNumberOfWheels());
        cycle.move();
    }
}
