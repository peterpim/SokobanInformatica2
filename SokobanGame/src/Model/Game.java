/*
 * Sokoban applicatie gemaakt door Peter-Pim Baken, all rights reserved.
 * Japanese simplistic puzzelgame, enjoy.
 */

package Model;
import View.MenuWindow;
import View.GameWindow;
import View.InstructionWindow;
import View.ScoreWindow;
import java.awt.BorderLayout;
import javax.swing.JFrame;
/**
 *
 * @author Peter-Pim Baken
 */
public class Game extends JFrame {
    private static Game game;
    private Maze maze;
    private GameWindow window = new GameWindow();
    private ScoreWindow scoreWindow = new ScoreWindow();
    private InstructionWindow instructionWindow = new InstructionWindow();
    private static MenuWindow menuWindow = new MenuWindow();

    private final int BOARD_HEIGHT = 680;
    private final int BOARD_WIDTH = 800;
    private boolean childmode = false;

    public static void main(String[] args) {
        game = new Game();
        menuWindow.setGame(game);
    }

    /**
     * Instantiates the menuWindow in MenuWindow and calls methods
     */
    public Game() {
        menuWindow.setScoreWindow(scoreWindow);
        menuWindow.setInstructionWindow(instructionWindow);
        scoreWindow.setMenuWindow(menuWindow);
        instructionWindow.setMenuWindow(menuWindow);
        maze = new Maze();
        buildMenu();
        buildInstructions();
    }

    /**
     * Creates the instructions panel
     */
    public void buildInstructions() {
        add(instructionWindow, BorderLayout.CENTER);
        instructionWindow.setMenuWindow(menuWindow);
        setSize(getBoardWidth(), getBoardHeight());
        setLocationRelativeTo(null);
        setTitle("Sokoban Instructions");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
    * Builds the main menu and makes it visible
    */
    public void buildMenu() {
        add(menuWindow, BorderLayout.CENTER);
        menuWindow.setMaze(maze);
        setSize(getBoardWidth(), getBoardHeight());
        setLocationRelativeTo(null);
        setTitle("Sokoban Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Creates the board on which the game'll be played
     */
    public void buildBoard() {
        add(window, BorderLayout.CENTER);
        add(scoreWindow, BorderLayout.SOUTH);
        window.setMaze(maze);
        window.setScoreWindow(scoreWindow);
        maze.setGameWindow(window);
        maze.setGame(game);
        setSize(getBoardWidth(), getBoardHeight());
        setLocationRelativeTo(null);
        setTitle("Sokoban");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Set the focus in the GameWindow panel
     */
    public void setWindowFocus() {
        window.setVisible(true);
        window.requestFocus();
    }

    public boolean getChildMode() {
        return childmode;
    }

    /**
     * @return boardHeight Retrieve the height of the playboard
     */
    public int getBoardHeight() {
        return BOARD_HEIGHT;
    }

    /**
     * @return boardWidth Retrieve the width of the playboard
     */
    public int getBoardWidth() {
        return BOARD_WIDTH;
    }

    /**
     * Enable or disable the childmode
     */
    public void setChildmode() {
        if(childmode == false) {
            childmode = true;
        } else
            childmode = false;
    }
}
