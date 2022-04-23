package Game;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Downlander {

    static private final String BASE_PATH = "src/main/resources/application-";
    static private final String PRODUCTION_PATH = "src/main/resources/application-production.properties";
    static private final String DEV_PATH = "src/main/resources/application-dev.properties";
    static private final String DEV = "dev";
    static private final String PRODUCTION = "production";
    static private final String PROPERTIES = ".properties";
    static private final String FILE_NOT_FOUND = "File not found";

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

    public Properties getProperties(){
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(this.propertiesPath));
        } catch (IOException e) {
            System.err.println(FILE_NOT_FOUND);
            System.exit(-1);
        }

        return properties;
    }
}
