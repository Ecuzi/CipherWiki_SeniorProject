package Algorithms;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.lang.Integer.toHexString;

public class Hashing_Encryption {
     String output;
    public Hashing_Encryption() {}
    public  String Hashing_Encryption(String plainText) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");        //Creating a digest object that uses the SHA-256 encryption algorithm
        byte[] encoded = digest.digest(plainText.getBytes(StandardCharsets.UTF_8));  //Converting the user generated plainText into an array of bytes
        output = bytesToHex(encoded);//Printing the output of the hexes from the bytes
        return output;
    }
    //Bytes to Hex implementation
    private  String bytesToHex(byte... text){
        StringBuilder hexString = new StringBuilder(2 * text.length); //Since we're effectively changing a string to another String
        for (byte b : text) { //All long as the length is not 1 element long, convert every byte element into a hexadecimal
            String hex = toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
