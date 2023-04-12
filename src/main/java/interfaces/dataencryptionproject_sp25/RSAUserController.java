package interfaces.dataencryptionproject_sp25;

import Algorithms.RSA_Encryption;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class RSAUserController {

    @FXML
    private TextArea Encrypt, Decrypt, PrivateKey, PubKey;
    @FXML
    private Label label1;
    @FXML
    private TextField plainText;

    RSA_Encryption Cipher = new RSA_Encryption();

    public RSAUserController() throws NoSuchAlgorithmException {
    }
    @FXML
    void backButtonAction(ActionEvent event) throws IOException {
        Parent guestViewParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/RSA.fxml")));
        Scene guestScene = new Scene(guestViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(guestScene);
        window.show();
    }
    @FXML
    void DecryptButton() {
        if(plainText.getText().isBlank()) {
            label1.setText("Please Enter Plaintext");
            return;
        }
        if(Encrypt.getText().isBlank()) {
            label1.setText("Please Encrypt First");
            return;
        }
        if(!PrivateKey.getText().isBlank()) {
            label1.setText("Please Encrypt First");
            return;
        }
        String plainT = plainText.getText();

        Decrypt.setText(plainT);
        Decrypt.setWrapText(true);

        PrivateKey.setText(String.valueOf(Cipher.privkey));
        PrivateKey.setWrapText(true);
    }
    @FXML
    void EncryptButton() throws IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {

        if(plainText.getText().isBlank()) {
            label1.setText("Please Enter Plaintext");
            return;
        }
        if(plainText.getText().getBytes().length > 245 ) {
            label1.setText("Plaintext is Too Large");
            return;
        }
        label1.setText("");
        String plainT = plainText.getText();

        Encrypt.setText("");
        PrivateKey.setText("");
        PubKey.setText("");
        PrivateKey.setText("");
        Decrypt.setText("");

        Encrypt.setText(Cipher.encryptRSA(plainT, Cipher.x));
        Encrypt.setWrapText(true);

        PubKey.setText(String.valueOf(Cipher.pubkey));
        PubKey.setWrapText(true);
    }
}

