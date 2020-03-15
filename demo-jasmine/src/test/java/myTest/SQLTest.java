package myTest;

import org.junit.Test;

import java.sql.*;
import java.text.ParseException;

/**
 * 测试sql语句
 *
 * @author libigyao
 * @create 2019-05-26-13:35
 */
public class SQLTest {

    /*

	 //分组查询相关数据
	 SELECT la.label_name FROM label AS la
WHERE la.LABEL_description<15
GROUP BY la.label_name HAVING count(1)>=2
	 */
    @Test
    public void test() throws ParseException {
        String sql= "SELECT la.label_name AS  name FROM label AS la\n" +
                "WHERE la.LABEL_description<15\n" +
                "GROUP BY la.label_name HAVING count(1)>=2";
        //获取执行返回的结果集
        ResultSet resultSet = getQuery(sql);
        String name="";
        try {
            while(resultSet.next()){
                //获取name这列数据
                name = resultSet.getString("name");
                //输出结果
                System.out.println( "姓名:" + name);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

     public ResultSet getQuery(String sql){
         Connection connection=null;
         Statement statement=null;
         ResultSet resultSet =null;
         try {
             //加载jdbc驱动器
             Class.forName("com.mysql.jdbc.Driver");
             //提供url链接，用户名，密码，创建jdbc链接
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
             if(!connection.isClosed()) {

                 //创建state对象执行sql语句
                 statement = connection.createStatement();
                 //获取执行返回的结果集
                 resultSet = statement.executeQuery(sql);
                 String name="";
                 return resultSet;
             }
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
             return null;
         }catch (SQLException e) {
             e.printStackTrace();
             return null;
         }finally {
             //关闭结果集

              //  resultSet.close();

             //关闭链接

              //   connection.close();

             //关闭驱动器

              //   statement.close();

         }
         return null;
    }
}