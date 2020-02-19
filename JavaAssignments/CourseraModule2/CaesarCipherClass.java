import java.io.FileReader;

public class CaesarCipherClass {
    public String getEncryptedAlphabet(int key)
    {
        StringBuilder alphabet=new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        String cipher=alphabet.substring(key);
        String cipher2=alphabet.substring(0,key);
        StringBuilder cipherAlpha=new StringBuilder(cipher);
        cipherAlpha.append(cipher2);
        return cipherAlpha.toString();
    }
    public String encrypt(String text,int key){
        StringBuilder encryptedText=new StringBuilder(text);
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String cipherAlpha=this.getEncryptedAlphabet(key);

        for(int i=0;i<encryptedText.length();i++){
            boolean isSmall=false;
            char curChar=encryptedText.charAt(i);
            if(Character.isLowerCase(curChar)){
                isSmall=true;
                curChar=Character.toUpperCase(curChar);
            }
            int indexInAlpha=alphabet.indexOf(curChar);
            if(indexInAlpha!=-1){
                char newChar=cipherAlpha.charAt(indexInAlpha);
                if(isSmall)
                {
                    newChar=Character.toLowerCase(newChar);
                }
                encryptedText.setCharAt(i,newChar);
            }
        }
        return encryptedText.toString();
    }
    public String encryptTwoKeys(String text,int key1,int key2){
        StringBuilder encryptedText=new StringBuilder((text));
        StringBuilder encryptKey1=new StringBuilder();
        StringBuilder encryptKey2=new StringBuilder();
        for(int i=0;i<encryptedText.length();i++){
            if(i%2==0)
               encryptKey1.append(encryptedText.charAt(i));
            else
                encryptKey2.append(encryptedText.charAt(i));
        }

        String finalEncryptKey1=this.encrypt(encryptKey1.toString(),key1);
        String finalEncryptKey2=this.encrypt(encryptKey2.toString(),key2);
        int firstIterator=0,secondIterator=0;
        for(int i=0;i<encryptedText.length();i++){
            if(i%2==0) {
                encryptedText.setCharAt(i, finalEncryptKey1.charAt(firstIterator));
                firstIterator += 1;
            }
            else {
                encryptedText.setCharAt(i, finalEncryptKey2.charAt(secondIterator));
                secondIterator += 1;
            }
        }
        return encryptedText.toString();

    }

    public static void main(String args[]){
        CaesarCipherClass c =new CaesarCipherClass();
        System.out.println(c.encryptTwoKeys("First Legion",23,17));

    }
}
