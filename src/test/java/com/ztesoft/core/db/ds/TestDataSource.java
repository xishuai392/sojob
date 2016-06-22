/**
 * 
 */
package com.ztesoft.core.db.ds;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.datasource.DataSourceUtils;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年9月23日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.db.ds <br>
 */

public class TestDataSource {
    public static boolean scwj(String path, String FileName, String body) {
        try {
            File f = new File(path);
            f.mkdirs();
            path = path + "\\" + FileName;
            f = new File(path);
            PrintWriter out;
            out = new PrintWriter(new FileWriter(f));
            out.print(body + "\n");
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Connection getconConnection() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:jtds:sqlserver://localhost:1433/adwatch", "sa",
                    "123456");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void showTable() {
        DynamicDataSourceManager dynamicDataSourceManager = new DynamicDataSourceManager();
        BasicDataSource ds = null;
        Connection conn = null;
        ResultSet rs = null;
        try {

            // 通过数据库连接池获取一个datasource
            ds = dynamicDataSourceManager.getDataSourcePoolByPoolId("aaaa",
                    bulidMysqlDbcpConfig());
            // 利用DataSourceUtils工具类，创建Connection
            conn = DataSourceUtils.getConnection(ds);
            // dosomething.....

            // DB2 com.ibm.db2.jcc.DB2Driver "jdbc:db2://localhost:50000/abc", "db2admin","123456"
            // MYSQL com.mysql.jdbc.Driver "jdbc:mysql://localhost:3306/manager","root","root"
            // MSSQLSERVER net.sourceforge.jtds.jdbc.Driver "jdbc:jtds:sqlserver://localhost:1433/abc","sa","123456"
            DatabaseMetaData odmd = conn.getMetaData();
            // String[] types = { "TABLE" };// 数组变量types
            rs = odmd.getTables(null, null, null, null);
            // odmd.getMaxTableNameLength()
            StringBuffer sql = new StringBuffer();
            int counti = 1;
            while (rs.next()) {
                // 取表名
                String Tablename = rs.getString(3);
                if (StringUtils.equalsIgnoreCase(rs.getString(4), "TABLE")
                // && StringUtils.equalsIgnoreCase(rs.getString(2),"abc")
                // &&StringUtils.equalsIgnoreCase(rs.getString(3), "ADDetail")
                ) {
                    System.out.println(counti + "-" + Tablename);
                    String commnt = "";
                    String indexu = "";
                    ResultSet pkRSet = odmd.getPrimaryKeys(null, null,
                            Tablename);
                    ResultSet rscol = odmd.getColumns(null, null, Tablename,
                            null);
                    ResultSet inset = odmd.getIndexInfo(null, null, Tablename,
                            false, true);
                    String colstr = "";
                    while (rscol.next()) {
                        String ColumnName = rscol.getString(4);
                        String ColumnTypeName = rscol.getString(6);
                        String REMARKS = rscol.getString(12);
                        if (StringUtils.isNotBlank(REMARKS)) {
                            commnt = commnt + "COMMENT ON " + Tablename + " ( "
                                    + ColumnName + " IS '" + REMARKS
                                    + "' ); \n";
                        }
                        while (inset.next()) {
                            if (inset.getInt(7) == DatabaseMetaData.tableIndexOther) {
                                indexu = indexu + "CREATE  UNIQUE  INDEX "
                                        + inset.getString(6) + " ON "
                                        + inset.getString(5) + "("
                                        + inset.getString(9) + ");\n";
                            }
                            System.out.println();
                        }

                        int displaySize = rscol.getInt(7);
                        int scale = rscol.getInt(9);
                        // int Precision = displaySize-scale;
                        if (StringUtils.isNotBlank(colstr)) {
                            colstr = colstr + ",\n";
                        }
                        colstr = colstr + "\t" + ColumnName + "\t";
                        if (StringUtils.indexOf(ColumnTypeName, "identity") >= 0) {
                            colstr = colstr + ColumnTypeName + "(1,1)";
                        }
                        else if (StringUtils.equalsIgnoreCase(ColumnTypeName,
                                "timestamp")
                                || StringUtils.equalsIgnoreCase(ColumnTypeName,
                                        "int")
                                || StringUtils.equalsIgnoreCase(ColumnTypeName,
                                        "datetime")
                                || StringUtils.equalsIgnoreCase(ColumnTypeName,
                                        "long")
                                || StringUtils.equalsIgnoreCase(ColumnTypeName,
                                        "date")
                                || StringUtils.equalsIgnoreCase(ColumnTypeName,
                                        "text")
                                || StringUtils.equalsIgnoreCase(ColumnTypeName,
                                        "image")
                                || StringUtils.equalsIgnoreCase(ColumnTypeName,
                                        "bit")
                                || StringUtils.equalsIgnoreCase(ColumnTypeName,
                                        "ntext")) {
                            colstr = colstr + ColumnTypeName + "";
                        }
                        else if (StringUtils.equalsIgnoreCase(ColumnTypeName,
                                "decimal")
                                || StringUtils.equalsIgnoreCase(ColumnTypeName,
                                        "number")
                                || StringUtils.equalsIgnoreCase(ColumnTypeName,
                                        "double")) {
                            if (scale == 0)
                                colstr = colstr + ColumnTypeName + "("
                                        + displaySize + ")";
                            else
                                colstr = colstr + ColumnTypeName + "("
                                        + displaySize + "," + scale + ")";
                        }
                        else {
                            colstr = colstr + ColumnTypeName + "("
                                    + displaySize + ")";
                        }
                        String defaultstr = rscol.getString(13);
                        if (defaultstr != null)
                            colstr = colstr + "\t default " + defaultstr;
                        if (rscol.getInt(11) == DatabaseMetaData.columnNoNulls) {
                            colstr = colstr + "\tnot null";
                        }
                        else if (rscol.getInt(11) == DatabaseMetaData.columnNullable) {
                            // sql.append("\tnull");
                        }
                    }
                    String pkcolstr = "";
                    while (pkRSet.next()) {

                        if (StringUtils.isNotBlank(pkcolstr)) {
                            pkcolstr = pkcolstr + ",\n";
                        }
                        else {
                            if (StringUtils.isNotBlank(colstr)) {
                                colstr = colstr + ",\n";
                            }
                        }
                        pkcolstr = pkcolstr + "\tconstraint \""
                                + pkRSet.getObject(6) + "\" primary key ("
                                + pkRSet.getObject(4) + ")";
                    }
                    sql.append("create table " + Tablename + "\n(" + colstr
                            + pkcolstr + "\n)\n\n");
                    System.out.println("create table " + Tablename + "\n("
                            + colstr + pkcolstr + "\n);\n" + commnt + ""
                            + indexu + "\n");
                }
                counti++;
            }
            // scwj("c:\\", "abc.sql", sql.toString());

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            System.out.println("getNumActive:" + ds.getNumActive());
            System.out.println("getNumIdle:" + ds.getNumIdle());
            System.out.println(conn);
            if (rs != null) {
                try {
                    rs.close();
                }
                catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

            if (conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            // conn.close();

            // 一定要记得释放连接
            // try {
            // DataSourceUtils.doReleaseConnection(conn, ds);
            // DataSourceUtils.releaseConnection(conn, ds);
            // System.out.println("释放连接");
            // }
            // catch (SQLException e) {
            // e.printStackTrace();
            // }

            System.out.println(conn);

            System.out.println("getNumActive:" + ds.getNumActive());
            System.out.println("getNumIdle:" + ds.getNumIdle());

        }

        // try {
        // dynamicDataSourceManager.close("aaaa");
        // }
        // catch (SQLException e1) {
        // // TODO Auto-generated catch block
        // e1.printStackTrace();
        // }

        try {
            Thread.sleep(360);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 如果不是通过spring的jdbctemplate操作DataSource的， 一定要记得用DataSourceUtils.doReleaseConnection(con, ds)释放连接
     */
    public static void main(String[] args) {
        TestDataSource testDataSource = new TestDataSource();
        for (int i = 0; i < 5; i++) {
            System.out.println("第" + i + "次。。。begin");
            testDataSource.showTable();
            System.out.println("第" + i + "次。。。end");
            try {
                Thread.sleep(8000);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(36000000);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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

        // cbcpConfig.setRemoveAbandoned(true);
        // cbcpConfig.setRemoveAbandonedTimeout(10);
        //
        // cbcpConfig.setMaxIdle(0);
        //
        cbcpConfig.setMinEvictableIdleTimeMillis(3000);
        cbcpConfig.setTimeBetweenEvictionRunsMillis(10000);
        // cbcpConfig.setTestOnBorrow(true);
        // cbcpConfig.setTestOnReturn(true);
        // cbcpConfig.setTestWhileIdle(true);
        //
         cbcpConfig.setInitialSize(15);
        // cbcpConfig.setLogAbandoned(true);
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
