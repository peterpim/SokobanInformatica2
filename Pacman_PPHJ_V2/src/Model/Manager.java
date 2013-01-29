package Model;

/**
 * @author Peter-Pim
 */
public class Manager {
    private GameRenderer gameRenderer;
            
    private boolean childMode = false;
    private boolean isPaused = false;
    private int currentLevel = 0;
    private int playerScore = 0;
    
    public Manager(GameRenderer gameRenderer) {
        this.gameRenderer = gameRenderer;
    }
    
    public void paint() {
        gameRenderer.getGameWindow().repaint();
    }
    
    public void incrementCurrentLevel() {
        if(currentLevel < 11) {
            currentLevel += 1;
        } else {
            currentLevel = 0;
        }
        gameRenderer.getMenuWindow().viewLevel(currentLevel);
    }
    
    public int getCurrentLevel() {
        return currentLevel;
    }
    
    public void resetCurrentLevel() {
        currentLevel = 0;
        gameRenderer.getMenuWindow().viewLevel(currentLevel);
    }
    
    public void incrementPlayerScore() {
        playerScore += 1;
        gameRenderer.getMenuWindow().viewScore(playerScore);
    }
    
    public int getPlayerScore() {
        return playerScore;
    }
    
    public void resetPlayerScore() {
        playerScore = 0;
        gameRenderer.getMenuWindow().viewScore(playerScore);
    }
    
    public void setChildmode() {
        if(childMode == false) {
            childMode = true;
        } else {
            childMode = false;
        }
    }
    
    public boolean getChildmode() {
        return childMode;
    }
    
    public void setPaused() {
        if(isPaused) {
            isPaused = false;
        } else {
            isPaused = true;
        }
    }
    
    public boolean getPaused() {
        return isPaused;
    }
    
    public void gameEnd(int result) {
        switch(result) {
            case 1: resetCurrentLevel(); gameRenderer.reset(); break;
            case 2: gameRenderer.reset(); break;
            case 3: incrementCurrentLevel(); gameRenderer.reset();break;
            case 4: break;
            case 5: break;
            default: throw new IllegalArgumentException("Manager: could not end " +
                    "game.");
        }  
    }
}