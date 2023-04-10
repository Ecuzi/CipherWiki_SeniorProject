package interfaces.dataencryptionproject_sp25;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HomeController {
    @FXML
    void AESAction(ActionEvent event) throws IOException {
        Parent guestViewParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/AES.fxml")));
        Scene guestScene = new Scene(guestViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(guestScene);
        window.show();
    }

    @FXML
    void CeaserButton(ActionEvent event) throws IOException {
        Parent guestViewParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/CaesarCipher.fxml")));
        Scene guestScene = new Scene(guestViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(guestScene);
        window.show();
    }

    @FXML
    void HashingAction(ActionEvent event) throws IOException {
        Parent guestViewParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Hash.fxml")));
        Scene guestScene = new Scene(guestViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(guestScene);
        window.show();
    }

    @FXML
    void RSAAction(ActionEvent event) throws IOException {
        Parent guestViewParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/RSA.fxml")));
        Scene guestScene = new Scene(guestViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(guestScene);
        window.show();
    }

    @FXML
    void CreditAction(ActionEvent event) throws IOException {
        Parent guestViewParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Credits.fxml")));
        Scene guestScene = new Scene(guestViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(guestScene);
        window.show();
    }
}
