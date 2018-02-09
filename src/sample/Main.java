package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // soit on peut prendre le sample.fxml
        Parent root = FXMLLoader.load(getClass().getResource("view/sample.fxml"));
        Scene scene = new Scene(root, 1200, 720);
        primaryStage.setTitle("Interface FB LN");
        primaryStage.setScene(scene);

        // pour récupérer un element de type Pane (conteneur)

        primaryStage.show();
    }

}