package com.ztesoft.web.sys.db.dao.mapper;

import com.ztesoft.web.sys.db.arg.SysCityArg;
import com.ztesoft.web.sys.db.po.SysCityPO;

import java.math.*;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ISysCityMapper {
    
    List<Integer> countByArg(SysCityArg arg);

    List<SysCityPO> selectByArg(SysCityArg arg);

    SysCityPO selectByPrimaryKey(Integer id);

    List<SysCityPO> selectByArgAndPage(SysCityArg arg, RowBounds rowBound);

    int insert(SysCityPO record);

    int insertSelective(SysCityPO record);

    int insertBatch(@Param("list") List<SysCityPO> records);

    int updateByArgSelective(@Param("record") SysCityPO record,
            @Param("arg") SysCityArg arg);

    int updateByArg(@Param("record") SysCityPO record,
            @Param("arg") SysCityArg arg);

    int updateByPrimaryKeySelective(SysCityPO record);

    int updateByPrimaryKey(SysCityPO record);
    
    int deleteByArg(SysCityArg arg);
    
    int deleteByPrimaryKey(Integer id);
    
}