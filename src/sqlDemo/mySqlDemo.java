package sqlDemo;
/**
 * jdbc连接mysql
 */
import java.sql.*;

public class mySqlDemo {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";             //驱动名
	static final String DB_URL = "JDBC:mysql://localhost:3306/sqltestdb";  //url
	
	static final String USER= "root";             //mysql用户名
	static final String PASS= "123456";				//mysql密码
		
	public static void main(String[] args) {
		Connection conn =null;
		Statement stmt =null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection(DB_URL,USER,PASS);
			stmt=conn.createStatement();
			String sql="SELECT id,name,url FROM websites;";
			
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String name =rs.getString("name");
				String url=rs.getString("url");
				System.out.print("ID:"+id);
				System.out.print(",站点名称:"+name);
				System.out.print(",站点 URL:"+url);
				System.out.print("\n");
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("数据库数据成功获取");
		}
		
		
	}

}
