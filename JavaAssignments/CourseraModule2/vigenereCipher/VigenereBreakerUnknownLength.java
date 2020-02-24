package vigenereCipher;

import edu.duke.FileResource;

import java.util.HashSet;

public class VigenereBreakerUnknownLength {
     public String sliceString(String message, int whichSlice, int totalSlices){
      StringBuilder slicedString=new StringBuilder();
        for(int i=whichSlice;i<message.length();i+=totalSlices){
        slicedString.append(message.charAt(i));
         }
        return slicedString.toString();
     }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker caesarCracker=new CaesarCracker(mostCommon);
        for(int i=0;i<klength;i++){
            key[i]=caesarCracker.getKey(sliceString(encrypted,i,klength));
        }
        return key;
    }
    public HashSet<String> readDictionary(FileResource fileResource){
         HashSet<String> words=new HashSet<>();
         for(String word:fileResource.lines()){
             words.add((word.toLowerCase()));
         }
         return words;
    }
    public int countWords(String message,HashSet<String> dictionary){
         int count=0;
         String[] words=message.split("\\W+");
         for(String word : words){
             if(dictionary.contains(word))
                 count+=1;
         }
         return count;
    }
    public String breakForLanguage(String encrypted,HashSet<String> dictionary){
         String decrypted="";
         int maxWords=0;
         for(int i=1;i<100;i++){
             int[] key=tryKeyLength(encrypted,i,'e');
             VigenereCipher vigenereCipher=new VigenereCipher(key);
             String presentString=vigenereCipher.decrypt(encrypted);
             int presentWords=countWords(decrypted,dictionary);
             if(presentWords>maxWords){
                 maxWords=presentWords;
                 decrypted=presentString;
             }
         }
         return decrypted;
    }
    public void breakVigenere () {
        VigenereBreaker vigenereBreaker=new VigenereBreaker();
        FileResource fileResource=new FileResource();
        String stringMessage=fileResource.asString();
        FileResource dictionaryFile=new FileResource();
        HashSet<String> dictionary=readDictionary(dictionaryFile);
        String decrptedMessage=breakForLanguage(stringMessage,dictionary);
        System.out.println(decrptedMessage);
    }
}
