module interfaces.dataencryptionproject_sp25 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires validatorfx;

    opens interfaces.dataencryptionproject_sp25 to javafx.fxml;
    exports interfaces.dataencryptionproject_sp25;
}