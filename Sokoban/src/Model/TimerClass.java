
package Model;

import Object.Monster;
import View.GameWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Peter-Pim
 */
public class TimerClass implements ActionListener {
    Monster monster;
    /*
     * Create a new pathFinder for this object.
     */
    FindPath pathFinder = new FindPath();
    GameWindow gameWindow;
    
    /*
     * Constuctor of TimerClass.
     * @param monster The monster this object belongs to.
     * @param gameWindow The gamewindow this object uses.
     */
    public TimerClass(Monster monster, GameWindow gameWindow) {
        this.monster = monster;
        this.gameWindow = gameWindow;
    }
       
    /*
     * @param e The event that is to be performed, in this case, each 1000 miliseconds
     * do execute this method.
     * Move the Monster object of the TimerClass in the direction that is returned
     * from the findPath method in FindPath.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            monster.move(pathFinder.findPath(gameWindow.getPlayer(0), monster));
        } catch(Exception exc) { exc.printStackTrace(); }
    }
    
    // Oude code, word waarschijnlijk niet meer gebruikt.
    /*
    public void changeDirection(int value) {
        switch(value) {
                case 0: dir = Direction.NORTH; break;
                case 1: dir = Direction.WEST; break;
                case 2: dir = Direction.SOUTH; break;
                case 3: dir = Direction.EAST; break;
            }
    }
    
    Random random = new Random();
    int dirInt = random.nextInt(4);
    if(!monster.move(dir)) {
    if(!monster.move(dir)) {
        actionPerformed(e);
    }
    }
        */
}