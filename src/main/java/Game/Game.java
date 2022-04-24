package Game;


public class Game {

    private Integer enemiesCount;
    private Integer wallsCount;
    private Integer mapSize;
    private String  profile;

    public Game(Integer enemiesCount, Integer wallsCount, Integer mapSize, String profile){
        setMapSize(mapSize);
        setWallsCount(wallsCount, enemiesCount);
        setEnemiesCount(enemiesCount);
        setProfile(profile);
    }

    public void setEnemiesCount(Integer enemiesCount) {
        if (enemiesCount <= 0 || enemiesCount > ((this.mapSize * this.mapSize) - enemiesCount - this.wallsCount) / 2){
            throw new IllegalParametersException("Illegal Parameters");
        }
        this.enemiesCount = enemiesCount;
    }

    public void setMapSize(Integer mapSize) {
        if (mapSize < 5 || mapSize > 100){
            throw new IllegalParametersException("Illegal Parameters");
        }
        this.mapSize = mapSize;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setWallsCount(Integer wallsCount, Integer enemiesCount) {
        if (wallsCount < 0 || wallsCount > ((this.mapSize * 4) - 7 - enemiesCount)  / 2 ){
            throw new IllegalParametersException("Illegal Parameters");
        }
        this.wallsCount = wallsCount;
    }

    public Integer getEnemiesCount() {
        return enemiesCount;
    }

    public Integer getWallsCount() {
        return wallsCount;
    }

    public Integer getMapSize() {
        return mapSize;
    }

    public String getProfile() {
        return profile;
    }
}
