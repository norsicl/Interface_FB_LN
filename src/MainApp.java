import helper.StringHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.lang.String;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainApp extends Application {

    public static void main(String[] args) {
        Application.launch(MainApp.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // soit on peut prendre le Interface_FB_LN.fxml
        Parent root = FXMLLoader.load(getClass().getResource("view/Interface_FB_LN.fxml"));
        Scene scene = new Scene(root, 1200, 720);
        primaryStage.setTitle("Interface FB LN");
        primaryStage.setScene(scene);

        // pour récupérer un element de type Pane (conteneur)






        primaryStage.show();


        // pour afficher un message avant la fermeture de la fenetre
        primaryStage.setOnCloseRequest(( WindowEvent we ) -> { System.out.println("Fermeture de l ' application");
            primaryStage.close();
        }) ;

    }
}