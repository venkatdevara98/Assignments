import java.io.*;
import java.util.*;
abstract class PostReactions{
    public abstract void displayReaction();
}
class HappyReaction extends PostReactions{
    public void displayReaction(){
        System.out.println("HappyEmoji");
    }
}
class SadReaction extends PostReactions{
    public void displayReaction(){
        System.out.println("SadEmoji");
    }
}
public class OCP{
    void main(){
     HappyReaction h=new HappyReaction();
     SadReaction r=new SadReaction();
     h.displayReaction();
     r.displayReaction();
    }
}