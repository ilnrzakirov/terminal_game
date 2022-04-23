package Game;

public class Game {

    private Integer enemiesCount;
    private Integer wallsCount;
    private Integer mapSize;
    private String  profile;
    private static final String IL_ARGUMENT = "IllegalParametersException";

    public Game(Integer enemiesCount, Integer wallsCount, Integer mapSize, String profile){
        setMapSize(mapSize);
        setWallsCount(wallsCount, enemiesCount);
        setEnemiesCount(enemiesCount);
    }

    public void setEnemiesCount(Integer enemiesCount) {
        if (enemiesCount <= 0 || enemiesCount > ((this.mapSize * this.mapSize) - enemiesCount - this.wallsCount) / 2){
            System.err.println(IL_ARGUMENT);
            System.exit(-1);
        }
        this.enemiesCount = enemiesCount;
    }

    public void setMapSize(Integer mapSize) {
        if (mapSize < 5){
            System.err.println(IL_ARGUMENT);
            System.exit(-1);
        }
        this.mapSize = mapSize;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setWallsCount(Integer wallsCount, Integer enemiesCount) {
        if (wallsCount < 0 || wallsCount > ((this.mapSize * this.mapSize) - enemiesCount - wallsCount) / 2 ){
            System.err.println(IL_ARGUMENT);
            System.exit(-1);
        }
        this.wallsCount = wallsCount;
    }
}
