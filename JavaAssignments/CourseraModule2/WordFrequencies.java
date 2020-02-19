import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    public WordFrequencies(){
        myWords=new ArrayList<String>();
        myFreqs=new ArrayList<Integer>();
    }
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        try {
            Scanner scanner=new Scanner(new File("/home/venkat/Documents/testWordFrequencies"));
            while(scanner.hasNext()){
                String s=scanner.next();
                if(myWords.indexOf(s)==-1) {
                    myWords.add(s);
                    myFreqs.add(1);
                }
                else{
                    int index=myWords.indexOf(s);
                    myFreqs.set(index,myFreqs.get(index)+1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void tester(){
        findUnique();
        System.out.println("Number of unique words are "+myFreqs.size());
        for(int i=0;i<myFreqs.size();i++){
            System.out.println(myWords.get(i)+" : "+myFreqs.get(i));
        }
        System.out.println("Word with largest frequency is "+myWords.get(findIndexOfMax())+" : "+myFreqs.get(findIndexOfMax()));
    }

    public int findIndexOfMax(){
        return myFreqs.indexOf(Collections.max(myFreqs));
    }
    public static void main(String args[]){
        WordFrequencies wordFrequencies=new WordFrequencies();
        wordFrequencies.tester();
    }
}
