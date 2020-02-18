/*
Create a class with a constructor that takes a String argument.
During construction, print the argument.
Create an array of object references to this class, but don’t actually create objects to assign into the array.
When you run the program, notice whether the initialization messages from the constructor calls are printed.
Complete the previous exercise by creating objects to attach to the array of references.


 */
public class ConstructorInitializationWithObjects {
    ConstructorInitializationWithObjects(String message){
        System.out.println(message);
    }
    public static void main(String args[]){
        ConstructorInitializationWithObjects[] objectReferences=new ConstructorInitializationWithObjects[5];
        for(int i=0;i<5;i++){
            objectReferences[i]=new ConstructorInitializationWithObjects("this message");
        }
    }
}
