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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sentrium.launcher.sentriumlauncher.WebAunth;


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
    private Text TextLB;

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
            stage.show();
        });
    //on login button click event
        LoginBtn.setOnAction(event -> {
        // get data from NicknameFil and PasswdFil
        String username = NicknameFil.getText();
        String password = PasswFil.getText();
            String USER_UUID = null;
            try {
                USER_UUID = WebAunth.WebAunthFunc(username, password);
            } catch (Exception e) {
                TextLB.setText("Sorry ERROR try later!");
                throw new RuntimeException(e);

            }
            TextLB.setText(USER_UUID);
        });




    }

}
