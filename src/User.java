import java.util.ArrayList;

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
    public User(String userName){
        name = userName;
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
            tiles.add(tilesToAdd.get(i));
        }
    }

    public Tile removeTile(char letter){
        for(int i = 0; i<tiles.size(); i++){
            if(letter == tiles.get(i).getLetter()){
                Tile tileToReturn = tiles.get(i);
                tiles.remove(i);
                return tileToReturn;
            }
        }
        return null;
    }

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
}