import java.io.*;
import java.util.*;

class Message{
    public void displayMessage(){
        System.out.println("This is the actual message");
    }
}
class AnonymousMessage extends Message{
    //Funtionality of anonymous message
}
class NonAnonymousMessage extends Message{
    public void displaySender(){
        System.out.println("This is the sender's name");
    }
}
class PublicMessage extends NonAnonymousMessage{
    //Additional functionality to make message public
}
class PrivateMessage extends NonAnonymousMessage{
    //Additional functionality to make message private
}
public class LSP{
    void main(){
        AnonymousMessage a=new AnonymousMessage();
        PublicMessage p=new PublicMessage();
        PrivateMessage pr=new PrivateMessage();
        a.displayMessage();
    }
}
