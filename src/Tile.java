/**
 * Created with IntelliJ IDEA.
 * User: dustin
 * Date: 8/19/13
 * Time: 9:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tile {
    private String letter;
    private Integer points;
    public Tile(String letterForTile, Integer pointsForTile){
        this.letter = letterForTile;
        this.points = pointsForTile;
    }

    public String getLetter(){
        return this.letter;
    };

    public Integer getPoints(){
        return this.points;
    };
}
