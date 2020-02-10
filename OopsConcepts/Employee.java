import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.Month;

class EmployeeSuper{
    protected String name;
    protected String email;
    protected LocalDate Birthdate;
    EmployeeSuper(String name,String email,LocalDate Birthdate)
    {
        this.name=name;
        this.email=email;
        this.Birthdate=Birthdate;
    }
    public void isBirthday(){
        if(Birthdate.getMonth().equals(LocalDate.now())){
            System.out.println("Today is employee's birthday");
        }
        else
        System.out.println("Today is not employee's birthday");
    }
        
}
class SoftwareDeveloper extends EmployeeSuper{
    SoftwareDeveloper(String name,String email,LocalDate Birthdate){
        super(name,email,Birthdate);
    }
    public String getWorkingProject(){
        return "This is current working project";
    }
    public void assignLead(){
        System.out.println("Team leader assigned");
    }
    public void isBirthday(){
        if((Birthdate.getMonth().equals(LocalDate.now().getMonth()))&&
        (Birthdate.getDayOfMonth()==LocalDate.now().getDayOfMonth())){
            System.out.println("Today is Software developer's birthday");
        }
        else
        System.out.println("Today is not software developer's birthday");;
    }
}
class BusinessAnalyst extends EmployeeSuper{
    BusinessAnalyst(String name,String email,LocalDate Birthdate){
        super(name,email,Birthdate);
    }
    public String getClient(){
        return "This is client";
    }
    public int getWorkingHours(){
        return 9;
    }
    public void isBirthday(){
        if((Birthdate.getMonth().equals(LocalDate.now().getMonth()))&&
        (Birthdate.getDayOfMonth()==LocalDate.now().getDayOfMonth())){
            System.out.println("This is Business Analyst's birthday");
        }
        else
        System.out.println("Today is not Business Analyst's birthday");;
    }
}
public class Employee{
    void main(){
        SoftwareDeveloper arun=new SoftwareDeveloper("Arun","arun@gmail.com",LocalDate.of(1998,2,10));
        arun.isBirthday();
        BusinessAnalyst ram=new BusinessAnalyst("Ram","ram@gmail.com",LocalDate.of(1996,10,4));
        ram.isBirthday();
    }
}

    
    
    