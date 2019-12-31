package Dictionary2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Dictionary {
    private static boolean modified = false;
    private static String dictionaryfile;
    private static String message = "";
    private static MyVector<String> details;
    private static HashMap<String, MyVector<String>> words =
            new HashMap<>();
    static {
        // get currency directory
        dictionaryfile = System.getProperty("user.dir") +
                "/dictionary.txt";
    }

    public static boolean isModified() {
        return modified;
    }

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        Dictionary.message = message;
    }

    public static Map<String, MyVector<String>> getWords() {
        return words;
    }

    public static void setWords(HashMap<String, MyVector<String>> words) {
        Dictionary.words = words;
        modified = true;
    }

    public static MyVector<String> searchWord(String word) {

        return words.get(word);
    }

    public static void addWord(String word, MyVector<String> detail) {
        words.put(word, detail);
        modified = true;
    }

    public static boolean deleteWord(String word) {
        Object done = words.remove(word);
        if (done == null) {
            return false;
        } else {
            modified = true;
            return true;
        }
    }

    public static boolean saveToDisk() {
        try {
            FileOutputStream fs = new FileOutputStream(dictionaryfile);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(words);
            os.close();
            fs.close();
            modified = false;
            return true;
        } catch (Exception ex) {
            message = ex.getMessage();
            return false;
        }

    }

    public static boolean loadFromDisk() {

        try {
            FileInputStream fs = new FileInputStream(dictionaryfile);
            ObjectInputStream is = new ObjectInputStream(fs);
            words = (HashMap<String, MyVector<String>>) is.readObject();
            is.close();
            fs.close();
            modified = false;
            return true;
        } catch (Exception ex) {
            message = ex.getMessage();
            return false;
        }
    }
}
