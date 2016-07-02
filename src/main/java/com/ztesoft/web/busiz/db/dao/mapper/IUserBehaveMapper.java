package com.ztesoft.web.busiz.db.dao.mapper;

import com.ztesoft.web.busiz.db.arg.UserBehaveArg;
import com.ztesoft.web.busiz.db.po.UserBehavePO;

import java.math.*;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface IUserBehaveMapper {
    
    List<Integer> countByArg(UserBehaveArg arg);

    List<UserBehavePO> selectByArg(UserBehaveArg arg);

    UserBehavePO selectByPrimaryKey(Integer id);

    List<UserBehavePO> selectByArgAndPage(UserBehaveArg arg, RowBounds rowBound);

    int insert(UserBehavePO record);

    int insertSelective(UserBehavePO record);

    int insertBatch(@Param("list") List<UserBehavePO> records);

    int updateByArgSelective(@Param("record") UserBehavePO record,
            @Param("arg") UserBehaveArg arg);

    int updateByArg(@Param("record") UserBehavePO record,
            @Param("arg") UserBehaveArg arg);

    int updateByPrimaryKeySelective(UserBehavePO record);

    int updateByPrimaryKey(UserBehavePO record);
    
    int deleteByArg(UserBehaveArg arg);
    
    int deleteByPrimaryKey(Integer id);
    
}