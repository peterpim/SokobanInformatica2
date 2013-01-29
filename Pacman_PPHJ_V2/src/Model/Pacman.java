package Model;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Peter-Pim
 */
public class Pacman extends JFrame {
    // static attribute as it belongs to the class itself, not the object.
    private static Pacman pacman;
    
    private GameRenderer gameRenderer;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        pacman = new Pacman();
    }
    
    private Pacman() {
        try { 
            initialize();
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    private void initialize() {
        try {
            gameRenderer = new GameRenderer();
            gameRenderer.initPositions();
            gameRenderer.initWorld();
        } catch(Exception e) { e.printStackTrace(); }
    }
}
