package controller;

import helper.LangageHelper;
import helper.StringHelper;
import helper.WriteExifMetadata;
import helper.enumLangage;
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
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.ImageWriteException;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.common.IImageMetadata;
import org.apache.commons.imaging.formats.jpeg.JpegImageMetadata;
import org.apache.commons.imaging.formats.jpeg.iptc.IptcRecord;
import org.apache.commons.imaging.formats.tiff.TiffField;
import org.apache.commons.imaging.formats.tiff.constants.ExifTagConstants;
import org.apache.commons.imaging.formats.tiff.constants.MicrosoftTagConstants;
import org.apache.commons.imaging.formats.tiff.constants.TiffTagConstants;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfo;

/**
 * Controller de la fenetre de l'application
 */
public class InterfaceLayoutController implements Initializable {

    /**
     * Element graphique Label : trié par
     */
    @FXML
    private Label L_sortBy;

    /**
     * Element graphique Label : mots clés
     */
    @FXML
    private Label L_keywords_bis;

    /**
     * Element graphique Label : filtré par mots clés
     */
    @FXML
    private Label L_filterByKeywords;

    /**
     * Element graphique Label : nom de l'image
     */
    @FXML
    private Label L_nameImage_bis;

    /**
     * Element graphique Label : nom de l'auteur de l'image
     */
    @FXML
    private Label L_I18N_author;

    /**
     * Element graphique Label : date de l'image
     */
    @FXML
    private Label L_I18N_date;

    /**
     * Element graphique Label : date de modification
     */
    @FXML
    private Label L_I18N_lastUpdate;

    /**
     * Element graphique Label : poid de l'image
     */
    @FXML
    private Label L_I18N_weight;

    /**
     * Element graphique Label : nom de l'image
     */
    @FXML
    private Label L_I18N_nameFile;

    /**
     * Element graphique Label : taille de l'image
     */
    @FXML
    private Label L_I18N_size;

    /**
     * Element graphique Label : focal de l'appareil
     */
    @FXML
    private Label L_I18N_focalLength;

    /**
     * Element graphique Label : diaphragme de l'appareil
     */
    @FXML
    private Label L_I18N_diaphragm;

    /**
     * Element graphique Label : vitesse de prise
     */
    @FXML
    private Label L_I18N_speed;

    /**
     * Element graphique Label : Objectif de l'appareil
     */
    @FXML
    private Label L_I18N_lens;

    /**
     * Element graphique Label : modèle de l'appareil
     */
    @FXML
    private Label L_I18N_model;

    /**
     * Element graphique Label : marque de l'appareil
     */
    @FXML
    private Label L_I18N_mark;

    /**
     * Element graphique ComboBox : filtre photo du week-end dernier
     */
    @FXML
    private ComboBox BC_lastWeek;

    /**
     * Element graphique ComboBox : filtre photo du week-end dernier
     */
    @FXML
    private ComboBox BC_date;

    /**
     * Element graphique TextField : recherche d'image par le champ de saisie
     */
    @FXML
    private TextField L_search;

    /**
     * Element graphique Label : mots clés
     */
    @FXML
    private Label L_keywords;

    /**
     * Element graphique Label : nom de l'image
     */
    @FXML
    private Label L_nameImage;

    /**
     * Element graphique Button : text du boutton parcourir
     */
    @FXML
    private Button BTN_parcourir;

    /**
     * Element graphique TabPane : pane layout
     */
    @FXML
    private TabPane TP_root;

    /**
     * Element graphique TextField : champ de saisie du chemin
     */
    @FXML
    private TextField TF_chemin;

    /**
     * Element graphique TextField : champ de saisie de l'image
     */
    @FXML
    private TextField TF_nameImg;

    /**
     * Element graphique ScrollPane : scroll bar pour la liste d'image
     */
    @FXML
    private ScrollPane SP_imgScroll;

    /**
     * Element graphique ImageView : image de le l'onglet vue/loupe
     */
    @FXML
    private ImageView IV_oneImg;

    /**
     * Element graphique TextField : champ de saisie - nom de l'image
     */
    @FXML
    private TextField TF_nameImgLoupe;

    /**
     * Element graphique Label : text nom de l'image
     */
    @FXML
    private Label L_nomFichier;

    /**
     * Element graphique Label : text dimension de l'image
     */
    @FXML
    private Label L_dimension;

    /**
     * Element graphique Label : text poids de l'image
     */
    @FXML
    private Label L_poidsPhoto;

    /**
     * Element graphique Label : text date derniere modification de l'image
     */
    @FXML
    private Label L_derniereModif;

    /**
     * Element graphique Label : text date derniere modification de l'image
     */
    @FXML
    private Label L_date;

    /**
     * Element graphique Label : text auteur de l'image
     */
    @FXML
    private Label L_auteur;

    /**
     * Element graphique Label : text ISO de l'image
     */
    @FXML
    private Label L_iso;

    /**
     * Element graphique Label : text marque de l'image
     */
    @FXML
    private Label L_marque;

    /**
     * Element graphique Label : text modèle de l'image
     */
    @FXML
    private Label L_modele;

    /**
     * Element graphique Label : text objectif de l'appareil
     */
    @FXML
    private Label L_objectif;

    /**
     * Element graphique Label : text vitesse de l'appareil
     */
    @FXML
    private Label L_vitesse;

    /**
     * Element graphique Label : text focale de l'appareil
     */
    @FXML
    private Label L_focale;

    /**
     * Element graphique Label : text diaphrame de l'appareil
     */
    @FXML
    private Label L_diaphragme;

    /**
     * Element graphique TextArea : mot clé
     */
    @FXML
    private TextArea TA_keyWord;

    /**
     * Element graphique TextArea : mot clé
     */
    @FXML
    private TextArea TA_keyWordLoupe;

    /**
     * Element graphique ListView<String>  : liste mots clés
     */
    @FXML
    private ListView<String> LV_KeyWords;

    /**
     * Map<String, String> MapKeyWords : list de mots clés contenue dans toutes les images
     */
    private Map<String, String> MapKeyWords = new HashMap<>();
    /**
     * GridPane GP_imgGrid : element GridPane créer dynamiquement
     */
    private GridPane GP_imgGrid;
    /**
     * File[] files : tableau de fichier d'images
     */
    private File[] files;

    /**
     * String KeyWordsNotChanged : chaine de mots clés contenue dans l'image d'origine
     */
    private String KeyWordsNotChanged;

    /**
     * File monFile : fichier d'image
     */
    private File monFile;
    /**
     *  File monFileAbsolue : fichier du chemin absolue de l'image selectionné
     */
    private File monFileAbsolue;

    /**
     * Evenement click sur le bouton parcourir pour récupérer la liste d'image
     * @method handleOnMouseClickedBtnParcourirAction
     * @throws IOException
     * @throws ImageReadException
     */
    @FXML
    private void handleOnMouseClickedBtnParcourirAction () throws IOException, ImageReadException {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setInitialDirectory(new File("./src"));
        chooser.setTitle("Open File");
      chooser.setInitialDirectory(new File(System.getProperty("user.home")));
//        System.out.print(TF_chemin.getText());
//        System.out.print(chooser.getInitialDirectory());
//        if(TF_chemin.getText().equals("./src") || TF_chemin.getText() == null) {
//            chooser.setInitialDirectory(new File("./src"));
//        }
        /*else{
            System.out.println(chemin.getText());
            //chooser.setInitialDirectory(new File((chemin.getText())));
        }*/

        File file = chooser.showDialog(new Stage());
        if (file != null) {
            if(!TF_chemin.getText().equals(file.toString())){
                TF_chemin.setText(file.toString());
                // tant que il n'y a pas de répétoire selectionné on ne donne pas droit au autre panel
                TP_root.getTabs().get(1).setDisable(false);
                TP_root.getTabs().get(2).setDisable(false);

                // remettre a zero quand on recharge toute les images
                if (MapKeyWords.containsValue("all")) {
                    MapKeyWords.clear();
                    LV_KeyWords.getItems().setAll("");
                }
                // construction du grid pane
                BuildGridImages(TF_chemin.getText());
            }
        }

    }

    /**
     * Ecrire un mot clé dans l'image selectionné
     * @method WriteKeyWord
     * @throws ImageWriteException
     * @throws ImageReadException
     * @throws IOException
     */
    private void WriteKeyWord() throws ImageWriteException, ImageReadException, IOException {
        if (!TA_keyWord.getText().equals("")) {
            new WriteExifMetadata().WriteExif(monFileAbsolue,TA_keyWord.getText());
        }
    }

    /**
     * Evenement click un mot clé pour filter la liste des images affichés
     * @method handleOnMouseClickedListViewLV_KeyWords
     * @throws IOException
     * @throws ImageReadException
     */
    @FXML
    public void handleOnMouseClickedListViewLV_KeyWords() throws IOException, ImageReadException {
        String KeyWordSeleted;
        int counter      = 0;
        File[] fileTried = new File[files.length];
        KeyWordSeleted = LV_KeyWords.getSelectionModel().getSelectedItem();
        // reinitialiser le filtre
        if (!KeyWordSeleted.equals("all")) {
            for (File file : files) {
                IImageMetadata metadataFilter = Imaging.getMetadata(file);
                if (metadataFilter instanceof JpegImageMetadata) {
                    JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadataFilter;
                    for (int i = 0; i < printTagValue(jpegMetadata, MicrosoftTagConstants.EXIF_TAG_XPKEYWORDS).split(";").length; i++) {
                        if (printTagValue(jpegMetadata, MicrosoftTagConstants.EXIF_TAG_XPKEYWORDS).split(";")[i].equals(KeyWordSeleted)) {
                            fileTried[counter] = file;
                        }
                    }
                }
                counter++;
            }
            //init
            counter = 0;
            GP_imgGrid.getChildren().clear();
            AjoutImage(rebuilidIndexArray(fileTried));
        } else {
            GP_imgGrid.getChildren().clear();
            AjoutImage(files);
        }
    }

    /**
     * Reconstruction du tableau (réinitialisation de l'index)
     * @method rebuilidIndexArray
     * @param fileTried
     * @return File[] tableau de fichier d'image
     */
    private File[] rebuilidIndexArray(File [] fileTried){
        int j                   = 0;
        File[] fileTriedReBuild = new File[files.length];
        for (File aFileTried : fileTried) {
            if (aFileTried != null) {
                fileTriedReBuild[j++] = aFileTried;
            }
        }
        return fileTriedReBuild;
    }

    /**
     * Construction de element gridPane contenant les images
     * @method BuildGridImages
     * @param path de type String : chemin du dossier contenant les images
     * @throws IOException
     * @throws ImageReadException
     */
    private void BuildGridImages(String path) throws IOException, ImageReadException {
        File repertoire = new File(path);
        files           = repertoire.listFiles(jpgFileFilter);

        // création de la grille sur 2 colonne
        GP_imgGrid      = new GridPane();
        GP_imgGrid.setAlignment(Pos.CENTER);

        AjoutImage(files);
    }

    /**
     * Construction de element gridPane contenant les images
     * @method AjoutImage
     * @param files de type File[] tableau de fichier d'image
     * @throws IOException
     * @throws ImageReadException
     */
    private void AjoutImage(File[] files) throws IOException, ImageReadException  {
        int row     = -1; // on part de -1 car l'indice est a 0
        int column  = 0;
        ImageView IV_imageView;
        for(int i = 0; i < files.length; i++)
        {
            if (files[i] != null) {
                if (!MapKeyWords.containsValue("all")) {
                    AllKeyWords(files[i]);
                }

                // pour construire le grid
                column = (i % 2 == 0) ? 0 : 1;
                row = (i % 2 != 1) ? row + 1 : row;

                String imageURI = new File(files[i].toString()).toURI().toString();
                Image I_image   = new Image(imageURI, 400, 400, true, true);
                IV_imageView    = new ImageView(I_image);
                IV_imageView.setId("img_" + i);
                IV_imageView.setOnMouseClicked(this::handOnMouseClickedVIImageAction);
                // ajout chaque image dans une cellule
                GP_imgGrid.add(IV_imageView,column,row);
            }
        }

        if (!MapKeyWords.containsValue("all")) {
            MapKeyWords.put("all", "all");
            for (Map.Entry<String, String> entry : MapKeyWords.entrySet()) {
                LV_KeyWords.getItems().add(entry.getValue());
            }
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

    /**
     * pour récupérer que les images d'extension .jpg
     * @method jpgFileFilter
     * @param dir
     * @param name
     */
    private static final FilenameFilter jpgFileFilter = (dir, name) -> name.endsWith(".jpg");


    /**
     * Initialise la classe de contrôleur Cette méthode est appelée automatiquement après le chargement du fichier fxml.
     * @method initialize
     * @param location de type URL
     * @param resources de type ResourceBundle
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//      System.out.print(location);
//      System.out.print(resources);
//      m_model = new FocusPropertyChangeListener();
        TA_keyWord.setWrapText(true);
        TA_keyWordLoupe.setWrapText(true);
//      TF_nameImg . textProperty () . bind ( TF_nameImgLoupe) ;
    }

    /**
     * Affiche le métadata de/le tag de l'image en fonction du tagInfo demandé
     * @method printTagValue
     * @param jpegMetadata de type JpegImageMetadata
     * @param tagInfo de type TagInfo : l'info voulu dans l'image
     * @return String tag de l'image demandé
     * @throws ImageReadException
     */
    private static String printTagValue(final JpegImageMetadata jpegMetadata,final TagInfo tagInfo) throws ImageReadException {
        final TiffField field  = jpegMetadata.findEXIFValueWithExactMatch(tagInfo);
        StringBuilder keyWords = new StringBuilder();
        String keyWordDecode   ="";
        if ((MicrosoftTagConstants.EXIF_TAG_XPKEYWORDS == tagInfo) && (null == field)) {
            if (null != jpegMetadata.getPhotoshop()) {
                for (int i = 0; i < jpegMetadata.getPhotoshop().getItems().size(); i++) {
                    if (jpegMetadata.getPhotoshop().photoshopApp13Data.getRecords().get(i).getIptcTypeName().equals("Keywords")) {
                        keyWords.append(jpegMetadata.getPhotoshop().photoshopApp13Data.getRecords().get(i).getValue()).append(";");
                    }
                }
                keyWordDecode = StringHelper.convertFromUTF8(keyWords.toString());
            }
            return  keyWordDecode;
        } else if (null == field) {
            return "N/A";
        } else {
            return  field.getValue().toString();
        }
    }


    /**
     * Selectionne une image dans le grid pane & affiche les différentes informations dans l'application
     * @method seletedImg
     * @param nodeImage de type ImageView
     * @throws IOException
     * @throws ImageReadException
     */
    private void seletedImg(ImageView nodeImage) throws IOException, ImageReadException {
        IV_oneImg.setImage(nodeImage.getImage());
        monFile        = new File(nodeImage.getImage().getUrl());
        monFileAbsolue = new File(TF_chemin.getText()+"\\"+monFile.getName());
        TF_nameImg.setText(monFile.getName());
        TF_nameImgLoupe.setText(monFile.getName());

        // pour ajouter un style a la selection
        for (int i = 0; i < GP_imgGrid.getChildren().size()-1; i++) {
            if (null != files[i]) {
                GP_imgGrid.getChildren().get(i).setStyle("");
            }
        }
        // met un encadré bleu autour de l'image selectionné
        nodeImage.setStyle("-fx-effect: innershadow(gaussian, #039ed3, 10, 1.0, 0, 0);");

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
            KeyWordsNotChanged = TA_keyWord.getText();
        } else {
            TA_keyWord.setText("");
            TA_keyWordLoupe.setText("");
        }

        // ajout evenement sur le focus du champs de saisie pour les mots clés
        TA_keyWord.focusedProperty().addListener((observable, oldValue, newValue) -> {
            // si false = unfocused et si le text n'est pas le meme qu'a l'origine
            if ((!newValue) && (!KeyWordsNotChanged.equals(TA_keyWord.getText()))) {
                try {
                    WriteKeyWord();
                    // mettre a jour la liste
                    // remettre a zero quand on recharge toute les images
                    if (MapKeyWords.containsValue("all")) {
                        MapKeyWords.clear();
                        LV_KeyWords.getItems().setAll("");
                        for (File file : files) {
                            if (null != file) {
                                AllKeyWords(file);
                            }
                        }
                        MapKeyWords.put("all", "all");
                        for (Map.Entry<String, String> entry : MapKeyWords.entrySet()) {
                            LV_KeyWords.getItems().add(entry.getValue());
                        }
                    }
                } catch (ImageWriteException | ImageReadException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Création de la map contenant la liste de mots clés
     * @method AllKeyWords
     * @param monFileAbsolue de type File
     * @throws IOException
     * @throws ImageReadException
     */
    private void AllKeyWords(File monFileAbsolue) throws IOException, ImageReadException {
        IImageMetadata metadata =  Imaging.getMetadata(monFileAbsolue);
        if (metadata instanceof JpegImageMetadata) {
            JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;
            TiffField field                = jpegMetadata.findEXIFValueWithExactMatch(MicrosoftTagConstants.EXIF_TAG_XPKEYWORDS);
            if (null == field) {
                if (null != jpegMetadata.getPhotoshop()) {
                    for(int i = 0; i < jpegMetadata.getPhotoshop().getItems().size(); i++)
                    {
                        IptcRecord iptcRecord = jpegMetadata.getPhotoshop().photoshopApp13Data.getRecords().get(i);
                        if (iptcRecord.getIptcTypeName().equals("Keywords")) {
                            if (null != iptcRecord.getValue()) {
                                // pour gérer le bon format UTF8 du mot clé contenu dans l'image
                                String keyWordDecode = StringHelper.convertFromUTF8(iptcRecord.getValue());
                                // ajout du mot clé dans la map
                                MapKeyWords.put(keyWordDecode, keyWordDecode);
                            }
                        }
                    }
                }
            } else {
                // pour les image qui ne vienent pas de photoshop
                for(int i = 0; i < field.getStringValue().split(";").length; i++) {
                    String keyWord = field.getStringValue().split(";")[i];
                    //String keyWordDecode = StringHelper.convertFromUTF8(keyWord);
                    MapKeyWords.put(keyWord,keyWord);
                }
            }
        }
    }

    /**
     * Evenement click pour la selection de l'image
     * @method handOnMouseClickedVIImageAction
     * @param event de type MouseEvent permetant de récupérer le node clické et récupérer l'image selectionné
     */
    private void handOnMouseClickedVIImageAction(MouseEvent event) {
        ImageView node = (ImageView) event.getSource();
        try {
            seletedImg(node);
        } catch (IOException | ImageReadException e) {
            e.printStackTrace();
        }
    }

    /**
     * Evenement click pour la traduction de l'application (Américain)
     * @method handleOnMouseClickedImgUSAction
     */
    public void handleOnMouseClickedImgUSAction() {
        ResourceBundle rb = LangageHelper.loaderTraduction(enumLangage.EN_US.getLanguage(),enumLangage.EN_US.getCountry());
        traductionReloader(rb);
    }

    /**
     * Evenement click pour la traduction de l'application (Français)
     * @method handleOnMouseClickedImgUSAction
     */
    public void handleOnMouseClickedImgFRAction() {
        ResourceBundle rb = LangageHelper.loaderTraduction(Locale.FRANCE.getLanguage(),Locale.FRANCE.getCountry());
        traductionReloader(rb);
    }

    /**
     * Evenement click pour la traduction de l'application (chinois)
     * @method handleOnMouseClickedImgUSAction
     */
    public void handleOnMouseClickedImgJAAction() {
        ResourceBundle rb = LangageHelper.loaderTraduction(Locale.SIMPLIFIED_CHINESE.getLanguage(),Locale.SIMPLIFIED_CHINESE.getCountry());
        traductionReloader(rb);
    }

    /**
     * Permet de modifier le text en fonction de la langue voulue de tout les Text contenue dans l'application
     * @method traductionReloader
     * @param rb de type ResourceBundle
     */
    private void traductionReloader(ResourceBundle rb) {
        BTN_parcourir.setText(rb.getString("I18N.browse"));

        // pour modifier le text des libellés des 3 onglets
        TP_root.getTabs().get(0).setText(rb.getString("I18N.grille"));
        TP_root.getTabs().get(1).setText(rb.getString("I18N.vue"));
        TP_root.getTabs().get(2).setText(rb.getString("I18N.slideshow"));

        L_I18N_author.setText(rb.getString("I18N.author"));
        L_I18N_date.setText(rb.getString("I18N.date"));
        L_I18N_lastUpdate.setText(rb.getString("I18N.lastUpdate"));
        L_I18N_weight.setText(rb.getString("I18N.weight"));
        L_I18N_nameFile.setText(rb.getString("I18N.nameFile"));
        L_I18N_size.setText(rb.getString("I18N.size"));
        L_I18N_focalLength.setText(rb.getString("I18N.focalLength"));
        L_I18N_diaphragm.setText(rb.getString("I18N.diaphragm"));
        L_I18N_speed.setText(rb.getString("I18N.speed"));
        L_I18N_lens.setText(rb.getString("I18N.lens"));
        L_I18N_model.setText(rb.getString("I18N.model"));
        L_I18N_mark.setText(rb.getString("I18N.mark"));

        BC_lastWeek.setPromptText(rb.getString("I18N.lastWeek"));
        BC_date.setPromptText(rb.getString("I18N.date"));

        L_search.setText(rb.getString("I18N.search"));

        L_keywords.setText(rb.getString("I18N.keywords"));
        L_nameImage.setText(rb.getString("I18N.nameImage"));

        L_keywords_bis.setText(rb.getString("I18N.keywords"));
        L_filterByKeywords.setText(rb.getString("I18N.filterByKeywords"));
        L_nameImage_bis.setText(rb.getString("I18N.nameImage"));
        L_sortBy.setText(rb.getString("I18N.sortBy"));
    }

}


