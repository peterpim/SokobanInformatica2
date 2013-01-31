package Object;

import Model.Direction;
import Model.Manager;
import Model.PathFind;
import Model.Position;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * @author Peter-Pim
 */
public class Monster extends GameObject implements ActionListener {
    PathFind pathFinder;
    
    public Monster(Color color, Position position, Manager manager) {
        super(color, position, manager);
        pathFinder = new PathFind();
        Timer timer = new Timer(1000, this);
        timer.start();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(position.getX(), position.getY(), 40, 40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Direction d = pathFinder.findPathRecursive(position);
        if(d == Direction.NONE) {
            manager.gameEnd(5);
        } else if(this.position.getNeighbour(d).getObject() instanceof Player) {
            manager.gameEnd(4);
        }
        move(d);
    }
}