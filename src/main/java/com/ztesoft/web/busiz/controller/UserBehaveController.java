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
import com.ztesoft.web.busiz.db.po.UserBehavePO;
import com.ztesoft.web.busiz.service.IUserBehaveService;

/**
 * <Description>userbehave管理 <br>
 * 
 * @author codeCreater <br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.busiz.controller <br>
 */

@Controller
@RequestMapping("/busiz/userbehave")
public class UserBehaveController {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(UserBehaveController.class);

    @Autowired
    private IUserBehaveService userBehaveService;

    @RequestMapping("index")
    public String index(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "/busiz/jsp/userBehave";
    }

    @RequestMapping("queryRecordByPage")
    @ResponseBody
    public Page<UserBehavePO> queryRecordByPage(UserBehavePO record,
            Page<UserBehavePO> resultPage) throws BaseAppException {
        resultPage = userBehaveService.selectByArgAndPage(record, resultPage);
        return resultPage;
    }

    @RequestMapping("add")
    @ResponseBody
    public UserBehavePO add(UserBehavePO record) throws BaseAppException {
        logger.debug("add record begin...record=[{0}]", record);
        userBehaveService.add(record);
        return record;
    }

    @RequestMapping("update")
    @ResponseBody
    public UserBehavePO update(UserBehavePO record) throws BaseAppException {
        logger.debug("modify record begin...record=[{0}]", record);
        userBehaveService.update(record);
        return record;
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(UserBehavePO record) throws BaseAppException {
        logger.debug("delete record begin...record=[{0}]", record);
        return userBehaveService.delete(record);
    }

    @RequestMapping("qryRecordInfo")
    @ResponseBody
    public UserBehavePO qryRecordInfo(@RequestParam(value = "behavId",
            required = true) Integer behavId) throws BaseAppException {
        UserBehavePO record = userBehaveService.selectByPrimaryKey(behavId);
        return record;
    }

}
