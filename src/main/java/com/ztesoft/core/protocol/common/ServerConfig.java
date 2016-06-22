/**
 * 
 */
package com.ztesoft.core.protocol.common;

import java.lang.reflect.Field;

import com.ztesoft.framework.dto.AbstractDto;
import com.ztesoft.framework.util.EqualsUtils;
import com.ztesoft.framework.util.HashCodeUtils;

/**
 * <Description>主机配置信息，建议host用IP地址 <br>
 * 本类的equals方法有特殊改造
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月19日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.pool <br>
 */

public class ServerConfig extends AbstractDto {
    // 主机用户
    private String user;

    // 主机用户密码
    private String password;

    // 主机Ip
    private String host;

    // 端口
    private int port = 0;

    // ssh， Telnet 等 协议的连接超时毫秒数
    private int timeout = 60000;

    // ssh(JSch session) 配置项
    private String strictHostKeyChecking = "no";

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * @return the timeout
     */
    public int getTimeout() {
        return timeout;
    }

    /**
     * @param timeout the timeout to set
     */
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    /**
     * @return the strictHostKeyChecking
     */
    public String getStrictHostKeyChecking() {
        return strictHostKeyChecking;
    }

    /**
     * @param strictHostKeyChecking the strictHostKeyChecking to set
     */
    public void setStrictHostKeyChecking(String strictHostKeyChecking) {
        this.strictHostKeyChecking = strictHostKeyChecking;
    }

    /**
     * 根据host、user、port判定哈希值，只比较三个属性host、user、port
     * 
     * @return int 返回哈希值<br>
     */
    @Override
    public int hashCode() {
        int result = 17;
        try {
            result = 37 * result + HashCodeUtils.hashCode(host);
            result = 37 * result + HashCodeUtils.hashCode(user);
            result = 37 * result + HashCodeUtils.hashCode(port);
        }
        catch (IllegalArgumentException e) {
            return super.hashCode();
        }

        return result;

    }

    /**
     * 判断两个对象是否相等 ，只比较三个属性host、user、port
     * 
     * @param obj 要比较的对象
     * @return boolean 两个对象相等才会返回true，否则返回false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        Field[] fieldList = this.getClass().getDeclaredFields();
        if (fieldList != null) {
            for (Field field : fieldList) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                // 只判断host、user、port
                if (!field.getName().equals("host")
                        && !field.getName().equals("user")
                        && !field.getName().equals("port")) {
                    continue;
                }

                try {
                    Object thisValue = field.get(this);
                    Object thatValue = field.get(obj);
                    if (!EqualsUtils.equals(thisValue, thatValue)) {
                        return false;
                    }
                }
                catch (IllegalArgumentException e) {
                    super.equals(obj);
                }
                catch (IllegalAccessException e) {
                    super.equals(obj);
                }
            }
        }
        return true;
    }
}
