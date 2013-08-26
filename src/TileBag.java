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
    private ArrayList<Tile> tileBag = new ArrayList<Tile>();
    private Integer numberOfTiles = tileBag.size();

    public TileBag(){
        tileBag.clear();
        // Read from file and create tiles one-by-one then put into the tileBag likeso:
        Tile tile = new Tile("e",1);
        tileBag.add(tileBag.size(), tile);
    }

    public Tile getTile(String letter){
        int i = (int)(Math.random() * (tileBag.size() + 1 ));
        return tileBag.get(i);
    };

    public Integer getNumberOfTiles(){
        return this.numberOfTiles;
    };

}
