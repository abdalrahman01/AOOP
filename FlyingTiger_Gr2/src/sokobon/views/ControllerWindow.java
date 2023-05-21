package sokobon.views;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!



public class ControllerWindow extends JPanel {
    private JButton buttonUP;
    private JButton buttonLEFT;
    private JButton buttonDOWN;
    private JButton buttonRIGHT;
    private JButton pullButton;
    private JLabel jcomp5;
    private JLabel jcomp6;
    private JLabel jcomp7;
    private JLabel jcomp8;
    private JLabel jcomp9;
    private JMenuBar menu;
    
   

    private static final File ICON_UP = new File("src/sokobon/resources/imgs/sokoban_icons/UP.png");
    private static final File ICON_DOWN = new File("src/sokobon/resources/imgs/sokoban_icons/DOWN.png");
    private static final File ICON_LEFT = new File("src/sokobon/resources/imgs/sokoban_icons/LEFT.png");
    private static final File ICON_RIGHT = new File("src/sokobon/resources/imgs/sokoban_icons/RIGHT.png");

    private GameMap gameMap;

    
    private boolean isPullMode;
    public ControllerWindow() {
        // construct preComponents
        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Save");
        fileMenu.add(saveItem);
        isPullMode = false; 
        // construct components
        buttonUP = new JButton("Up");
        buttonLEFT = new JButton("left");
        buttonDOWN = new JButton("down");
        buttonRIGHT = new JButton("right");
        pullButton = new JButton("Pull");
        jcomp5 = new JLabel("Press and hold [space] to PULL");
        jcomp6 = new JLabel("Press [Right Arrow] to move right");
        jcomp7 = new JLabel("Press [Left Arrow] to move left");
        jcomp8 = new JLabel("Press [Right Arrow] to move up");
        jcomp9 = new JLabel("Press [Right Arrow] to move down");
        menu = new JMenuBar();
        menu.add(fileMenu);

        // adjust size and set layout
        setPreferredSize(new Dimension(632, 360));
        setLayout(null);
        setDesignButton(buttonDOWN, ICON_DOWN, 70, 100);
        setDesignButton(buttonUP, ICON_UP, 70, 100);
        setDesignButton(buttonRIGHT, ICON_RIGHT, 100, 70);
        setDesignButton(buttonLEFT, ICON_LEFT, 100, 70);

        // add components
        add(buttonUP);
        add(buttonLEFT);
        add(buttonDOWN);
        add(buttonRIGHT);
        add(pullButton);
        add(jcomp5);
        add(jcomp6);
        add(jcomp7);
        add(jcomp8);
        add(jcomp9);
        add(menu);

        // set component bounds (only needed by Absolute Positioning)
        buttonLEFT.setBounds (0, 110, 85, 55);
        buttonUP.setBounds (85, 25, 55, 85);
        buttonRIGHT.setBounds (140, 110, 85, 55);
        buttonDOWN.setBounds (85, 165, 55, 85);
        pullButton.setBounds (45, 260, 140, 30);
        jcomp5.setBounds(335, 245, 200, 25);
        jcomp6.setBounds(335, 135, 205, 25);
        jcomp7.setBounds(335, 150, 200, 25);
        jcomp8.setBounds(335, 170, 195, 25);
        jcomp9.setBounds(335, 190, 200, 20);
        menu.setBounds(0, 0, 200, 25);

        addClickedListners();
    }

    public void attachGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    private void addClickedListners() {
        buttonDOWN.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	if (isPullMode)
            		gameMap.player.moveDownAndPull();
            	else
            		gameMap.player.moveDown();
                }
        });
        buttonUP.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	if (isPullMode)
            		gameMap.player.moveUpAndPull();
            	else
            		gameMap.player.moveUp();


            }
        });
        buttonLEFT.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	if (isPullMode)
            		gameMap.player.moveLeftAndPull();
            	else
            		gameMap.player.moveLeft();
           

            }
        });
        buttonRIGHT.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	if (isPullMode)
            		gameMap.player.moveRightAndPull();
            	else 
            		gameMap.player.moveRight();
                	 
            }
        });
        pullButton.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		isPullMode = !isPullMode;
        		if (isPullMode)
        			pullButton.setText("Pull Mode: ON");
        		else 
        			pullButton.setText("Pull Mode: OFF");
        	}
        });
        
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Game Controller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ControllerWindow());
        frame.pack();
        frame.setVisible(true);
    }

    private void setDesignButton(JButton button, File imageIconFile, int width, int height) {
        try {
            BufferedImage mainImage = ImageIO.read(imageIconFile);
            BufferedImage resizeImage = new BufferedImage(width, height, mainImage.getType());
            Graphics2D graph = resizeImage.createGraphics();
            graph.drawImage(mainImage, 0, 0, width, height, null);
            graph.dispose();
            ImageIcon icon = new ImageIcon(resizeImage);
            button.setIcon(icon);
            button.setPreferredSize(new Dimension(width, height));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
