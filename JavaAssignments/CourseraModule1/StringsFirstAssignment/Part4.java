import edu.duke.*;

public class Part4 {
    public void displayURL(String url){
        URLResource urlResource=new URLResource(url);
        for(String word : urlResource.words()){
            word=word.toLowerCase();
            if(word.indexOf("youtube.com")!=-1){
                int startIndex=word.indexOf("\"");
                int endIndex=word.lastIndexOf("\"");
                System.out.println(word.substring(startIndex+1,endIndex));
            }
        }
    }
    public void test(){
        displayURL("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    }

}
