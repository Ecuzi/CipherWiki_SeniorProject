package interfaces.dataencryptionproject_sp25;

import javafx.animation.SequentialTransition;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Splash {
    static Scene splash;
    static Rectangle rectangle = new Rectangle();
    final private Pane pane;
    final private SequentialTransition sequentialTransition;

    public Splash(){
        pane = new Pane();
        pane.setStyle("-fx-background-color:black");

        splash = new Scene(pane);
        sequentialTransition = new SequentialTransition();
    }
    public void show(){
        int scale = 30, dur = 800;
        rectangle = new Rectangle(100 - 2 * scale, 20, scale, scale);
        rectangle.setFill(Color.LIMEGREEN);

    }
}
