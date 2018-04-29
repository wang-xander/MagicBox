package com.xander.magic.ui;

import com.xander.magic.model.Music;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MusicPlayerBoard extends JPanel {
	private static Music currentPlaying;
	private JButton playButton = new JButton("Play");
	private JButton stopButton = new JButton("Stop");
	private JButton pauseButton = new JButton("Pause");
	private JButton ffButton = new JButton("Forward");
	private JButton nextButton = new JButton("Next");
	private JProgressBar processBar = new JProgressBar();
	private FileInputStream musicIS;
	private AdvancedPlayer player;
	private boolean isPlaying = false;
	private long musicLength = 0; //按字节算
	private long musicStopAt = 0; //按字节算

	public static Music getCurrentMusic() {
		return currentPlaying;
	}

	public static void setCurrentMusic(Music goingToPlay) {
		currentPlaying = goingToPlay;
	}

	//	private
	public MusicPlayerBoard() {
		super();
		this.playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentPlaying == null) {
					return;
				}
				try {
					musicIS = new FileInputStream(currentPlaying.getFile());
					player = new AdvancedPlayer(musicIS);
					player.play();
					musicLength = currentPlaying.getFile().length();
					isPlaying = true;
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
					isPlaying = false;
				} catch (JavaLayerException e1) {
					e1.printStackTrace();
					isPlaying = false;
				}
			}
		});
		this.pauseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		this.setLayout(new GridBagLayout());
		this.add(processBar,
				new GridBagConstraints(0, 0, 5, 1, 1, 0.3, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(10, 10, 10, 10), 5, 5));
		this.add(stopButton,
				new GridBagConstraints(0, 1, 1, 1, 0.2, 0.7, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(10, 10, 10, 10), 5, 5));
		this.add(playButton,
				new GridBagConstraints(1, 1, 1, 1, 0.2, 0.7, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(10, 10, 10, 10), 5, 5));
		this.add(pauseButton,
				new GridBagConstraints(2, 1, 1, 1, 0.2, 0.7, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(10, 10, 10, 10), 5, 5));
		this.add(ffButton,
				new GridBagConstraints(3, 1, 1, 1, 0.2, 0.7, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(10, 10, 10, 10), 5, 5));
		this.add(nextButton,
				new GridBagConstraints(4, 1, 1, 1, 0.2, 0.7, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(10, 10, 10, 10), 5, 5));

	}

	public static void main(String[] a) {
		try {
			BufferedInputStream buffer =
					new BufferedInputStream(new FileInputStream("F:\\Music\\Songs\\Adele - Rolling In The Deep.mp3"));
			buffer.skip(1000000);
			System.out.println(buffer.available());
			AdvancedPlayer player = new AdvancedPlayer(buffer);
			player.play(1111111111);
//			TimeUnit.SECONDS.timedWait(new Object(), 10);
			player.stop();
			System.out.println(buffer.available());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JavaLayerException e) {
			e.printStackTrace();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
	}
}
