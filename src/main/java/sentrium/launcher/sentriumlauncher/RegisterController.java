package sentrium.launcher.sentriumlauncher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sentrium.launcher.sentriumlauncher.WebRegister;

import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField EmailFil;

    @FXML
    private TextField NicknameFil;

    @FXML
    private TextField PasswdFil;

    @FXML
    private Button RegisterBtn;

    @FXML
    private TextField RetPasswdFil;

    @FXML
    private Button goLoginBtn;

    @FXML
    private Text DebugLog;

    @FXML
    void GoLogin(ActionEvent event) {

    }

    @FXML
    void onRegisterBTNClick(ActionEvent event) {
        RegisterBtn.setOnAction(event1 -> {
            //check if the lines not emty
            DebugLog.setText("Connecting to server...");
            try{
               String DATA;
               DATA = WebRegister.WebAunthFunc(NicknameFil.getText(), PasswdFil.getText(), EmailFil.getText(), RetPasswdFil.getText());
               if (DATA.equals("Pass dont mach")) {
                   DebugLog.setText("Passwords dont mach!");
               }
               if (DATA.equals("Login Error")) {
                   DebugLog.setText("Login Error!");

               }
               if (DATA.equals("nae")) {
                   DebugLog.setText("Nickname Exist");
               }
               if (DATA.equals("true")) {

                   RegisterBtn.getScene().getWindow().hide();

                   DebugLog.setText("Registration Successful");
                   FXMLLoader loader = new FXMLLoader();
                   loader.setLocation(getClass().getResource("Login.fxml"));
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
               }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        goLoginBtn.setOnAction(event2 -> {
            RegisterBtn.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Login.fxml"));
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
        });
    }

}
