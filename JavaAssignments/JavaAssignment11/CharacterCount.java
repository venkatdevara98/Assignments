/*
I/O

Using TextFile and a Map<Character,Integer>,
 create a program that takes the file name as a command line argument
 and counts the occurrence of all the different characters.
 Save the results in a text file.
 */
import java.io.*;
import java.util.HashMap;

public class CharacterCount {
    private HashMap<Character,Integer> countMap;
    CharacterCount(){
        countMap=new HashMap<>();
    }
    public void writeIntoFile() throws IOException {
        File file=new File("/home/venkat/Documents/CharacterCountWriter");
        file.createNewFile();
        FileWriter fileWriter=new FileWriter(file);
        for(Character curChar:countMap.keySet()){
            String line="\n"+curChar+" : "+countMap.get(curChar);
            fileWriter.write(line);
        }
        fileWriter.close();
    }
    public void readChars(FileReader fileReader) throws IOException {
        countMap.clear();
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line;
        while((line=bufferedReader.readLine())!=null) {
            for (int i = 0; i < line.length(); i++) {
                Character currentChar = line.charAt(i);
                if (countMap.containsKey(currentChar))
                    countMap.put(currentChar, countMap.get(currentChar) + 1);
                else
                    countMap.put(currentChar, 1);
            }
        }
    }
    public static void main(String args[]) throws IOException {
        String fileName=args[0];
        File file=new File(fileName);
        FileReader fileReader=new FileReader(file);
        CharacterCount characterCount=new CharacterCount();
        characterCount.readChars(fileReader);
        characterCount.writeIntoFile();
    }
}
