package com.aaron.mapper;

import com.aaron.common.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Aaron on 2017/7/22.
 */
@Mapper
public interface UserMapper<User> extends BaseMapper<User,Long>{

    public List<User> getAll();

}
