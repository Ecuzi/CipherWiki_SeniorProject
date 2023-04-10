package Algorithms;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public class AES_Encryption {
    public SecretKey keyUsed;
    public String keyVisual;
    public static String IV;
    public static int blockSize;
    public int status = 0;
    public String algorithm = "AES/ECB/PKCS5Padding";

    public AES_Encryption() throws NoSuchAlgorithmException {

        SecretKey key = generateKey();
        keyUsed = key;
        keyVisual = Arrays.toString(key.getEncoded());
        IvParameterSpec ivParameterSpec = generateIV();
        IV = Arrays.toString(ivParameterSpec.getIV());

    }

    /* Generate Key */
    public SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        keygen.init(128);
        return keygen.generateKey();
    }

    /* Generate IV Spec */
    public IvParameterSpec generateIV() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    /* Encrypt Plain Text */
    public String encrypt(String algorithm, String plainText, SecretKey key)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        blockSize = cipher.getBlockSize();
        status = 2;
        byte[] cipherText = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }

    /* Decrypt Plain Text */
    public String decrypt(String algorithm, String cipherText, SecretKey key)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(plainText);
    }


}
