package mazeGenerator;

import java.util.Scanner;

public class MazeTester {

    private static Scanner keyboard;
    private static Maze testMaze;

    public static void main(String[] args) {
        keyboard = new Scanner(System.in);
        int w;
        int h;
        String answer;
//        int sx;
//        int sy;
//        int ex;
//        int ey;

        System.out.print("Enter the width of the maze: ");
        w = keyboard.nextInt();

        System.out.print("Enter the height of the maze: ");
        h = keyboard.nextInt();

        // Call method to create maze
        testMaze = new Maze(w, h);

        // Call method to show maze
        testMaze.showMaze();

        System.out.println("");
        System.out.print("Solve maze? (y/n): ");
        answer = keyboard.next();

        if (answer.equalsIgnoreCase("y")){

            // Call method to solve maze
            testMaze.solveMaze(1, 1, (w-1) * 2 + 1, (h-1) * 2 + 1, -1, -1);
            // Call method to show solved maze
            testMaze.showMaze();
        }

//        if(answer.equalsIgnoreCase("yes")) {
//            System.out.println("");
//            System.out.print("Enter the starting x-coordinate: ");
//            sx = keyboard.nextInt() - 1;
//            System.out.print("Enter the starting y-coordinate: ");
//            sy = keyboard.nextInt() - 1;
//            System.out.print("Enter the ending x-coordinate: ");
//            ex = keyboard.nextInt() - 1;
//            System.out.print("Enter the ending y-coordinate: ");
//            ey = keyboard.nextInt() - 1;
//            testMaze.solveMaze(sx * 2 + 1, sy * 2 + 1, ex * 2 + 1, ey * 2 + 1, -1, -1);
//            testMaze.showMaze();
//        }

    }
}
