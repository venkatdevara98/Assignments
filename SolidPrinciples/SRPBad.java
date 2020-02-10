import java.io.*;
import java.util.*;
class Group{
    public void addMember(String name)
    {
        System.out.println(name+" added to database");
    }
    public String getMemberDetails(String name)
    {
        return "Details of "+name;
    }
}
public class SRPBad{
    void main(){
        Group Friends=new Group();
        Friends.addMember("Ram");
        System.out.println(Friends.getMemberDetails("Ram"));
    }
    
}
