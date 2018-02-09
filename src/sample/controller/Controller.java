package sample.controller;
import javafx.fxml.FXML;

import javax.swing.*;
import java.io.*;
import javafx.scene.control.*;

public class Controller {
    @FXML
    public TextField chemin;

    public void Parcourir(){
        JFileChooser dialogue;
        System.out.println(chemin.getText());
        if(chemin.getText() == ""){
            dialogue = new JFileChooser();
        }else{
            dialogue = new JFileChooser(chemin.getText());
        }
        // création de la boîte de dialogue
        dialogue = new JFileChooser();
        //Recupération que des repertoire
        dialogue.setFileSelectionMode(2);
        // affichage
        dialogue.showOpenDialog(null);
        if(dialogue.getSelectedFile().toString() != null) {
            chemin.setText(dialogue.getSelectedFile().toString());
        }
    }
}
