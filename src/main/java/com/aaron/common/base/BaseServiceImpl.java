package com.aaron.common.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Aaron on 2017/7/30.
 */
public class BaseServiceImpl<T,PK extends Serializable> {
    @Autowired
    private BaseMapper<T,PK> mapper;

    public int insert(T t){
        return mapper.insert(t);
    }

    public int update(T t){
        return mapper.update(t);
    }

    public int updateBySelective(T t){
        return mapper.updateBySelective(t);
    }

    public void deleteById(PK id){
        mapper.deleteById(id);
    }

    //表示不定参数,兼容deleteById(PK id)
    public void deleteByIds(PK... id){
        mapper.deleteByIds(id);
    }

    public T selectById(PK id){
        return mapper.selectById(id);
    }

    public Integer selectByMapCount(Map map){
        return mapper.selectByMapCount(map);
    }

    public T selectByMap(Map map){
        return mapper.selectByMap(map);
    }

    public List<T> selectListByMap(Map  map){
        return mapper.selectListByMap(map);
    }

    public Integer selectByModelCount(T t){
        return mapper.selectByModelCount(t);
    }

    public T selectByModel(T t){
        return mapper.selectByModel(t);
    }

    public List<T> selectListByModel(T t){
        return mapper.selectListByModel(t);
    }

}
