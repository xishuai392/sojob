/**
 * 
 */
package com.ztesoft.web.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ztesoft.core.common.Page;
import com.ztesoft.core.convert.IArgConversionService;
import com.ztesoft.core.db.ds.DBType;
import com.ztesoft.core.db.ds.DbcpConfig;
import com.ztesoft.core.db.ds.DynamicDataSourceManager;
import com.ztesoft.core.idproduce.ISequenceGenerator;
import com.ztesoft.core.spring.context.SpringApplicationContextHolder;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.exception.ExceptionHandler;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.DateUtils;
import com.ztesoft.web.demo.db.arg.EhcacheArg;
import com.ztesoft.web.demo.db.arg.EhcacheArg.EhcacheCriteria;
import com.ztesoft.web.demo.db.dao.EhcacheDao;
import com.ztesoft.web.demo.db.dao.MutilDataSourceDao;
import com.ztesoft.web.demo.db.po.EhcachePO;
import com.ztesoft.web.demo.service.IEhcacheService;

/**
 * <Description> <br>
 * 
 * @author codeCreater<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.demo.service.impl <br>
 */

@Service("ehcacheService")
public class EhcacheServiceImpl implements IEhcacheService {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(EhcacheServiceImpl.class);

    @Autowired
    private EhcacheDao ehcacheDao;

    /**
     * 查询条件转换成Arg类的服务接口
     */
    @Resource(name = "defaultArgConversionService")
    private IArgConversionService argConversionService;

    /**
     * 主键生成器
     */
    @Resource(name = "sequenceProcGenerator")
    private ISequenceGenerator sequenceGenerator;

    @Autowired
    private DynamicDataSourceManager dynamicDataSourceManager;

    @Override
    public EhcachePO selectByPrimaryKey(Integer key) throws BaseAppException {
        // ///////
        // TODO 根据业务场景，设置查询条件、数据校验等

        // ///////
        return ehcacheDao.selectByPrimaryKey(key);
    }

    @Override
    public List<EhcachePO> selectByArg(EhcachePO record)
            throws BaseAppException {
        logger.debug("selectByArg begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        // EhcacheArg arg = new EhcacheArg();
        // EhcacheCriteria criteria = arg.createCriteria();

        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        EhcacheArg arg = argConversionService.invokeArg(EhcacheArg.class,
                record);

        EhcacheCriteria criteria = arg.createCriteria();
        criteria.andEmpNameLike(record.getEmpName());

        // ///////
        // TODO 根据业务场景，设置查询条件，示例
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }
        // ///////

        return ehcacheDao.selectByArg(arg);
    }

    public List<Integer> countByArg(EhcachePO record) throws BaseAppException {
        EhcacheArg arg = argConversionService.invokeArg(EhcacheArg.class,
                record);

        EhcacheCriteria criteria = arg.createCriteria();
        criteria.andEmpNameLike(record.getEmpName());

        return ehcacheDao.countByArg(arg);
    }

    @Override
    @Cacheable(value = {
        "frameworkCache"
    })
    public Page<EhcachePO> selectByArgAndPage(EhcachePO record,
            Page<EhcachePO> resultPage) throws BaseAppException {
        logger.debug("selectByArgAndPage begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        // EhcacheArg arg = new EhcacheArg();
        // //TODO 根据业务场景，设置查询条件，示例
        // EhcacheCriteria criteria = arg.createCriteria();
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }

        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        EhcacheArg arg = argConversionService.invokeArg(EhcacheArg.class,
                record);

        resultPage = ehcacheDao.selectByArgAndPage(arg, resultPage);

        MutilDataSourceDao mutilDataSourceDao = (MutilDataSourceDao) SpringApplicationContextHolder
                .getBean(MutilDataSourceDao.class);

        SqlSessionTemplate sqlSessionTemplate = (SqlSessionTemplate) SpringApplicationContextHolder
                .getBean("majorSqlSessionTemplate");

        System.out.println(mutilDataSourceDao);
        System.out.println(sqlSessionTemplate);

        try {
            EhcachePO oldPo = mutilDataSourceDao.selectByPrimaryKey(101);
            System.out.println("newPo:" + oldPo);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        mutilDataSourceDao.setSqlSessionTemplate(sqlSessionTemplate);
        System.out.println(mutilDataSourceDao);

        EhcachePO newPo = mutilDataSourceDao.selectByPrimaryKey(101);
        System.out.println("newPo:" + newPo);

        return resultPage;
    }

    @Override
    public int add(EhcachePO record) throws BaseAppException {
        logger.debug("add begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、设置主键、设置属性默认值等
        // 获取主键
        int pkId = sequenceGenerator.sequenceIntValue("EHCACHE", "EMP_ID");
        record.setEmpId(pkId);
        // ///////

        return ehcacheDao.insertSelective(record);
    }

    @Override
    public int update(EhcachePO record) throws BaseAppException {
        logger.debug("update begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、数据有效性校验、设置属性默认值等

        // ///////

        return ehcacheDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(EhcachePO record) throws BaseAppException {
        logger.debug("delete begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行关联性校验、关联删除等

        // ///////

        return ehcacheDao.deleteByPrimaryKey(record.getEmpId());
    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.web.demo.service.IEhcacheService#updateByArg(com.ztesoft.web.demo.db.po.EhcachePO, com.ztesoft.web.demo.db.po.EhcachePO)
     */
    @Override
    public int updateByArgSelective(EhcachePO valueRecord, EhcachePO queryRecord)
            throws BaseAppException {
        EhcacheArg arg = argConversionService.invokeArg(EhcacheArg.class,
                queryRecord);

        EhcacheCriteria criteria = arg.createCriteria();
        criteria.andEmpNameLike(queryRecord.getEmpName());

        ehcacheDao.updateByArgSelective(valueRecord, arg);
        return 0;
    }

    public void update4TestDynaicDataSource(EhcachePO record) throws Exception {
        ehcacheDao.updateByPrimaryKeySelective(record);

        updateOracle();

        // 模拟抛出业务异常
        if (record.getEmpAge() > 100) {
            ExceptionHandler.publish("APP-00-0022");
        }

    }

    public void updateOracle() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(
                dynamicDataSourceManager.getDataSourcePoolByPoolId("oracle",
                        bulidOracleDbcpConfig()));
        String sql = "update  AAA_TEST set name='" + DateUtils.getCurrentDate()
                + "'  where id=1 ";
        jdbcTemplate.update(sql);

    }

    public void updateMysql() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(
                dynamicDataSourceManager.getDataSourcePoolByPoolId("mysql",
                        bulidMysqlDbcpConfig()));

    }

    public void updateInformix() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(
                dynamicDataSourceManager.getDataSourcePoolByPoolId("informix",
                        bulidInformixDbcpConfig()));
        String sql = "SELECT * FROM activate_rule";

    }

    private DbcpConfig bulidOracleDbcpConfig() {
        DbcpConfig cbcpConfig = new DbcpConfig(DBType.ORACLE);
        cbcpConfig.setUrl("jdbc:oracle:thin:@10.45.44.212:1521:ora11g");
        cbcpConfig.setUsername("HN_PROD");
        cbcpConfig.setPassword("HN_PROD_HN");
        cbcpConfig.setValidationQuery("SELECT 1 FROM DUAL ");
        return cbcpConfig;
    }

    private DbcpConfig bulidMysqlDbcpConfig() {
        DbcpConfig cbcpConfig = new DbcpConfig(DBType.MYSQL);
        cbcpConfig.setUrl("jdbc:mysql://10.45.44.188:3306/webframework");
        cbcpConfig.setUsername("web");
        cbcpConfig.setPassword("web");
        cbcpConfig.setValidationQuery("SELECT 1  ");
        return cbcpConfig;
    }

    private DbcpConfig bulidInformixDbcpConfig() {
        DbcpConfig cbcpConfig = new DbcpConfig(DBType.INFORMIX);
        cbcpConfig
                .setUrl("jdbc:informix-sqli://10.45.44.201:7088/prod_new:informixserver=infoserver;DB_LOCALE=en_us.819;CLIENT_LOCALE=en_us.57372;NEWCODESET=GBK,8859-1,819");
        cbcpConfig.setUsername("informix");
        cbcpConfig.setPassword("informix");
        cbcpConfig.setValidationQuery("SELECT 1 FROM DUAL  ");
        return cbcpConfig;
    }

}
