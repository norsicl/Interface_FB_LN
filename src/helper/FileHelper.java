package helper;

/**
 * @description  FileHelper permet de comme son nom l'indique d'aider sur l'object File
 */
public class FileHelper {

    /**
     * @method getFilenameWithSuffix
     * @description permet de retourner le nom de l'image avec son extension
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
