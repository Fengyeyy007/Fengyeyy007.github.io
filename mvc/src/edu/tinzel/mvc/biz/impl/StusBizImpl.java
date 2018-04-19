package edu.tinzel.mvc.biz.impl;

import java.util.List;

import edu.tinzel.mvc.biz.StusBiz;
import edu.tinzel.mvc.dao.StusDao;
import edu.tinzel.mvc.dao.impl.StusDaoImpl;
import edu.tinzel.mvc.entity.Stus;

public class StusBizImpl implements StusBiz {
	//创建业务逻辑层对象
	StusDao stusDao=new StusDaoImpl();
	@Override
	public boolean login(String name, String pwd) throws Exception {
		return this.stusDao.login(name, pwd);
	}

	@Override
	public boolean save(Stus stus) throws Exception {
		return this.stusDao.save(stus);
	}

	@Override
	public boolean update(Stus stus) throws Exception {
		return this.stusDao.update(stus);
	}

	@Override
	public boolean del(int id) throws Exception {
		return this.stusDao.del(id);
	}

	@Override
	public List<Stus> getlist() throws Exception {
		return this.stusDao.getlist();
	}

	@Override
	public Stus getId(int id) throws Exception {
		return this.stusDao.getId(id);
	}

}
