package com.ztesoft.web.busiz.db.dao.mapper;

import com.ztesoft.web.busiz.db.arg.SjJobArg;
import com.ztesoft.web.busiz.db.po.SjJobPO;

import java.math.*;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ISjJobMapper {
    
    List<Integer> countByArg(SjJobArg arg);

    List<SjJobPO> selectByArg(SjJobArg arg);

    SjJobPO selectByPrimaryKey(Integer id);

    List<SjJobPO> selectByArgAndPage(SjJobArg arg, RowBounds rowBound);

    int insert(SjJobPO record);

    int insertSelective(SjJobPO record);

    int insertBatch(@Param("list") List<SjJobPO> records);

    int updateByArgSelective(@Param("record") SjJobPO record,
            @Param("arg") SjJobArg arg);

    int updateByArg(@Param("record") SjJobPO record,
            @Param("arg") SjJobArg arg);

    int updateByPrimaryKeySelective(SjJobPO record);

    int updateByPrimaryKey(SjJobPO record);
    
    int deleteByArg(SjJobArg arg);
    
    int deleteByPrimaryKey(Integer id);
    
}