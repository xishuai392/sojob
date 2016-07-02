/**
 * 
 */
package com.ztesoft.web.inbound.conver;

import org.springframework.beans.BeanUtils;

import com.ztesoft.core.common.Page;
import com.ztesoft.web.inbound.param.QryParamBDZP;
import com.ztesoft.web.qryjob.vo.QryJobParam;

/**
 * <Description>查询参数的转换 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年6月26日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.inbound.conver <br>
 */

public class QryParamConver {

    /**
     * QryJobParam==>QryParamBDZP
     * 
     * @return
     */
    public static QryParamBDZP toBDZP(QryJobParam qryJobParam, Page page) {
        QryParamBDZP qryParamBDZP = new QryParamBDZP();
        BeanUtils.copyProperties(qryJobParam, qryParamBDZP);
        qryParamBDZP.setPn(String.valueOf(page.getStart()));
        qryParamBDZP.setRn(String.valueOf(page.getLimit()));
        return qryParamBDZP;
    }
}
