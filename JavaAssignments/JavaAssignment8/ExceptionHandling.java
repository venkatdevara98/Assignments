/*
Error Handling

Create three new types of exceptions.
Write a class with a method that throws all three.
In main( ), call the method but only use a single catch clause that will catch all three types of exceptions.
Add a finally clause and verify that your finally clause is executed, even if a NullPointerException is thrown.

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionHandling {
    public void handler() throws NumberException, EmailException,PhoneNumberException, IOException {
        int number;
        System.out.println("Enter your roll number(1-60)");
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        number=Integer.parseInt(bufferedReader.readLine());
        if(number>60)
            throw new NumberException();
        System.out.println("Enter Email address");
        String email=bufferedReader.readLine();
        if(!email.contains("@"))
            throw new EmailException();
        System.out.println("Enter your phone number:");
        String phoneNumber=bufferedReader.readLine();
        if(!phoneNumber.matches("[0-9]+"))
            throw new PhoneNumberException();

    }
    public static void main(String args[]){
        ExceptionHandling exceptionHandling=new ExceptionHandling();
        try {
            exceptionHandling.handler();
        }catch (NumberException | EmailException |PhoneNumberException | IOException e){
        }
        finally {
            System.out.println("Program executed successfully");
        }
    }
}

