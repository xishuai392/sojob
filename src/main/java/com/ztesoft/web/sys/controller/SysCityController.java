package com.ztesoft.web.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.web.qryjob.vo.ReponseResultWrap;
import com.ztesoft.web.sys.db.po.SysCityPO;
import com.ztesoft.web.sys.service.ISysCityService;

/**
 * <Description>syscity管理 <br>
 * 
 * @author codeCreater <br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.sys.controller <br>
 */

@Controller
@RequestMapping("/sys/syscity")
public class SysCityController {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(SysCityController.class);

    @Autowired
    private ISysCityService sysCityService;

    @RequestMapping("index")
    public String index(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "/sys/jsp/sysCity";
    }

    @RequestMapping("queryRecordByPage")
    @ResponseBody
    public Page<SysCityPO> queryRecordByPage(SysCityPO record,
            Page<SysCityPO> resultPage) throws BaseAppException {
        resultPage = sysCityService.selectByArgAndPage(record, resultPage);
        return resultPage;
    }

    @RequestMapping("byList")
    @ResponseBody
    public ReponseResultWrap<List<SysCityPO>> queryRecordByList(SysCityPO record)
            throws BaseAppException {
        ReponseResultWrap<List<SysCityPO>> resultWrap = new ReponseResultWrap<List<SysCityPO>>();
        List<SysCityPO> resultList = sysCityService.selectByArg(record);
        resultWrap.setEntity(resultList);
        return resultWrap;
    }

    
    @RequestMapping("add")
    @ResponseBody
    public SysCityPO add(SysCityPO record) throws BaseAppException {
        logger.debug("add record begin...record=[{0}]", record);
        sysCityService.add(record);
        return record;
    }

    @RequestMapping("update")
    @ResponseBody
    public SysCityPO update(SysCityPO record) throws BaseAppException {
        logger.debug("modify record begin...record=[{0}]", record);
        sysCityService.update(record);
        return record;
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(SysCityPO record) throws BaseAppException {
        logger.debug("delete record begin...record=[{0}]", record);
        return sysCityService.delete(record);
    }

    @RequestMapping("qryRecordInfo")
    @ResponseBody
    public SysCityPO qryRecordInfo(@RequestParam(value = "cityId",
            required = true) Integer cityId) throws BaseAppException {
        SysCityPO record = sysCityService.selectByPrimaryKey(cityId);
        return record;
    }

}
