package StringsSecondAssignment;

public class Part1 {
    public int findStopCodon(String dna,int startIndex,String stopCodon){
        int firstIndex=dna.indexOf(stopCodon,startIndex+3);
        while(firstIndex!=-1){
            if((firstIndex-startIndex)%3==0)
                return firstIndex;
            else
                firstIndex=dna.indexOf(stopCodon,firstIndex+1);
        }
        return dna.length();
    }
    public void testFindStopCodon(){
        System.out.println(findStopCodon("ATGGGCCTTTTTAA",1,"TAA"));
        System.out.println(findStopCodon("ATGGGCCTTTTTAA",3,"TAG"));
    }
    public int compare(int a,int b){
        if(a==-1&&b==-1)
            return -1;
        else if(a==-1)
            return b;
        else if(b==-1)
            return a;
        else
            return Math.min(a,b);
    }
    public String findGene(String dna){
        if(dna.indexOf("ATG")==-1)
            return "";
        int atgIndex=dna.indexOf("ATG");
        int taaIndex=findStopCodon(dna,atgIndex,"TAA");
        int tagIndex=findStopCodon(dna,atgIndex,"TAG");
        int tgaIndex=findStopCodon(dna,atgIndex,"TGA");
        int minIndex=compare(taaIndex,tagIndex);
        if(minIndex==-1){
            if(tgaIndex!=-1)
                return dna.substring(atgIndex,tgaIndex+3);
            else
                return "";
        }
        else{
            minIndex=compare(minIndex,tgaIndex);
            return dna.substring(atgIndex,minIndex+3);
        }

    }

    public void printAllGenes(String dna){
        while(true){
            String gene=findGene(dna);
            if(gene.isEmpty())
                break;
            else{
                System.out.println(gene);
                dna=dna.substring(dna.indexOf(gene)+gene.length());
            }
        }
    }
    public void testFindGene(){
        String dna="GGATGHHHTAAGGGGATGHAGAGGGATGA";
        System.out.println(findGene(dna));
    }
}
