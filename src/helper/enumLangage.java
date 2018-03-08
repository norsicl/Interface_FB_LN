package helper;

public enum enumLangage {
    //Objets directement construits
    EN_US("en", "US"),
    FR_FR("fr", "FR"),
    EN_UK("en", "UK");

    private String language;
    private String country;

    //Constructeur
    enumLangage(String language, String country){
        this.language = language;
        this.country = country;
    }

    public String getLanguage(){
        return language;
    }

    public String getCountry(){
        return country;
    }

    public String toString(){
        return getLanguage() + "_" + getCountry();
    }

    public static String getLanguageByCountry(String Country){
        for(enumLangage row : enumLangage.values()){
            if(row.getCountry() == Country) {
                return row.getLanguage();
            }
        }
        return null;
    }
}