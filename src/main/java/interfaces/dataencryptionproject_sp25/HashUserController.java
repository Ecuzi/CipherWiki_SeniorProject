package interfaces.dataencryptionproject_sp25;

import Algorithms.CaesarCipher_Encryption;
import Algorithms.Hashing_Encryption;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class HashUserController {

    @FXML
    private TextArea DisplayArea;




    @FXML
    private Label label1;
    @FXML
    private TextField plainText;

    Hashing_Encryption Cipher = new Hashing_Encryption();


    @FXML
    void backButtonAction(ActionEvent event) throws IOException {
        Parent guestViewParent = FXMLLoader.load(getClass().getResource("/Hash.fxml"));
        Scene guestScene = new Scene(guestViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(guestScene);
        window.show();
    }


    @FXML
    void EncryptButton(ActionEvent event) throws NoSuchAlgorithmException {

        if(plainText.getText().isBlank() == true) {
            label1.setText("Please Enter Plaintext");
            return;
        }
        else {
            DisplayArea.setWrapText(true);
            DisplayArea.setText(Cipher.Hashing_Encryption(plainText.getText()));

        }
    }


}

