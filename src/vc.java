import java.util.ArrayList;

public class VigenereCipher{
    private String key;
    private String alphabet;
    
    public VigenereCipher(String k){ 
        key = k.toLowercase()
        alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
    }

    public String genString(String str, String key) {
        int x = str.length();
        for (int i = 0; ; i++){
            if (x == i) i = 0;
            if (key.length() == str.length())
                break;
            key+=(key.charAt(i));
        }
        return key;
    }

    public String encode(String str) {
        str = str.toLowerCase();

        String key = genString(str, this.key);
        String enTxt = "";

        System.out.println("key: " + key);
        System.out.println("str: " + str);

        for (int i = 0; i < str.length(); i++){
            if (alphabet.contains(String.valueOf(str.charAt((i))))) {
                int x = (alphabet.indexOf(str.charAt(i)) + alphabet.indexOf(key.charAt(i))) % 26;
                enTxt += alphabet.charAt(x);
                System.out.println(enTxt);
            }
            else {
                enTxt += str.charAt(i);
                System.out.println(enTxt);
            }
        }
        System.out.println("out: " + enTxt);
        return enTxt;
    }

    public String decode(String str) {
        str = str.toLowerCase();

        String key = genString(str, this.key);
        String deTxt = "";

        for (int i = 0; i < str.length(); i++) {
            if (alphabet.contains(String.valueOf(str.charAt((i))))) {
                int x = (alphabet.indexOf(str.charAt(i)) - alphabet.indexOf(key.charAt(i)) + 26) % 26;
                deTxt += alphabet.charAt(x);
                System.out.println(deTxt);
            }
            else {
                deTxt += str.charAt(i);
                System.out.println(deTxt);
            }
        }
        return deTxt;
    }

    public String getAlphabet() { return alphabet; }
    public void setAlphabet(String alphabet) { this.alphabet = alphabet;}
    public String getKey() { return key;}
    public void setKey(String key) { this.key = key;}
}