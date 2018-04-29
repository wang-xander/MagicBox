package com.xander.magic.ui;

import javax.swing.*;
import java.awt.*;

public class FileActionBoard extends JPanel {
    private JButton deleteButton = new JButton("刪除文件");
    private JButton formatNameButton = new JButton("格式化文件");
    private JButton moveFileButton = new JButton("移动文件");

    public FileActionBoard() {
        super();
        this.setLayout(new GridBagLayout());
        this.add(formatNameButton,
                new GridBagConstraints(0, 0, 1, 1, 0.3, 1, GridBagConstraints.WEST, GridBagConstraints.NONE,
                        new Insets(10, 10, 10, 10), 5, 5));
        this.add(moveFileButton,
                new GridBagConstraints(1, 0, 1, 1, 0.3, 1, GridBagConstraints.WEST, GridBagConstraints.NONE,
                        new Insets(10, 10, 10, 10), 5, 5));
        this.add(deleteButton,
                new GridBagConstraints(2, 0, 1, 1, 0.3, 1, GridBagConstraints.WEST, GridBagConstraints.NONE,
                        new Insets(10, 10, 10, 10), 5, 5));
    }
}
