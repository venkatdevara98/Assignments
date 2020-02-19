import java.util.Collections;
import java.util.HashMap;
import edu.duke.*;

public class Codon {
    HashMap<String,Integer> dnaMap;
    public Codon(){
        dnaMap=new HashMap<String, Integer>();
    }
    public void buildCodonMap(int start,String dna){
        dnaMap.clear();
        for(int i=start;i+3<=dna.length();i+=3){
            String codon=dna.substring(start,start+3);
            if(dnaMap.containsKey(codon))
                dnaMap.put(codon,dnaMap.get(codon)+1);
            else
                dnaMap.put(codon,1);
        }
    }
    public String getMostCommonCodon(){
        int maxRepeated=Collections.max(dnaMap.values());
        for(String s:dnaMap.keySet()) {
            if (dnaMap.get(s) == maxRepeated)
                return s;
        }
        return "";
    }
    public void printCodonCounts(int start,int end){
        for(String s:dnaMap.keySet()){
            if(dnaMap.get(s)>=start&&dnaMap.get(s)<=end)
                System.out.println(s+" : "+dnaMap.get(s));
        }
    }
    public void tester(){
        FileResource fileResource=new FileResource();
        StringBuilder dnaStrand=new StringBuilder();
        for(String s:fileResource.words()){
            dnaStrand.append(s);
        }
        buildCodonMap(0,dnaStrand.toString());
        System.out.println(getMostCommonCodon());
        printCodonCounts(1,5);
    }
    public static void main(String args[]){
        Codon codon=new Codon();
        codon.tester();
    }
}

