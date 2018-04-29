package com.xander.magic.model;

import com.xander.magic.model.basic.Language;
import com.xander.magic.model.basic.Style;

import java.io.File;
import java.io.IOException;

public class Music {
	//{"歌曲名", "专辑", "歌手", "语言", "风格", "文件大小", "文件路径", "标签"}
	private long id = -1;
	private String name = "";
	private File file = null;
	private Album album = new Album();
	private Singers singers = new Singers();
	private Language language = Language.Null;
	private Style style = Style.Null;
	private Labels labels = new Labels();
	private String info = "";

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return file.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Singers getSingers() {
		return singers;
	}

	public void setSingers(Singers singers) {
		this.singers = singers;
	}

	public File getFile() {
		return file;
	}

	public String getFileSize() {
		return Math.floor(file.length() / 1024 / 102.4)/10.0 + "M";
	}

	public String getFilePath() {
		try {
			return file.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
			return "Failed to get file path";
		}
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public void setLanguage(String language) {
		for (Language lang : Language.values()) {
			if (lang.getLang().equals(language)) {
				this.language = lang;
			}
		}
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(String style) {
		for (Style s : Style.values()) {
			if (s.name().equals(style)) {
				this.style = s;
			}
		}
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public Labels getLabels() {
		return labels;
	}

	public void setLabels(Labels labels) {
		this.labels = labels;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}