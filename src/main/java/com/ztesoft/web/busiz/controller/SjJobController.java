package com.ztesoft.web.busiz.controller;

import java.math.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.web.busiz.db.po.SjJobPO;
import com.ztesoft.web.busiz.service.ISjJobService;

/**
 * <Description>sjjob管理 <br>
 * 
 * @author codeCreater <br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.busiz.controller <br>
 */

@Controller
@RequestMapping("/busiz/sjjob")
public class SjJobController {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(SjJobController.class);

    @Autowired
    private ISjJobService sjJobService;

    @RequestMapping("index")
    public String index(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "busiz/jsp/sjJob";
    }

    @RequestMapping("queryRecordByPage")
    @ResponseBody
    public Page<SjJobPO> queryRecordByPage(SjJobPO record,
            Page<SjJobPO> resultPage) throws BaseAppException {
        resultPage = sjJobService.selectByArgAndPage(record, resultPage);
        return resultPage;
    }

    @RequestMapping("add")
    @ResponseBody
    public SjJobPO add(SjJobPO record) throws BaseAppException {
        logger.debug("add record begin...record=[{0}]", record);
        sjJobService.add(record);
        return record;
    }

    @RequestMapping("update")
    @ResponseBody
    public SjJobPO update(SjJobPO record) throws BaseAppException {
        logger.debug("modify record begin...record=[{0}]", record);
        sjJobService.update(record);
        return record;
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(SjJobPO record) throws BaseAppException {
        logger.debug("delete record begin...record=[{0}]", record);
        return sjJobService.delete(record);
    }

    @RequestMapping("qryRecordInfo")
    @ResponseBody
    public SjJobPO qryRecordInfo(@RequestParam(value = "jobId",
            required = true) Integer jobId) throws BaseAppException {
        SjJobPO record = sjJobService.selectByPrimaryKey(jobId);
        return record;
    }

}
