public class Part3 {
    public boolean twoOccurences(String stringa,String stringb){
        if(stringb.indexOf(stringa)==-1)
            return false;
        if(stringb.indexOf(stringa,stringb.indexOf(stringa))==-1){
            return false;
        }
        return true;
    }
    public void testing(){
        System.out.println(twoOccurences("by","A story by AbbyLong"));
        System.out.println(twoOccurences("ease","Please help me"));
        System.out.println(lastPart("by","A story by AbbyLong"));
        System.out.println(lastPart("ease","Please help me"));
    }
    public String lastPart(String stringa,String stringb){
        int index=stringb.indexOf(stringa);
        if(index==-1)
            return stringb;
        else
            return stringb.substring(index+stringa.length());
    }
}
