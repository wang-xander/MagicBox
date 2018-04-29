package com.xander.magic.dao;

import com.xander.magic.dao.impl.SingerJsonDAOImpl;
import com.xander.magic.model.Singer;

import java.util.List;

public interface SingerDAO {

default SingerDAO getInstance(){
    return new SingerJsonDAOImpl();
}

    public List<Singer> loadSingerList();

}
