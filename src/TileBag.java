import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: dustin
 * Date: 8/19/13
 * Time: 9:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class TileBag {
    private HashMap<String, ArrayList<Tile>> tileBag = new HashMap<String, ArrayList<Tile>>();
    private Integer numberOfTiles = tileBag.size();

    public TileBag(){
        tileBag.clear();
        // Read from file and create tiles one-by-one then put into the tileBag likeso:
        ArrayList<Tile> tiles = new ArrayList<Tile>();
        Tile tile = new Tile("e",1);
        tiles.add(0, tile);
        tileBag.put("e",tiles);
        // All "psueo-code" above
    }

    public Tile getTile(String letter){
        Tile tile;
        if(tileBag.get(letter) == null || tileBag.get(letter).isEmpty()){
            tile = null;
            // Maybe this should raise an error?
        }
        else{
            ArrayList tiles = tileBag.get(letter);
            tiles.size();
            // This is giving an error, why?
            tile = tiles.get(0);

        }
        return tile;
    };

    public Integer getNumberOfTiles(){
        return this.numberOfTiles;
    };

}
