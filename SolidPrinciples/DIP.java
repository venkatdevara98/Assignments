import java.io.*;
import java.util.*;

interface ISenderDetails{
  public String getSenderName();
}
class Comment implements ISenderDetails{
    public String getSenderName(){
        return "Sender 1";
    }
}
class ReplyToComment {
  public String senderName="";
  public void getSenderName(ISenderDetails s)
  {
    senderName=s.getSenderName();
  }
  public void reply(){
       System.out.println("Reply posted on comment made by "+senderName);
    }
}
public class DIP {
    void main(){
     Comment c=new Comment();
     ReplyToComment r=new ReplyToComment();
     r.getSenderName(c);
     r.reply();
    }
}

    
