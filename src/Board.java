import java.util.*;

public class Board {
    //Constructor
    public Board() {
        //creates blank board
        initializeBoard();
    }

    private ArrayList<ArrayList> board = new ArrayList(15);
    private String blankSpace = "_";

    //Creates board with blank spaces
    public void initializeBoard(){
        for(int i = 0; i<15; i++){
            board.add(i,new ArrayList(15));
        }
        for(int i = 0; i<15; i++){
            ArrayList arrayPlaceHolder = board.get(i);
            for(int j = 0; j < 15; j++){
                arrayPlaceHolder.add(j, blankSpace);
            }
        }
    }

    public void printBoard(){
        System.out.println("   1    2    3    4    5    6    7    8    9    10   11   12   13   14   15");
        int rowNumber = 1;
        for (int i=0;i<15;i++){
            ArrayList<Tile> arrayPlaceHolder = board.get(i);
            if(rowNumber<=9){
                System.out.print(rowNumber + " ");
            }else{
                System.out.print(rowNumber);
            }
            rowNumber ++;
            for(int j=0; j<15;j++){
                System.out.print(" _");
//                System.out.print(arrayPlaceHolder.get(j).getLetter());
                System.out.print("_ ");
            }
            System.out.println("\n");
        }
    }

    public void placeTiles(ArrayList<Tile> tiles, String direction, int row, int column){
        //plays word down
        int tilePlaceHolder = 0;
        if(direction.equals("down")){
            for(int i = 0; i<tiles.size();i++){
                ArrayList arrayPlaceHolder = board.get(row-1+i);
                arrayPlaceHolder.set(column, tiles.get(tilePlaceHolder));
                tilePlaceHolder++;
            }
        }else if(direction.equals("right")){
            ArrayList arrayPlaceHolder = board.get(row-1);
            for(int i=column-1; i<tiles.size(); i++){
                arrayPlaceHolder.set(i, tiles.get(tilePlaceHolder));
                tilePlaceHolder++;
            }
        }else{
            System.out.println("Direction Invalid");
        }
    }

    public void isWord(String word){

    }

    /*
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
    */
}

