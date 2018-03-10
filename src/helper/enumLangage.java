package helper;

/**
 * enumLangage permet de choisir plus facilement la langue pour la traduction
 * todo: plus du tout utile car une classe équivalente existe en JAVA par défaut
 */
public enum enumLangage {
    //Objets directement construits
    EN_US("en", "US"),
    FR_FR("fr", "FR"),
    EN_UK("en", "UK");

    /**
     * language de type String
     */
    private String language;
    /**
     * country de type String
     */
    private String country;

    /**
     * Constructeur
     * @method enumLangage
     * @param language de type String
     * @param country de type String
     */
    enumLangage(String language, String country){
        this.language = language;
        this.country = country;
    }

    /**
     * Retourne la langue
     * @method getLanguage
     * @return String
     */
    public String getLanguage(){
        return language;
    }

    /**
     * Retourne le pays
     * @method getCountry
     * @return String
     */
    public String getCountry(){
        return country;
    }

    /**
     * @method toString
     * @return String
     */
    public String toString(){
        return getLanguage() + "_" + getCountry();
    }

    /**
     * Permet de récupérer le pays par rapport au language
     * @method getLanguageByCountry
     * @param Country de type String
     * @return String
     */
    public static String getLanguageByCountry(String Country){
        for(enumLangage row : enumLangage.values()){
            if(row.getCountry().equals(Country)) {
                return row.getLanguage();
            }
        }
        return null;
    }
}