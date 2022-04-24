package Game;

import ChaseLogic.ChaseLogic;
import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

import java.util.Scanner;

public class RunGame {

    private char[][] matrix;
    private Map map;
    private Integer size;
    private String profile;
    private static final String UP = "1";
    private static final String DOWN = "2";
    private static final String LEFT = "3";
    private static final String RIGHT = "4";
    private static final String HELP = "5";
    private static final String EXIT = "9";
    private static final String CONFIRM = "8";
    private static final String HELP_TEXT = "1 - up; 2 - down, 3 - left, 4 - right, 9 - exit";
    private static final String ACCEPT_TEXT = "Confirm the actions bu entry 8";
    private static final String DEV = "dev";
    private static final String COLOR_NOT_FOUND = "Color not found";
    private static final String YOUR_MOVE = "Your move, press 5 for help, press 9 for exit";

    public RunGame(char[][] matrix, Map map, Integer size, String profile) {
        this.matrix = matrix;
        this.map = map;
        this.size = size;
        this.profile = profile;
    }

    public void run() {
        ColoredPrinter coloredPrinter = new ColoredPrinter
                .Builder(1, false)
                .foreground(Ansi.FColor.BLACK)
                .build();
        printMatrix(coloredPrinter);

        Scanner scanner = new Scanner(System.in);
        Move move = new Move(matrix, size, map);
        ChaseLogic chaseLogic = new ChaseLogic(matrix, size, map);

        while (true) {
            System.out.println(YOUR_MOVE);
            String s = scanner.nextLine();

            if (s.equals(EXIT)) {
                break;
            }

            if (s.equals(UP)) {
                move.up();
            } else if (s.equals(DOWN)) {
                move.down();
            } else if (s.equals(LEFT)) {
                move.left();
            } else if (s.equals(RIGHT)) {
                move.right();
            } else if (s.equals(HELP)) {
                System.out.println(HELP_TEXT);
                continue;
            } else {
                System.out.println(HELP_TEXT);
                continue;
            }

            if (profile.equals(DEV)){
                printMatrix(coloredPrinter);
                System.out.println();
            };

            chaseLogic.move();
            printMatrix(coloredPrinter);

            if (profile.equals(DEV)) {
                System.out.println(ACCEPT_TEXT);
                while (!scanner.nextLine().equals(CONFIRM)) {
                    System.out.println(ACCEPT_TEXT);
                }
            }
        }
    }

    private void printMatrix(ColoredPrinter coloredPrinter) {
        try {
            Ansi.BColor.valueOf(map.getEmptyColor());
            Ansi.BColor.valueOf(map.getPlayerColor());
            Ansi.BColor.valueOf(map.getGoalColor());
            Ansi.BColor.valueOf(map.getWallColor());
            Ansi.BColor.valueOf(map.getEnemyColor());
        } catch (IllegalArgumentException error) {
            System.err.println(COLOR_NOT_FOUND);
            System.exit(-1);
        }
        for (int y = 1; y < size + 1; y++) {
            for (int x = 1; x < size + 1; x++) {
                try {
                    if (matrix[y][x] == map.getEmptyChar()) {
                        coloredPrinter.setBackgroundColor(Ansi.BColor.valueOf(map.getEmptyColor()));
                    } else if (matrix[y][x] == map.getPlayerChar()) {
                        coloredPrinter.setBackgroundColor(Ansi.BColor.valueOf(map.getPlayerColor()));
                    } else if (matrix[y][x] == map.getGoalChar()) {
                        coloredPrinter.setBackgroundColor(Ansi.BColor.valueOf(map.getGoalColor()));
                    } else if (matrix[y][x] == map.getWallChar()) {
                        coloredPrinter.setBackgroundColor(Ansi.BColor.valueOf(map.getWallColor()));
                    } else if (matrix[y][x] == map.getEnemyChar()) {
                        coloredPrinter.setBackgroundColor(Ansi.BColor.valueOf(map.getEnemyColor()));
                    }
                } catch (IllegalArgumentException error) {
                    System.err.println(COLOR_NOT_FOUND);
                    System.exit(-1);
                }
                coloredPrinter.print(matrix[y][x]);
            }
            System.out.println();
        }
    }
}