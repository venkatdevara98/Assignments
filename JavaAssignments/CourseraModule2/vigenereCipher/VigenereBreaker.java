package  vigenereCipher;
import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
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

    public void breakVigenere () {
        VigenereBreaker vigenereBreaker=new VigenereBreaker();
        FileResource fileResource=new FileResource();
        String stringMessage=fileResource.asString();
        int[] keyArray=vigenereBreaker.tryKeyLength(stringMessage,4,'e');
        VigenereCipher vigenereCipher=new VigenereCipher(keyArray);
        System.out.println(vigenereCipher.decrypt(stringMessage));
    }

}