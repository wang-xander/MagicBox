package com.xander.magic.ui;

import javax.swing.*;
import java.awt.*;

public class Id3Editor extends JPanel {

    private double labelWeight = 0.2;
    private double textWeight = 0.8;
    private double rowHeight=0.25;
    private JLabel musicNameLabel = new JLabel("歌曲名");
    private JTextField musicNameText = new JTextField(40);
    private JLabel albumNameLabel  = new JLabel("专辑");
    private JTextField albumNameText = new JTextField(40);
    private JLabel singerLabel = new JLabel("歌手");
    private JTextField singerText = new JTextField(40);
    private JLabel yearLabel = new JLabel("年份");
    private JTextField yearText = new JTextField(40);

    public Id3Editor(){
        super();
        this.setLayout(new GridBagLayout());
        this.add(musicNameLabel,
                new GridBagConstraints(0, 0, 1, 1, labelWeight, rowHeight, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                        new Insets(10, 10, 10, 10), 5, 5));
        this.add(musicNameText,
                new GridBagConstraints(1, 0, 1, 1, textWeight, rowHeight, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                        new Insets(10, 10, 10, 10), 5, 5));
        this.add(albumNameLabel,
                new GridBagConstraints(0, 1, 1, 1, labelWeight, rowHeight, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                        new Insets(10, 10, 10, 10), 5, 5));
        this.add(albumNameText,
                new GridBagConstraints(1, 1, 1, 1, textWeight, rowHeight, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                        new Insets(10, 10, 10, 10), 5, 5));
        this.add(singerLabel,
                new GridBagConstraints(0, 2, 1, 1, labelWeight, rowHeight, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                        new Insets(10, 10, 10, 10), 5, 5));
        this.add(singerText,
                new GridBagConstraints(1, 2, 1, 1, textWeight, rowHeight, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                        new Insets(10, 10, 10, 10), 5, 5));
        this.add(yearLabel,
                new GridBagConstraints(0, 3, 1, 1, labelWeight, rowHeight, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                        new Insets(10, 10, 10, 10), 5, 5));
        this.add(yearText,
                new GridBagConstraints(1, 3, 1, 1, textWeight, rowHeight, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                        new Insets(10, 10, 10, 10), 5, 5));

    }
}
