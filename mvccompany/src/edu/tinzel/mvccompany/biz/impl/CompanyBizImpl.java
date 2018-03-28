package edu.tinzel.mvccompany.biz.impl;

import java.util.List;

import edu.tinzel.mvccompany.biz.CompanyBiz;
import edu.tinzel.mvccompany.dao.CompanyDao;
import edu.tinzel.mvccompany.dao.impl.CompanyDaoImpl;
import edu.tinzel.mvccompany.entity.Company;

public class CompanyBizImpl implements CompanyBiz {
	//创建访问实体类对象
	CompanyDao companyDao=new CompanyDaoImpl();
	@Override
	public boolean login(String cmpName, String cmpPwd) throws Exception {
		
		return this.companyDao.login(cmpName, cmpPwd);
	}

	@Override
	public boolean update(Company cmpt) throws Exception {

		return this.companyDao.update(cmpt);
	}

	@Override
	public boolean del(int cmpId) throws Exception {

		return this.companyDao.del(cmpId);
	}

	@Override
	public boolean save(Company cmpt) throws Exception {

		return this.companyDao.save(cmpt);
	}

	@Override
	public List<Company> getlist() throws Exception {

		return this.companyDao.getlist();
	}

	@Override
	public Company getId(int cmpId) throws Exception {

		return this.companyDao.getId(cmpId);
	}

}
