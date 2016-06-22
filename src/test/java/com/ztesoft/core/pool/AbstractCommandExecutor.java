/**
 * 
 */
package com.ztesoft.core.pool;

/**
 * <Description>r任务执行器 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月19日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.pool <br>
 */

public abstract class AbstractCommandExecutor {

    protected ServerDetails serverDetails;

    public AbstractCommandExecutor(ServerDetails serverDetails) {
        this.serverDetails = serverDetails;
    }

    public abstract AbstractCommandExecutor execute(ExecutableCommand command);
}
