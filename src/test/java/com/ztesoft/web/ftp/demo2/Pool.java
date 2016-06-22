/**
 * 
 */
package com.ztesoft.web.ftp.demo2;

import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;

/** 
 * <Description> <br> 
 *  
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月18日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.ftp.demo2 <br>
 */

public abstract class Pool<T> {
    private final GenericObjectPool<T> internalPool;  
    
    public Pool(GenericObjectPool.Config poolConfig, PoolableObjectFactory factory)    
    {  
        this.internalPool = new GenericObjectPool<T>(factory, poolConfig);    
    }  
      
    public synchronized T getResource(){  
        try{  
            return this.internalPool.borrowObject();  
        }catch(Exception e){  
            e.printStackTrace();  
            return null;  
        }  
    }  
      
    public void returnResource(T resource){  
        try {  
            this.internalPool.returnObject(resource);  
        }catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    public void destroy(){  
        try{  
            this.internalPool.close();    
        }catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    public int getNumIdle(){  
        try{  
            return this.internalPool.getNumIdle();  
        }catch(Exception e){  
            e.printStackTrace();  
            return 0;  
        }  
    }  
      
    public int getNumActive(){  
        try{  
            return this.internalPool.getNumActive();  
        }catch(Exception e){  
            e.printStackTrace();  
            return 0;  
        }  
    }  
}
