package Game;


import java.awt.*;
import java.util.Properties;

public class Map {

    private Properties properties;
    private static final String ERROR = "Properties error";
    private char emptyChar;
    private char playerChar;
    private char wallChar;
    private char goalChar;
    private char enemyChar;
    private Color enemyColor;
    private Color emptyColor;
    private Color playerColor;
    private Color goalColor;
    private Color wallColor;

    public Map(Properties properties){
        this.properties = properties;
        validationProperties(properties);
    }

    private void validationProperties(Properties properties) {
        setEmptyChar(properties.getProperty("empty.char"));
        setEnemyChar(properties.getProperty("enemy.char"));
    }

    public char getEmptyChar() {
        return emptyChar;
    }

    public char getPlayerChar() {
        return playerChar;
    }

    public char getWallChar() {
        return wallChar;
    }

    public char getGoalChar() {
        return goalChar;
    }

    public char getEnemyChar() {
        return enemyChar;
    }

    public Color getEnemyColor() {
        return enemyColor;
    }

    public Color getEmptyColor() {
        return emptyColor;
    }

    public Color getPlayerColor() {
        return playerColor;
    }

    public Color getGoalColor() {
        return goalColor;
    }

    public Color getWallColor() {
        return wallColor;
    }

    private void setEmptyChar(String emptyLine) {
        if (emptyLine.length() == 1){
            this.emptyChar = emptyLine.charAt(0);
        } else {
            System.err.println(ERROR);
            System.exit(-1);
        }
    }

    private void setPlayerChar(char playerChar) {
        this.playerChar = playerChar;
    }

    private void setWallChar(char wallChar) {
        this.wallChar = wallChar;
    }

    private void setGoalChar(char goalChar) {
        this.goalChar = goalChar;
    }

    private void setEnemyChar(String enemyLine) {
        if (enemyLine.length() == 1){
            this.enemyChar = enemyLine.charAt(0);
        } else {
            System.err.println(ERROR);
            System.exit(-1);
        }
    }

    private void setEnemyColor(Color enemyColor) {
        this.enemyColor = enemyColor;
    }

    private void setEmptyColor(Color emptyColor) {
        this.emptyColor = emptyColor;
    }

    private void setPlayerColor(Color playerColor) {
        this.playerColor = playerColor;
    }

    private void setGoalColor(Color goalColor) {
        this.goalColor = goalColor;
    }

    public void setWallColor(Color wallColor) {
        this.wallColor = wallColor;
    }
}
