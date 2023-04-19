package interfaces.dataencryptionproject_sp25;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GUIStarter extends Application {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/HomePage.fxml")));
    Parent AESUSER = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/AESUser.fxml")));
    Scene AES_USER_SCENE = new Scene(AESUSER);
    Parent CCUSER = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/CCUser.fxml")));
    Scene CC_USER_SCENE = new Scene(CCUSER);
    Parent RSAUSER = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/RSAUser.fxml")));
    Scene RSA_USER_SCENE = new Scene(RSAUSER);
    Parent HASHUSER = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/HashUser.fxml")));
    Scene HASH_USER_SCENE = new Scene(HASHUSER);
    public GUIStarter() throws IOException {
    }

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) {
        stage.setResizable(false);
        stage.setTitle("Cipher Wiki!");
        stage.setScene(new Scene(root,1280,800));
        stage.show();
    }
}