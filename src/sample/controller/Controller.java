package sample.controller;
import javafx.collections.ObservableList;
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
        chooser.setInitialDirectory(new File("./src/sample"));

        File file = chooser.showDialog(new Stage());
        if (file != null) {
            chemin.setText(file.toString());
        }

        File repertoire = new File(chemin.getText());
        File[] files = repertoire.listFiles(jpgFileFilter);

        // création de la grille sur 2 colonne
        GridPane imgGrid = new GridPane();
        imgGrid.setAlignment(Pos.CENTER);

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

        // parti loupe
        // récupére la premier image
        ImageView nodeImage1 = (ImageView) imgGrid.getChildren().get(0);
        oneImg.setImage(nodeImage1.getImage());
        // todo : si on veut récupérer un element via l'id ( à tester)
        // ImageView photoView = (ImageView)node.lookup("#img_1");

//        imgGrid.getChildren().setOnMouseClicked ( new EventHandler <MouseEvent>() {
//            public void handle ( MouseEvent event ) {
//
//                Node node = (Node) event.getSource();
//                System.out.print(node);
////                ImageView photoView = (ImageView)node.lookup("#"+node.getId());
////System.out.print(node);
////                oneImg.setImage(photoView.getImage());
//            }
//        });


    }



    private static FilenameFilter jpgFileFilter = new FilenameFilter() {
        public boolean accept(File dir, String name) {
            return name.endsWith(".jpg");
        }
    };
}
