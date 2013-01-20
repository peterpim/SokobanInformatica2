
package Model;

import Object.Box;
import Object.Monster;
import Object.Player;
import Object.Wall;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Peter-Pim
 */
public class FindPath {
    public Direction findPath(Player source, Monster monster) {
        try {
            HashMap<Position, Direction> newPositions = new HashMap<Position, Direction>();
            ArrayList<Position> visited = new ArrayList<Position>();

            Position targetPos = source.getPosition();
            visited.add(monster.getPosition());
            boolean bool = true;

            while(bool)
            {
                for(int i = 0; i < visited.size(); i++) {
                    Position currentPos = visited.get(i);
                    for (Direction d: Direction.values()) {
                        Position neighbourPos = currentPos.getNeighbour(d);
                        if((currentPos.getNeighbour(d) != null && !(currentPos.getNeighbour(d).getObject() instanceof Wall) &&
                                !(currentPos.getNeighbour(d).getObject() instanceof Box))) {
                            if(!newPositions.containsKey(neighbourPos)) {
                                if(!(neighbourPos.getObject() instanceof Player)) {
                                    visited.add(neighbourPos);
                                    newPositions.put(neighbourPos, d);
                                    if(visited.size() > 100) {
                                        return d;
                                    }
                                }
                                else {
                                    return d;
                                }
                            }
                            //  System.out.println(neighbourPos.getPosX() + " " + neighbourPos.getPosY()); 
                            //  Gebruikt om op te sporen welke posities de methode bezocht.
                        }
                    }
                }
            }
            return newPositions.get(targetPos);
        } catch(Exception e) { e.printStackTrace(); }
        return null;
    }
}
