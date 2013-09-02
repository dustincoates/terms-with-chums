import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: dustin
 * Date: 9/2/13
 * Time: 11:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class BoardController {
    private static BoardController boardController = null;
    private ArrayList<Tile> tilesToPlay = new ArrayList<Tile>();
    private String word;
    private Dictionary dictionary = Dictionary.getDictionary();

    public static BoardController getBoardController(){
        if (boardController == null){
            boardController = new BoardController();
        }
        return boardController;
    }

    public boolean placeTiles(ArrayList<Tile> tilesToBePlayed){
        tilesToPlay = tilesToBePlayed;

        return false;
    }

    public ArrayList<Tile> getTilesBack(){
        ArrayList<Tile> tilesToBeReturned = new ArrayList<Tile>();
        for (int i = 0; i < tilesToPlay.size(); i++){
            if (!tilesToPlay.get(i).getPlayedStatus()){
                tilesToBeReturned.add(tilesToPlay.get(i));
            }
        }
        tilesToPlay.clear();
        return tilesToBeReturned;
    }

    public boolean finalizePlay(){
        for (int i = 0; i < tilesToPlay.size(); i++){
            word = new StringBuilder().append(tilesToPlay.get(i)).toString();
        }
        if(dictionary.checkWord(word)){
//          this needs to actually set the word on the board and give points to the user
            return true;
        }
        else{
            return false;
        }
    }
}
