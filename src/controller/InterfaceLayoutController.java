package controller;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import java.io.*;
import java.net.URL;
import java.util.*;

import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image ;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import model.InterfaceModelProperty;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.common.IImageMetadata;
import org.apache.commons.imaging.formats.jpeg.JpegImageMetadata;
import org.apache.commons.imaging.formats.jpeg.iptc.IptcRecord;
import org.apache.commons.imaging.formats.tiff.TiffField;
import org.apache.commons.imaging.formats.tiff.constants.AdobePhotoshopTagConstants;
import org.apache.commons.imaging.formats.tiff.constants.ExifTagConstants;
import org.apache.commons.imaging.formats.tiff.constants.MicrosoftTagConstants;
import org.apache.commons.imaging.formats.tiff.constants.TiffTagConstants;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfo;

public class InterfaceLayoutController implements Initializable {


    @FXML
    private TabPane TP_root;

    @FXML
    private TextField TF_chemin;
    @FXML
    private TextField TF_nameImg;

    @FXML
    private ScrollPane SP_imgScroll;
    @FXML
    private ImageView IV_oneImg;
    @FXML
    private TextField TF_nameImgLoupe;

    @FXML
    private Label L_nomFichier;
    @FXML
    private Label L_dimension;
    @FXML
    private Label L_poidsPhoto;
    @FXML
    private Label L_derniereModif;
    @FXML
    private Label L_date;
    @FXML
    private Label L_auteur;
    @FXML
    private Label L_iso;
    @FXML
    private Label L_marque;
    @FXML
    private Label L_modele;
    @FXML
    private Label L_objectif;
    @FXML
    private Label L_vitesse;
    @FXML
    private Label L_focale;
    @FXML
    private Label L_diaphragme;

    @FXML
    private TextArea TA_keyWord;

    @FXML
    private TextArea TA_keyWordLoupe;

    @FXML
    private ListView LV_KeyWords;

    private InterfaceModelProperty m_model ;
    public Map<String, String> MapKeyWords = new HashMap<>();

    @FXML
    public void handleOnMouseClickedBtnParcourirAction () throws IOException, ImageReadException {
        System.out.print("test");
        System.out.println(TF_chemin.getText());
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setInitialDirectory(new File("./src"));
        chooser.setTitle("Open File");
//      chooser.setInitialDirectory(new File(System.getProperty("user.home")));
        System.out.print(TF_chemin.getText());
        System.out.print(chooser.getInitialDirectory());
        if(TF_chemin.getText() == "./src" || TF_chemin.getText() == null) {
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


                // todo ; remettre a zero quand on recharge toute les images
//                LV_KeyWords.getSelectionModel().clearSelection();
//                LV_KeyWords.getItems().clear();
//                List<Integer> selectedItemsCopy = new ArrayList<>(LV_KeyWords.getSelectionModel().getSelectedItems());
//                LV_KeyWords.getItems().removeAll(selectedItemsCopy.toArray().toString());
//                LV_KeyWords.refresh();
                BuildGridImages(TF_chemin.getText());

            }
        }

    }


    private void BuildGridImages(String path) throws IOException, ImageReadException {
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
            //File monFileAbsolue = new File(TF_chemin.getText()+"\\"+monFile.getName());
            AllKeyWords(files[i]);
            // pour construire le grid
            column = (i%2 == 0) ? 0:1 ;
            row = (i%2 != 1) ? row+1 : row ;

            System.out.println("la ligne"+(row));
            System.out.println("la colonne"+column);

            String imageURI = new File(files[i].toString()).toURI().toString();
            Image I_image = new Image(imageURI, 400, 400, true, true);
            ImageView IV_imageView = new ImageView(I_image);
            IV_imageView.setId("img_"+i);
            IV_imageView.setOnMouseClicked (new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    ImageView node = (ImageView) event.getSource();
                    try {
                        seletedImg(node);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ImageReadException e) {
                        e.printStackTrace();
                    }
//                    IV_oneImg.setImage(node.getImage());
//                    File monFile = new File(node.getImage().getUrl());
//                    TF_nameImg.setText(monFile.getName());
                }
            });

//            IV_imageView.setOnMouseClicked(mouseEvent ->IV_oneImg.setImage(((ImageView) mouseEvent.getSource()).getImage()));

            // ajout chaque image dans une cellule
            GP_imgGrid.add(IV_imageView,column,row);

        }



        for(Map.Entry<String, String> entry : MapKeyWords.entrySet()) {
            LV_KeyWords.getItems().add(entry.getValue());
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
        ImageView nodeImage = (ImageView) GP_imgGrid.getChildren().get(0);
        seletedImg(nodeImage);

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
        m_model = new InterfaceModelProperty();
        TA_keyWord.setWrapText(true);
//        TF_nameImg . textProperty () . bind ( TF_nameImgLoupe) ;


    }

    /**
     * @param jpegMetadata
     * @param tagInfo
     * @return
     * @throws ImageReadException
     */
    private static String printTagValue(final JpegImageMetadata jpegMetadata,final TagInfo tagInfo) throws ImageReadException {
        final TiffField field = jpegMetadata.findEXIFValueWithExactMatch(tagInfo);
        String keyWords = "";
        if ((MicrosoftTagConstants.EXIF_TAG_XPKEYWORDS == tagInfo) && (field == null)) {
            for(int i = 0; i < jpegMetadata.getPhotoshop().getItems().size(); i++)
            {
                if (jpegMetadata.getPhotoshop().photoshopApp13Data.getRecords().get(i).getIptcTypeName() == "Keywords") {
                    keyWords +=  jpegMetadata.getPhotoshop().photoshopApp13Data.getRecords().get(i).getValue()+";";
                }
            }

            return  keyWords;
        } else if (field == null) {
            return "N/A";
        } else {
            return  field.getValue().toString();
        }

    }


    /**
     * @param nodeImage
     * @throws IOException
     * @throws ImageReadException
     */
    private void seletedImg(ImageView nodeImage) throws IOException, ImageReadException {
        IV_oneImg.setImage(nodeImage.getImage());
        File monFile = new File(nodeImage.getImage().getUrl());
        TF_nameImg.setText(monFile.getName());
        TF_nameImgLoupe.setText(monFile.getName());

        File monFileAbsolue = new File(TF_chemin.getText()+"\\"+monFile.getName());
        IImageMetadata metadata =  Imaging.getMetadata(monFileAbsolue);
        if (metadata instanceof JpegImageMetadata) {
            JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;

            L_auteur.setText(printTagValue(jpegMetadata,TiffTagConstants.TIFF_TAG_ARTIST));
            // todo : a faire // date  // poid // dimension // Name
            L_marque.setText(printTagValue(jpegMetadata,TiffTagConstants.TIFF_TAG_MAKE));
            L_modele.setText(printTagValue(jpegMetadata,TiffTagConstants.TIFF_TAG_MODEL));
            L_objectif.setText(printTagValue(jpegMetadata,ExifTagConstants.EXIF_TAG_APERTURE_VALUE));
            // todo : a faire  // vitesse
            L_diaphragme.setText(printTagValue(jpegMetadata,ExifTagConstants.EXIF_TAG_LENS));
            L_focale.setText(printTagValue(jpegMetadata,ExifTagConstants.EXIF_TAG_FOCAL_LENGTH));
            L_iso.setText(printTagValue(jpegMetadata,ExifTagConstants.EXIF_TAG_ISO));

            TA_keyWord.setText(printTagValue(jpegMetadata,MicrosoftTagConstants.EXIF_TAG_XPKEYWORDS));
            TA_keyWordLoupe.setText(printTagValue(jpegMetadata,MicrosoftTagConstants.EXIF_TAG_XPKEYWORDS));
        }
    }


    private void AllKeyWords(File monFileAbsolue) throws IOException, ImageReadException {
        IImageMetadata metadata =  Imaging.getMetadata(monFileAbsolue);
        if (metadata instanceof JpegImageMetadata) {
            JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;
            TiffField field = jpegMetadata.findEXIFValueWithExactMatch(MicrosoftTagConstants.EXIF_TAG_XPKEYWORDS);

            if (field == null) {
                if (jpegMetadata.getPhotoshop() != null) {
                    for(int i = 0; i < jpegMetadata.getPhotoshop().getItems().size(); i++)
                    {
                        IptcRecord iptcRecord = jpegMetadata.getPhotoshop().photoshopApp13Data.getRecords().get(i);
                        if (iptcRecord.getIptcTypeName() == "Keywords") {
                            if (iptcRecord.getValue() != null) {
                                MapKeyWords.put(iptcRecord.getValue(), iptcRecord.getValue());
                            }
                        }
                    }
                }

            } else {
               // pour les image qui ne vienent pas de photoshop
                for(int i = 0; i < field.getStringValue().split(";").length; i++) {
                   String keyWord = field.getStringValue().split(";")[i];
                    MapKeyWords.put(keyWord,keyWord);
                }
            }
        }
    }
}
