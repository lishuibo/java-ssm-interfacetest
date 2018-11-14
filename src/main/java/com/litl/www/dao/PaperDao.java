package com.litl.www.dao;

import com.litl.www.pojo.Paper;

import java.util.List;

public interface PaperDao {
    int addPaper(Paper paper);

    int deletePaperById(int id);

    int updatePaper(Paper paper);

    Paper queryById(int id);

    List<Paper> queryAllPaper();
}
