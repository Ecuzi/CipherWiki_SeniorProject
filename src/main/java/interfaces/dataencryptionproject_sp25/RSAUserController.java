package interfaces.dataencryptionproject_sp25;

import Algorithms.CaesarCipher_Encryption;
import Algorithms.RSA_Encryption;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSAUserController {

    @FXML
    private TextArea Encrypt;
    @FXML
    private TextArea Decrypt;

    @FXML
    private TextArea PrivKey;

    @FXML
    private TextArea PubKey;




    @FXML
    private TextField key;
    @FXML
    private Label label1;
    @FXML
    private TextField plainText;

    RSA_Encryption Cipher = new RSA_Encryption();

    public RSAUserController() throws IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
    }


    @FXML
    void backButtonAction(ActionEvent event) throws IOException {
        Parent guestViewParent = FXMLLoader.load(getClass().getResource("/RSA.fxml"));
        Scene guestScene = new Scene(guestViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(guestScene);
        window.show();
    }

    @FXML
    void DecryptButton(ActionEvent event) {

        if(plainText.getText().isBlank() == true) {
            label1.setText("Please Enter Plaintext");
            return;
        }
        if(Encrypt.getText().isBlank() == true) {
            label1.setText("Please Encrypt First");
            return;
        }

        String plainT = plainText.getText();

        Decrypt.setText(plainT);
        Decrypt.setWrapText(true);

        PrivKey.setText(String.valueOf(Cipher.y));
        PrivKey.setWrapText(true);

    }

    @FXML
    void EncryptButton(ActionEvent event) throws IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {

        if(plainText.getText().isBlank() == true) {
            label1.setText("Please Enter Plaintext");
            return;
        }
        String plainT = plainText.getText();

        Encrypt.setText(Cipher.encryptRSA(plainT, Cipher.x));
        Encrypt.setWrapText(true);


        PubKey.setText(String.valueOf(Cipher.x));
        PubKey.setWrapText(true);
    }


}

