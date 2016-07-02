/**
 * 
 */
package com.ztesoft.web.busiz.service.impl;

import java.math.*;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztesoft.core.common.Page;
import com.ztesoft.core.convert.IArgConversionService;
import com.ztesoft.core.idproduce.ISequenceGenerator;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.Utils;
import com.ztesoft.web.busiz.db.arg.SjJobArg;
import com.ztesoft.web.busiz.db.arg.SjJobArg.SjJobCriteria;
import com.ztesoft.web.busiz.db.dao.SjJobDao;
import com.ztesoft.web.busiz.db.po.SjJobPO;
import com.ztesoft.web.busiz.service.ISjJobService;

/**
 * <Description> <br>
 * 
 * @author codeCreater<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.busiz.service.impl <br>
 */

@Service("sjJobService")
public class SjJobServiceImpl implements ISjJobService {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(SjJobServiceImpl.class);

    @Autowired
    private SjJobDao sjJobDao;
    

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
    

    @Override
    public SjJobPO selectByPrimaryKey(Integer key) throws BaseAppException {
        // ///////
        // TODO 根据业务场景，设置查询条件、数据校验等

        // ///////
        return sjJobDao.selectByPrimaryKey(key);
    }

    @Override
    public List<SjJobPO> selectByArg(SjJobPO record) throws BaseAppException {
        logger.debug("selectByArg begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        //SjJobArg arg = new SjJobArg();
        //SjJobCriteria criteria = arg.createCriteria();
        
        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        SjJobArg arg = argConversionService.invokeArg(SjJobArg.class, record);

        // ///////
        // TODO 根据业务场景，设置查询条件，示例
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }
        // ///////

        return sjJobDao.selectByArg(arg);
    }

    @Override
    public Page<SjJobPO> selectByArgAndPage(SjJobPO record, Page<SjJobPO> resultPage)
            throws BaseAppException {
        logger.debug("selectByArgAndPage begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        // SjJobArg arg = new SjJobArg();
        // //TODO 根据业务场景，设置查询条件，示例
        // SjJobCriteria criteria = arg.createCriteria();
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }

        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        SjJobArg arg = argConversionService.invokeArg(SjJobArg.class, record);

        resultPage = sjJobDao.selectByArgAndPage(arg, resultPage);


        return resultPage;
    }

    @Override
    public int add(SjJobPO record) throws BaseAppException {
        logger.debug("add begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、设置主键、设置属性默认值等
        // 获取主键
        // int pkId = sequenceGenerator.sequenceIntValue("表名","主键名");
        // record.setUserId(pkId);
        // record.setCreatedDate(new Date());
        // ///////

        return sjJobDao.insertSelective(record);
    }
    
    public int addBatch(List<SjJobPO> records) {
        return sjJobDao.insertBatch(records);
    }

    @Override
    public int update(SjJobPO record) throws BaseAppException {
        logger.debug("update begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、数据有效性校验、设置属性默认值等

        // ///////

        return sjJobDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SjJobPO record) throws BaseAppException {
        logger.debug("delete begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行关联性校验、关联删除等

        // ///////

        return sjJobDao.deleteByPrimaryKey(record.getJobId());
    }

}
