package Game;

public class Program {

    private static final String BAD_ARGUMENT = "Error: bad argument";
    private static final String ENEMIES = "--enemiesCount=";
    private static final String WALLS = "--wallsCount=";
    private static final String SIZE = "--size=";
    private static final String PROFILE = "--profile=";

    public static void main(String[] args) {
        if (args.length != 4 || !args[0].startsWith(ENEMIES) || !args[1].startsWith(WALLS)
                || args[2].startsWith(SIZE) || args[3].startsWith(PROFILE)){
            System.err.println(BAD_ARGUMENT);
            System.exit(-1);
        }
    }
}
