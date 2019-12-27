package Dictionary2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Vector;

public class ListWords extends JFrame {
    Container container = getContentPane();
    Panel pn = new Panel();
    Panel pn1,pn2 ;
    Label lb1,lb2,lb3,lb4,lb5;
    TextField txt1,txt2,txt3,txt4;
    JTextArea  taMeaning;
    JTable wordsTable;
    Button btnAdd,btnDelete,btnUpdate;
    DefaultTableModel model = new DefaultTableModel();
    public ListWords(){
        super("List Of Words");
        Vector<String> headings = new Vector<>();
        headings.add("Word");
        headings.add("Meaning");
        headings.add("Noun");
        headings.add("Verb");
        headings.add("Transcribe:");
        Vector<Vector<String>> rows = new Vector<>();
        HashMap<String, MyVector<String>> words = (HashMap<String, MyVector<String>>) Dictionary.getWords();
        for (String word : words.keySet()){
            Vector<String> row = new Vector<>();
            row.add(word);
            MyVector<String> detail = words.get(word);
            String detail1 = (String) detail.get(1);
            String detail2 = (String) detail.get(2);
            String detail3 = (String) detail.get(3);
            String detail4 = (String) detail.get(4);
           row.add(detail1);
            row.add(detail2);
            row.add(detail3);
            row.add(detail4);
            rows.add(row);
        }
        wordsTable = new JTable(rows, headings);
        JScrollPane sp = new JScrollPane(wordsTable,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pn.add(sp);
        pn1 = new Panel(new GridLayout(10,1));
        lb1 = new Label("Word: ");
        lb2 = new Label("Meaning: ");
        lb3 = new Label("Noun: ");
        lb4 = new Label("Verb: ");
        lb5 = new Label("Transcribe: ");
        txt1 = new TextField(30);
        txt2 = new TextField(30);
        txt3 = new TextField(30);
        taMeaning = new JTextArea();
        taMeaning.setRows(2);
        taMeaning.setColumns(30);
        txt4 = new TextField();
        btnAdd = new Button("Add in List");
        btnDelete = new Button("Delete element");
        btnUpdate = new Button("Update element");
        btnAdd.setBackground(Color.CYAN);
        btnDelete.setBackground(Color.CYAN);
        btnUpdate.setBackground(Color.CYAN);
        wordsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int index=wordsTable.getSelectedRow();
                txt1.setText((String)(wordsTable.getValueAt(index, 0)));
                taMeaning.setText((String)wordsTable.getValueAt(index, 1));
                txt2.setText((String)wordsTable.getValueAt(index, 2));
                txt3.setText((String)wordsTable.getValueAt(index, 3));
                txt4.setText((String)wordsTable.getValueAt(index, 4));
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (  txt1.getText().length() > 0 && taMeaning.getText().length() > 0 && txt2.getText().length() > 0&& txt3.getText().length() > 0&& txt4.getText().length() > 0 ) {
                    MyVector<String> details = new MyVector<>();
                    details.add(txt1.getText());
                    details.add(taMeaning.getText());
                    details.add(txt2.getText());
                    details.add(txt3.getText());
                    details.add(txt4.getText());
                    Dictionary.addWord(txt1.getText(), details);
                    Dictionary.saveToDisk();
                    JOptionPane.showMessageDialog( ListWords.this, "Added Word Successfully!","List Word", JOptionPane.INFORMATION_MESSAGE);
                    txt1.setText("");
                    taMeaning.setText("");
                    txt2.setText("");
                    txt3.setText("");
                    txt4.setText("");
                    txt1.requestFocus();
                   setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog( ListWords.this, "Please enter word and meaning!","List Word", JOptionPane.ERROR_MESSAGE);
                    txt1.requestFocus();
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (  txt1.getText().length() > 0 ) {
                    boolean done = Dictionary.deleteWord(txt1.getText());
                    //Dictionary.saveToDisk();
                    setVisible(false);
                    if (!done)
                        JOptionPane.showMessageDialog( ListWords.this, "Word  Not Found. Please try again!","Delete Word", JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog( ListWords.this, "Word  Deleted Successfully!","Delete Word", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog( ListWords.this, "Please enter word from dictionary!","Delete Word", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (  txt1.getText().length() > 0 && taMeaning.getText().length() > 0 && txt2.getText().length() > 0&& txt3.getText().length() > 0&& txt4.getText().length() > 0 ) {
                    MyVector<String> details = new MyVector<>();
                    details.add(txt1.getText());
                    details.add(taMeaning.getText());
                    details.add(txt2.getText());
                    details.add(txt3.getText());
                    details.add(txt4.getText());
                    boolean done = Dictionary.deleteWord(txt1.getText());
                    if (done){
                    Dictionary.addWord(txt1.getText(), details);
                    Dictionary.saveToDisk();
                    JOptionPane.showMessageDialog( ListWords.this, "Update Word Successfully!","List Word", JOptionPane.INFORMATION_MESSAGE);
                    txt1.setText("");
                    taMeaning.setText("");
                    txt2.setText("");
                    txt3.setText("");
                    txt4.setText("");
                    txt1.requestFocus();
                    setVisible(false);}
                    else
                        JOptionPane.showMessageDialog( ListWords.this, "Word  Not Found. Please try again!","Update Word", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog( ListWords.this, "Please enter all fields!","List Word", JOptionPane.ERROR_MESSAGE);
                    txt1.requestFocus();
                }
            }
        });
        pn1.add(lb1);
        pn1.add(txt1);
        pn1.add(lb2);
        pn1.add(taMeaning);
        pn1.add(lb3);
        pn1.add(txt2);
        pn1.add(lb4);
        pn1.add(txt3);
        pn1.add(lb5);
        pn1.add(txt4);
        pn2 = new Panel(new FlowLayout());
        pn2.add(btnAdd);
        pn2.add(btnDelete);
        pn2.add(btnUpdate);
        pn1.add(pn2);
        pn.add(pn1);
        container.add(pn);
        pack();
        show();
    }
    public static void main(String[] args) {
        ListWords listWords = new ListWords();
    }
}
