/*
Create a class with an inner class that has a non-default constructor (one that takes arguments).
 Create a second class with an inner class that inherits from the first inner class.
 */
public class SecondOuterClass {
    public class SecondInnerClass extends FirstOuterClass.FirstInnerClass {

        SecondInnerClass(int integer) {
            new FirstOuterClass().super(integer);
        }
        public void printNumber(){
            System.out.println("The number is "+integerInstance);
        }

    }
    public static void main(String args[]){
        SecondOuterClass secondOuterClass=new SecondOuterClass();
        SecondOuterClass.SecondInnerClass secondInnerClass=secondOuterClass.new SecondInnerClass(5);
        secondInnerClass.printNumber();
    }
}
