/**
 * 
 */
package com.ztesoft.web.demo.customdb.dao;

import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.ztesoft.core.db.dao.mapper.ISequenceProcMapper;
import com.ztesoft.web.demo.customdb.dao.mapper.ICallProcMapper;

/**
 * <Description> 通用调用 数据库存储过程 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年12月1日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.db.dao <br>
 */
@Repository("callProcDao")
public class CallProcDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public synchronized String callSequence(Map<String, Object> params) {
        return getMapper().callSequence(params);
    }

    public ICallProcMapper getMapper() {
        return getSqlSession().getMapper(ICallProcMapper.class);
    }
}
