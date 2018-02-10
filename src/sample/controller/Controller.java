package sample.controller;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javax.swing.*;
import java.io.*;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image ;
import javafx.scene.control.* ;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private TabPane tabPaneRoot;

    @FXML
    private TextField chemin;
//    @FXML
//    private GridPane imgGrid;
    @FXML
    private ScrollPane imgScroll;
    @FXML
    private ImageView oneImg;

    public void Parcourir() {
        JFileChooser dialogue;
        System.out.println(chemin.getText());
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Open File");
//      chooser.setInitialDirectory(new File(System.getProperty("user.home")));
        if(chemin.getText() == "" || chemin.getText() == null) {
            chooser.setInitialDirectory(new File("./src/sample"));
        }
        /*else{
            System.out.println(chemin.getText());
            //chooser.setInitialDirectory(new File((chemin.getText())));
        }*/

        File file = chooser.showDialog(new Stage());
        if (file != null) {
            if(chemin.getText() != file.toString()){
                chemin.setText(file.toString());
                // tant que il n'y a pas de répétoire selectionné on ne donne pas droit au autre panel
                tabPaneRoot.getTabs().get(1).setDisable(false);
                tabPaneRoot.getTabs().get(2).setDisable(false);
                Image(chemin.getText());
            }
        }
    }

    private void Image(String path){
        File repertoire = new File(path);
        File[] files = repertoire.listFiles(jpgFileFilter);

        // création de la grille sur 2 colonne
        GridPane imgGrid = new GridPane();
//        imgGrid.setAlignment(Pos.CENTER);
//        imgGrid.setFocusTraversable(false);
//        imgScroll.setFocusTraversable(false);
//        System.out.print(imgGrid.isMouseTransparent());
//        imgScroll.setMouseTransparent(true);
//        imgGrid.setMouseTransparent(true);

        System.out.print(files);
        int row = -1; // on part de -1 car l'indice est a 0
        int column = 0;
        for(int i = 0; i < files.length; i++)
        {
            System.out.println("À l'emplacement " + i +" du tableau nous avons = " + files[i]);

            // pour construire le grid
            column = (i%2 == 0) ? 0:1 ;
            row = (i%2 != 1) ? row+1 : row ;

            System.out.println("la ligne"+(row));
            System.out.println("la colonne"+column);

            String imageURI = new File(files[i].toString()).toURI().toString();
            Image image = new Image(imageURI, 400, 400, true, true);
            ImageView imageView = new ImageView(image);
            imageView.setId("img_"+i);
//            imageView.setMouseTransparent(false);
            // on donne le focus pour pouvoir avoir l'évenement du click
            imageView.setFocusTraversable(true);
            imageView.setOnMouseClicked(mouseEvent -> System.out.printf("Bouton %s cliqué sur le nœud, %d click(s) %f x %f.", mouseEvent.getButton(), mouseEvent.getClickCount(), mouseEvent.getX(), mouseEvent.getY()).println());
            // ajout chaque image dans une cellule
            imgGrid.add(new ImageView(image),column,row);
        }

        // permet d'ajouter l'object imgGrig a l'object imgScroll pour scroller en fonction du nombre d'image
        imgScroll.setContent(imgGrid);
        // afficher la grille
        imgGrid.setGridLinesVisible(true);
        // mettre des espaces entre les cellules
        imgGrid.setHgap(6);
        imgGrid.setVgap(6);
//         ImageView photoView = (ImageView)imgGrid.lookup("#img_1");


        // parti loupe
        // récupére la premier image
        ImageView nodeImage1 = (ImageView) imgGrid.getChildren().get(0);
        oneImg.setImage(nodeImage1.getImage());
        // todo : si on veut récupérer un element via l'id ( à tester)
        // ImageView photoView = (ImageView)node.lookup("#img_1");

            /*imgGrid.setOnMouseClicked ( new EventHandler <MouseEvent>()) {
                public void handle ( MouseEvent event ) {

                    Node node = (Node) event.getSource();

                    System.out.print(node);
            //                ImageView photoView = (ImageView)node.lookup("#"+node.getId());
            //System.out.print(node);
            //                oneImg.setImage(photoView.getImage());
                }
            });*/
    }

    private static FilenameFilter jpgFileFilter = new FilenameFilter() {
        public boolean accept(File dir, String name) {
            return name.endsWith(".jpg");
        }
    };
}
