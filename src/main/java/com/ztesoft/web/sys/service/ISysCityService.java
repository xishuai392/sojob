/**
 * 
 */
package com.ztesoft.web.sys.service;

import java.math.*;
import java.util.*;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;

import com.ztesoft.web.sys.db.po.SysCityPO;

/**
 * <Description> <br>
 * 
 * @author codeCreater<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.sys.service <br>
 */

public interface ISysCityService {

    SysCityPO selectByPrimaryKey(Integer key) throws BaseAppException;

    List<SysCityPO> selectByArg(SysCityPO record) throws BaseAppException;

    Page<SysCityPO> selectByArgAndPage(SysCityPO record, Page<SysCityPO> resultPage)
            throws BaseAppException;

    int add(SysCityPO record) throws BaseAppException;

    int update(SysCityPO record) throws BaseAppException;

    int delete(SysCityPO record) throws BaseAppException;

}
