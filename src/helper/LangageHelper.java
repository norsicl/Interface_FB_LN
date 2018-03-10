package helper;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.util.Locale;
import java.util.ResourceBundle;


/**
 *  LangageHelper permet de comme son nom l'indique d'aider sur l'object ResourceBundle
 */
public class LangageHelper {

    /**
     * Permet de charger la langue et le pays pour la traduction
     * @method loaderTraduction
     * @param language de type String
     * @param country de type String
     * @return ResourceBundle
     */
    public static ResourceBundle loaderTraduction(String language,String country) {
        return ResourceBundle.getBundle("ResourceBundle.MessagesBundle",new Locale(language , country));
    }
}
