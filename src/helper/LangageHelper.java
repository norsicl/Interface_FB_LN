package helper;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.util.Locale;
import java.util.ResourceBundle;


/**
 * @description  LangageHelper permet de comme son nom l'indique d'aider sur l'object ResourceBundle
 */
public class LangageHelper {

    /**
     * @method loaderTraduction
     * @description permet de charger la langue et le pays pour la traduction
     * @param language de type String
     * @param country de type String
     * @return ResourceBundle
     */
    public static ResourceBundle loaderTraduction(String language,String country) {
        return ResourceBundle.getBundle("ResourceBundle.MessagesBundle",new Locale(language , country));
    }
}
