package interfaces.dataencryptionproject_sp25;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GUIStarter extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/HomePage.fxml")));
        stage.setResizable(false);
        stage.setTitle("Cipher Wiki!");
        root.setCache(true);
        stage.setScene(new Scene(root,1280,800));
        stage.show();
    }
}
