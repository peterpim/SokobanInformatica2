
package Model;

import Object.Box;
import Object.GameObject;
import Object.Monster;
import Object.Player;
import Object.Wall;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Peter-Pim
 */
public class FindPath {
    /*
    / Find the path to the target GameObject, then move to the closest Position to the target possible.
    / @Param GameObject source: The GameObject that is to be the target where to Monster moves to.
    / @Param int maxCost: The maximum distance between the Monster and Player objects for the method to return a Direction.
    / @return The first Direction it needs to go occuring to the path. 
    / If the path is longer then the macCost "null" will be returned.
    */
    /*
    public Direction findPath(Player source, int maxCost){
        HashMap<Position, Direction> newPositions = new HashMap<Position, Direction>();
	ArrayList<Position> currentPositions = new ArrayList<Position>();
	HashMap<Position, Direction> oldPositions = new HashMap<Position, Direction>();
		
	Position sourcePos = source.getPosition();
	currentPositions.add(sourcePos);
		
	for (int i = 0; i != maxCost && !currentPositions.isEmpty(); i++){
            for (Position position : currentPositions) {
                for (Direction d: Direction.values()) {
                    Position node = position.getNeighbour(d);
			
                    if(node != null){
			if(node.getObject() == null && !oldPositions.containsKey(node)){
                            newPositions.put(node, d);
                        //  If the target is found, call the method in Player isCatched().
			} else if(node.getObject() instanceof Player /*&& !((Player)node.getObject()).isCatched()){
                            if(oldPositions.isEmpty()) {
                                return(d);
                            }
                            Position destNode = node.getNeighbour(d.getOpposite());
                            Position nextNode = destNode.getNeighbour(oldPositions.get(destNode).getOpposite());
							
                            while(nextNode != source.getPosition()) {
                                destNode = nextNode;
                                nextNode = destNode.getNeighbour(oldPositions.get(destNode).getOpposite());
                            }
                            return oldPositions.get(destNode);
                        }
                    }
		}
            }
            oldPositions.putAll(newPositions);
            currentPositions.clear();
            currentPositions.addAll(newPositions.keySet());
            newPositions.clear();
        }
        return null;
    }
    */
    public Direction findPath(Player source, Monster monster) {
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
                        System.out.println(neighbourPos.getPosX() + " " + neighbourPos.getPosY());
                    }
                }
            }
        }
        return newPositions.get(targetPos);        
    }
    /*
    public Direction findPath(Player source, Monster monster){
	Direction result = findPathRecursive(source.getPosition(), monster.getPosition(), new ArrayList<Position>());
	if(result != null) return result;
	return null; //I don't know what you want to do if you don't find the player
}

private static Direction findPathRecursive(Position targetPos, Position currentPos, ArrayList<Position> visited){
	if(visited.contains(currentPos)) return null; //if it already checked this position, then it doesn't matter
	visited.add(currentPos);
	for (Direction d: Direction.values()) {
		Position neighbourPos = currentPos.getNeighbour(d);
		if(neighbourPos == null) continue;
		GameObject obj = neighbourPos.getObject();
		if((obj instanceof Wall) || (obj instanceof Box)) continue; //If its blocked, ignore this direction
		if(obj instanceof Player) return d; //If its the Player, its this direction
		Direction result = findPathRecursive(targetPos, neighbourPos, visited);
		if(result != null) return d; //If its different from null, it means that it eventually found the player in this direction, so its the direction we want
		if(visited.size() >= 100) return null; //Reached the limit, return null
	}
	return null;
}
* */
}
