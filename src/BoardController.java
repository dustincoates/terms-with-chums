import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Home
 * Date: 9/1/13
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */

public class BoardController {

    private static int userCount = 0;
    private static ArrayList<User> userList = new ArrayList();
    private static HashMap userScores = new HashMap();
    private static User activeUser = null;

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
}
