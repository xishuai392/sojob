/**
 * 
 */
package com.ztesoft.web.inbound.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.DateUtils;
import com.ztesoft.web.busiz.db.po.SjJobPO;
import com.ztesoft.web.busiz.service.ISjJobService;
import com.ztesoft.web.inbound.param.QryParamBDZP;
import com.ztesoft.web.inbound.reponse.JobInfo;
import com.ztesoft.web.inbound.reponse.JobInfoGroup;
import com.ztesoft.web.inbound.reponse.ResponseBDZP;
import com.ztesoft.web.inbound.reponse.ResponseBDZPBody;

/**
 * <Description>百度招聘，查询服务 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年6月15日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.inbound.service <br>
 */

@Service("qryBDZPService")
public class QryBDZPService {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(QryBDZPService.class);

    @Autowired
    private HttpClentBDZP httpClentBDZP;

    @Autowired
    private ISjJobService sjJobService;

    /**
     * 查询后把结果持久化到库里
     * 
     * @param qryParam
     * @return
     */
    public Page<SjJobPO> saveByQury(QryParamBDZP qryParam) {
        ResponseBDZP result = null;
        Page<SjJobPO> pageResult = new Page<SjJobPO>(Integer.parseInt(qryParam
                .getPn()), Integer.parseInt(qryParam.getRn()));
        try {
            result = httpClentBDZP.doGet(qryParam);

            JobInfo[] jobAry = parser(result, pageResult);
            if (null == jobAry) {
                logger.error("本次数据存在异常，解析结果为空。");
            }
            List<SjJobPO> poList = new ArrayList<SjJobPO>();
            for (JobInfo jobInfo : jobAry) {
                poList.add(converToJobPO(jobInfo));
            }
            pageResult.setResultList(poList);
            sjJobService.addBatch(poList);
        }
        catch (BaseAppException e) {
            logger.error("查询百度招聘，发生错误。", e);
        }
        return pageResult;
    }

    /**
     * 解析结果
     * 
     * @param result
     * @return
     */
    public JobInfo[] parser(ResponseBDZP result, Page<SjJobPO> pageResult) {

        if (!"0".equals(result.getStatus())) {
            logger.error("数据异常，ResponseBDZP.status=" + result.getStatus());
            return null;
        }

        ResponseBDZPBody body = result.getData();

        if (null == body) {
            logger.error("数据异常，ResponseBDZPBody is null!!!");
            return null;
        }

        if (!"0".equals(body.getStatus())) {
            logger.error("数据异常，body.status=" + result.getStatus());
            return null;
        }

        JobInfoGroup jobGroup = body.getData();

        if (null == jobGroup) {
            logger.error("数据异常，jobGroup is null!!!");
            return null;
        }

        // 总记录数
        int totalRecords = Integer.parseInt(jobGroup.getDispNum());
        // 每页多少条记录
        int pageSize = Integer.parseInt(jobGroup.getResNum());
        // 设置总查询数，每页数，总页数
        pageResult.setTotalRecords(totalRecords);
        pageResult.setLimit(pageSize);
        pageResult.initOtherData();

        return jobGroup.getDisp_data();
    }

    /**
     * 转换成SjJobPO
     * 
     * @param jobInfo
     * @return
     */
    public SjJobPO converToJobPO(JobInfo jobInfo) {
        SjJobPO jobPO = new SjJobPO();
        BeanUtils.copyProperties(jobInfo, jobPO);

        try {
            jobPO.setStartDate(DateUtils.string2Date(jobInfo.getStartDateStr(),
                    DateUtils.STR_DATE_FORMAT_DAY_WITH_SPLIT));
            jobPO.setEndDate(DateUtils.string2Date(jobInfo.getEndDateStr(),
                    DateUtils.STR_DATE_FORMAT_DAY_WITH_SPLIT));
        }
        catch (Exception e) {
            logger.error("转换日期格式时出错", e);
        }

        // 薪水拆分
        // if("不限".equals(jobPO.getSalaryRange())||"面议".equals(jobPO.getSalaryRange())){
        // jobPO.setSalaryMax(99999999);
        // jobPO.setSalaryMin(0);
        // }
        // if("2000以下".equals(jobPO.getSalaryRange())){
        // jobPO.setSalaryMax(2000);
        // jobPO.setSalaryMin(0);
        // }
        // if("2000以下".equals(jobPO.getSalaryRange())){
        // jobPO.setSalaryMax(2000);
        // jobPO.setSalaryMin(0);
        // }

        // 工作经验拆分
        return jobPO;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
