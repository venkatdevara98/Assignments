/*
String and Type Information

Using the documentation for java.util.regex.Pattern as a resource,
write and test a regular expression that checks a sentence to see that
it begins with a capital letter and ends with a period
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegexChecker {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the sentence");
        String sentence=bufferedReader.readLine();
        if(sentence.matches("^[A-Z].*[.]$"))
            System.out.println("Valid String");
        else
            System.out.println("Invalid String");
    }
}
