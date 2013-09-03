import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: dustin
 * Date: 9/1/13
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    public String name = "";
    private ArrayList<Tile> tiles = new ArrayList<Tile>();
    private Integer points = 0;

    public User(String userName, TileBag tileBag){
        name = userName;
        for (int i = 0; i < 7; i++){
            Tile tile = tileBag.getTile();
            tiles.add(tile);
        }
    }

    public String showTiles(){
        String tilesString = "| ";
        for (int i = 0; i < tiles.size(); i++){
            tilesString += tiles.get(i).getLetter();
            tilesString += " | ";
        }
        return tilesString;
    };

    public void addTiles(ArrayList<Tile> tilesToAdd){
        for (int i = 0; i < tilesToAdd.size(); i++){
            Tile tile = tilesToAdd.get(i);
            tiles.add(tilesToAdd.get(i));
        }
    }

    // Refactor this--currently O(n) but with something like a HashMap, it could be much faster
    public Tile getTile(char letter){
        for(int i = 0; i<tiles.size(); i++){
            if(letter == tiles.get(i).getLetter()){
                Tile tileToReturn = tiles.get(i);
                tiles.remove(i);
                return tileToReturn;
            }
        }
        return null;
    }

    // Refactor this--currently O(n) but with something like a HashMap, it could be much faster
    public boolean checkLetter(char letter){
        for(int i = 0; i <tiles.size(); i++){
            if (letter == tiles.get(i).getLetter()){
                return true;
            }
        }
        return false;
    }


    public void addPoints(Integer newPoints){
        points += newPoints;
    }

    public Integer getPoints(){
        return points;
    }

    public void resetTiles(int numOfTiles, TileBag tileBag){
        ArrayList<Tile> tiles = new ArrayList<Tile>();
        for(int i = 0; i < numOfTiles; i++){
            tiles.add(tileBag.getTile());
        }
        addTiles(tiles);
    }
}