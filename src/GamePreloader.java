/**
 *
 *
 *  @author Kenny Peng
 *  @version 12/1/2018
 */

/**
 * initializes a game object that serves as the main game
 * calls the play method from game class starting main game loop
 */
public class GamePreloader {
    public static void main(String[] args){
        BattleshipGame singlePlayer = new BattleshipGame();
        singlePlayer.play();
    }
}
