public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipher(int key)
    {
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
        mainKey=key;
    }
    public String encrypt(String inputText)
    {
        StringBuilder encryptedText=new StringBuilder(inputText);

        for(int i=0;i<inputText.length();i++){
            boolean isSmall=false;
            char curChar=inputText.charAt(i);
            if(Character.isLowerCase(curChar)){
                isSmall=true;
                curChar=Character.toUpperCase(curChar);
            }
            int indexInAlpha=alphabet.indexOf(curChar);
            if(indexInAlpha!=-1){
                char newChar=shiftedAlphabet.charAt(indexInAlpha);
                if(isSmall)
                {
                    newChar=Character.toLowerCase(newChar);
                }
                encryptedText.setCharAt(i,newChar);
            }
        }
        return encryptedText.toString();
    }
    public String decrypt(String encryptedText){
        CaesarCipher caesarCipher=new CaesarCipher(26-mainKey);
        return caesarCipher.encrypt(encryptedText);
    }
}
