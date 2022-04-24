package Game;

import java.util.Properties;

public class Program {

    private static final String BAD_ARGUMENT = "Error: bad argument";
    private static final String ENEMIES = "--enemiesCount=";
    private static final String WALLS = "--wallsCount=";
    private static final String SIZE = "--size=";
    private static final String PROFILE = "--profile=";

    public static void main(String[] args) {
        if (args.length != 4 || !args[0].startsWith(ENEMIES) || !args[1].startsWith(WALLS)
                || !args[2].startsWith(SIZE) || !args[3].startsWith(PROFILE)){
            System.err.println(BAD_ARGUMENT);
            System.exit(-1);
        }

        String inputEnemiesCount = args[0].replaceAll(ENEMIES, "");
        String inputWallsCount = args[1].replaceAll(WALLS, "");
        String inputSize = args[2].replaceAll(SIZE, "");
        String inputProfile = args[3].replaceAll(PROFILE, "");
        Integer enemiesCount = 0;
        Integer wallsCount = 0;
        Integer mapSize = 0;


        try {
            enemiesCount = Integer.parseInt(inputEnemiesCount);
            wallsCount = Integer.parseInt(inputWallsCount);
            mapSize = Integer.parseInt(inputSize);
        } catch (NumberFormatException error){
            System.err.println(BAD_ARGUMENT);
            System.exit(-1);
        }

        Game game = new Game(enemiesCount, wallsCount, mapSize, inputProfile);
        Downlander downlander = new Downlander(inputProfile);
        Properties properties = downlander.getProperties();
        Map map = new Map(properties);
        MatrixInitializer matrixInitializer = new MatrixInitializer(map, enemiesCount, wallsCount,mapSize);
        char[][] matrix = matrixInitializer.init();


    }
}
