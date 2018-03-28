package edu.tinzel.mvccompany.dao;

import java.util.List;

import edu.tinzel.mvccompany.entity.Company;

public interface CompanyDao {
	/**
	 * 登录
	 * @param cmpName
	 * @param cmpPwd
	 * @return
	 * @throws Exception
	 */
	public boolean login(String cmpName,String cmpPwd)throws Exception;
	/**
	 * 修改
	 * @param cmpt
	 * @return
	 * @throws Exception
	 */
	public boolean update(Company cmpt)throws Exception;
	/**
	 * 删除
	 * @param cmpId
	 * @return
	 * @throws Exception
	 */
	public boolean del(int cmpId)throws Exception;
	/**
	 * 注册
	 * @param cmpt
	 * @return
	 * @throws Exception
	 */
	public boolean save(Company cmpt)throws Exception;
	/**
	 *查询全部
	 * @return
	 * @throws Exception
	 */
	public List<Company> getlist()throws Exception;
	/**
	 * 根据编号查询
	 * @param cmpId
	 * @return
	 * @throws Exception
	 */
	public Company getId(int cmpId)throws Exception;
}
