/*Create a java program to search through the home directory and look for files that match a regular expression. The program should be able to take inputs repeatedly and should print out the full absolute path of the matching files found.

        Provide appropriate documentation and comments on your code.

        Post your code to your GitHub repo and share the url.*/
import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileSearcher {
    public void searchFiles(String inputRegex,File directory){
        Pattern pattern=Pattern.compile(inputRegex);
        for(File file:directory.listFiles()){
            if(file.isFile()) {
                Matcher m = pattern.matcher(file.getName());
                if (m.find())
                    System.out.println(file.getAbsolutePath());
            }
            else if(file.isDirectory()){
                searchFiles(inputRegex,file);
            }
        }

    }
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        String inputRegex;
        File directory=new File("/home/venkat");
        do{
            inputRegex=s.nextLine();
            FileSearcher fileSearcher=new FileSearcher();
            fileSearcher.searchFiles(inputRegex,directory);
        }while(!inputRegex.equals("0"));

    }
}
