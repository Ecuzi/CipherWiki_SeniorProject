package interfaces.dataencryptionproject_sp25;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AESController extends GUIStarter {
    public Button backButton, tryButton;

    public AESController() throws IOException {
    }

    @FXML
    void TryAction(ActionEvent event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(AES_USER_SCENE);
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
