package com.xander.magic.dao.impl;

import com.xander.magic.dao.MusicDAO;
import com.xander.magic.model.Music;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MusicSqliteDAOImpl implements MusicDAO {
	private Connection connection;

	public MusicSqliteDAOImpl() {

	}

	public List<Music> loadMusicList(String dir) throws Exception {
		try {
			this.connection = SQLiteManager.getConnection();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			this.connection.close();
			this.connection = null;
		}
	}

}
