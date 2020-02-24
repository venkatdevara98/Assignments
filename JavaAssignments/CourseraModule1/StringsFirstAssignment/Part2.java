public class Part2 {
        public String findSimpleGene(String dna,String startCodon,String endCodon)
        {
            String gene="";
            boolean isLower=false;
            if(Character.isLowerCase(dna.charAt(0))){
                isLower=true;
                dna=dna.toUpperCase();
            }
            int startPos=dna.indexOf(startCodon);
            int endPos=dna.indexOf(endCodon,startPos+3)+3;
            if (startPos == -1 || endPos == -1)
                return gene;
            if ((endPos-startPos)%3!=0)
                return gene;
            gene=dna.substring(startPos,endPos);
            if(isLower)
                return dna.toLowerCase();
            return gene;
        }
        public void testSimpleGene(){
            String str1="TGATGAAAGGGTAAATT";
            String str2="ATATATATGGGGAAT";
            String str3="ATGGGGGTTAAATG";
            String str4="ATGATGATGATG";
            String str5="GTGTATGGGGGGGTTTTTGTAA";
            System.out.println(findSimpleGene(str1,"ATG","TAA"));
        }


}
