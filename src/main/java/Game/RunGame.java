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
            String s = scanner.nextLine();

            if (s.equals("9")) {
                break;
            }

            if (s.equals("1")) {
                move.up();
            } else if (s.equals("2")) {
                move.down();
            } else if (s.equals("3")) {
                move.left();
            } else if (s.equals("4")) {
                move.right();
            } else {
                System.out.println("haha");
            }

            chaseLogic.move();

            if (profile.equals("dev")) {
                while (!scanner.nextLine().equals("8")) {
                    System.out.println("Accept enemy move by entering 8");
                }
            }

            printMatrix(coloredPrinter);
        }
    }

    private void printMatrix(ColoredPrinter coloredPrinter) {
        for (int y = 0; y < size + 2; y++) {
            for (int x = 0; x < size + 2; x++) {
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
                coloredPrinter.print(matrix[y][x]);
            }
            System.out.println();
        }
    }
}