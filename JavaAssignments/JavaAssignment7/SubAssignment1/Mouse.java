public class Mouse extends Rodent{
    Mouse(){
        super();
        System.out.println("I am mouse");
    }
    @Override
    public boolean isActive() {

        return false;
    }

    @Override
    public void eat() {
      System.out.println("Mouse is eating");
    }

    @Override
    public void run() {
      System.out.println("Mouse is running");
    }
}
