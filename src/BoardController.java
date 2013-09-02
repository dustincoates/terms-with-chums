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
    private ArrayList<ArrayList<Integer>> spaces = new ArrayList<ArrayList<Integer>>();
    private String word;
    private Dictionary dictionary = Dictionary.getDictionary();
    private User currentUser;

    public static BoardController getBoardController(){
        if (boardController == null){
            boardController = new BoardController();
        }
        return boardController;
    }

    public void playTile(Tile tileToBePlayed, int rowToPlay, int columnToPlay){
        tilesToPlay.add(tileToBePlayed);
        ArrayList<Integer> space = new ArrayList<Integer>();
        space.add(rowToPlay);
        space.add(columnToPlay);
        spaces.add(space);
    }

    public void giveTilesBack(){
        ArrayList<Tile> tilesToBeReturned = new ArrayList<Tile>();
        for (int i = 0; i < tilesToPlay.size(); i++){
            if (!tilesToPlay.get(i).getPlayedStatus()){
                tilesToBeReturned.add(tilesToPlay.get(i));
            }
        }
        currentUser.addTiles(tilesToBeReturned);
        tilesToPlay.clear();
    }

    public boolean finalizePlay(){
        for (int i = 0; i < tilesToPlay.size(); i++){
            word = new StringBuilder().append(tilesToPlay.get(i)).toString();
        }
        if(dictionary.checkWord(word)){
            providePointsToUser();
            tilesToPlay.clear();
//            Then we should put the tiles on the board, mark them as true for played and give more tiles back to user
            return true;
        }
        else{
            tilesToPlay.clear();
            return false;
        }
    }

    private void providePointsToUser(){
        Integer points = 0;
        for (int i = 0; i < tilesToPlay.size(); i++){
            points += tilesToPlay.get(i).getPoints();
        }
        currentUser.addPoints(points);
    }
}
