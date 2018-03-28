package edu.tinzel.mvccompany.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.tinzel.mvccompany.dao.CompanyDao;
import edu.tinzel.mvccompany.entity.Company;
import edu.tinzel.mvccompany.util.BaseDao;

public class CompanyDaoImpl extends BaseDao implements CompanyDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public boolean login(String cmpName, String cmpPwd) throws Exception {
		String sql="select * from company where cmpName=? and cmpPwd=?";
		//获取连接对象
		this.con=super.getcon();
		//创建执行SQL语句对象
		this.ps=this.con.prepareStatement(sql);
		this.ps.setString(1, cmpName);
		this.ps.setString(2, cmpPwd);
		this.rs=this.ps.executeQuery();
		boolean bo=this.rs.next();
		//关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	@Override
	public boolean update(Company cmpt) throws Exception {
		String sql="update company set cmpName=?,cmpPwd=?,cmpEmail=? where cmpId=?";
		//获取连接对象
		this.con=super.getcon();
		//创建执行SQL语句对象
		this.ps=this.con.prepareStatement(sql);
		this.ps.setString(1, cmpt.getCmpName());
		this.ps.setString(2, cmpt.getCmpPwd());
		this.ps.setString(3, cmpt.getCmpEmail());
		this.ps.setInt(4, cmpt.getCmpId());
		boolean bo=this.ps.executeUpdate()>0?true:false;
		//关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	@Override
	public boolean del(int cmpId) throws Exception {
		String sql="delete from company where cmpId=?";
		//获取连接对象
		this.con=super.getcon();
		//创建执行SQL语句对象
		this.ps=this.con.prepareStatement(sql);
		this.ps.setInt(1, cmpId);
		boolean bo=this.ps.executeUpdate()>0?true:false;
		//关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	@Override
	public boolean save(Company cmpt) throws Exception {
		String sql="if not exists(select * from company where cmpName=?) insert into company(cmpName,cmpPwd,cmpEmail) values(?,?,?)";
		//获取连接对象
		this.con=super.getcon();
		//创建执行SQL语句对象
		this.ps=this.con.prepareStatement(sql);
		this.ps.setString(1, cmpt.getCmpName());
		this.ps.setString(2, cmpt.getCmpName());
		this.ps.setString(3, cmpt.getCmpPwd());
		this.ps.setString(4, cmpt.getCmpEmail());
		boolean bo=this.ps.executeUpdate()>0?true:false;
		//关闭释放数据库操作资源
		super.close(rs, ps, con);
		return bo;
	}

	@Override
	public List<Company> getlist() throws Exception {
		String sql="select * from company";
		//获取连接对象
		this.con=super.getcon();
		//创建执行SQL语句对象
		this.ps=this.con.prepareStatement(sql);
		this.rs=this.ps.executeQuery();
		List<Company> list=new ArrayList<Company>();
		while(this.rs.next()){
			Company cmp=new Company(this.rs.getInt("cmpId"),this.rs.getString("cmpName"),this.rs.getString("cmpPwd"),this.rs.getString("cmpEmail"));
			list.add(cmp);
		}
		//关闭释放数据库操作资源
		super.close(rs, ps, con);
		return list;
	}

	@Override
	public Company getId(int cmpId) throws Exception {
		String sql="select * from company where cmpId=?";
		//获取连接对象
		this.con=super.getcon();
		//创建执行SQL语句对象
		this.ps=this.con.prepareStatement(sql);
		this.ps.setInt(1, cmpId);
		this.rs=this.ps.executeQuery();
		boolean bo=this.rs.next();
		Company cmpt=null;
		if(bo){
			cmpt=new Company(this.rs.getInt("cmpId"),this.rs.getString("cmpName"),this.rs.getString("cmpPwd"),this.rs.getString("cmpEmail"));
		}
		//关闭释放数据库操作资源
		super.close(rs, ps, con);
		return cmpt;
	}

}
