/**
 * 
 */
package com.ztesoft.core.db.ds;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ztesoft.core.db.ds.DBType;
import com.ztesoft.core.db.ds.DbcpConfig;
import com.ztesoft.core.db.ds.DynamicDataSourceManager;
import com.ztesoft.core.spring.context.SpringApplicationContextHolder;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月4日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.ds <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "classpath:/config/spring-content.xml", "/config/spring-servlet.xml"
})
public class TestDynamicDataSource {
    @Autowired
    private DynamicDataSourceManager dynamicDataSourceManager;

    @Before
    public void setUp() {

    }

    @Test
    public void testAll() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("第" + (i + 1) + "次查询。。。。。。。。。。。。。");
                testOracle();
                testMysql();
                testInformix();
                if (i % 2 == 0) {
                    dynamicDataSourceManager.closeAll();
                }
                Thread.sleep(10000);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void testReloadSpring() throws Exception {
        SpringApplicationContextHolder.getApplicationContext()
                .getParentBeanFactory();

    }

    @Test
    public void testOracle() throws Exception {
        // 获取数据源连接池
        System.out.println("------------------->oracle数据源1");
        //
        JdbcTemplate jdbcTemplate = new JdbcTemplate(
                dynamicDataSourceManager.getDataSourcePoolByPoolId("oracle",
                        bulidOracleDbcpConfig()));
        //
        String sql = "SELECT * FROM ACTION";
        List<Map<String, Object>> retList2 = jdbcTemplate.queryForList(sql);
        System.out.println("查询结果条数：" + retList2.size());
        for (Map<String, Object> entityMap : retList2) {
            // System.out.println("-------查询结果:" + entityMap);
        }
    }

    @Test
    public void testMysql() throws Exception {
        // 获取数据源连接池
        System.out.println("------------------->Mysql数据源1");
        //
        JdbcTemplate jdbcTemplate = new JdbcTemplate(
                dynamicDataSourceManager.getDataSourcePoolByPoolId("mysql",
                        bulidMysqlDbcpConfig()));
        //
        String sql = "SELECT * FROM am_user";
        List<Map<String, Object>> retList2 = jdbcTemplate.queryForList(sql);
        System.out.println("查询结果条数：" + retList2.size());
        for (Map<String, Object> entityMap : retList2) {
            // System.out.println("-------查询结果:" + entityMap);
        }
    }

    @Test
    public void testInformix() throws Exception {
        // 获取数据源连接池
        System.out.println("------------------->Informix数据源1");
        //
        JdbcTemplate jdbcTemplate = new JdbcTemplate(
                dynamicDataSourceManager.getDataSourcePoolByPoolId("informix",
                        bulidInformixDbcpConfig()));
        //
        String sql = "SELECT * FROM activate_rule";
        List<Map<String, Object>> retList2 = jdbcTemplate.queryForList(sql);
        System.out.println("查询结果条数：" + retList2.size());
        for (Map<String, Object> entityMap : retList2) {
            // System.out.println("-------查询结果:" + entityMap);
        }
    }

    private DbcpConfig bulidOracleDbcpConfig() {
        DbcpConfig cbcpConfig = new DbcpConfig(DBType.ORACLE);
        cbcpConfig.setUrl("jdbc:oracle:thin:@10.45.44.212:1521:ora11g");
        cbcpConfig.setUsername("HN_PROD");
        cbcpConfig.setPassword("HN_PROD_HN");
        cbcpConfig.setValidationQuery("SELECT 1 FROM DUAL ");
        return cbcpConfig;
    }

    private DbcpConfig bulidMysqlDbcpConfig() {
        DbcpConfig cbcpConfig = new DbcpConfig(DBType.MYSQL);
        cbcpConfig.setUrl("jdbc:mysql://10.45.44.188:3306/webframework");
        cbcpConfig.setUsername("web");
        cbcpConfig.setPassword("web");
        cbcpConfig.setValidationQuery("SELECT 1  ");
        return cbcpConfig;
    }

    private DbcpConfig bulidInformixDbcpConfig() {
        DbcpConfig cbcpConfig = new DbcpConfig(DBType.INFORMIX);
        cbcpConfig
                .setUrl("jdbc:informix-sqli://10.45.44.201:7088/prod_new:informixserver=infoserver;DB_LOCALE=en_us.819;CLIENT_LOCALE=en_us.57372;NEWCODESET=GBK,8859-1,819");
        cbcpConfig.setUsername("informix");
        cbcpConfig.setPassword("informix");
        cbcpConfig.setValidationQuery("SELECT 1 FROM DUAL  ");
        return cbcpConfig;
    }

}
