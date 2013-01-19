package Model;

/**
 * @author Peter-Pim
 */
public enum Direction {
    NORTH, WEST, SOUTH, EAST;
    
    public Direction getOpposite() {
        switch(this) {
                case NORTH: return SOUTH;
                case WEST: return EAST;
                case SOUTH: return NORTH;
                case EAST: return WEST;
                default: throw new IllegalArgumentException("Direction has not opposite " + this);
        }
    }
}