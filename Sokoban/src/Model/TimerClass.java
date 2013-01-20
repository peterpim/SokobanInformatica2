
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
    FindPath pathFinder = new FindPath();
    GameWindow gameWindow;
    
    public TimerClass(Monster monster, GameWindow gameWindow) {
        this.monster = monster;
        this.gameWindow = gameWindow;
    }
    
    // This method could be removed later is it is not relevant to the project.
    /*
    public void changeDirection(int value) {
        switch(value) {
                case 0: dir = Direction.NORTH; break;
                case 1: dir = Direction.WEST; break;
                case 2: dir = Direction.SOUTH; break;
                case 3: dir = Direction.EAST; break;
            }
    }
    * */
    
    @Override
    public void actionPerformed(ActionEvent e) {
        monster.move(pathFinder.findPath(gameWindow.getPlayer(0), monster));
        /*
            Random random = new Random();
            int dirInt = random.nextInt(4);
            if(!monster.move(dir)) {
                if(!monster.move(dir)) {
                    actionPerformed(e);
                }
            }
        */
    }
}