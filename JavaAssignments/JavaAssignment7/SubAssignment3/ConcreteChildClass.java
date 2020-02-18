/*
Create three interfaces, each with two methods.
Inherit a new interface that combines the three, adding a new method.
 Create a class by implementing the new interface and also inheriting from a concrete class.
 Now write four methods, each of which takes one of the four interfaces as an argument.
In main( ), create an object of your class and pass it to each of the methods
 */
public class ConcreteChildClass extends ConcreteBaseClass implements ChildInterface{

    @Override
    public void childInterfaceMethod() {
        System.out.println("This is method of Child Interface");
    }

    @Override
    public void method1Interface1() {
        System.out.println("This is method 1 of Interface 1");
    }

    @Override
    public void method2Interface1() {
        System.out.println("This is method 2 of Interface 1");
    }

    @Override
    public void method1Interface2() {
        System.out.println("This is method 1 of Interface 2");
    }

    @Override
    public void method2Interface2() {
        System.out.println("This is method 2 of Interface 2");
    }

    @Override
    public void method1Interface3() {
        System.out.println("This is method 1 of Interface 3");
    }

    @Override
    public void method2Interface3() {
        System.out.println("This is method 2 of Interface 3");
    }

    public void methodOfInterface1(Interface1 interface1){
             interface1.method1Interface1();
             interface1.method2Interface1();
    }
    public void methodOfInterface2(Interface2 interface2){
             interface2.method1Interface2();
             interface2.method2Interface2();
    }
    public void methodOfInterface3(Interface2 interface3){
             interface3.method1Interface2();
             interface3.method2Interface2();
    }
    public void methodOfChildInterface(ChildInterface childInterface){
              childInterface.childInterfaceMethod();
    }
    public static void main(String args[]){
        ConcreteChildClass concreteChildClass=new ConcreteChildClass();
        concreteChildClass.methodOfInterface1(concreteChildClass);
        concreteChildClass.methodOfInterface2(concreteChildClass);
        concreteChildClass.methodOfInterface3(concreteChildClass);
        concreteChildClass.methodOfChildInterface(concreteChildClass);
    }
}
