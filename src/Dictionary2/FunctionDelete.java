package Dictionary2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FunctionDelete extends JFrame {
    JTextField tfWord;
    JButton btnDelete;
    public FunctionDelete(){
        super("Delete Word");
        tfWord = new JTextField(20);
        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (  tfWord.getText().length() > 0 ) {
                    boolean done = Dictionary.deleteWord(tfWord.getText());

                    if (!done)
                        JOptionPane.showMessageDialog( FunctionDelete.this, "Word  Not Found. Please try again!","Delete Word", JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog( FunctionDelete.this, "Word  Deleted Successfully!","Delete Word", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog( FunctionDelete.this, "Please enter word from dictionary!","Add Word", JOptionPane.ERROR_MESSAGE);
            }
        });
        Container c = getContentPane();
        c.setLayout( new FlowLayout());
        c.add( new JLabel("Word To Delete :"));
        c.add(tfWord);
        c.add( btnDelete);
        c.setBackground(Color.MAGENTA);
        pack();
        show();
    }
}
