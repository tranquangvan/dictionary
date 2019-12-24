package Dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWord extends JFrame {
    JTextField tfWord;
    JTextArea  taMeaning;
    JButton btnAdd;

    public AddWord() {
        GridBagLayout gbl  = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,5);
        gbc.fill = GridBagConstraints.BOTH;

        tfWord = new JTextField(30);
        taMeaning = new JTextArea();
        btnAdd = new JButton("Add Word");
        btnAdd.addActionListener( new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          if (  tfWord.getText().length() > 0 && taMeaning.getText().length() > 0  ) {
                                              Dictionary.addWord(tfWord.getText(), taMeaning.getText());
                                              JOptionPane.showMessageDialog( AddWord.this, "Added Word Successfully!","Add Word", JOptionPane.INFORMATION_MESSAGE);
                                              tfWord.setText("");
                                              taMeaning.setText("");
                                              tfWord.requestFocus();
                                          }
                                          else {
                                              JOptionPane.showMessageDialog( AddWord.this, "Please enter word and meaning!","Add Word", JOptionPane.ERROR_MESSAGE);
                                              tfWord.requestFocus();
                                          }
                                      }
                                  }
        );

        Container c = getContentPane();
        c.setLayout(gbl);
        c.setSize(400,400);

        // add tfWord
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        c.add( new JLabel("Enter Word :"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        c.add(tfWord);

        // add taMeaning
        gbc.gridx=0;
        gbc.anchor = GridBagConstraints.EAST;
        c.add( new JLabel("Enter Meaning :"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        taMeaning.setRows(3);
        taMeaning.setColumns(30);
        JScrollPane sp = new JScrollPane(taMeaning, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        c.add(sp, gbc);

        // add button
        gbc.gridy  = 3;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        c.add(btnAdd,gbc);
        show();
        pack(); // get requried size based on components
    }

    public static void main(String[] args) {
        new AddWord();
    }
}
