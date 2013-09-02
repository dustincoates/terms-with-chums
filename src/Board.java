import java.util.*;

public class Board {
    //Constructor
    public Board() {
        //creates blank board
        initializeBoard();
    }

    private ArrayList<ArrayList> board = new ArrayList(15);
    private Tile blankTile = new Tile('_', 0);

    //Creates board with blank spaces
    public void initializeBoard(){
        for(int i = 0; i<15; i++){
            board.add(i,new ArrayList<Tile>(15));
        }
        for(int i = 0; i<15; i++){
            ArrayList arrayPlaceHolder = board.get(i);
            for(int j = 0; j < 15; j++){
                arrayPlaceHolder.add(j, blankTile);
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
                System.out.print(arrayPlaceHolder.get(j).getLetter());
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
                ArrayList<Tile> arrayPlaceHolder = board.get(row-1+i);
                arrayPlaceHolder.set(column, tiles.get(tilePlaceHolder));
                tilePlaceHolder++;
            }
        }else if(direction.equals("right")){
            ArrayList<Tile> arrayPlaceHolder = board.get(row-1);
            for(int i=column-1; i<tiles.size(); i++){
                arrayPlaceHolder.set(i, tiles.get(tilePlaceHolder));
                tilePlaceHolder++;
            }
        }else{
            System.out.println("Direction Invalid");
        }
    }

    public boolean checkLetter(char letter, int row, int column){
        ArrayList<Tile> arrayPlaceHolder = board.get(row-1);
        if(arrayPlaceHolder.get(column-1).getLetter() == letter){
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<ArrayList> getBoard() {
        return board;
    }
}

