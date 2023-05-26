package sokobon.views;

//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;

import javax.swing.*;

import sokobon.GameObject;
import sokobon.models.DataModel;

public class menuBarView extends JFrame {
    private JMenuBar menuBarFile;
    private DataModel dataModel;

    public menuBarView(String name) {
        setTitle(name);
        setSize(700, 700);
        // construct preComponents
        JMenu fileMenu = new JMenu("File");
        JMenuItem load_a_stateItem = new JMenuItem("Load a state");
        fileMenu.add(load_a_stateItem);
        JMenuItem save_current_stateItem = new JMenuItem("Save current state");
        fileMenu.add(save_current_stateItem);

        // construct components
        menuBarFile = new JMenuBar();
        menuBarFile.add(fileMenu);

        // adjust size and set layout
        setPreferredSize(new Dimension(904, 661));
        setLayout(null);

        // add components
        add(menuBarFile);

        // set component bounds (only needed by Absolute Positioning)
        menuBarFile.setBounds(0, 0, 200, 25);

        // // add mouse clicked listener to the load a state menu item using mouse
        // adapter
        // load_a_stateItem.addMouseListener(new MouseAdapter() {
        // public void mouseClicked(MouseEvent evt) {
        // load_a_stateItem();
        // }
        // });
        // // add mouse clicked listener to the save current state menu item using mouse
        // // adapter
        // save_current_stateItem.addMouseListener(new MouseAdapter() {
        // public void mouseClicked(MouseEvent evt) {
        // save_current_stateItem(dataModel.getData());
        // }
        // });

        // when selecting save_current_stateItem from the menu bar, the
        // save_current_stateItem method is called
        save_current_stateItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                save_current_stateItem(dataModel.getData());
            }
        });

        // when selecting load_a_stateItem from the menu bar, the load_a_stateItem
        // method is called
        load_a_stateItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                load_a_stateItem();
            }
        });
    }

    /**
     * connect to the data model
     * 
     * @param dataModel
     */
    public void setDataModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    /**
     * Saves GameObjects[][] as char[][] to a file
     * 
     * @param map GameObjects[][]
     *            return void
     */
    private void save_current_stateItem(GameObject[][] map) {
        // the current timestamp as filename in format sokobon_level_n_yymmddhhmmss
        int levelN = dataModel.getCurrnetLevel();
        String fileName = "sokobon_level_" + levelN + "_"
                + new java.text.SimpleDateFormat("yyMMddHHmmss").format(new java.util.Date()) + ".txt";

        // if path /gameStates doesn't exist, create it
        File dir = new File("gameStates");
        if (!dir.exists()) {
            dir.mkdir();
        }

        // check if file exists in /gameStates extend the filename with a number
        int i = 0;
        while (new File(fileName).exists()) {
            i++;
            fileName = fileName + i;
        }

        // append dir to filename
        fileName = "gameStates/" + fileName;

        // write char[][] to file with filewriter. write the matrix row by row without
        // comma seperation and without brackets and without spaces
        try {
            FileWriter writer = new FileWriter(fileName);
            // save the the file in dir

            // save the number of rows and cols in the first line
            writer.write(dataModel.getRows() + "," + dataModel.getCols() + "\n");
            for (int row = 0; row < dataModel.getRows(); row++) {
                for (int col = 0; col < dataModel.getCols(); col++) {
                    writer.write(map[row][col].getID());
                }
                writer.write("\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void load_a_stateItem() {
        // use JFileChooser to select a file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("gameStates"));
        // files must be .txt
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".txt") || f.isDirectory();
            }

            public String getDescription() {
                return "Text files (*.txt)";
            }
        });

        int result = fileChooser.showOpenDialog(this);

        // if result not equal to JFileChooser.APPROVE_OPTION, return
        if (result != JFileChooser.APPROVE_OPTION) {
            return;
        }
        dataModel.loadState(fileChooser.getSelectedFile().getAbsolutePath());

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sokobon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new menuBarView());
        frame.pack();
        frame.setVisible(true);
    }
}
