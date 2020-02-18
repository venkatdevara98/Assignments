public class Hamster extends Rodent {
    Hamster(){
        super();
        System.out.println("I am a hamster");
    }
    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void eat() {
        System.out.println("Hamster is eating");
    }

    @Override
    public void run() {
        System.out.println("Hamster is eating");
    }
}
