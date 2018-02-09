package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

//    @Override
    public void start(Stage primaryStage) throws Exception{
        // soit on peut prendre le sample.fxml
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        // soit on créer directement les element ici
//        StackPane root = new StackPane();
        Scene scene = new Scene(root,1200,720);
        primaryStage.setTitle("Interface FB LN");
        primaryStage.setScene(scene);

//        Pane pane = new Pane();
//        root.getChildren().add(pane);
        primaryStage.show();
    }

//    public MenuBar createMenus() {
//        MenuBar menubar = new MenuBar() ;
//        Menu menu1 = new Menu("Menu1");
//        menu1.getItems(). add (new MenuItem("menuItem11")) ;
//        Menu menu2 = new Menu("Menu2");
//        menu2.getItems().addAll( new MenuItem("menuItem21") , new MenuItem("menuItem22")) ;
//        menubar.getMenus().addAll( menu1 , menu2 ) ;
//        return menubar ;
//    }
//
//    public HBox createButtons() {
//        HBox hbox = new HBox() ;
//        Button b1 = new Button ("Bouton1");
//        Button b2 = new Button ("Bouton2");
//        Button b3 = new Button ("Bouton3");
//        hbox . getChildren () . addAll (b1 , b2 , b3 );
//        return hbox ;
//    }
//
//    @Override
//    public void start ( Stage primaryStage ) {
//        MenuBar menubar = createMenus() ;
//        GridPane grid = new GridPane() ;
//        grid.setVgap (40) ;
//        grid.add( new Label ("Label1") , 0, 0) ;
//        grid.add( new Label ("Label2") , 1, 0) ;
//        grid.add( createButtons() , 0, 1) ; // column 0 , row 1
//        VBox root = new VBox() ;
//        root.getChildren().addAll( menubar , grid );
//        Scene scene = new Scene( root );
//        primaryStage . setScene ( scene );
//        primaryStage . setTitle ("Exemple4");
//        primaryStage . show () ;
//    }
//
//
//    public TabPane createPanel() {
//
//        TabPane tabPane = new TabPane();
//        Tab tabGrill = new Tab("Grille");
//        Tab tabLoupe = new Tab("Loupe");
//        tabGrill.setText("Grille");
//        Tab tabDiaporama = new Tab("Diaporama");
//        tabPane.getTabs().addAll(tabGrill,tabLoupe,tabDiaporama);
//        return tabPane;
//    }
}
