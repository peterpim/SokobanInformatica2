
package Model;

import Object.Box;
import Object.GameObject;
import Object.Player;
import Object.Wall;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Peter-Pim
 */
public class PathFind {
    public Direction findPathRecursive(Position position) {
        try {
            HashMap<Position, Direction> newPositions = new HashMap<Position, Direction>();
            ArrayList<Position> visited = new ArrayList<Position>();

            visited.add(position);
            
            for(int i = 0; i < visited.size(); i++) {
                Position currentPos = visited.get(i);
                for (Direction d: Direction.values()) {
                    Position neighbourPos = currentPos.getNeighbour(d);
                    if((currentPos.getNeighbour(d) != null && !(currentPos.getNeighbour(d).getObject() instanceof Wall) &&
                        !(currentPos.getNeighbour(d).getObject() instanceof Box))) {
                        if(!newPositions.containsKey(neighbourPos)) {
                            GameObject obj = neighbourPos.getObject();
                            if(!(obj instanceof Player)) {
                                visited.add(neighbourPos);
                                newPositions.put(neighbourPos, d);
                                if(visited.size() > 100) {
                                    if(!(obj instanceof Wall) && !(obj instanceof Box)) {
                                        return d;
                                    }
                                }
                            }
                            else {
                                if(!(obj instanceof Wall) && !(obj instanceof Box)) {
                                    return d;
                                }
                            }
                        }
                    }
                }
            }
            newPositions.clear();
        } catch(Exception e) { e.printStackTrace(); }
        System.out.println("none");
        return Direction.NONE;
    }
}