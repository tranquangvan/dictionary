package Dictionary2;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;
import java.util.Vector;

public class ListWords extends JFrame {
    public ListWords(){
        super("List Of Words");
        Container container = getContentPane();
        Vector<String> headings = new Vector<>();
        headings.add("Word");
        headings.add("Meaning");
        headings.add("Noun");
        headings.add("Verb");
        headings.add("Transcribe:");
        Vector<Vector<String>> rows = new Vector<>();
        TreeMap<String,Vector<String>> words = Dictionary.getWords();
        for (String word : words.keySet()){
            Vector<String> row = new Vector<>();
            row.add(word);
           row.add(words.get(word).get(1));
            row.add(words.get(word).get(2));
            row.add(words.get(word).get(3));
            row.add(words.get(word).get(4));
            rows.add(row);
        }
        JTable wordsTable = new JTable(rows,headings);
        JScrollPane sp = new JScrollPane(wordsTable,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        container.add(sp);
        pack();
        show();
    }
}
