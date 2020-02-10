import java.io.*;
import java.util.*;
class BadMessage{
    public void displayMessage(){
        System.out.println("This is the actual message");
    }
    public void displaySender(){
        System.out.println("This is the sender's name");
    }
}
class BadAnonymousMessage extends Message {
    
    public void displaySender(){
        
        System.out.println("cannot display name of sender");
    
    }   
}
class BadpublicMessage extends Message{
    //additional functionality to make message public
}
class BadprivateMessage extends Message{
    //additional functionality to make message private
}
public class LSPBad{
    void main(){
      BadAnonymousMessage an=new BadAnonymousMessage();
      an.displaySender();
    }
    
}