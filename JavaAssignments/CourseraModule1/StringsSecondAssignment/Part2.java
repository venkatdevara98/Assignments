package StringsSecondAssignment;

public class Part2 {
    public int howMany(String stringa,String stringb) {
        int count=0;
        while (true){
            int curIndex=stringb.indexOf(stringa);
            if(curIndex==-1)
                break;
            count+=1;
            stringb=stringb.substring(curIndex+stringa.length());
        }
        return count;
    }
    public void testHowMany(){
        System.out.println(howMany("AA","AAAAAA"));
    }
}
