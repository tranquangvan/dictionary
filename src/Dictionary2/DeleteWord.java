package Dictionary2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteWord extends JFrame {
    JTextField tfWord;
    JButton btnDelete;
    public DeleteWord(){
        super("Delete Word");
        tfWord = new JTextField(20);
        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (  tfWord.getText().length() > 0 ) {
                    boolean done = Dictionary.deleteWord(tfWord.getText());

                    if (!done)
                        JOptionPane.showMessageDialog( DeleteWord.this, "Word  Not Found. Please try again!","Delete Word", JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog( DeleteWord.this, "Word  Deleted Successfully!","Delete Word", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog( DeleteWord.this, "Please enter word from dictionary!","Add Word", JOptionPane.ERROR_MESSAGE);
            }
        });
        Container c = getContentPane();
        c.setLayout( new FlowLayout());
        c.add( new JLabel("Word To Delete :"));
        c.add(tfWord);
        c.add( btnDelete);
        pack();
        show();
    }
}
