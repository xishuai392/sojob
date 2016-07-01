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

import com.ztesoft.web.busiz.db.arg.UserBehaveArg;
import com.ztesoft.web.busiz.db.arg.UserBehaveArg.UserBehaveCriteria;
import com.ztesoft.web.busiz.db.dao.mapper.IUserBehaveMapper;
import com.ztesoft.web.busiz.db.po.UserBehavePO;

@Repository
public class UserBehaveDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<Integer> countByArg(UserBehaveArg arg) {
        return getMapper().countByArg(arg);
    }

    public int deleteByArg(UserBehaveArg arg) {
        return getMapper().deleteByArg(arg);
    }

    public List<UserBehavePO> selectByArg(UserBehaveArg arg) {
        return getMapper().selectByArg(arg);
    }

    public int updateByArgSelective(UserBehavePO record, UserBehaveArg arg) {
        return getMapper().updateByArgSelective(record, arg);
    }

    public int updateByArg(UserBehavePO record, UserBehaveArg arg) {
        return getMapper().updateByArg(record, arg);
    }

    public Page<UserBehavePO> selectByArgAndPage(UserBehaveArg arg,
            Page<UserBehavePO> resultPage) {
        List<UserBehavePO> resultList = getMapper().selectByArgAndPage(arg,
                resultPage);
        resultPage.setResultList(resultList);
        return resultPage;
    }

    public int insert(UserBehavePO record) {
        return getMapper().insert(record);
    }

    public int insertSelective(UserBehavePO record) {
        return getMapper().insertSelective(record);
    }

    public int insertBatch(List<UserBehavePO> records) {
        return getMapper().insertBatch(records);
    }

    public int deleteByPrimaryKey(Integer key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    public UserBehavePO selectByPrimaryKey(Integer key) {
        return getMapper().selectByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(UserBehavePO record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserBehavePO record) {
        return getMapper().updateByPrimaryKey(record);
    }

    /**
     * 根据传入的Map条件进行查询，当前仅支持所有Map中Key字段的EqualTo查询
     * @param params Map,Key=字段名，value=查询值
     * @return
     */
    public List<UserBehavePO> selectByMap(Map<String, Object> params) {
        return (selectByArg(buildQueryObject(params)));
    }

    private UserBehaveArg buildQueryObject(Map<String, Object> params) {

        UserBehaveArg arg = new UserBehaveArg();
        UserBehaveCriteria criteria = arg.createCriteria();

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

    public IUserBehaveMapper getMapper() {
    	return getSqlSession().getMapper(IUserBehaveMapper.class);
    }

}
