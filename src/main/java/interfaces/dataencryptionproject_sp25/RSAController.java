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

public class RSAController {
    @FXML
    void TryAction(ActionEvent event) throws IOException {
        Parent guestViewParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/RSAUser.fxml")));
        Scene guestScene = new Scene(guestViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(guestScene);
        window.show();
    }
    @FXML
    void backButtonAction(ActionEvent event) throws IOException {
        Parent guestViewParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/HomePage.fxml")));
        Scene guestScene = new Scene(guestViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(guestScene);
        window.show();
    }
}
