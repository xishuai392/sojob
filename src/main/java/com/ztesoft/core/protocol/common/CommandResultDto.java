/**
 * 
 */
package com.ztesoft.core.protocol.common;

import com.ztesoft.framework.dto.AbstractDto;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年9月9日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.protocol.common <br>
 */

public class CommandResultDto extends AbstractDto {

    private boolean isTimeout = false;// 是否超时

    private String command;// 原始命令

    private String commandResult;// 返回的结果

    /**
     * @return the isTimeout
     */
    public boolean isTimeout() {
        return isTimeout;
    }

    /**
     * @param isTimeout the isTimeout to set
     */
    public void setTimeout(boolean isTimeout) {
        this.isTimeout = isTimeout;
    }

    /**
     * @return the command
     */
    public String getCommand() {
        return command;
    }

    /**
     * @param command the command to set
     */
    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * @return the commandResult
     */
    public String getCommandResult() {
        return commandResult;
    }

    /**
     * @param commandResult the commandResult to set
     */
    public void setCommandResult(String commandResult) {
        this.commandResult = commandResult;
    }

}
