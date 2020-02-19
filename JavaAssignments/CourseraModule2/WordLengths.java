

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordLengths {
    public int[] countWordLengths(File file,int[] count){

        try {
            FileReader file1=new FileReader(file);
            int content;
            int maxCount=count.length;
            int curWordLength=0;
            boolean lastWordIsNotLetter=false;
            while ((content=file1.read()) != -1) {

                char curChar=(char)content;
                if(curChar==' '){
                    if(lastWordIsNotLetter)
                        curWordLength-=1;
                    if(curWordLength>maxCount-1)
                        count[maxCount-1]+=1;
                    else
                        count[curWordLength]+=1;
                    curWordLength=0;
                }
                if(Character.isLetter(curChar)) {
                    curWordLength += 1;
                    lastWordIsNotLetter = false;
                }
                else if(curWordLength!=0) {
                    curWordLength += 1;
                    lastWordIsNotLetter = true;
                }

            }
            count[curWordLength-1]+=1;
        } catch (IOException e) {
            e.printStackTrace();
        }
         return count;

    }
    public void testCountWordLengths(){
       int[] count=new int[31];
       for(int i=0;i<31;i++)
           count[i]=0;
       File file=new File("/home/venkat/Documents/testWordLengths");
       count=countWordLengths(file,count);
       for(int i=0;i<31;i++){
           if(count[i]!=0)
               System.out.println("Number of words of count "+i+" are : "+count[i]);
       }
    }
    public static void main(String args[]){
        WordLengths wordLengths=new WordLengths();
        wordLengths.testCountWordLengths();
    }
}

