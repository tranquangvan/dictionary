package Dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchWord extends JFrame {
    private JTextField tfWord;
    private JTextArea  taMeaning;
    private JButton btnSearch;
    public SearchWord() {
        super("Search Word");

        GridBagLayout gbl  = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;

        tfWord = new JTextField(20);
        taMeaning = new JTextArea();
        btnSearch = new JButton("Search");
        btnSearch.addActionListener( new ActionListener() {

                                         @Override
                                         public void actionPerformed(ActionEvent e) {
                                             if (  tfWord.getText().length() > 0 ) {
                                                 String meaning = Dictionary.searchWord(tfWord.getText());
                                                 if ( meaning != null)
                                                     taMeaning.setText(meaning);
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

        // add tfWord
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        c.add( new JLabel("Search Word :"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        c.add(tfWord);
        gbc.gridx = 0;
        gbc.gridy = 2;
        c.add( btnSearch);


        // add taMeaning

        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        c.add( new JLabel("Meaning :"), gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        taMeaning.setRows(3);
        taMeaning.setColumns(30);
        JScrollPane sp = new JScrollPane(taMeaning, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        c.add(sp, gbc);

        pack(); // get requried size based on components
    }


}
