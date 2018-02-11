package controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
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

public class InterfaceLayoutController implements Initializable {

    @FXML
    private TabPane TP_root;

    @FXML
    private TextField TF_chemin;

    @FXML
    private ScrollPane SP_imgScroll;
    @FXML
    private ImageView IV_oneImg;

    @FXML
    protected void handleOnMouseClickedBtnParcourirAction () {
    System.out.print("test");
        System.out.println(TF_chemin.getText());
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setInitialDirectory(new File("./src"));
        chooser.setTitle("Open File");
//      chooser.setInitialDirectory(new File(System.getProperty("user.home")));
        System.out.print(TF_chemin.getText());
        System.out.print(chooser.getInitialDirectory());
        if(TF_chemin.getText() == "./src/sample" || TF_chemin.getText() == null) {
            chooser.setInitialDirectory(new File("./src"));
        }
        /*else{
            System.out.println(chemin.getText());
            //chooser.setInitialDirectory(new File((chemin.getText())));
        }*/

        File file = chooser.showDialog(new Stage());
        if (file != null) {
            if(TF_chemin.getText() != file.toString()){
                TF_chemin.setText(file.toString());
                // tant que il n'y a pas de répétoire selectionné on ne donne pas droit au autre panel
                TP_root.getTabs().get(1).setDisable(false);
                TP_root.getTabs().get(2).setDisable(false);
                Image(TF_chemin.getText());
            }
        }
    }


    private void Image(String path){
        File repertoire = new File(path);
        File[] files = repertoire.listFiles(jpgFileFilter);

        // création de la grille sur 2 colonne
        GridPane GP_imgGrid = new GridPane();
        GP_imgGrid.setAlignment(Pos.CENTER);

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
            Image I_image = new Image(imageURI, 400, 400, true, true);
            ImageView IV_imageView = new ImageView(I_image);
            IV_imageView.setId("img_"+i);
//            imageView.setMouseTransparent(false);
            // on donne le focus pour pouvoir avoir l'évenement du click
            IV_imageView.setFocusTraversable(true);
            IV_imageView.setOnMouseClicked(mouseEvent -> System.out.printf("Bouton %s cliqué sur le nœud, %d click(s) %f x %f.", mouseEvent.getButton(), mouseEvent.getClickCount(), mouseEvent.getX(), mouseEvent.getY()).println());
            // ajout chaque image dans une cellule
            GP_imgGrid.add(IV_imageView,column,row);

        }

        // permet d'ajouter l'object imgGrig a l'object imgScroll pour scroller en fonction du nombre d'image
        SP_imgScroll.setContent(GP_imgGrid);
        // afficher la grille
        GP_imgGrid.setGridLinesVisible(true);
        // mettre des espaces entre les cellules
        GP_imgGrid.setHgap(6);
        GP_imgGrid.setVgap(6);
//         ImageView photoView = (ImageView)imgGrid.lookup("#img_1");


        // parti loupe
        // récupére la premier image
        ImageView nodeImage1 = (ImageView) GP_imgGrid.getChildren().get(0);
        IV_oneImg.setImage(nodeImage1.getImage());
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

    private static final FilenameFilter jpgFileFilter = new FilenameFilter() {
        public boolean accept(File dir, String name) {
            return name.endsWith(".jpg");
        }
    };

    // ici les initalisation concernant le controlleur
    /**
     * Initializes the controller class . This method is automatically called
     * after the fxml file has been loaded .
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        System.out.print(location);
//        System.out.print(resources);
//        m_model = new CounterModel () ;
//        m_model . addObserver ( this ) ;
//        valueLabel . setText ( m_model . getValue () );

    }
}
