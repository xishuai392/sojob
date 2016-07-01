/**
 * 
 */
package com.ztesoft.web.busiz.service;

import java.math.*;
import java.util.*;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;

import com.ztesoft.web.busiz.db.po.UserBehavePO;

/**
 * <Description> <br>
 * 
 * @author codeCreater<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.busiz.service <br>
 */

public interface IUserBehaveService {

    UserBehavePO selectByPrimaryKey(Integer key) throws BaseAppException;

    List<UserBehavePO> selectByArg(UserBehavePO record) throws BaseAppException;

    Page<UserBehavePO> selectByArgAndPage(UserBehavePO record, Page<UserBehavePO> resultPage)
            throws BaseAppException;

    int add(UserBehavePO record) throws BaseAppException;

    int update(UserBehavePO record) throws BaseAppException;

    int delete(UserBehavePO record) throws BaseAppException;

}
