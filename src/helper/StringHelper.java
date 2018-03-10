package helper;

/**
 *  StringHelper permet de comme son nom l'indique d'aider sur l'object String
 */
public class StringHelper {

    /**
     * Permet de convertir une chaine de caractere du format "ISO-8859-15" en UTF-8
     * @method convertFromUTF8
     * @param s de type String
     * @return String
     */
    public static String convertFromUTF8(String s) {
        String out = null;
        try {
            out = new String(s.getBytes("ISO-8859-15"), "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return out;
    }

    /**
     * Permet de convertir une chaine de caractere du format UTF-8 en "ISO-8859-15"
     * @method convertFromUTF8
     * @param s de type String
     * @return String
     */
    public static String convertToUTF8(String s) {
        String out = null;
        try {
            out = new String(s.getBytes("UTF-8"), "ISO-8859-1");
        } catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return out;
    }
}
