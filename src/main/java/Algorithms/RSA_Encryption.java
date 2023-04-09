package Algorithms;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class RSA_Encryption {
    public PublicKey x;
    public PrivateKey y;

    public RSA_Encryption() throws NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchPaddingException {

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair pair = generator.generateKeyPair();              //Generate a private key and public key
        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();
        x = publicKey;
        y = privateKey;
    }








    /* Encrypt Message */
    public String encryptRSA(String plainText, PublicKey publicKey)
            throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] secretMessageBytes = plainText.getBytes(StandardCharsets.UTF_8);  // Interpret the plainText given by the user as an array of bytes
        byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);// Finalize the bytes into a single-part operation

                      // Initialize the Cipher with a private key
        return Base64.getEncoder().encodeToString(encryptedMessageBytes);
    }
    /* Decrypt Message */
    public static String decryptRSA(String plainText, PrivateKey privateKey) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] secretMessageBytes = plainText.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedMessageBytes = decryptCipher.doFinal(Base64.getDecoder().decode(secretMessageBytes));

        // Initialize the Cipher with a private key
        byte[] decryptedMessageBytes = decryptCipher.doFinal(encryptedMessageBytes);
        return Base64.getEncoder().encodeToString(decryptedMessageBytes);

    }




}
