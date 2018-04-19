package edu.tinzel.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.tinzel.mvc.dao.StusDao;
import edu.tinzel.mvc.entity.Stus;
import edu.tinzel.mvc.util.BaseDao;

public class StusDaoImpl extends BaseDao implements StusDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public boolean login(String name, String pwd) throws Exception {
		String sql="select *from Stus where name=? and pwd=?";
		//获取连接对象
		this.con=super.getcon();
		//创建执行sql语句对象
		this.ps=this.con.prepareStatement(sql);
		this.ps.setString(1, name);
		this.ps.setString(2, pwd);
		this.rs=this.ps.executeQuery();
		boolean bo=this.rs.next();
		//关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	@Override
	public boolean save(Stus stus) throws Exception {
		String sql="if not exists(select * from Stus where name=?)insert into Stus(name,pwd,age) values(?,?,?)";
		//获取连接对象
		this.con=super.getcon();
		//创建执行SQL语句对象
		this.ps=this.con.prepareStatement(sql);
		this.ps.setString(1, stus.getName());
		this.ps.setString(2, stus.getName());
		this.ps.setString(3, stus.getPwd());
		this.ps.setInt(4, stus.getAge());
		boolean bo=this.ps.executeUpdate()>0?true:false;
		//关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	@Override
	public boolean update(Stus stus) throws Exception {
		String sql="update Stus set name=?,pwd=?,age=? where id=?";
		//获取连接对象
		this.con=super.getcon();
		//创建执行SQL语句对象
		this.ps=this.con.prepareStatement(sql);
		this.ps.setString(1, stus.getName());
		this.ps.setString(2, stus.getPwd());
		this.ps.setInt(3, stus.getAge());
		this.ps.setInt(4, stus.getId());
		boolean bo=this.ps.executeUpdate()>0?true:false;
		//关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	@Override
	public boolean del(int id) throws Exception {
		String sql="delete from Stus where id=?";
		//获取连接对象
		this.con=super.getcon();
		//创建执行SQL语句对象
		this.ps=this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		boolean bo=this.ps.executeUpdate()>0?true:false;
		//关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	@Override
	public List<Stus> getlist() throws Exception {
		String sql="select * from Stus";
		//获取连接对象
		this.con=super.getcon();
		//创建执行SQL语句对象
		this.ps=this.con.prepareStatement(sql);
		this.rs=this.ps.executeQuery();
		List<Stus> list=new ArrayList<Stus>();
		while(this.rs.next()){
			Stus stus=new Stus(this.rs.getInt("id"),this.rs.getString("name"),this.rs.getString("pwd"),this.rs.getInt("age"));
			list.add(stus);
		}
		//关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	@Override
	public Stus getId(int id) throws Exception {
		String sql="select * from Stus where id=?";
		//获取连接对象
		this.con=super.getcon();
		//创建执行SQL语句对象
		this.ps=this.con.prepareStatement(sql);
		this.ps.setInt(1, id);
		this.rs=this.ps.executeQuery();
		Stus stus=null;
		if(this.rs.next()){
			stus=new Stus(this.rs.getInt("id"),this.rs.getString("name"),this.rs.getString("pwd"),this.rs.getInt("age"));
		}
		//关闭释放数据库操作资源
		super.close(rs, ps, con);
		return stus;
	}

}
