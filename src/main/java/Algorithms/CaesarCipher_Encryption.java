package Algorithms;

public class CaesarCipher_Encryption {
    CaesarCipher_Encryption(){}

    static String encrypt(String plainText, int key){
        StringBuilder encrypted = new StringBuilder(); char index;
        for(int i = 0; i < plainText.length();i++){
            index = plainText.charAt(i);
            if(index >= 'a' && index <= 'z'){
                index = (char) (index + key);
                if(index > 'z') index = (char)(index - 'z' + 'a' - 1);
                encrypted.append(index);
            } else if (index >= 'A' && index <= 'Z'){
                index = (char) (index + key);
                if(index > 'Z') index = (char)(index - 'Z' + 'A' - 1);
                encrypted.append(index);
            } else encrypted.append(index);
        }
        return encrypted.toString();
    }
    static boolean decrypt(String encrypted, String cipherText, double key){
        StringBuilder decrypted = new StringBuilder(); char index;
        for(int i = 0; i < cipherText.length();i++){
            index = cipherText.charAt(i);
            if(index >= 'a' && index <= 'z'){
                index = (char) (index - key);
                if(index < 'a') index = (char)(index + 'z' - 'a' + 1);
                decrypted.append(index);
            } else if (index >= 'A' && index <= 'Z'){
                index = (char) (index - key);
                if(index < 'A') index = (char)(index + 'Z' - 'A' + 1);
                decrypted.append(index);
            } else decrypted.append(index);
        }
        return decrypted.equals(encrypted);
    }
}