package edu.tinzel.mvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;
import edu.tinzel.mvc.biz.StusBiz;
import edu.tinzel.mvc.biz.impl.StusBizImpl;
import edu.tinzel.mvc.entity.Stus;


public class mvcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
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
			//获取参数
			String name=request.getParameter("name");
			String pwd=request.getParameter("pwd");
			//创建业务逻辑层对象
			StusBiz stus=new StusBizImpl();
			boolean bo=stus.login(name, pwd);
			if(bo){
				//登陆成功！
				this.getlist(request, response);//调用查询全部方法
			}else{
				//登陆失败！
				//重定向
				//存在request 
				request.setAttribute("msg", "<font color='red'>出错了！账号密码不匹配！</font>");
				//response.sendRedirect("index.jsp");//回到登录界面
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
			String name=request.getParameter("name");
			String pwd=request.getParameter("pwd");
			String age=request.getParameter("age");
			//创建业务逻辑层
			StusBiz stusBiz=new StusBizImpl();
			boolean bo=stusBiz.save(new Stus(name,pwd,Integer.parseInt(age)));
			if(bo){
				//注册成功，返回登录界面
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				//注册失败，返回注册界面，并提示
				request.setAttribute("mag","<font color='red'>该用户名已存在！</font>");
				request.getRequestDispatcher("save.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String pwd=request.getParameter("pwd");
			int age=Integer.parseInt(request.getParameter("age"));
			StusBiz stusBiz=new StusBizImpl();
			//改
			stusBiz.update(new Stus(id,name,pwd,age));
			//直接调用查询全部
			this.getlist(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			StusBiz stusBiz=new StusBizImpl();
			String id=request.getParameter("id");
			stusBiz.del(Integer.parseInt(id));
			//删除成功之后查询全部
			this.getlist(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void getlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			StusBiz stus=new StusBizImpl();
			List<Stus> list=stus.getlist();
			//把list集合存在request中
			request.setAttribute("aa", list);
			//转发：服务器端跳转，地址栏中的地址不会发生变化，效率高
			request.getRequestDispatcher("getlist.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void getId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			String id=request.getParameter("id");
			//创建业务逻辑层对象
			StusBiz stusBiz=new StusBizImpl();
			Stus stu=stusBiz.getId(Integer.parseInt(id));
			request.setAttribute("stusa",stu);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
