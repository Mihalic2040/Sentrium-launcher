package sentrium.launcher.sentriumlauncher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button GoRegBtn;

    @FXML
    private CheckBox KeepLogined;

    @FXML
    private Button LoginBtn;

    @FXML
    private TextField NicknameFil;

    @FXML
    private TextField PasswFil;

    @FXML
    void GoRegister(ActionEvent event) {

    }

    @FXML
    void onLoginBTNClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        GoRegBtn.setOnAction(event -> {
            GoRegBtn.getScene().getWindow().hide();
            // load register scene

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Register.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 1200, 720));
            stage.setResizable(false);
            stage.showAndWait();
        });
    }

}
