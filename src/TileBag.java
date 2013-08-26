import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        try {
            BufferedReader br = new BufferedReader(new FileReader("/resources/letterFrequencies.txt"));
            String line;
            int numberOfTiles;
            int tilePoints;
            char tileLetter;
            tileBag.clear();
            // Read from file and create tiles one-by-one then put into the tileBag likeso:
            while((line = br.readLine()) != null){

            }
            Tile tile = new Tile("e",1);
            tileBag.add(tileBag.size(), tile);

            br.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public Tile getTile(String letter){
        int i = (int)(Math.random() * (tileBag.size() + 1 ));
        return tileBag.get(i);
    };

    public Integer getNumberOfTiles(){
        return this.numberOfTiles;
    };

}
