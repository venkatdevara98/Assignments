import java.util.Arrays;
import java.util.Collections;

public class CaesarBreaker {
    public int getMaxIndex(String message) {
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] count = new int[26];
        message = message.toUpperCase();
        for (int i = 0; i < message.length(); i++) {
            char curChar=message.charAt(i);
            int indexOfCurChar=Alphabet.indexOf(curChar);
            if(indexOfCurChar!=-1)
              count[indexOfCurChar] += 1;
        }
        int maxCount = Arrays.stream(count).max().getAsInt();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == maxCount)
                if(i>=4)
                 return i-4;
                else
                    return 26-(4-i);
        }
        return -1;
    }
    public String decrypt(String encryptedText){
        int key=26-getMaxIndex(encryptedText);
        CaesarCipherClass c=new CaesarCipherClass();
        return c.encrypt(encryptedText,key);
    }
    public String decryptTwoKeys(String encryptedText){
           StringBuilder firstMessage=new StringBuilder();
           StringBuilder secondMessage=new StringBuilder();
           for(int i=0;i<encryptedText.length();i++){
               if(i%2==0)
                   firstMessage.append(encryptedText.charAt(i));
               else
                   secondMessage.append(encryptedText.charAt(i));
           }
           String decryptedFirstMessage=decrypt(firstMessage.toString());
           String decryptedSecondMessage=decrypt(secondMessage.toString());
           int firstIterator=0,secondIterator=0;
           StringBuilder encrptedTextFinal=new StringBuilder();
           for(int i=0;i<encryptedText.length();i++){
               if(i%2==0) {
                   encrptedTextFinal.append(decryptedFirstMessage.charAt(firstIterator));
                   firstIterator += 1;
               }
               else{
                   encrptedTextFinal.append(decryptedSecondMessage.charAt(secondIterator));
                   secondIterator += 1;
               }
           }
           return encrptedTextFinal.toString();

    }
     public static void main(String args[]){
         CaesarBreaker caesarBreaker=new CaesarBreaker();
         System.out.println(caesarBreaker.decryptTwoKeys("Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu"));
     }
}
