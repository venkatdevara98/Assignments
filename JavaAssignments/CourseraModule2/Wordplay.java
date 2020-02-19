import static java.lang.Character.toUpperCase;

public class Wordplay {
    public boolean isVowel(char ch){
        String s=Character.toString(toUpperCase(ch));
        char[] vowels={'A','E','I','O','U'};
        if(new String(vowels).contains(s)){
            return true;
        }
        return false;
    }
    public String replaceVowels(String phrase,char ch)
    {
        StringBuilder sb=new StringBuilder();
        sb.append(phrase);
        for(int i=0;i<phrase.length();i++){
            if(isVowel(phrase.charAt(i))) {
                sb.replace(i,i+1,Character.toString(ch));
            }
        }
        return sb.toString();
    }
    public String emphasize(String phrase,char ch){
        StringBuilder sb=new StringBuilder();
        sb.append(phrase);
        for(int i=0;i<phrase.length();i++) {
            if (phrase.charAt(i) == ch) {
                if (i % 2 == 0)
                    sb.replace(i, i + 1, Character.toString('*'));
                else
                    sb.replace(i, i + 1, Character.toString('+'));
            }
        }
        return sb.toString();
    }
    public static void main(String args[]){
        Wordplay w=new Wordplay();
       System.out.println(w.emphasize("Mary Bella Abracadabra",'a'));

    }
}
