// I will try to complete this project in less than 100 lines, so all classes will be in one file
// so I can better track how many lines of code there are
// *Note* I was able to get the code to work in 98 lines, but I am going to format the
// file now since I will attempt to write a method that will generate random mazes
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MinesOfMoria {
    public enum Cell { // enum to represent different cell types in the maze
        WALL, PATH, TRACK // wall represented by 0, path by 1, and track by 2
    }
    private Cell[][] maze;
    // = {
    //     {Cell.PATH, Cell.WALL, Cell.PATH, Cell.PATH, Cell.PATH},
    //     {Cell.PATH, Cell.WALL, Cell.PATH, Cell.WALL, Cell.PATH},
    //     {Cell.PATH, Cell.PATH, Cell.PATH, Cell.WALL, Cell.PATH},
    //     {Cell.WALL, Cell.WALL, Cell.WALL, Cell.PATH, Cell.PATH},
    //     {Cell.PATH, Cell.PATH, Cell.PATH, Cell.PATH, Cell.PATH},
    // };
    // constructor to generate a random maze
    public MinesOfMoria(int rows, int cols) {
        generateMaze(rows, cols);
    }
    // method to generate a random maze with a valid path
    private void generateMaze(int rows, int cols) {
        maze = new Cell[rows][cols];
        Random rand = new Random();

        // first initialize the maze as walls
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = Cell.WALL;
            }
        }
        // make sure a valid path exists by freeing up a diagonal path
        int x = 0, y = 0;
        maze[x][y] = Cell.PATH;
        while (x < rows - 1 || y < cols - 1) {
            if (x == rows - 1) {
                // if at the bottom, move right
                y++;
            } else if (y == cols - 1) {
                // if at last col, move down
                x++;
            } else if (rand.nextBoolean()) {
                // decide wheter to move right or down
                x++;
            } else {
                y++;
            }
            // mark the cell as a path
            maze[x][y] = Cell.PATH;
        }
        // add more paths and walls randomly
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[x][y] == Cell.WALL && rand.nextInt(100) < 30) {
                    // 30% chance that a wall will become a path
                    maze[i][j] = Cell.PATH;
                }
            }
        }    
    }
    //Recursive method to find the path from (x, y) to the exit
    public boolean findPath(int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] == Cell.WALL || maze[x][y] == Cell.TRACK) {
            return false;
        }
        // if bottom right corner is reached, mark it and return true
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            maze[x][y] = Cell.TRACK;
            return true;
        }
        // mark current cell as part of the path
        maze[x][y] = Cell.TRACK;
        // recursively move in all 4 directions (up, down, left, right)
        if (findPath(x + 1, y) || findPath(x - 1, y) || findPath(x, y + 1) || findPath(x, y - 1)) {
            return true;
        }
        // backtrack if no path is found
        maze[x][y] = Cell.PATH; // this will unmark the cell
        return false;
    }
    // print the maze to the console
    public void printMaze() {
        for (Cell[] row : maze) {
            for (Cell cell : row) {
                System.out.print((cell == Cell.WALL ? "0" : (cell == Cell.PATH ? "1" : "2")) + " ");
            }
            System.out.println(); // print a new line for each row
        }
    }
    // make a getMaze method for the GUI
    public Cell[][] getMaze() {
        return maze;
    }
}
class MazeSolver {
    public static void main(String[] args) {
        // initialize the # of rows and cols in generated maze
        int rows = 10;
        int cols = 10;
        MinesOfMoria moria = new MinesOfMoria(rows, cols);
        System.out.println("Generated Maze:");
        moria.printMaze();
        if (moria.findPath(0, 0)) {
            System.out.println("\nPath found:");
            moria.printMaze();
        } else {
            System.out.println("\nNo path found.");
        }
        // create GUI
        JFrame frame = new JFrame("Mines of Moria Maze Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MazePanel mazePanel = new MazePanel(moria);
        frame.add(mazePanel);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
// make a JPanel subclass
class MazePanel extends JPanel {
    private final MinesOfMoria moria;
    // set size of each cell
    private final int cellSize = 50;
    public MazePanel(MinesOfMoria moria) {
        this.moria = moria;
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        MinesOfMoria.Cell[][] maze = moria.getMaze();
        for (int x = 0; x < maze.length; x++) {
            for (int y = 0; y < maze[x].length; y++) {
                if (maze[x][y] == MinesOfMoria.Cell.WALL) {
                    graphics.setColor(Color.BLACK);
                } else if (maze[x][y] == MinesOfMoria.Cell.TRACK) {
                    graphics.setColor(Color.GREEN);
                } else {
                    graphics.setColor(Color.BLUE);
                }
                graphics.fillRect(y * cellSize, x * cellSize, cellSize, cellSize);
                graphics.setColor(Color.GRAY);
                graphics.drawRect(y * cellSize, x * cellSize, cellSize, cellSize);
            }
        }
    }
}