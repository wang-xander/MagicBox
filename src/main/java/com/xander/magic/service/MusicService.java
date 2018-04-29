package com.xander.magic.service;

import com.xander.magic.model.Album;
import com.xander.magic.model.Music;
import com.xander.magic.model.Singers;
import com.xander.magic.model.basic.Language;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class MusicService {
	public List<Music> findMusic(File dir) {
		List<Music> musicList = new ArrayList<Music>();
		if (dir != null && dir.isDirectory()) {
			this.traverseFolder(dir, musicList);
		}
		return musicList;
	}

	private void traverseFolder(File dir, List<Music> musicList) {
		if (musicList == null) {
			musicList = new ArrayList<>();
		}
		if (dir != null && dir.exists()) {
			if (dir.isDirectory()) {
				File[] fileList = dir.listFiles();
				for (File f : fileList) {
					traverseFolder(f, musicList);
				}
			} else if (dir.isFile()) {
				if (dir.getName().toLowerCase().endsWith(".mp3")) {
					musicList.add(parseMusic(dir));
				}
			}
		}
	}

	public Music parseMusic(File file) {
		Music music = new Music();
		if (file != null && file.exists() && file.isFile()) {
			music.setFile(file);
			try {
				//我这里用RandomAccessFile类来读取(输入流); "r"只读如果写"rw"就是又读又写。RandomAccessFile这个类可以跳过几个或多个字符后读取。
				RandomAccessFile in = new RandomAccessFile(file, "r");
				//因为信息在mp3最后128个字节
				byte[] b = new byte[128];
				in.seek(file.length() - 128);
				in.read(b);
				//读完后，先判断前3个字符是不是TAG 如果是下面才会有内容
				if (new String(b, 0, 3, "GBK").startsWith("TAG")) {
					//标题
					music.setName(new String(b, 3, 30, "GBK").trim());
					//艺术家
					music.setSingers(new Singers(new String(b, 33, 30, "GBK").trim()));
					//专辑名+发行年份
					music.setAlbum(new Album(new String(b, 63, 30, "GBK").trim(), "",
							new String(b, 93, 4, "GBK").trim(), Language.Null));
					//注释/附加/备注信息
					//new String(b, 97, 28, "GBK").trim());
				}
				System.out.println(file.getName());
				in.close();   //关闭输入流
			} catch (IOException ex) { ///捕获IO异常
				ex.printStackTrace();
				music.setInfo("文件元数据异常");
			}
		}
		return music;
	}
}
