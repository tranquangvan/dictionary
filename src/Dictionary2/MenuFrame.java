package Dictionary2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame {

    public MenuFrame() throws Exception {
        super("Dictionary");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar mb = new JMenuBar();
        // create menu
        JMenu mnuDictionary = new JMenu("Dictionary");
        mb.add(mnuDictionary);

        // options in Dictionary Menu
        JMenuItem option = new JMenuItem("Add Word...");
        ImageIcon iconAdd = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\edit.gif");
        option.setIcon(iconAdd);
        option.setAccelerator( KeyStroke.getKeyStroke("F5"));
        mnuDictionary.add(option);
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
        mnuDictionary.add(option);
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
        mnuDictionary.add(option);
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
        mnuDictionary.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listWords();
            }
        });
        option = new JMenuItem("Play Games");
        ImageIcon iconPlayGame = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\anhgame.gif");
        option.setIcon( iconPlayGame);
        option.setAccelerator( KeyStroke.getKeyStroke("F8"));
        mnuDictionary.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                playGame();
            }
        });


//        mnuDictionary.addSeparator();

        option = new JMenuItem("Exit");
        mnuDictionary.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });

        addStorageMenu(mb);
        addToolbar();
        setJMenuBar(mb);

        // load dictionary from disk
        Dictionary.loadFromDisk();

    }

    public void exit() {
        if (Dictionary.isModified()) {
            int option = JOptionPane.showConfirmDialog(MenuFrame.this, "You have some pending changes. Do you want to write them to disk and then exit?",
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
        AddWord w = new AddWord();
        centerToParent(MenuFrame.this, w);
        w.setVisible(true);
    }

    public void deleteWord() {
        DeleteWord w = new DeleteWord();
        centerToParent(MenuFrame.this, w);
        w.setVisible(true);
    }

    public void searchWord() {
        SearchWord w = new SearchWord();
        centerToParent(MenuFrame.this, w);
        w.setVisible(true);
    }

    public void listWords() {
        ListWords w = new ListWords();
        w.setVisible(true);
        centerToParent(MenuFrame.this, w);
    }
    public void playGame() {
        PlayGame w = new PlayGame("Play Game");
        w.setVisible(true);
        centerToParent(MenuFrame.this, w);
    }


    public void addToolbar() {
        JToolBar tb = new JToolBar();
        ImageIcon iconAdd = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\edit.gif");
        JButton b = new JButton();
        b.setPreferredSize( new Dimension(80,80));
        tb.add(b);
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

        b = new JButton();
        ImageIcon iconLoad = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\load.gif");
        tb.add(b);
        b.setIcon(iconLoad);
        b.setToolTipText("Load Dictionary From Disk");
        b.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dictionary.loadFromDisk();
            }

        });

        getContentPane().add(tb, BorderLayout.NORTH);
    }

    public void addStorageMenu(JMenuBar mb) {

        JMenu mnuStorage = new JMenu("Storage");

        // options in Storage Menu

        JMenuItem option = new JMenuItem("Save Dictionary");
        ImageIcon iconSave = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\save.gif");
        option.setIcon(iconSave);
        option.setAccelerator( KeyStroke.getKeyStroke("F2"));
        mnuStorage.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean result = Dictionary.saveToDisk();
                if (result) {
                    JOptionPane.showMessageDialog(MenuFrame.this, "Saved Dictionary Successfully!", "Feedback",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(MenuFrame.this, "Could Not Save Dictionary Successfully! Error --> " + Dictionary.getMessage(), "Feedback",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        option = new JMenuItem("Load Dictionary");
        ImageIcon iconLoad = new ImageIcon("C:\\Users\\Huy Coc\\Pictures\\load.gif");
        option.setIcon(iconLoad);
        option.setAccelerator( KeyStroke.getKeyStroke("F3"));
        mnuStorage.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean result = Dictionary.loadFromDisk();
                if (result) {
                    JOptionPane.showMessageDialog(MenuFrame.this, "Loaded Dictionary Successfully!", "Feedback",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(MenuFrame.this, "Could Not Load Dictionary Successfully! Error --> " + Dictionary.getMessage(), "Feedback",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        mb.add(mnuStorage);
    }
    public static void main(String[] args) throws Exception {
        MenuFrame f = new MenuFrame();
        f.setVisible(true);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }
}
