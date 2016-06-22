package com.ztesoft.core.convert;

import com.ztesoft.framework.exception.BaseAppException;

/**
 * <Description>转换接口 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年11月10日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.convert <br>
 */
public interface Converter<I, O> {
    O convert(I inputData) throws BaseAppException;
}
