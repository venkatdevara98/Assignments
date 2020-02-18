/*Write a java function that checks if the input string contains all the letters of the alphabet a-z
(case-insensitive). Write time and space complexity of your solution as comments in the source file.*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*Here,I have written two methods to check the string : checkString() and checkStringFaster()

Time complexity :
checkString() : O(n^2)
checkStringFaster() : O(n)

Space complexity :
checkString() : Linear
checkStringFaster() : Linear
 */
public class StringChecker {

    public boolean checkString(String input){
        StringBuilder presentChars=new StringBuilder();
        for(int i=0;i<input.length();i++){
            char curChar=Character.toUpperCase(input.charAt(i));
            int indexOfCurChar=presentChars.indexOf(Character.toString(curChar));
            if(Character.isLetter(curChar)&&indexOfCurChar==-1){
                presentChars.append(curChar);
            }
        }
        if(presentChars.length()==26)
            return true;
        else
            return false;
    }

    public boolean checkStringFaster(String input){
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        HashMap<String,Integer> letterCounts=new HashMap<String, Integer>();
        for(int i=0;i<alphabet.length();i++){
            letterCounts.put(Character.toString(alphabet.charAt(i)),0);
        }
        for(int i=0;i<input.length();i++){
            if(Character.isLetter(input.charAt(i))) {
                char curChar = Character.toUpperCase(input.charAt(i));
                letterCounts.put(Character.toString(curChar), letterCounts.get(Character.toString(curChar)) + 1);
            }
        }
        for(String s : letterCounts.keySet()){
            if(letterCounts.get(s)==0)
                return false;
        }
        return true;
    }
    public static void main(String args[]){
        StringChecker stringChecker=new StringChecker();
        Scanner scanner=new Scanner(System.in);
        String presentString;
        do{
           presentString=scanner.nextLine();
           if(stringChecker.checkStringFaster(presentString))
               System.out.println("Yes");
           else
               System.out.println("No");
        }while(!presentString.equals("0"));
    }
}
