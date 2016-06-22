/**
 * 
 */
package com.ztesoft.core.spring.transaction;

import java.util.HashMap;
import java.util.Map;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.util.Assert;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月5日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.spring.transaction <br>
 */

public class RoutingTransactionManager implements PlatformTransactionManager {
    private Map<Object, PlatformTransactionManager> targetTransactionManagers = new HashMap<Object, PlatformTransactionManager>();

    
    /**
     * 根据给定的规则获取指定的tx
     * 
     * @return
     */
    protected PlatformTransactionManager getTargetTransactionManager() {
      Object context = RoutingContextHolder.getContext();
      Assert.notNull(context, "必须指定路由的context");
      return targetTransactionManagers.get(context);
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see org.springframework.transaction.PlatformTransactionManager#getTransaction(org.springframework.transaction.TransactionDefinition)
     */
    @Override
    public TransactionStatus getTransaction(TransactionDefinition definition)
            throws TransactionException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.transaction.PlatformTransactionManager#commit(org.springframework.transaction.TransactionStatus)
     */
    @Override
    public void commit(TransactionStatus status) throws TransactionException {
        getTargetTransactionManager().commit(status);

    }

    /*
     * (non-Javadoc)
     * @see org.springframework.transaction.PlatformTransactionManager#rollback(org.springframework.transaction.TransactionStatus)
     */
    @Override
    public void rollback(TransactionStatus status) throws TransactionException {
        // TODO Auto-generated method stub

    }

}
