package venkat.assignment.data;

public class Printer {
    int intInstance;
    char charInstance;
    public void printInstanceVariables(){
        System.out.println(intInstance+" "+charInstance);
    }
    public void printLocalVariables(){
        int intLocal;
        char charLocal;
        //System.out.println(intLocal+" "+charLocal); //THIS IS NOT POSSIBLE IN JAVA BECAUSE VARIABLES
                                                    // CANNOT BE PRINTED BEFORE THEY ARE INITIALIZED
    }
}
