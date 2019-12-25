package Dictionary2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;
import java.util.Vector;

public class Dictionary {
    private static boolean modified = false;
    private static String dictionaryfile;
    private static String message = "";
    private static Vector<String> details;
    private static TreeMap<String, Vector<String>> words =
            new TreeMap<String, Vector<String>>();
    static {
        // get currency directory
        dictionaryfile = System.getProperty("user.dir") +
                "/dictionary.ser";
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

    public static TreeMap<String, Vector<String>> getWords() {
        return words;
    }

    public static void setWords(TreeMap<String, Vector<String>> words) {
        Dictionary.words = words;
        modified = true;
    }

    public static Vector<String> searchWord(String word) {

        return words.get(word);
    }

    public static void addWord(String word, Vector<String> detail) {
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
        // create file and save to disk
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
        // read words from serialized treemap
        try {
            FileInputStream fs = new FileInputStream(dictionaryfile);
            ObjectInputStream is = new ObjectInputStream(fs);
            words = (TreeMap<String,Vector<String>>) is.readObject();
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
