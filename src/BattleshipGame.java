/**
 *
 *
 *  @author Kenny Peng
 *  @version 10/1/2018
 */
import java.util.*;

//A0 up A1 up A2 up A3 up A4 up
public class BattleshipGame {
    //the long list of boards, ships, etc
    private BoardState playerBoard;
    private BoardState aiBoard;
    private BoardState playerVison;
    private boolean win;
    private Scanner input;
    private Random random;
    private Carrier friendlyCarrier;
    private Battleship friendlyBattleship;
    private Cruiser friendlyCruiser;
    private Submarine friendlySubmarine;
    private Destroyer friendlyDestroyer;
    private Carrier enemyCarrier;
    private Battleship enemyBattleship;
    private Cruiser enemyCruiser;
    private Submarine enemySubmarine;
    private Destroyer enemyDestroyer;

    /**
     * Creates the main game object and initializes
     * the ships, utils, win condition, and boards
     */
    public BattleshipGame(){
        win = false;
        playerBoard = new BoardState(1);
        aiBoard = new BoardState(0);
        playerVison = new BoardState(0);
        input = new Scanner(System.in);
        random = new Random();
        friendlyDestroyer = new Destroyer();
        friendlySubmarine = new Submarine();
        friendlyCruiser = new Cruiser();
        friendlyBattleship = new Battleship();
        friendlyCarrier = new Carrier();
        enemyDestroyer = new Destroyer();
        enemySubmarine = new Submarine();
        enemyCruiser = new Cruiser();
        enemyBattleship = new Battleship();
        enemyCarrier = new Carrier();
    }

    /**
     * Runs main game loop
     * asks and places your ship and auto places the ai ships
     * Continues to swap turns until game won
     */

    public void play(){
        placeShips();
        placeAiShips();
        System.out.println();
        while(win != true) {
            yourMove();
            //stops game immediatly if you win first
            if(win){
                break;
            }
            aiMove();
        }
    }

    /**
     * your turn logic
     * asks for target selection and computes if you hit the target or missed
     * checks for win after each turn
     */
    public void yourMove(){
        System.out.println("Your Turn");
        System.out.println("Enemy Board");
        playerVison.showBoardState();
        System.out.println("Your move so take a shot, enter row then column");
        //collects first entry for target
        String coordsReceived = input.next();
        int targetY = coordsReceived.charAt(0);
        int targetX;
        //sets value to force repeat when no int found
        try {
            targetX = Integer.parseInt("" + coordsReceived.charAt(1));
        }
        catch (Exception e){
            targetX = -1;
        }
        //set to repeat if incorrect input
        while((targetY < 'A' || targetY > 'J') || (targetX < 0 || targetX > 9)){
            System.out.println("invalid input");
            coordsReceived = input.next();
            targetY = (coordsReceived.charAt(0));
            try {
                targetX = Integer.parseInt("" + coordsReceived.charAt(1));
            }
            catch (Exception e){
                targetX = -1;
            }
        }
        //actual computation for hit
        hit(targetX, targetY - 'A', aiBoard);
        //setting if won or not
        win = checkWin();
    }

    /**
     * ai turn logic
     * ai targets location on player's board based on certain conditions
     * checks if won at the end
     */
    public void aiMove(){
        System.out.println("Ai Turn");
        aiHit(playerBoard);
        win = checkWin();

    }

    /**
     * aks player to place their ships on their board
     * shows player's board at the end of each ship placement
     */
    public void placeShips(){
        boolean isAi = false;

        //loops handling placement of each ship stops when placed right
        while(friendlyCarrier.getPlaced() == false){
            System.out.println("place yor Carrier(5x1), direction y peg then x peg");
            //asks for input and checks if valid
            String coordsReceived = input.next();
            int y = coordsReceived.charAt(0);
            int x;
            //sets value to force repeat when no int found
            try {
                x = Integer.parseInt("" + coordsReceived.charAt(1));
            }
            catch (Exception e){
                x = -1;
            }
            //set to repeat if incorrect input
            while((y < 'A' || y > 'J') || (x < 0 || x > 9)){
                System.out.println("invalid input");
                coordsReceived = input.next();
                y = (coordsReceived.charAt(0));
                try {
                    x = Integer.parseInt("" + coordsReceived.charAt(1));
                }
                catch (Exception e){
                    x = -1;
                }
            }
            //selection for ship direction when placed
            System.out.println("Choose Direction: up, down ,right, or left");
            String direction = input.next();
            System.out.println();
            friendlyCarrier.place(direction, x,y - 'A', playerBoard, isAi);
            playerBoard.showBoardState();
        }

        while(friendlyBattleship.getPlaced() == false){
            System.out.println("place yor Battleship(4x1), direction y peg then x peg");
            String coordsReceived = input.next();
            int y = coordsReceived.charAt(0);
            int x;
            //sets value to force repeat when no int found
            try {
                x = Integer.parseInt("" + coordsReceived.charAt(1));
            }
            catch (Exception e){
                x = -1;
            }
            //set to repeat if incorrect input
            while((y < 'A' || y > 'J') || (x < 0 || x > 9)){
                System.out.println("invalid input");
                coordsReceived = input.next();
                y = (coordsReceived.charAt(0));
                try {
                    x = Integer.parseInt("" + coordsReceived.charAt(1));
                }
                catch (Exception e){
                    x = -1;
                }
            }
            System.out.println("Choose Direction: up, down ,right, or left");
            String direction = input.next();
            System.out.println();
            friendlyBattleship.place(direction, x,y - 'A', playerBoard,isAi);
            playerBoard.showBoardState();
        }

        while(friendlyCruiser.getPlaced() == false){
            System.out.println("place yor Cruiser(3x1), direction y peg then x peg");
            String coordsReceived = input.next();
            int y = coordsReceived.charAt(0);
            int x;
            //sets value to force repeat when no int found
            try {
                x = Integer.parseInt("" + coordsReceived.charAt(1));
            }
            catch (Exception e){
                x = -1;
            }
            //set to repeat if incorrect input
            while((y < 'A' || y > 'J') || (x < 0 || x > 9)){
                System.out.println("invalid input");
                coordsReceived = input.next();
                y = (coordsReceived.charAt(0));
                try {
                    x = Integer.parseInt("" + coordsReceived.charAt(1));
                }
                catch (Exception e){
                    x = -1;
                }
            }
            System.out.println("Choose Direction: up, down ,right, or left");
            String direction = input.next();
            System.out.println();
            friendlyCruiser.place(direction, x,y - 'A', playerBoard,isAi);
            playerBoard.showBoardState();
        }

        while(friendlySubmarine.getPlaced() == false){
            System.out.println("place yor Submarine(3x1), direction y peg then x peg");
            String coordsReceived = input.next();
            int y = coordsReceived.charAt(0);
            int x;
            //sets value to force repeat when no int found
            try {
                x = Integer.parseInt("" + coordsReceived.charAt(1));
            }
            catch (Exception e){
                x = -1;
            }
            //set to repeat if incorrect input
            while((y < 'A' || y > 'J') || (x < 0 || x > 9)){
                System.out.println("invalid input");
                coordsReceived = input.next();
                y = (coordsReceived.charAt(0));
                try {
                    x = Integer.parseInt("" + coordsReceived.charAt(1));
                }
                catch (Exception e){
                    x = -1;
                }
            }
            System.out.println("Choose Direction: up, down ,right, or left");
            String direction = input.next();
            System.out.println();
            friendlySubmarine.place(direction, x,y - 'A', playerBoard,isAi);
            playerBoard.showBoardState();
        }

        while(friendlyDestroyer.getPlaced() == false){
            System.out.println("place yor Destroyer(2x1), direction y peg then x peg");
            String coordsReceived = input.next();
            int y = coordsReceived.charAt(0);
            int x;
            //sets value to force repeat when no int found
            try {
                x = Integer.parseInt("" + coordsReceived.charAt(1));
            }
            catch (Exception e){
                x = -1;
            }
            //set to repeat if incorrect input
            while((y < 'A' || y > 'J') || (x < 0 || x > 9)){
                System.out.println("invalid input");
                coordsReceived = input.next();
                y = (coordsReceived.charAt(0));
                try {
                    x = Integer.parseInt("" + coordsReceived.charAt(1));
                }
                catch (Exception e){
                    x = -1;
                }
            }
            System.out.println("Choose Direction: up, down ,right, or left");
            String direction = input.next();
            System.out.println();
            friendlyDestroyer.place(direction, x,y - 'A', playerBoard,isAi);
            playerBoard.showBoardState();
        }

    }

    /**
     * places AI Ships recursively
     */
    public void placeAiShips(){
        boolean isAi = true;
        enemyCarrier.placeAi(aiShipDirectionChoice(), aiBoard, isAi);
        enemyBattleship.placeAi(aiShipDirectionChoice(), aiBoard, isAi);
        enemyCruiser.placeAi(aiShipDirectionChoice(), aiBoard, isAi);
        enemySubmarine.placeAi(aiShipDirectionChoice(), aiBoard, isAi);
        enemyDestroyer.placeAi(aiShipDirectionChoice(), aiBoard, isAi);
    }

    /**
     * checks for hit and misses on enemy ships
     * hit area marked with X, miss is marked with *
     * when hit, ships are checked for which is hit, then hit ship loses one hull
     * @param hitX player target X for missles
     * @param hitY player target Y for missles
     * @param boardNow board containing targets
     */
    public void hit(int hitX, int hitY,BoardState boardNow){
        //when hit, swap area to X and remove from ship hulls
        if(boardNow.getBoardState()[hitY][hitX] == '+'){
            System.out.println("Ding! Hit!");
            boardNow.getBoardState()[hitY][hitX] = 'X';
            playerVison.getBoardState()[hitY][hitX] = 'X';
            enemyCarrier.checkHullDamage(hitX, hitY);
            enemyBattleship.checkHullDamage(hitX, hitY);
            enemyCruiser.checkHullDamage(hitX, hitY);
            enemySubmarine.checkHullDamage(hitX, hitY);
            enemyDestroyer.checkHullDamage(hitX, hitY);

        }
        //No ship found, then miss
        else if(boardNow.getBoardState()[hitY][hitX] == 'O'){
                System.out.println("Splash! Missed");
                boardNow.getBoardState()[hitY][hitX] = '*';
                playerVison.getBoardState()[hitY][hitX] = '*';

        }

        //when you hit the same spot fo some reason
        else{
            System.out.println("You hit the same spot again, so obviously nothing happens");
            System.out.println("splash");
        }
        playerVison.showBoardState();
    }

    /**
     * Similar to hit, but made for ai and has a visual element to signify end battle phase
     * random targeting for hits within Player's board
     * updates player's board after each shot
     *
     * @param boardNow player's current board as the target
     */
    public void aiHit(BoardState boardNow){
        //random targets
        int hitX = random.nextInt(10);
        int hitY = random.nextInt(10);
        if(boardNow.getBoardState()[hitY][hitX] == '+'){
            System.out.println("Ding! Hit!");
            //visual seperators
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Your Board");
            boardNow.getBoardState()[hitY][hitX] = 'X';
            friendlyCarrier.checkHullDamage(hitX, hitY);
            friendlyBattleship.checkHullDamage(hitX, hitY);
            friendlyCruiser.checkHullDamage(hitX, hitY);
            friendlySubmarine.checkHullDamage(hitX, hitY);
            friendlyDestroyer.checkHullDamage(hitX, hitY);

        }
        //logic for a miss
        else if(boardNow.getBoardState()[hitY][hitX] == 'O'){
            System.out.println("Splash! Missed");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Your Board");
            boardNow.getBoardState()[hitY][hitX] = '*';
        }
        //show updated player's board at end of turn
        boardNow.showBoardState();
    }


    /**
     * determines ai choice for direction when placing ships
     * @return direction of ship placement for ai
     */
    public String aiShipDirectionChoice(){
        //random selection of direction
        int direction = random.nextInt(4);
        if(direction == 0){
            return "up";
        }
        else if(direction == 1){
            return "right";
        }
        else if(direction == 2){
            return "down";
        }
        else if (direction == 3){
            return "left";
        }
        //should never be reached
        else{
            System.out.print("AI DIRECTIOM CHOICE ERROR, DEFAULTED TO UP");
            return "up";
        }
    }

    /**
     * checks if either player or ai has won the game
     * @return true if won, false if not
     */

    public boolean checkWin(){
        //checks friendlies if are still alive
        if(friendlyCarrier.getIsSunk() && friendlyBattleship.getIsSunk() && friendlyCruiser.getIsSunk() &&
                friendlySubmarine.getIsSunk() && friendlyDestroyer.getIsSunk())
        {
            System.out.println("Defeat!");
            System.out.println("Remind yourself that overconfidence is a slow and insidious killer");
            return true;
        }
        //check enemies if are dead
        if(enemyCarrier.getIsSunk() && enemyBattleship.getIsSunk() && enemyCruiser.getIsSunk() &&
                enemySubmarine.getIsSunk() && enemyDestroyer.getIsSunk())
        {
            System.out.println("Victory!");
            return true;
        }
        return false;
    }


}
