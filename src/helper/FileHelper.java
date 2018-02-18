package helper;

public class FileHelper {

    /**
     * @param original
     * @param suffix
     * @return
     */
    public static String getFilenameWithSuffix(String original, String suffix) {
        String name = original.split("[.]")[0];
        String extension = original.split("[.]")[1];

        return name + suffix + "." + extension;
    }
}
