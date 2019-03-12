/**
 *
 *
 *  @author Kenny Peng
 *  @version 10/1/2018
 */
public class BoardState {

    private char[][] board;
    private final int boardSize = 10;

    /**
     * creates the BoardState object
     * initiializes char 2D array based on if human or not
     * @param typeOfPlayer 0 for ai, 1 for human player
     */
    public BoardState(int typeOfPlayer){
        board = new char[boardSize][boardSize];
        //ai
        if(typeOfPlayer == 0){
            aiInitBoard();
        }
        //human
        else if(typeOfPlayer == 1){
            initBoard();
        }
    }

    /**
     * initializes char 2D array board for player to all O
     * spacing at the end to make this look nicer
     */
    public void initBoard(){
        System.out.print("   ");
        for(int i = 0; i < boardSize; i++){
            System.out.print(" " + i + " ");
        }
        System.out.println();
        for(int i = 0; i < boardSize; i++){
            System.out.print(" " + (char)(i + 'A') + " ");
            for (int j = 0; j < boardSize; j++){
                board[i][j] = 'O';
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * initializes board to all O, but without letting player see, only for ai
     */
    //init board but without letting player see, only for ai
    public void aiInitBoard(){
        for(int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = 'O';
            }
        }
    }


    /**
     * gets the current 2D array representing the board
     * @return char 2D array of the board
     */
    public char[][] getBoardState(){
        return board;
    }

    /**
     * Loops through 2D char board and prints out the result in grid
     * extra lines at end for seperators
     */
    public void showBoardState() {
        System.out.print("   ");
        //top row X axis
        for(int i = 0; i < boardSize; i++){
            System.out.print(" " + i + " ");
        }
        System.out.println();
        for (int i = 0; i < boardSize; i++) {
            //conversion 0-9 to char for display as Y axis
            System.out.print(" " + (char)(i + 'A') + " ");
            for (int j = 0; j < boardSize; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();

        }
        System.out.println();
    }


}
