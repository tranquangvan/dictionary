package Dictionary2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SearchWord extends JFrame {
    private JTextField tfWord;
    private JTextArea  taMeaning;
    JTextField tfNoun;
    JTextField tfVerb;
    JTextField tfTranscribe;
    private JButton btnSearch;
    public SearchWord() {
        super("Search Word");

        GridBagLayout gbl  = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,5);
        gbc.fill = GridBagConstraints.BOTH;
        tfWord = new JTextField(30);
        tfNoun = new JTextField(30);
        tfVerb = new JTextField(30);
        tfTranscribe = new JTextField(30);
        taMeaning = new JTextArea();
        btnSearch = new JButton("Search");
        btnSearch.addActionListener( new ActionListener() {

                                         @Override
                                         public void actionPerformed(ActionEvent e) {
                                             if (  tfWord.getText().length() > 0 ) {
                                                 MyVector<String> details = Dictionary.searchWord(tfWord.getText());//fix o day
                                                 if ( details.size() != 0){
                                                     taMeaning.setText(String.valueOf(details.get(1)));//fix o day
                                                 tfNoun.setText(String.valueOf(details.get(2)));//fix o day
                                                 tfVerb.setText(String.valueOf(details.get(3)));//fix o day
                                                 tfTranscribe.setText(String.valueOf(details.get(4)));//fix o day
                                                      }
                                                 else
                                                     JOptionPane.showMessageDialog( SearchWord.this, "Word  Not Found. Please try again!","Search Word", JOptionPane.INFORMATION_MESSAGE);
                                             }
                                             else
                                                 JOptionPane.showMessageDialog( SearchWord.this, "Please enter word from dictionary!","Search Word", JOptionPane.ERROR_MESSAGE);
                                         }
                                     }
        );

        Container c = getContentPane();
        c.setLayout(gbl);
        c.setSize(500,500);

        // add tfWord
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        c.add( new JLabel("Search Word :"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        c.add(tfWord);
        gbc.gridx = 2;
        gbc.gridy = 0;
        c.add( btnSearch);


        // add taMeaning
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx=0;
        gbc.gridy = 1;
        c.add( new JLabel(" Meaning :"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        taMeaning.setRows(3);
        taMeaning.setColumns(30);
        JScrollPane sp = new JScrollPane(taMeaning, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        c.add(sp, gbc);
        //ADD tfNoun
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 2;
        c.add( new JLabel(" NOUN :"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        c.add(tfNoun,gbc);
        //add tfVerb
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 3;
        c.add( new JLabel(" VERB :"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        c.add(tfVerb,gbc);
        //add tfTranscribe
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 4;
        c.add( new JLabel(" Transcribe :"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        c.add(tfTranscribe,gbc);
        show();
        pack(); // get requried size based on components
    }

    public static void main(String[] args) {
        SearchWord searchWord = new SearchWord();
    }
}
