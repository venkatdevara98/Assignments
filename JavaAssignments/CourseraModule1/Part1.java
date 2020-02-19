public class Part1
{
    public String findSimpleGene(String dna)
    {
        String gene="";
        int startPos=dna.indexOf("ATG");
        int endPos=dna.indexOf("TAA",startPos+3)+3;
        if (startPos == -1 || endPos == -1)
         return gene;
        if ((endPos-startPos)%3!=0)
         return gene;
        gene=dna.substring(startPos,endPos);
        return gene;
    }
    public void testSimpleGene(){
        String str1="TGATGAAAGGGTAAATT";
        String str2="ATATATATGGGGAAT";
        String str3="ATGGGGGTTAAATG";
        String str4="ATGATGATGATG";
        String str5="GTGTATGGGGGGGTTTTTGTAA";
        System.out.println(findSimpleGene(str1));
        System.out.println(findSimpleGene(str2));
        System.out.println(findSimpleGene(str3));
        System.out.println(findSimpleGene(str4));
        System.out.println(findSimpleGene(str5));
    }
        
}
