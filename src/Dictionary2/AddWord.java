package Dictionary2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWord extends JFrame {
    JTextField tfWord;
    JTextArea  taMeaning;
    JTextField tfNoun;
    JTextField tfVerb;
    JTextField tfTranscribe;
    JButton btnAdd;

    public AddWord() {
        GridBagLayout gbl  = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;

        tfWord = new JTextField(30);
        tfNoun = new JTextField(30);
        tfVerb = new JTextField(30);
        tfTranscribe = new JTextField(30);
        taMeaning = new JTextArea();
        btnAdd = new JButton("Add Word");
        btnAdd.addActionListener( new ActionListener() {

                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          if (  tfWord.getText().length() > 0 && taMeaning.getText().length() > 0 && tfNoun.getText().length() > 0&& tfVerb.getText().length() > 0&& tfTranscribe.getText().length() > 0 ) {
                                              MyVector<String> details = new MyVector<>();
                                              details.add(tfWord.getText());
                                              details.add(taMeaning.getText());
                                              details.add(tfNoun.getText());
                                              details.add(tfVerb.getText());
                                              details.add(tfTranscribe.getText());
                                                  Dictionary.addWord(tfWord.getText(), details);
                                              JOptionPane.showMessageDialog( AddWord.this, "Added Word Successfully!","Add Word", JOptionPane.INFORMATION_MESSAGE);
                                              tfWord.setText("");
                                              taMeaning.setText("");
                                              tfNoun.setText("");
                                              tfVerb.setText("");
                                              tfTranscribe.setText("");
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
        c.setSize(500,500);

        // add tfWord
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        c.add( new JLabel("Enter Word :"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        c.add(tfWord);

        // add taMeaning
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx=0;
        gbc.gridy = 1;
        c.add( new JLabel("Enter Meaning :"), gbc);
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
        c.add( new JLabel("Enter NOUN :"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        c.add(tfNoun,gbc);
        //add tfVerb
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 3;
        c.add( new JLabel("Enter VERB :"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        c.add(tfVerb,gbc);
        //add tfTranscribe
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 4;
        c.add( new JLabel("Enter Transcribe :"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        c.add(tfTranscribe,gbc);
        // add button
        gbc.gridx =0;
        gbc.gridy  = 5;
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
