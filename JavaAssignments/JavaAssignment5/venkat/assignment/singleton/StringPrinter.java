package venkat.assignment.singleton;

public class StringPrinter {
    String stringInstance;
    public static StringPrinter initializeString(String currentString){
       // stringInstance=currentString; //THIS IS NOT POSSIBLE IN JAVA BECAUSE
                                       // NON STATIC VARIABLES CANNOT BE REFERENCED FROM STATIC METHODS
        return new StringPrinter();
    }
    public void printString(){
        System.out.println(stringInstance);
    }
}
