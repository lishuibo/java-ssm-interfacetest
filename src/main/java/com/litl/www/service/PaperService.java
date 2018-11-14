package com.litl.www.service;

import com.litl.www.pojo.Paper;

import java.util.List;

public interface PaperService {
    int addPaper(Paper paper);

    int deletePaperById(int id);

    int updatePaper(Paper paper);

    Paper queryById(int id);

    List<Paper> queryAllPaper();
}
