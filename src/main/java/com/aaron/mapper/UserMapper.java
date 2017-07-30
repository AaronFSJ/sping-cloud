package com.aaron.mapper;

import com.aaron.common.base.BaseMapper;
import com.aaron.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by Aaron on 2017/7/22.
 */
@Mapper
public interface UserMapper extends BaseMapper<User,Long>{

}
