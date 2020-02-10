import java.io.*;
import java.util.*;

class BadComment{
    public void postComment(String comment)
    {
        System.out.println("Comment posted");
    }
    public String getSenderName()
    {
        return "sender 1";
    }
}
class BadReplyToComment{
    public String senderName="";
    public void getSenderName(BadComment c)
    {
        senderName=c.getSenderName();
    }
    public void reply(){
        System.out.println("Reply posted on comment made by "+senderName);
    }
}
public class DIPBad{
    void main(){
        BadComment c=new BadComment();
        BadReplyToComment r=new BadReplyToComment();
        r.getSenderName(c);
        r.reply();
    }
}
