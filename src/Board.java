import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Home
 * Date: 8/18/13
 * Time: 6:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Board {
    //Constructor
    public Board() {

    }

    private ArrayList board = new ArrayList(225);
    private String blankSpace = "_";

    public void initializeBoard(){
        for(int i = 0; i<225; i++){
            board.add(blankSpace);
        }
    }

    public void printBoard(){
        System.out.println("   1    2    3    4    5    6    7    8    9    10   11   12   13   14   15");
        int spaceHolder = 0;
        for (int i=0;i<15;i++){
            if(i<9){System.out.print(i+1+" ");}else{System.out.print(i + 1);}

            for(int j=0;j<15;j++){
                System.out.print(" _");
                System.out.print(board.get(spaceHolder));
                System.out.print("_ ");
                spaceHolder++;
            }
            System.out.println("\n");
        }
    }

    public void playWord(String word, String direction, int column, int row){
        //TODO: Check if player has the chips in word
        //TODO: Check if word is real word
        //TODO: Check if word conflicts with other spots on the board
        char[] wordArray = word.toCharArray();

        if(direction=="down"){
            for(int i = 0; i < wordArray.length; i++){
                board.set((15*(row+i-1))+column-1,wordArray[i]);
                printBoard();
            }
        }else if (direction=="right"){
            for(int i = 0; i < wordArray.length; i++){
                board.set((15*(row-1))+(column-1+i),wordArray[i]);
            }
        }
    }
}

