/**
 * 
 */
package com.ztesoft.web.busiz.service;

import java.math.*;
import java.util.*;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.web.busiz.db.po.SjJobPO;

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

public interface ISjJobService {

    SjJobPO selectByPrimaryKey(Integer key) throws BaseAppException;

    List<SjJobPO> selectByArg(SjJobPO record) throws BaseAppException;

    Page<SjJobPO> selectByArgAndPage(SjJobPO record, Page<SjJobPO> resultPage)
            throws BaseAppException;

    int add(SjJobPO record) throws BaseAppException;
    
    public int addBatch(List<SjJobPO> records) throws BaseAppException;

    int update(SjJobPO record) throws BaseAppException;

    int delete(SjJobPO record) throws BaseAppException;

}
