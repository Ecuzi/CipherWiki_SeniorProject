package interfaces.dataencryptionproject_sp25;

import Algorithms.CaesarCipher_Encryption;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class CCUserController {

    @FXML
    private TextArea DisplayArea;



    @FXML
    private TextField key;
    @FXML
    private Label label1;
    @FXML
    private TextField plainText;

    CaesarCipher_Encryption Cipher = new CaesarCipher_Encryption();


    @FXML
    void backButtonAction(ActionEvent event) throws IOException {
        Parent guestViewParent = FXMLLoader.load(getClass().getResource("/CaesarCipher.fxml"));
        Scene guestScene = new Scene(guestViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(guestScene);
        window.show();
    }
    static boolean isNumLess(String s)
    {
        for (int i = 0; i < s.length(); i++)
            if (Character.isDigit(s.charAt(i)) == true)
                return false;

        return true;
    }
    static boolean isNumber(String s)
    {
        for (int i = 0; i < s.length(); i++)
            if (Character.isDigit(s.charAt(i)) == false)
                return false;

        return true;
    }
    @FXML
    void DecryptButton(ActionEvent event) {
        if(key.getText().isBlank() == true) {  //Validate User input to avoid exceptions
            label1.setText("Please Enter A Key");
            return;
        }
        if(plainText.getText().isBlank() == true) {
            label1.setText("Please Enter Plaintext");
            return;
        }
        String plainT = plainText.getText();

        if(!isNumber(key.getText())) {
            label1.setText("Please Only Enter Numbers for Key");
            return;
        } else if (Integer.parseInt(key.getText()) >= 5000) {
            label1.setText("Please Use Numbers less than 5000");
            return;
        }

        int key1 = Integer.parseInt(key.getText());


        if(!isNumLess(plainT)) {
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
    void EncryptButton(ActionEvent event) {
        if(key.getText().isBlank() == true) {  //Validate User input to avoid exceptions
            label1.setText("Please Enter A Key");
            return;
        }
        if(plainText.getText().isBlank() == true) {
            label1.setText("Please Enter Plaintext");
            return;
        }
        String plainT = plainText.getText();
        if(!isNumber(key.getText())) {
            label1.setText("Please Only Enter Numbers for Key");
            return;
        } else if (Integer.parseInt(key.getText()) >= 5000) {
            label1.setText("Please Use Numbers less than 5000");
            return;
        }
        int key1 = Integer.parseInt(key.getText());



        if(!isNumLess(plainT)) {
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

