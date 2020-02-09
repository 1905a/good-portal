package com.fh.mapper;

import com.fh.model.Area;
import com.fh.model.Good;
import com.fh.model.GoodQuery;

import java.util.List;

public interface GoodMapper {
    Long selectGoodListCount(GoodQuery goodQuery);

    List<Good> selectGoodList(GoodQuery goodQuery);

    void addGood(Good good);

    Good toUpdateGood(Integer id);

    void updateGood(Good good);

    void deleteGood(Integer id);

    List<Area> queryAreaByPid(int pid);

    void updateGood2(Good good);
}
