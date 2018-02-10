package sample.controller;
import javafx.fxml.FXML;

import javax.swing.*;
import java.io.*;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image ;
import javafx.scene.control.* ;

public class Controller {
    @FXML
    private TextField chemin;
//    @FXML
//    private GridPane imgGrid;
    @FXML
    private ScrollPane imgScroll;

    public void Parcourir() {
        JFileChooser dialogue;
        System.out.println(chemin.getText());
        if (chemin.getText() == "") {
            dialogue = new JFileChooser();
        } else {
            dialogue = new JFileChooser(chemin.getText());
        }
        // création de la boîte de dialogue
        dialogue = new JFileChooser();
        //Recupération que des repertoire
        dialogue.setFileSelectionMode(2);
        // affichage
        // todo: a enlever quand on rend le projet
        dialogue.setCurrentDirectory(new File("./src/sample"));
        dialogue.showOpenDialog(null);
        if (dialogue.getSelectedFile().toString() != null) {
            chemin.setText(dialogue.getSelectedFile().toString());
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
            imageView.setId(toString()+i);

            // ajout chaque image dans une cellule
            imgGrid.add(new ImageView(image),column,row);
        }
        // permet d'ajouter l'object imgGrig a l'object imgScroll pour scroller en fonction du nombre d'image
        imgScroll.setContent(imgGrid);
    }

    private static FilenameFilter jpgFileFilter = new FilenameFilter() {
        public boolean accept(File dir, String name) {
            return name.endsWith(".jpg");
        }
    };
}
