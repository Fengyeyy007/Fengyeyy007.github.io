package edu.tinzel.mvc.biz;

import java.util.List;

import edu.tinzel.mvc.entity.Stus;

public interface StusBiz {
	/**
	 * 登录
	 * @param name
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public boolean login(String name,String pwd)throws Exception;
	/**
	 * 注册
	 * @param stus
	 * @return
	 * @throws Exception
	 */
	public boolean save(Stus stus)throws Exception;
	/**
	 * 修改
	 * @param stus
	 * @return
	 * @throws Exception
	 */
	public boolean update(Stus stus)throws Exception;
	/**
	 * 删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean del(int id) throws Exception;
	/**
	 * 查询全部，返回集合
	 * @return
	 * @throws Exception
	 */
	public List<Stus> getlist()throws Exception;
	/**
	 * 根据编号查询，返回Stus
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Stus getId(int id)throws Exception;
}
