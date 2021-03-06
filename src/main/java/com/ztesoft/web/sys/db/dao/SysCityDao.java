package com.ztesoft.web.sys.db.dao;

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

import com.ztesoft.web.sys.db.arg.SysCityArg;
import com.ztesoft.web.sys.db.arg.SysCityArg.SysCityCriteria;
import com.ztesoft.web.sys.db.dao.mapper.ISysCityMapper;
import com.ztesoft.web.sys.db.po.SysCityPO;

@Repository
public class SysCityDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<Integer> countByArg(SysCityArg arg) {
        return getMapper().countByArg(arg);
    }

    public int deleteByArg(SysCityArg arg) {
        return getMapper().deleteByArg(arg);
    }

    public List<SysCityPO> selectByArg(SysCityArg arg) {
        return getMapper().selectByArg(arg);
    }

    public int updateByArgSelective(SysCityPO record, SysCityArg arg) {
        return getMapper().updateByArgSelective(record, arg);
    }

    public int updateByArg(SysCityPO record, SysCityArg arg) {
        return getMapper().updateByArg(record, arg);
    }

    public Page<SysCityPO> selectByArgAndPage(SysCityArg arg,
            Page<SysCityPO> resultPage) {
        List<SysCityPO> resultList = getMapper().selectByArgAndPage(arg,
                resultPage);
        resultPage.setResultList(resultList);
        return resultPage;
    }

    public int insert(SysCityPO record) {
        return getMapper().insert(record);
    }

    public int insertSelective(SysCityPO record) {
        return getMapper().insertSelective(record);
    }

    public int insertBatch(List<SysCityPO> records) {
        return getMapper().insertBatch(records);
    }

    public int deleteByPrimaryKey(Integer key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    public SysCityPO selectByPrimaryKey(Integer key) {
        return getMapper().selectByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(SysCityPO record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SysCityPO record) {
        return getMapper().updateByPrimaryKey(record);
    }

    /**
     * 根据传入的Map条件进行查询，当前仅支持所有Map中Key字段的EqualTo查询
     * @param params Map,Key=字段名，value=查询值
     * @return
     */
    public List<SysCityPO> selectByMap(Map<String, Object> params) {
        return (selectByArg(buildQueryObject(params)));
    }

    private SysCityArg buildQueryObject(Map<String, Object> params) {

        SysCityArg arg = new SysCityArg();
        SysCityCriteria criteria = arg.createCriteria();

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

    public ISysCityMapper getMapper() {
    	return getSqlSession().getMapper(ISysCityMapper.class);
    }

}
