package com.aaron.common.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Aaron on 2017/7/30.
 */
public abstract interface BaseService <T,PK extends Serializable> {
    public abstract int insert(T t);

    public abstract int update(T t);

    public abstract int updateBySelective(T t);

    public abstract void deleteById(PK id);

    public abstract void deleteByIds(PK... id);//表示不定参数,兼容deleteById(PK id)

    public abstract T selectById(PK id);

    public abstract Integer selectByMapCount(Map map);

    public abstract T selectByMap(Map map);

    public abstract List<T> selectListByMap(Map  map);

    public abstract Integer selectByModelCount(T t);

    public abstract T selectByModel(T t);

    public abstract List<T> selectListByModel(T t);
}

