import java.io.*;
import java.util.*;
class BadPostReactions{
    public void displayReaction(String[] emojis)
    {
        for(int i=0;i<emojis.length;i++)
        {
                if(emojis[i].equals("HappyEmoji"))
                 System.out.println("Happy Emoji");
                else if(emojis[i].equals("SadEmoji"))
                 System.out.println("Sad Emoji");
        }
    }
    
}
public class OCPBad{
    void main(){
        String[] emojis=new String[]{"HappyEmoji","SadEmoji"};
        BadPostReactions p=new BadPostReactions();
        p.displayReaction(emojis);
        
    }
}