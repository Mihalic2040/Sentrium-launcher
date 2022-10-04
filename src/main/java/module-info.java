module sentrium.launcher.sentriumlauncher {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens sentrium.launcher.sentriumlauncher to javafx.fxml;
    exports sentrium.launcher.sentriumlauncher;
}