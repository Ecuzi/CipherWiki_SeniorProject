package interfaces.dataencryptionproject_sp25;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HashController extends GUIStarter{
    public HashController() throws IOException {
    }

    @FXML
    void TryAction(ActionEvent event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(HASH_USER_SCENE);
        window.show();
    }

    @FXML
    void backButtonAction(ActionEvent event) {
        Scene guestScene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(guestScene);
        window.show();
    }
}
