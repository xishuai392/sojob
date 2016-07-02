package com.ztesoft.web.busiz.db.dao;

import java.lang.reflect.Method;
import java.math.*;
import java.util.*;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.SysRuntimeException;
import com.ztesoft.framework.util.StringUtils;

import com.ztesoft.web.busiz.db.arg.SjJobArg;
import com.ztesoft.web.busiz.db.arg.SjJobArg.SjJobCriteria;
import com.ztesoft.web.busiz.db.dao.mapper.ISjJobMapper;
import com.ztesoft.web.busiz.db.po.SjJobPO;

@Repository
public class SjJobDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<Integer> countByArg(SjJobArg arg) {
        return getMapper().countByArg(arg);
    }

    public int deleteByArg(SjJobArg arg) {
        return getMapper().deleteByArg(arg);
    }

    public List<SjJobPO> selectByArg(SjJobArg arg) {
        return getMapper().selectByArg(arg);
    }

    public int updateByArgSelective(SjJobPO record, SjJobArg arg) {
        return getMapper().updateByArgSelective(record, arg);
    }

    public int updateByArg(SjJobPO record, SjJobArg arg) {
        return getMapper().updateByArg(record, arg);
    }

    public Page<SjJobPO> selectByArgAndPage(SjJobArg arg,
            Page<SjJobPO> resultPage) {
        List<SjJobPO> resultList = getMapper().selectByArgAndPage(arg,
                resultPage);
        resultPage.setResultList(resultList);
        return resultPage;
    }

    public int insert(SjJobPO record) {
        return getMapper().insert(record);
    }

    public int insertSelective(SjJobPO record) {
        return getMapper().insertSelective(record);
    }

    public int insertBatch(List<SjJobPO> records) {
        return getMapper().insertBatch(records);
    }

    public int deleteByPrimaryKey(Integer key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    public SjJobPO selectByPrimaryKey(Integer key) {
        return getMapper().selectByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(SjJobPO record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SjJobPO record) {
        return getMapper().updateByPrimaryKey(record);
    }

    /**
     * 根据传入的Map条件进行查询，当前仅支持所有Map中Key字段的EqualTo查询
     * @param params Map,Key=字段名，value=查询值
     * @return
     */
    public List<SjJobPO> selectByMap(Map<String, Object> params) {
        return (selectByArg(buildQueryObject(params)));
    }

    private SjJobArg buildQueryObject(Map<String, Object> params) {

        SjJobArg arg = new SjJobArg();
        SjJobCriteria criteria = arg.createCriteria();

        Class criteriaClass = criteria.getClass();
        Set keys = params.keySet();

        if (keys != null) {

            Iterator iterator = keys.iterator();

            while (iterator.hasNext()) {

                Object key = iterator.next();
                Object value = params.get(key);
                for (Method method : criteriaClass.getMethods()) {
                    if (method.getName().equals(
                            "and"+ StringUtils.toUpperCaseFirstOne(key.toString()) + "EqualTo")) {
                        try {
                            method.invoke(criteria, value);
                        }
                        catch (Exception e) {
                            throw new SysRuntimeException(e);
                        }
                        break;
                    }
                }
            }
        }
        return arg;
    }

    public ISjJobMapper getMapper() {
    	return getSqlSession().getMapper(ISjJobMapper.class);
    }

}
