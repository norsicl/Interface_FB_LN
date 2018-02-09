package sample.controller;
import javafx.fxml.FXML;

import javax.swing.*;
import java.io.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image ;

public class Controller {
    @FXML
    private TextField chemin;

    @FXML
    private GridPane imgGrid;

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
        dialogue.showOpenDialog(null);
        if (dialogue.getSelectedFile().toString() != null) {
            chemin.setText(dialogue.getSelectedFile().toString());
        }

        File repertoire = new File(chemin.getText());
        File[] files = repertoire.listFiles(jpgFileFilter);
        System.out.print(files);
        int row = 1;
        int column = 1;
        for(int i = 0; i < files.length; i++)
        {
            System.out.println("À l'emplacement " + i +" du tableau nous avons = " + files[i]);

            ImageView monImage = new ImageView(files[i].toString());

//            column++;
//            if(i%3 > 3){
//                row++;
//                column = 1;
//            }


            Image image = new Image("File:image/"+monImage);
            imgGrid.getChildren().add(new ImageView(image));
//            Image image = new Image(files[i].toString());
//            imgGrid.add(new ImageView(image),0,0);
        }
    }

    private static FilenameFilter jpgFileFilter = new FilenameFilter() {
        public boolean accept(File dir, String name) {
            return name.endsWith(".jpg");
        }
    };
}
