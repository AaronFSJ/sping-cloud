package com.aaron.common.base;

import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Aaron on 2017/7/29.
 */
public interface BaseMapper<T,PK extends Serializable> {
    public int insert(T t);

    public int update(T t);

    public int updateBySelective(T t);

    public void deleteById(PK id);

    public void deleteByIds(PK... id);//表示不定参数,兼容deleteById(PK id)

    public T selectById(PK id);

    public Integer selectByMapCount(Map map);

    public T selectByMap(Map map);

    public List<T> selectListByMap(Map  map);

    public Integer selectByModelCount(T t);

    public T selectByModel(T t);

    public List<T> selectListByModel(T t);
}
