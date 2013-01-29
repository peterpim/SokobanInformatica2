package Object;

import Model.Manager;
import Model.Position;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * @author Peter-Pim
 */
public abstract class GameObject extends JPanel {
    protected Color color;
    protected Position position;
    protected Manager manager;
    
    public GameObject(Color color, Position position, Manager manager) {
        this.color = color;
        this.position = position;
        this.manager = manager;
    }
    
    //public abstract void draw(Graphics g);
}