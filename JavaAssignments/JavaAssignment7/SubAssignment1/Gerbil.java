public class Gerbil extends Rodent {
    Gerbil(){
        super();
        System.out.println("I am a Gerbil");
    }
    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void eat() {
       System.out.println("Gerbil is eating");
    }

    @Override
    public void run() {
       System.out.println("Gerbil is running");
    }
}
