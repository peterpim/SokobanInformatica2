
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
    
    public void incrementCurrentLevel() {
        if(currentLevel < 11) {
            currentLevel += 1;
        } else {
            currentLevel = 0;
        }
    }
    
    public int getCurrentLevel() {
        return currentLevel;
    }
    
    public void resetCurrentLevel() {
        currentLevel = 0;
    }
    
    public void incrementPlayerScore() {
        playerScore += 1;
    }
    
    public int getPlayerScore() {
        return playerScore;
    }
    
    public void resetPlayerScore() {
        playerScore = 0;
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
    
    public void gameEnd(boolean result) {
        if(result) {
            incrementCurrentLevel();

        } else {

        }     
    }
    
    public void doPaint() {
        gameRenderer.getGameWindow().repaint();
    }
}