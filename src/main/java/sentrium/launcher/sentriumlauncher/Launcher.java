package sentrium.launcher.sentriumlauncher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import sentrium.launcher.sentriumlauncher.WebAunth;
import java.io.IOException;

//Отче наш, Иже еси на небесе́х!
//Да святится имя Твое, да прии́дет Царствие Твое,
//да будет воля Твоя, яко на небеси́ и на земли́.
//Хлеб наш насущный да́ждь нам дне́сь;
//и оста́ви нам до́лги наша, якоже и мы оставляем должнико́м нашим;
//и не введи нас во искушение, но изба́ви нас от лукаваго.
//Яко Твое есть Царство и сила, и слава, Отца, и Сына, и Святаго Духа, ныне и присно, и во веки веков. Аминь

//For good build

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 720);
        stage.setTitle("Sentrium Launcher");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        //тут тест для аунтефікації його можна ігнорити
        //String UUID_DATA = WebAunth.WebAunthFunc("test", "test_pass");
        // System.out.println(UUID_DATA);

    }

    public static void main(String[] args) {
        launch();
    }
}