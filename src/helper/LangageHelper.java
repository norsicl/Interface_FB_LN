package helper;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.util.Locale;
import java.util.ResourceBundle;

public class LangageHelper {


    public static ResourceBundle loaderTraduction(String language,String country) {
        return ResourceBundle.getBundle("ResourceBundle.MessagesBundle",new Locale(language , country));
    }
}
