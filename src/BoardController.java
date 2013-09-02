import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: dustin
 * Date: 9/2/13
 * Time: 11:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class BoardController {

    private static int userCount = 0;
    private static ArrayList<User> userList = new ArrayList();
    private static HashMap userScores = new HashMap();
    private static User activeUser = null;

    private ArrayList<Tile> tilesToPlay = new ArrayList<Tile>();
    private ArrayList<ArrayList<Integer>> spaces = new ArrayList<ArrayList<Integer>>();
    private String word;
    private Dictionary dictionary = Dictionary.getDictionary();

    //starts a new game
    public static void newGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players?");
        userCount = scanner.nextInt();
        Board board = new Board();
        for(int i = 0; i<userCount; i++){
            Integer userCount = i + 1;
            User user = new User("Player " + userCount.toString());
            userList.add(i, user);
            userScores.put(user, 0);
        }
        activeUser = userList.get(0);
    }

    //changes turn after play, if user is last user, go to user 1
    public static void changeTurn(){
        if(activeUser == userList.get(userCount-1)){
            activeUser = userList.get(0);
        }
        activeUser = userList.get(userList.indexOf(activeUser)+1);
    }

    //updates scores
    public static void updateScore(User user, int score){
        if(userScores.containsKey(user)){
            userScores.put(user, score);
        }else{
            System.out.println("Cannot find that user");
        }
    }

    public static int getUserCount() {
        return userCount;
    }

    public static ArrayList getUserList() {
        return userList;
    }

    public static HashMap getUserScores() {
        return userScores;
    }

    public static User getActiveUser() {
        return activeUser;
    }


//    public void playTile(Tile tileToBePlayed, int rowToPlay, int columnToPlay){
//        tilesToPlay.add(tileToBePlayed);
//        ArrayList<Integer> space = new ArrayList<Integer>();
//        space.add(rowToPlay);
//        space.add(columnToPlay);
//        spaces.add(space);
//    }

    public void giveTilesBack(){
        ArrayList<Tile> tilesToBeReturned = new ArrayList<Tile>();
        for (int i = 0; i < tilesToPlay.size(); i++){
            if (!tilesToPlay.get(i).getPlayedStatus()){
                tilesToBeReturned.add(tilesToPlay.get(i));
            }
        }
        activeUser.addTiles(tilesToBeReturned);
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
        activeUser.addPoints(points);
    }
}