package sample.controller;
import javax.swing.*;
public class Controller {
    public void Parcourir(){
        // création de la boîte de dialogue
        JFileChooser dialogue = new JFileChooser();

        // affichage
        dialogue.showOpenDialog(null);
    }
}
