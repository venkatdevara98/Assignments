import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CharactersInPlay {
    private ArrayList<String> names;
    private ArrayList<Integer> counts;
    public CharactersInPlay(){
        names=new ArrayList<String>();
        counts=new ArrayList<Integer>();
    }
    public void update(String person){
        if(names.indexOf(person)==-1){
            names.add(person);
            counts.add(1);
        }
        else{
            int index=names.indexOf(person);
            counts.set(index,counts.get(index)+1);
        }
    }
    public void findAllCharacters(){
        names.clear();
        counts.clear();
        try {
            Scanner scanner=new Scanner(new File("/home/venkat/Documents/macbeth"));
            while(scanner.hasNextLine()){
                String presentLine=scanner.nextLine();
                int indexOfPeriod=presentLine.indexOf(".");
                if(indexOfPeriod!=-1){
                    String presentPerson=presentLine.substring(0,indexOfPeriod);
                    int indexOfPerson=names.indexOf(presentPerson);
                    if(indexOfPerson==-1){
                        names.add(presentPerson);
                        counts.add(1);
                    }
                    else{
                        counts.set(indexOfPerson,counts.get(indexOfPerson)+1);
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void tester(){
        this.findAllCharacters();
        for(int i=0;i<counts.size();i++){
            if(counts.get(i)>1){
                System.out.println(names.get(i)+" : "+counts.get(i));
            }
        }
    }

    public void charactersWithNumParts(int num1,int num2){
        this.findAllCharacters();
        for(int i=0;i<counts.size();i++){
            if(counts.get(i)>=num1 && counts.get(i)<=num2){
                System.out.println(names.get(i)+" : "+counts.get(i));
            }
        }
    }
    public static void main(String args[]){
        CharactersInPlay charactersInPlay=new CharactersInPlay();
        charactersInPlay.charactersWithNumParts(3,8);
    }

}
