/**
 *
 *
 *  @author Kenny Peng
 *  @version 10/1/2018
 */
public abstract class Ship {
    private boolean placed;

    /**
     *
     * Places ship with head facing up
     * checks if ship will fit or not before placing
     * @param choiceX x where you want to place ship
     * @param choiceY y where you want to place ship
     * @param currentBoard board placing ship on
     * @param size size of shup
     * @param ai determines if messages should be given
     * @return true if successful placement, false otherwise
     */
    //direction i 1up,2right,3,down,4right
    public boolean setLocationUp(int choiceX, int choiceY, BoardState currentBoard, int size, boolean ai) {
        //checks direction and if there is space for the ship
        if(choiceY >= 0 && choiceY<currentBoard.getBoardState().length - size + 1){
            //needs two for loops to check valid placement and placing ship since unable to do both at once, pass by reference
            for(int y = choiceY; y < choiceY + size; y++){
                if(currentBoard.getBoardState()[y][choiceX] != 'O'){
                    if(!ai) {
                        System.out.println("ship blocking placement");
                    }
                    return false;
                }
            }
            for(int y = choiceY; y < choiceY + size; y++){
                currentBoard.getBoardState()[y][choiceX] = '+';
            }
            return true;
        }
        else{
            if(!ai) {
                System.out.println("not enough space on board");
            }
            return false;
        }
    }

    /**
     *
     * Places ship with head facing down
     * checks if ship will fit or not before placing
     * @param choiceX x where you want to place ship
     * @param choiceY y where you want to place ship
     * @param currentBoard board placing ship on
     * @param size size of ship
     * @param ai determines if messages should be given
     * @return true if successful placement, false otherwise
     */
    public boolean setLocationDown(int choiceX, int choiceY, BoardState currentBoard, int size, boolean ai){
        //checks direction and if there is space for the shio
        if(choiceY >= size && choiceY<currentBoard.getBoardState().length){
            //needs two for loops to check valid placemnet and placing ship since unable to do both at once, pass by reference
            for(int y = choiceY-size+1; y <= choiceY; y++){
                if(currentBoard.getBoardState()[y][choiceX] != 'O'){
                    if(!ai) {
                        System.out.println("ship blocking placement");
                    }
                    return false;
                }
            }
            for(int y = choiceY-size+1; y <= choiceY; y++){
                currentBoard.getBoardState()[y][choiceX] = '+';
            }
            return true;
        }
        else{
            if(!ai) {
                System.out.println("not enough space on board");
            }
            return false;

        }
    }

    /**
     *
     * Places ship with head facing right
     * checks if ship will fit or not before placing
     * @param choiceX x where you want to place ship
     * @param choiceY y where you want to place ship
     * @param currentBoard board placing ship on
     * @param size size of ship
     * @param ai determines if messages should be given
     * @return true if successful placement, false otherwise
     */
    public boolean setLocationRight(int choiceX, int choiceY, BoardState currentBoard, int size, boolean ai){
        //checks direction and if there is space for the ship
        if(choiceX >= size && choiceX<currentBoard.getBoardState().length){
            //needs two for loops to check valid placement and placing ship since unable to do both at once, pass by reference
            for(int x = choiceX - size + 1; x <= choiceX; x++){
                if(currentBoard.getBoardState()[choiceY][x] != 'O'){
                    if(!ai) {
                        System.out.println("ship blocking placement");
                    }
                    return false;
                }
            }
            for(int x = choiceX - size + 1; x <= choiceX; x++){
                currentBoard.getBoardState()[choiceY][x] = '+';
            }
            return true;
        }

        else{
            if(!ai) {
                System.out.println("not enough space on board");
            }
            return false;

        }
    }


    /**
     *
     * Places ship with head facing left
     * checks if ship will fit or not before placing
     * @param choiceX x where you want to place ship
     * @param choiceY y where you want to place ship
     * @param currentBoard board placing ship on
     * @param size size of ship
     * @param ai determines if messages should be given
     * @return true if successful placement, false otherwise
     */
    public boolean setLocationLeft(int choiceX, int choiceY, BoardState currentBoard, int size, boolean ai){
        //checks direction and if there is space for the ship
        if(choiceX >= 0 && choiceX<currentBoard.getBoardState().length - size + 1){
            //needs two for loops to check valid placement and placing ship since unable to do both at once, pass by reference
            for(int x = choiceX; x < choiceX + size; x++){
                if(currentBoard.getBoardState()[choiceY][x] != 'O'){
                    if(!ai) {
                        System.out.println("ship blocking placement");
                    }
                    return false;
                }
            }
            for(int x = choiceX; x < choiceX + size; x++){
                currentBoard.getBoardState()[choiceY][x] = '+';
            }
            return true;
        }
        else{
            if(!ai) {
                System.out.println("not enough space on board");
            }
            return false;
        }
    }


    /**
     * places player ships
     * @param direction direction to place ship
     * @param choiceX x location for placement
     * @param choiceY y location for placement
     * @param currentBoard board to put ships on
     * @param isAi whether player or not
     */
    abstract void place(String direction,int choiceX, int choiceY, BoardState currentBoard, boolean isAi);

    /**
     * recursively places ai ships in random spots
     * @param direction direction to place ship
     * @param currentBoard board to put ships on
     * @param isAi whether player or not
     */
    abstract boolean placeAi(String direction, BoardState currentBoard, boolean isAi);

    /**
     * checks if ship hp should be lowered when a hit lands
     * @param targetedX x location of hit
     * @param targetedY y location of hit
     */
    abstract void checkHullDamage(int targetedX,int targetedY);

    /**
     * gets if the ship is placed
     * @return if ship is placed
     */
    abstract boolean getPlaced();

    /**
     * gets ship size
     * @return ship size
     */
    abstract int getShipSize();

    /**
     * gets if ship is sunk or not
     * @return if ship is sunk
     */
    abstract boolean getIsSunk();
}
