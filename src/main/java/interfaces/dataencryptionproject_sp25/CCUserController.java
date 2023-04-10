package interfaces.dataencryptionproject_sp25;

import Algorithms.CaesarCipher_Encryption;
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

import java.io.IOException;
import java.util.Objects;

public class CCUserController {

    public Button backButton;
    @FXML
    private TextArea DisplayArea;

    @FXML
    private TextField key, plainText;
    @FXML
    private Label label1;
    CaesarCipher_Encryption Cipher = new CaesarCipher_Encryption();
    @FXML
    void backButtonAction(ActionEvent event) throws IOException {
        Parent guestViewParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/CaesarCipher.fxml")));
        Scene guestScene = new Scene(guestViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(guestScene);
        window.show();
    }
    static boolean isNumLess(String s)
    {
        for (int i = 0; i < s.length(); i++)
            if (Character.isDigit(s.charAt(i)))
                return true;

        return false;
    }
    static boolean isNumber(String s)
    {
        for (int i = 0; i < s.length(); i++)
            if (!Character.isDigit(s.charAt(i)))
                return true;

        return false;
    }
    @FXML
    void DecryptButton() {
        if(key.getText().isBlank()) {  //Validate User input to avoid exceptions
            label1.setText("Please Enter A Key");
            return;
        }
        if(plainText.getText().isBlank()) {
            label1.setText("Please Enter Plaintext");
            return;
        }
        String plainT = plainText.getText();

        if(isNumber(key.getText())) {
            label1.setText("Please Only Enter Numbers for Key");
            return;
        } else if (Integer.parseInt(key.getText()) >= 5000) {
            label1.setText("Please Use Numbers less than 5000");
            return;
        }

        int key1 = Integer.parseInt(key.getText());


        if(isNumLess(plainT)) {
            label1.setText("Please Only Enter Letters for Plaintext");
            return;
        }
        else {
            DisplayArea.setText(Cipher.decrypt(plainT, key1));

        }
        DisplayArea.setWrapText(true);
        label1.setText("");
    }

    @FXML
    void EncryptButton() {
        if(key.getText().isBlank()) {  //Validate User input to avoid exceptions
            label1.setText("Please Enter A Key");
            return;
        }
        if(plainText.getText().isBlank()) {
            label1.setText("Please Enter Plaintext");
            return;
        }
        String plainT = plainText.getText();
        if(isNumber(key.getText())) {
            label1.setText("Please Only Enter Numbers for Key");
            return;
        } else if (Integer.parseInt(key.getText()) >= 5000) {
            label1.setText("Please Use Numbers less than 5000");
            return;
        }
        int key1 = Integer.parseInt(key.getText());



        if(isNumLess(plainT)) {
            label1.setText("Please Only Enter Letters for Plaintext");
            return;
        }
        else {
            DisplayArea.setText(Cipher.encrypt(plainT, key1));

        }
        DisplayArea.setWrapText(true);
        label1.setText("");
    }


}

