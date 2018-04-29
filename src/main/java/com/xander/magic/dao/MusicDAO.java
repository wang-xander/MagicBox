package com.xander.magic.dao;

import com.xander.magic.dao.impl.MusicSqliteDAOImpl;
import com.xander.magic.model.Music;

import java.util.List;

public interface MusicDAO {
	static MusicDAO getInstance() {
		return new MusicSqliteDAOImpl();
	}

	public List<Music> loadMusicList(String dir) throws Exception;

}
