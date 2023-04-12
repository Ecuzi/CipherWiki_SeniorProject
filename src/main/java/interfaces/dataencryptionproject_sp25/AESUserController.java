package interfaces.dataencryptionproject_sp25;

import Algorithms.AES_Encryption;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class AESUserController {

    public Button backButton;
    @FXML
    private TextArea DisplayArea, BlockText, IVText, key;
    @FXML
    private Label label1;
    @FXML
    private TextField plainText;
    AES_Encryption Cipher = new AES_Encryption();

    public AESUserController() throws NoSuchAlgorithmException {

    }

    @FXML
    void backButtonAction(ActionEvent event) throws IOException {
        Parent guestViewParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/AES.fxml")));
        Scene guestScene = new Scene(guestViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(guestScene);
        window.show();
    }

    @FXML
    void DecryptButton() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        if(plainText.getText().isBlank()) {
            label1.setText("Please Enter Plaintext");
            label1.setStyle("-fx-text-fill: red");
            return;
        }

        if (Cipher.status == 3) {
            label1.setText("Already Decrypted");
            label1.setStyle("-fx-text-fill: red");
            return;
        }

        if (Cipher.status == 0) {
            label1.setText("Please Encrypt First");
            label1.setStyle("-fx-text-fill: red");
            return;
        }
            label1.setText("Decryption Successful");
            label1.setStyle("-fx-text-fill: green");

            String plainT = DisplayArea.getText();
            plainText.setText(plainT);
            key.setText(Cipher.keyVisual);

            String cipherText = Cipher.decrypt(Cipher.algorithm, plainT, Cipher.keyUsed);
            IVText.setText(String.valueOf(AES_Encryption.IV));
            BlockText.setText(String.valueOf(AES_Encryption.blockSize));
            DisplayArea.setText(cipherText);

            key.setWrapText(true);
            IVText.setWrapText(true);
            BlockText.setWrapText(true);
            DisplayArea.setWrapText(true);

            Cipher.status = 3;
    }

    @FXML
    void EncryptButton() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        if(plainText.getText().isBlank()) {
            label1.setStyle("-fx-text-fill: red");
            label1.setText("Please Enter Plaintext");
            return;
        }

        String plainT = plainText.getText();
        label1.setStyle("-fx-text-fill: green");
        label1.setText("Decrypting Will Use The CipherText");
        key.setText(Cipher.keyVisual);

        String cipherText = Cipher.encrypt(Cipher.algorithm, plainT, Cipher.keyUsed);
        IVText.setText(String.valueOf(AES_Encryption.IV));
        BlockText.setText(String.valueOf(AES_Encryption.blockSize));
        DisplayArea.setText(cipherText);

        key.setWrapText(true);
        IVText.setWrapText(true);
        BlockText.setWrapText(true);
        DisplayArea.setWrapText(true);
    }
}

