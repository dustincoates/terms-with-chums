import java.util.*;
import java.io.*;
/**
 * Created with IntelliJ IDEA.
 * User: Home
 * Date: 8/27/13
 * Time: 8:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Dictionary {

    private Dictionary dictionary = new Dictionary();

    private String[] dictionaryArray() throws IOException {
        FileReader fileReader = new FileReader("../words.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }

    //TODO Verify that binarysearch returns negative index when word is not foundf
    public boolean isWord(String word) throws IOException{
        int index = Arrays.binarySearch(dictionaryArray(), word);
        if(index < 0){
            return false;
        }else{
            return true;
        }

    }

    public Dictionary getDictionary() {
        return dictionary;
    }
}
