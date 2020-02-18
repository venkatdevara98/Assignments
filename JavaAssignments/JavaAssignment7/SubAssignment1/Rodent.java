public abstract class Rodent {
    int incisorPairs;
    int canineTeeth;
    Rodent(){
        this.incisorPairs=2;
        this.canineTeeth=0;
        System.out.println("I am Rodent");
    }
    public abstract boolean isActive();
    public abstract void eat();
    public abstract void run();
}
