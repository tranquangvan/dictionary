package Dictionary2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMainMenu extends JFrame {

    public FrameMainMenu() throws Exception {
        super("Dictionary");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar mb = new JMenuBar();
        mb.add(Box.createRigidArea(new Dimension(100,50)));
        // create menu
        JMenu menuDictionary = new JMenu("DictionaryMenu");
        menuDictionary.setPreferredSize(new Dimension(100,50));
        mb.add(menuDictionary);
        mb.setBackground(Color.cyan);
        menuDictionary.setBackground(Color.cyan);
        // options in Dictionary Menu
        JMenuItem option = new JMenuItem("Add Word...");
        ImageIcon iconAdd = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\edit.gif");
        option.setIcon(iconAdd);
        option.setAccelerator( KeyStroke.getKeyStroke("F5"));
        menuDictionary.add(option);
        option.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWord();
            }
        });

        // options in Dictionary Menu
        option = new JMenuItem("Delete Word...");
        ImageIcon iconDelete = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\delete.gif");
        option.setIcon(iconDelete);
        option.setAccelerator( KeyStroke.getKeyStroke("F6"));
        menuDictionary.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                deleteWord();
            }
        });

//        mnuDictionary.addSeparator();

        // options in Dictionary Menu
        option = new JMenuItem("Search Word...");
        ImageIcon iconSearch = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\search-icon2.gif");
        option.setIcon(iconSearch);
        option.setAccelerator( KeyStroke.getKeyStroke("F7"));
        menuDictionary.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                searchWord();
            }
        });


        option = new JMenuItem("List Words");
        ImageIcon iconList = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\list.gif");
        option.setIcon( iconList);
        option.setAccelerator( KeyStroke.getKeyStroke("F8"));
        menuDictionary.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listWords();
            }
        });
        option = new JMenuItem("Play Games");
        ImageIcon iconPlayGame = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\anhgame.gif");
        option.setIcon( iconPlayGame);
        option.setAccelerator( KeyStroke.getKeyStroke("F1"));
        menuDictionary.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                playGame();
            }
        });


         option = new JMenuItem("Save Dictionary");
        ImageIcon iconSave = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\save.gif");
        option.setIcon(iconSave);
        option.setAccelerator( KeyStroke.getKeyStroke("F2"));
        menuDictionary.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean result = Dictionary.saveToDisk();
                if (result) {
                    JOptionPane.showMessageDialog(FrameMainMenu.this, "Saved Dictionary Successfully!", "Feedback",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(FrameMainMenu.this, "Could Not Save Dictionary Successfully! Error --> " + Dictionary.getMessage(), "Feedback",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        option = new JMenuItem("Load Dictionary");
        ImageIcon iconLoad = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\load.gif");
        option.setIcon(iconLoad);
        option.setAccelerator( KeyStroke.getKeyStroke("F3"));
        menuDictionary.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean result = Dictionary.loadFromDisk();
                if (result) {
                    JOptionPane.showMessageDialog(FrameMainMenu.this, "Loaded Dictionary Successfully!", "Feedback",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(FrameMainMenu.this, "Could Not Load Dictionary Successfully! Error --> " + Dictionary.getMessage(), "Feedback",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
//        mnuDictionary.addSeparator();

        option = new JMenuItem("Exit");
        menuDictionary.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });


        addToolbar();
        setJMenuBar(mb);

        // load dictionary from disk
        Dictionary.loadFromDisk();

    }

    public void exit() {
        if (Dictionary.isModified()) {
            int option = JOptionPane.showConfirmDialog(FrameMainMenu.this, "You have some pending changes. Do you want to write them to disk and then exit?",
                    "Save", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {  // exit after save
                Dictionary.saveToDisk();
                System.exit(0);
            }
            else if (option == JOptionPane.NO_OPTION) // exit without saving
            {
                System.exit(0);
            }
            // if cancel then do not exit
        } else {
            System.exit(0);
        }
    }



    public void centerToParent(JFrame parent, JFrame child) {
        Dimension pd = parent.getSize();
        Dimension cd = child.getSize();
        int x = (int) (pd.getWidth() - cd.getWidth()) / 2;
        int y = (int) (pd.getHeight() - cd.getHeight()) / 2;
        child.setLocation(x, y);

    }

    public void addWord() {
        FunctionAdd w = new FunctionAdd();
        centerToParent(FrameMainMenu.this, w);
        w.setVisible(true);
    }

    public void deleteWord() {
        FunctionDelete w = new FunctionDelete();
        centerToParent(FrameMainMenu.this, w);
        w.setVisible(true);
    }

    public void searchWord() {
        FunctionSearch w = new FunctionSearch();
        centerToParent(FrameMainMenu.this, w);
        w.setVisible(true);
    }

    public void listWords() {
        ListWords w = new ListWords();

        w.setVisible(true);
        centerToParent(FrameMainMenu.this, w);
    }
    public void playGame() {
        PlayGame w = new PlayGame("Play Game");
        w.setVisible(true);
        centerToParent(FrameMainMenu.this, w);
    }


    public void addToolbar() {
        JToolBar tb = new JToolBar();
        ImageIcon iconAdd = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\edit.gif");
        JButton b = new JButton();
        b.setPreferredSize( new Dimension(80,80));
        tb.setBackground(Color.lightGray);
        tb.add(b);
        b.setBackground(Color.yellow);
        b.setToolTipText("Add Word");
        b.setIcon(iconAdd);
        b.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWord();
            }

        });
        ImageIcon iconDelete = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\delete.gif");
        b = new JButton();
        b.setIcon(iconDelete);
        b.setBackground(Color.yellow);
        b.setPreferredSize( new Dimension(80,80));
        tb.add(b);
        b.setToolTipText("Delete Word");
        b.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteWord();
            }

        });
        ImageIcon iconPlayGame = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\anhgame.gif");
        b = new JButton();
        b.setBackground(Color.yellow);
        b.setIcon(iconPlayGame);
        b.setPreferredSize( new Dimension(80,80));
        tb.add(b);
        b.setToolTipText("Play Games");
        b.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame();
            }

        });

        ImageIcon iconSearch = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\search-icon2.gif");
        b = new JButton();
        b.setIcon(iconSearch);
        b.setBackground(Color.yellow);
        b.setPreferredSize( new Dimension(80,80));
        tb.add(b);
        b.setToolTipText("Search Word");
        b.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchWord();
            }

        });


        b = new JButton();
        b.setBackground(Color.yellow);
        ImageIcon iconList = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\list.gif");
        b.setIcon( iconList);
        tb.add(b);
        b.setToolTipText("List Words");
        b.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listWords();
            }

        });

        tb.addSeparator();

        b = new JButton();
        b.setBackground(Color.yellow);
        ImageIcon iconSave = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\save.gif");
        tb.add(b);
        b.setIcon(iconSave);
        b.setToolTipText("Save Dictionary To Disk");
        b.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dictionary.saveToDisk();
            }

        });
         JLabel headerLabel= new JLabel("", JLabel.CENTER);

        ImageIcon iconAvatar = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\dictionary3.gif");
        headerLabel.setIcon(iconAvatar);
        getContentPane().add(headerLabel);
        getContentPane().add(tb, BorderLayout.NORTH);
        getContentPane().setBackground(Color.lightGray);
    }


    public static void main(String[] args) throws Exception {
        FrameMainMenu f = new FrameMainMenu();
        f.setVisible(true);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
