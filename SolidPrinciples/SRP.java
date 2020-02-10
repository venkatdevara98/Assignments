import java.io.*;
import java.util.*;

class GroupDB{
    public void addMember(String name)
    {
        System.out.println(name+" added to database");
    }
}
class GroupDetails{
    public String getMemberDetails(String name)
    {
        return "Details of "+name;
    }
}
public class SRP{
    void main(){
        GroupDB Friends=new GroupDB();
        Friends.addMember("Ram");
        GroupDetails FriendsDetails=new GroupDetails();
        System.out.println(FriendsDetails.getMemberDetails("Ram"));
    }
}


