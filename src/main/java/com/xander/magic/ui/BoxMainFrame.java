package com.xander.magic.ui;

import com.xander.magic.model.Music;
import com.xander.magic.service.MusicService;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class BoxMainFrame extends JFrame {
    private MusicListTable musicListTable;
    private JScrollPane musicListScrollPane;
    private MusicPlayerBoard player = new MusicPlayerBoard();
    private DuplicateListTable duplicateListTable = new DuplicateListTable();
    private JScrollPane duplicateListScrollPane;

    private FileActionBoard fileActionBoard = new FileActionBoard();
    private Id3Editor id3Editor = new Id3Editor();
    private ArrayList<Music> musicList;

    public BoxMainFrame() {
        super();
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.setLocation(30, 30);
        Image icon = Toolkit.getDefaultToolkit().getImage("pencil.png");
        this.setIconImage(icon);
        this.setTitle("Magical Box");
        this.setLayout(new GridBagLayout());

        this.musicListTable = new MusicListTable(new ArrayList<Music>());
        this.musicListScrollPane = new JScrollPane(musicListTable);
        this.musicListScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.musicListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.duplicateListScrollPane = new JScrollPane(duplicateListTable);
        this.duplicateListScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.duplicateListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(musicListScrollPane,
                new GridBagConstraints(0, 0, 1, 4, 0.7, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(10, 10, 10, 10), 5, 5));
        this.add(id3Editor,
                new GridBagConstraints(1, 0, 1, 1, 0.3, 0.4, GridBagConstraints.WEST, GridBagConstraints.NONE,
                        new Insets(10, 10, 10, 10), 5, 5));
        this.add(player,
                new GridBagConstraints(1, 1, 1, 1, 0.3, 0.1, GridBagConstraints.WEST, GridBagConstraints.NONE,
                        new Insets(10, 10, 10, 10), 5, 5));
        this.add(fileActionBoard,
                new GridBagConstraints(1, 2, 1, 1, 0.3, 0.1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(10, 10, 10, 10), 5, 5));
        this.add(duplicateListScrollPane,
                new GridBagConstraints(1, 3, 1, 1, 0.3, 0.4, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                        new Insets(10, 10, 10, 10), 5, 5));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		this.setResizable(false);
        this.setVisible(true);
    }

    public void initialize() {
        this.loadMusic();
        this.musicListTable.init(this.musicList);
    }

    private void loadMusic() {
        try {
            this.musicList = new ArrayList<Music>();
            InputStream propertiesIS = BoxMainFrame.class.getResourceAsStream("/config.properties");
            Properties properties = new Properties();
            properties.load(propertiesIS);
            String musicDir = properties.getProperty("magicalbox.music.dirs");
            MusicService musicService = new MusicService();
            String[] dirs = musicDir.split(";");
            for (String dir : dirs) {
                if (dir != null && !dir.equals("")) {
                    File dirFile = new File(dir);
                    if (dirFile.exists() && dirFile.isDirectory()) {
                        this.musicList.addAll(musicService.findMusic(dirFile));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static void main(String[] a) {
        BoxMainFrame mainFrame = new BoxMainFrame();
        mainFrame.initialize();
    }
}
