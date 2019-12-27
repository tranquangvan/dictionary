package Dictionary2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;

public class PlayGame extends JFrame {
    Panel pn;
    JPanel jp=new JPanel();
    JPanel jpMain,jp1= new JPanel();
    JButton[] btn = new JButton[10];
    JButton btnHeader = new JButton();
    TextField txtN = new TextField();
    JLabel lb1;
    public PlayGame(String title){
        super(title);
        HashMap<String, MyVector<String>> words = (HashMap<String, MyVector<String>>) Dictionary.getWords();
        int lenght =  words.size();
        Random rd = new Random();
        int random = rd.nextInt(lenght);
        String key = (String) words.keySet().toArray()[random];
        MyVector<String> detail = words.get(key);
       char[] arrKey = key.toCharArray();
       int randow2 = rd.nextInt(key.length());
       String resultRandowm = "" + arrKey[randow2];

        for (int k=0;k<key.length();k++){
            if (k==randow2){
                btn[k] = new JButton("");
                btn[k].setText("__");
            }
            else {
                btn[k] = new JButton("");
                btn[k].setText("" + arrKey[k]);
            }
        }
        jp.setLayout(new FlowLayout());
        for (int i=0;i<key.length();i++) {
            jp.add(btn[i]);
        }
        ////////
        jp1.setLayout(new FlowLayout());
        btnHeader.setText("THIS IS A GAME TO HELP YOU LEARN ENGLISH VOCABULARY:");
        jp1.add(btnHeader);
        jpMain = new JPanel(new GridLayout(4,1));
        Panel panel = new Panel();
        Button button = new Button("Enter the missing character:");
        Button buttonSubmit = new Button("SUBMIT");
        JTextField jTextField = new JTextField(5);
        button.setBackground(Color.CYAN);
        buttonSubmit.setBackground(Color.gray);
        jTextField.requestFocus();
        panel.add(button);
        panel.add(jTextField);
        panel.add(buttonSubmit);
        //////////////
       Panel pn1 = new Panel(new GridLayout(10,1));
        Label lb1 = new Label("Word: ");
        Label lb2 = new Label("Meaning: ");
        Label lb3 = new Label("Noun: ");
        Label lb4 = new Label("Verb: ");
        Label lb5 = new Label("Transcribe: ");
        TextField txt1 = new TextField(30);
        TextField txt2 = new TextField(30);
        TextField txt3 = new TextField(30);
        JTextArea taMeaning = new JTextArea();
         taMeaning.setRows(1);
        taMeaning.setColumns(30);
        TextField txt4 = new TextField();
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

        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = jTextField.getText();
                if (jTextField.getText().length()> 0){
                    if (resultRandowm.equals(result) == false){
                        JOptionPane.showMessageDialog( PlayGame.this, "There is no word in English!","Play Game", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        txt1.setText(key);
                        taMeaning.setText(detail.get(1));
                        txt2.setText(detail.get(2));
                        txt3.setText(detail.get(3));
                        txt4.setText(detail.get(4));
                        JOptionPane.showMessageDialog(PlayGame.this, "Your answer is correct!", "Play Game", JOptionPane.INFORMATION_MESSAGE);
                        jTextField.setText("");
                        setVisible(false);
                    }
                }
                else {
                    JOptionPane.showMessageDialog( PlayGame.this, "Please enter empty!","Play Game", JOptionPane.ERROR_MESSAGE);
                    jTextField.requestFocus();
                }
            }
        });
        ////////////
        jpMain.add(jp1);
        jpMain.add(jp);
        jpMain.add(panel);
        jpMain.add(pn1);
        add(jpMain);
        pack();
        show();
    }

    public static void main(String[] args) {
        PlayGame playGame = new PlayGame("Play Game Learn English ");
        playGame.setSize(500,500);
        playGame.setVisible(true);
    }
}
