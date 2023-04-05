package Algorithms;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class AES_Encryption {
    AES_Encryption(){}

    AES_Encryption(String plainText) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {
        System.out.println("This is the message you gave: " + plainText);

        SecretKey key = generateKey();
        IvParameterSpec ivParameterSpec = generateIV();
        String algorithm = "AES/ECB/PKCS5Padding";

        String cipherText = AES_Encryption.encrypt(algorithm, plainText, key);
        System.out.println("What the message looks like now via encryption: "+ cipherText);
        plainText = AES_Encryption.decrypt(algorithm, cipherText, key);
        System.out.println("We can return the text back: " + plainText + "\nWere we successful? ");
    }
    public static SecretKey generateKey() throws NoSuchAlgorithmException{
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        keygen.init(128);
        return keygen.generateKey();
    }
    public static IvParameterSpec generateIV(){
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }
    public static String encrypt(String algorithm, String plainText, SecretKey key)
        throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException{

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] cipherText = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }
    static String decrypt(String algorithm, String cipherText, SecretKey key)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException{

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE,key);
        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(plainText);
    }
}
