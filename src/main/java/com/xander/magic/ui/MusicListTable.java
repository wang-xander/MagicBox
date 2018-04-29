package com.xander.magic.ui;

import com.xander.magic.model.Labels;
import com.xander.magic.model.Music;
import com.xander.magic.model.Singers;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class MusicListTable extends JTable {

	private MusicTableModel model;

	public MusicListTable(List<Music> musicList) {
		super();
		this.model = new MusicTableModel(musicList);
		this.setModel(model);
		this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumnModel columnModel = this.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(150);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(80);
		columnModel.getColumn(3).setPreferredWidth(100);
		columnModel.getColumn(4).setPreferredWidth(60);
		columnModel.getColumn(5).setPreferredWidth(60);
		columnModel.getColumn(6).setPreferredWidth(80);
		columnModel.getColumn(7).setPreferredWidth(60);
		columnModel.getColumn(8).setPreferredWidth(200);
	}

	public void init(List<Music> musicList) {
		if (musicList == null) {
			this.model.setMusicList(new ArrayList<Music>());
		} else {
			this.model.setMusicList(musicList);
		}
		this.model.fireTableDataChanged();
	}

	public class MusicTableModel extends AbstractTableModel {

		private List<Music> musicList;
		private String[] columns = {"文件名", "歌名", "专辑", "歌手", "语言", "风格", "标签", "文件大小", "文件路径"};

		public List<Music> getMusicList() {
			return musicList;
		}

		public void setMusicList(List<Music> musicList) {
			this.musicList = musicList;
		}

		public String[] getColumns() {
			return columns;
		}

		public void setColumns(String[] columns) {
			this.columns = columns;
		}

		public MusicTableModel() {
			this.musicList = new ArrayList<Music>();
		}

		public MusicTableModel(List<Music> musicList) {
			this();
			this.musicList.addAll(musicList);
		}

		public int getRowCount() {
			return musicList.size();
		}

		public int getColumnCount() {
			return columns.length;
		}

		public String getColumnName(int columnIndex) {
			return columns[columnIndex];
		}

		public Class<?> getColumnClass(int columnIndex) {
			return String.class;
		}

		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			Music music = this.musicList.get(rowIndex);
			if (columnIndex == 0) {
				return music.getFileName();
			} else if (columnIndex == 1) {
				return music.getName();
			} else if (columnIndex == 2) {
				return music.getAlbum();
			} else if (columnIndex == 3) {
				return music.getSingers().toString();
			} else if (columnIndex == 4) {
				return music.getLanguage();
			} else if (columnIndex == 5) {
				return music.getLabels().toString();
			} else if (columnIndex == 6) {
				return music.getStyle();
			} else if (columnIndex == 7) {
				return music.getFileSize();
			} else if (columnIndex == 8) {
				return music.getFilePath();
			}
			return "";
		}

		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			Music music = this.musicList.get(rowIndex);
			if (columnIndex == 1) {
				music.setName(aValue.toString());
			} else if (columnIndex == 2) {
				music.getAlbum().setName(aValue.toString());
			} else if (columnIndex == 3) {
				music.getAlbum().setSingers(new Singers(aValue.toString()));
			} else if (columnIndex == 4) {
				music.setLanguage(aValue.toString());
			} else if (columnIndex == 5) {
				music.setStyle(aValue.toString());
			} else if (columnIndex == 6) {
				music.setLabels(new Labels(aValue.toString()));
			}
		}
	}

}