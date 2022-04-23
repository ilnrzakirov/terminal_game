package Game;

public class Downlander {

    static private final String BASE_PATH = "src/main/resources/application-";
    static private final String PRODUCTION_PATH = "src/main/resources/application-production.properties";
    static private final String DEV_PATH = "src/main/resources/application-dev.properties";
    static private final String DEV = "dev";
    static private final String PRODUCTION = "production";
    static private final String PROPERTIES = ".properties";

    private String profile;
    private String propertiesPath;

    public Downlander(String profile){
        this.profile = profile;
        setPropertiePath(profile);
    }

    private void setPropertiePath(String profile){
        if (profile.equals(PRODUCTION)){
            this.propertiesPath = PRODUCTION_PATH;
        } else if (profile.equals(DEV)){
            this.propertiesPath = DEV_PATH;
        } else {
            this.propertiesPath = BASE_PATH + profile + PROPERTIES;
        }

    }
}
