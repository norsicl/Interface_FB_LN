package helper;

/**
 *  FileHelper permet de comme son nom l'indique d'aider sur l'object File
 */
public class FileHelper {

    /**
     * permet de retourner le nom de l'image avec son extension
     * @method getFilenameWithSuffix
     * @param original de type String
     * @param suffix de type String
     * @return String
     */
    public static String getFilenameWithSuffix(String original, String suffix) {
        String name = original.split("[.]")[0];
        String extension = original.split("[.]")[1];
        return name + suffix + "." + extension;
    }
}
