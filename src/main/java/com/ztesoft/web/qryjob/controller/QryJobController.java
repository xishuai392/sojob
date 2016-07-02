package com.ztesoft.web.qryjob.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.FrameWorkConstants;
import com.ztesoft.framework.util.JsonUtil;
import com.ztesoft.web.busiz.db.po.SjJobPO;
import com.ztesoft.web.busiz.db.po.UserBehavePO;
import com.ztesoft.web.busiz.service.IUserBehaveService;
import com.ztesoft.web.inbound.conver.QryParamConver;
import com.ztesoft.web.inbound.param.QryParamBDZP;
import com.ztesoft.web.inbound.service.QryBDZPService;
import com.ztesoft.web.qryjob.vo.QryJobParam;
import com.ztesoft.web.qryjob.vo.ReponseResultWrap;

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
@RequestMapping("/qryJob/")
public class QryJobController {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(QryJobController.class);

    @Autowired
    private QryBDZPService qryBDZPService;

    @Autowired
    IUserBehaveService userBehaveService;

    @RequestMapping("index")
    public String index(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "busiz/jsp/sjJob";
    }

    @RequestMapping("byPage")
    @ResponseBody
    public ReponseResultWrap<Page<SjJobPO>> queryRecordByPage(
            QryJobParam qryJobParam, Page<SjJobPO> qryPage,
            UserBehavePO userBehavePO) throws BaseAppException {
        ReponseResultWrap<Page<SjJobPO>> resultWrap = new ReponseResultWrap<Page<SjJobPO>>();
        QryParamBDZP qryParamBDZP = QryParamConver.toBDZP(qryJobParam, qryPage);
        Page<SjJobPO> resultPage = qryBDZPService.saveByQury(qryParamBDZP);
        // 设置下起始记录
        resultPage.setStart(qryPage.getStart());
        resultWrap.setEntity(resultPage);
        try {
            userBehavePO.setModule("QUERY_JOB");
            userBehavePO.setReqUrl(JsonUtil.toJson(qryJobParam));
            userBehavePO.setCreateDate(new Date());
            userBehavePO.setState(FrameWorkConstants.STATUS_EFF);
            //TODO 需要转换地理位置到城市
            
            // 记录用户行为
            userBehaveService.add(userBehavePO);
        }
        catch (Exception e) {
            logger.error("记录用户行为时，发生异常", e);
        }

        // SjJobPO qryJobPO = new SjJobPO();

        return resultWrap;
    }

}
