package Algorithms;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class RSA_Encryption {

    RSA_Encryption() {}

    RSA_Encryption(String plainText) throws NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchPaddingException {

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair pair = generator.generateKeyPair();              //Generate a private key and public key
        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        String input = encryptRSA(plainText, publicKey);        // The input from the user
        System.out.println("The Encrypted message: " + input);
        String output = decryptRSA(input, privateKey);          // The output for the recipient
        System.out.println("The Decrypted message: " + output);
    }
    /* Encrypt Message */
    static String encryptRSA(String plainText, PublicKey publicKey)
            throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        Cipher encryptCipher;{ try {  encryptCipher = Cipher.getInstance("RSA");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException(e); }
        }
        byte[] secretMessageBytes = plainText.getBytes(StandardCharsets.UTF_8);  // Interpret the plainText given by the user as an array of bytes
        byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);// Finalize the bytes into a single-part operation

        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);                      // Initialize the Cipher with a private key
        return Base64.getEncoder().encodeToString(encryptedMessageBytes);
    }
    /* Decrypt Message */
    static String decryptRSA(String plainText, PrivateKey privateKey)
            throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher decryptCipher = Cipher.getInstance("RSA");
        byte[] secretMessageBytes = plainText.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedMessageBytes = decryptCipher.doFinal(secretMessageBytes);

        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);                      // Initialize the Cipher with a private key
        byte[] decryptedMessageBytes = decryptCipher.doFinal(encryptedMessageBytes);
        return new String(decryptedMessageBytes, StandardCharsets.UTF_8);
    }
}
