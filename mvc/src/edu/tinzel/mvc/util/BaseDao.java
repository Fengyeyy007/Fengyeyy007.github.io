package edu.tinzel.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {
	private static final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL="jdbc:sqlserver://localhost:1433;DatabaseName=tinzel";
	private static final String UID="sa";
	private static final String PWD="123";
	protected Connection getcon()throws Exception{
		//加载驱动
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, UID, PWD);
	}
	protected void close(ResultSet rs,PreparedStatement ps,Connection con)throws Exception{
		if(rs!=null){
			rs.close();
		}
		if(ps!=null){
			ps.close();
		}
		if(con!=null){
			con.close();
		}
		rs=null;
		ps=null;
		con=null;
	}
}
