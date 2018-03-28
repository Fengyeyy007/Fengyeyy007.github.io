package edu.tinzel.mvccompany.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.group.Response;

import edu.tinzel.mvccompany.biz.CompanyBiz;
import edu.tinzel.mvccompany.biz.impl.CompanyBizImpl;
import edu.tinzel.mvccompany.entity.Company;
import edu.tinzel.mvccompany.util.MD5;

/**
 * Servlet implementation class CmpServlet
 */
public class CmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码-1
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//设置编码-3
		response.setContentType("text/html");
		String opt=request.getParameter("opt");
		if(opt.equals("login")){
			this.login(request, response);
		}else if(opt.equals("save")){
			this.save(request, response);
		}else if(opt.equals("update")){
			this.update(request, response);
		}else if(opt.equals("del")){
			this.del(request, response);
		}else if(opt.equals("getlist")){
			this.getlist(request, response);
		}else if(opt.equals("getId")){
			this.getId(request, response);
		}
	}
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			//获取账号密码
			//设置编码-2
//			String cmpName=request.getParameter("cmpName");
//			String cmpPwd=request.getParameter("cmpPwd");
			String cmpName=new String(request.getParameter("cmpName").getBytes("ISO-8859-1"),"utf-8");
			String cmpPwd=new String(request.getParameter("cmpPwd").getBytes("ISO-8859-1"),"utf-8");
			//在登录时将密码加密
			MD5 md5=new MD5();
			String md5String =md5.getMD5ofStr(cmpPwd);
			
			//创建业务逻辑层对象
			CompanyBiz cmpt=new CompanyBizImpl();
			boolean bo=cmpt.login(cmpName, md5String);
			//获取用户提供的验证码
			String randomss=request.getParameter("randomss");
			// 获取系统生成的验证码
			String rand=request.getSession().getAttribute("rand").toString();
			if(randomss.equals(rand)){
				//验证成功
				if(bo){
					//存用户名
					HttpSession session=request.getSession();
					session.setAttribute("cmpName", cmpName);
					//登录成功
					this.getlist(request, response);
				}else{
					//存到request中
					request.setAttribute("msg", "<font color='red'>用户名密码不匹配！</font>");
					//转发
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}else{
				//验证失败,验证码错误
				request.setAttribute("cmpName", cmpName);
				request.setAttribute("cmpPwd", cmpPwd);
				request.setAttribute("msg", "<font color='red'>验证码错误！</font>");
				//转发
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			//获取参数
			String cmpName=request.getParameter("cmpName");
			String cmpPwd=request.getParameter("cmpPwd");
			String cmpEmail=request.getParameter("cmpEmail");
			MD5 md5=new MD5();
			String md5String=md5.getMD5ofStr(cmpPwd);
			//创建业务逻辑层对象
			CompanyBiz cmpt=new CompanyBizImpl();
			boolean bo=cmpt.save(new Company(cmpName,md5String,cmpEmail));
			if(bo){
				request.setAttribute("cmpName", cmpName);
				//注册成功，则返回登录界面
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}else{
				//注册失败，返回注册界面
				request.setAttribute("mag", "<font color='red'>该用户名已存在！</font>");
				request.getRequestDispatcher("save.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			CompanyBiz cmpt=new CompanyBizImpl();
			String cmpId=request.getParameter("cmpId");
			cmpt.del(Integer.parseInt(cmpId));
			//删除成功之后查询全部
			this.getlist(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			//获取参数
			int cmpId=Integer.parseInt(request.getParameter("cmpId"));
			String cmpName=request.getParameter("cmpName");
			String cmpPwd=request.getParameter("cmpPwd");
			String cmpEmail=request.getParameter("cmpEmail");
			//创建业务逻辑层对象
			CompanyBiz cmpt=new CompanyBizImpl();
			cmpt.update(new Company(cmpId,cmpName,cmpPwd,cmpEmail));
			//直接调用查询全部
			this.getlist(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	protected void getlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			CompanyBiz cmptBiz=new CompanyBizImpl();
			List<Company> list=cmptBiz.getlist();
			request.setAttribute("aa",list);//将list集合存在request中
			//转发：服务器端跳转，地址栏中的地址不会发生变化，效率高
			request.getRequestDispatcher("getlist.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	protected void getId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			String cmpId=request.getParameter("cmpId");
			//创建业务逻辑层对象
			CompanyBiz cmpt=new CompanyBizImpl();
			Company cmpts=cmpt.getId(Integer.parseInt(cmpId));
			request.setAttribute("cmps", cmpts);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
