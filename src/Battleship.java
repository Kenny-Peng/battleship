import java.util.*;

public class Battleship extends Ship {

    private int shipSize;
    private String shipType;
    private boolean isSunk;
    private boolean placed;
    private ArrayList<Hull> shipHp;
    private Random random;



    /**
     * creates Battleship object
     */
    public Battleship(){
        shipSize = 4;
        shipType = "Battleship";
        isSunk = false;
        placed = false;
        shipHp = new ArrayList<Hull>();
        random = new Random();

    }
    /**
     * gets ship size
     * @return ship size
     */
    @Override
    public int getShipSize(){
        return shipSize;
    }

    /**
     * gets if the ship is placed
     * @return if ship is placed
     */
    @Override
    public boolean getPlaced(){
        return placed;
    }

    /**
     * recursively places ai ships in random spots
     * @param direction direction to place ship
     * @param currentBoard board to put ships on
     * @param isAi whether player or not
     */
    @Override
    public boolean placeAi(String direction, BoardState currentBoard, boolean isAi){
        if (!placed) {
            //random choice for where o put ships in range of board
            int choiceX = random.nextInt(10);
            int choiceY = random.nextInt(('J'-'A') + 1);
            //check to see if direcion allows for placement
            if (direction.equals("up")) {
                placed = setLocationUp(choiceX, choiceY, currentBoard, this.getShipSize(), isAi);
                //if placement is allowed then add location to arraylist and stop recursing
                if (placed == true) {
                    for (int i = 0; i < shipSize; i++) {
                        shipHp.add(new Hull(choiceX, choiceY + i));
                    }
                    return placed;
                }
            } else if (direction.equals("down")) {
                placed = setLocationDown(choiceX, choiceY, currentBoard, this.getShipSize(), isAi);
                if (placed == true) {
                    for (int i = 0; i < shipSize; i++) {
                        shipHp.add(new Hull(choiceX, choiceY - i));
                    }
                    return placed;
                }
            } else if (direction.equals("right")) {
                placed = setLocationRight(choiceX, choiceY, currentBoard, this.getShipSize(), isAi);
                if (placed == true) {
                    for (int i = 0; i < shipSize; i++) {
                        shipHp.add(new Hull(choiceX - i, choiceY));
                    }
                    return placed;
                }
            } else if (direction.equals("left")) {
                placed = setLocationLeft(choiceX, choiceY, currentBoard, this.getShipSize(), isAi);
                if (placed == true) {
                    for (int i = 0; i < shipSize; i++) {
                        shipHp.add(new Hull(choiceX + i, choiceY));
                    }
                    return placed;
                }
            }
        }
        //stops when placed == true;
        return placeAi(direction, currentBoard, isAi);
    }

    /**
     * places player ship
     * @param direction direction to place ship
     * @param choiceX x location for placement
     * @param choiceY y location for placement
     * @param currentBoard board to put ships on
     * @param isAi whether player or not
     */
    @Override
    public void place(String direction,int choiceX, int choiceY, BoardState currentBoard, boolean isAi) {
        if (direction.equals("up")) {
            placed = setLocationUp(choiceX, choiceY, currentBoard, this.getShipSize(), isAi);
            if (placed == true) {
                for (int i = 0; i < shipSize; i++) {
                    shipHp.add(new Hull(choiceX, choiceY - i));
                }
            }
        } else if (direction.equals("down")) {
            placed = setLocationDown(choiceX, choiceY, currentBoard, this.getShipSize(), isAi);
            if (placed == true) {
                for (int i = 0; i < shipSize; i++) {
                    shipHp.add(new Hull(choiceX, choiceY + i));
                }
            }
        } else if (direction.equals("right")) {
            placed = setLocationRight(choiceX, choiceY, currentBoard, this.getShipSize(), isAi);
            if (placed == true) {
                for (int i = 0; i < shipSize; i++) {
                    shipHp.add(new Hull(choiceX - i, choiceY));
                }
            }
        } else if (direction.equals("left")) {
            placed = setLocationLeft(choiceX, choiceY, currentBoard, this.getShipSize(), isAi);
            if (placed == true) {
                for (int i = 0; i < shipSize; i++) {
                    shipHp.add(new Hull(choiceX + i, choiceY));
                }
            }
        }
    }

    /**
     * checks if ship hp should be lowered when a hit lands
     * @param targetedX x location of hit
     * @param targetedY y location of hit
     */
    @Override
    public void checkHullDamage(int targetedX,int targetedY){
        //if target peg is a part of ship, remove from shipHp array

        for (int shipBlock = 0; shipBlock < shipHp.size(); shipBlock++) {
            if(targetedX == shipHp.get(shipBlock).getHullX() && targetedY == shipHp.get(shipBlock).getHullY()){
                shipHp.remove(shipBlock);
            }
        }
        if(shipHp.size() == 0 && !isSunk){
            System.out.println("Battleship Down!");
            isSunk = true;

        }
    }

    /**
     * gets if ship is sunk or not
     * @return if ship is sunk
     */
    public boolean getIsSunk(){
        return isSunk;
    }


}
