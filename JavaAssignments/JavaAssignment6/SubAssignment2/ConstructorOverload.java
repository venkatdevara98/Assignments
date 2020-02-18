/*
Create a class with two (overloaded) constructors. Using this, call the second constructor inside the first one.
 */
public class ConstructorOverload {
    int firstInteger, secondInteger;

    ConstructorOverload(int firstInteger) {
        this.firstInteger = firstInteger;
    }

    ConstructorOverload(int firstInteger, int secondInteger) {
        this(firstInteger);
        this.secondInteger = secondInteger;
    }

    public static void main(String args[]) {
        ConstructorOverload constructorOverload = new ConstructorOverload(2, 3);
        System.out.println("First Integer : " + constructorOverload.firstInteger + "\nSecond Integer : " + constructorOverload.secondInteger);
    }
}


