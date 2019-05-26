package action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Appoint;
import model.Archives;
import model.Gonggao;
import model.Jichu;
import model.Kaoshi;
import model.Kaoshijilu;
import model.Keshi;
import model.Manager;
import model.Product;
import model.Shiti;
import model.User;
import model.Visit;

import org.apache.struts2.ServletActionContext;
import util.Pager;
import util.Util;

import com.opensymphony.xwork2.ActionSupport;

import dao.AppointDao;
import dao.ArchivesDao;
import dao.GonggaoDao;
import dao.JichuDao;
import dao.KaoshiDao;
import dao.KaoshijiluDao;
import dao.KeshiDao;
import dao.ManagerDao;
import dao.ProductDao;
import dao.ShitiDao;
import dao.UserDao;
import dao.VisitDao;


public class ManageAction extends ActionSupport{

	
	private static final long serialVersionUID = 1L;
	
	
	private String url="./";
	


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	
	private UserDao userDao;
	private GonggaoDao gonggaoDao;
	private ManagerDao managerDao;
	private KeshiDao keshiDao;
	private JichuDao jichuDao;
	private VisitDao visitDao;
	private AppointDao appointDao;
	private ArchivesDao archivesDao;
	private ProductDao productDao;
	private ShitiDao shitiDao;
	private KaoshiDao kaoshiDao;
	private KaoshijiluDao kaoshijiluDao;


	
	public ShitiDao getShitiDao() {
		return shitiDao;
	}


	public void setShitiDao(ShitiDao shitiDao) {
		this.shitiDao = shitiDao;
	}


	public KaoshiDao getKaoshiDao() {
		return kaoshiDao;
	}


	public void setKaoshiDao(KaoshiDao kaoshiDao) {
		this.kaoshiDao = kaoshiDao;
	}


	public KaoshijiluDao getKaoshijiluDao() {
		return kaoshijiluDao;
	}


	public void setKaoshijiluDao(KaoshijiluDao kaoshijiluDao) {
		this.kaoshijiluDao = kaoshijiluDao;
	}
	
	
	
	
	public ProductDao getProductDao() {
		return productDao;
	}


	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}


	public AppointDao getAppointDao() {
		return appointDao;
	}


	public void setAppointDao(AppointDao appointDao) {
		this.appointDao = appointDao;
	}


	public VisitDao getVisitDao() {
		return visitDao;
	}

	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}


	public JichuDao getJichuDao() {
		return jichuDao;
	}


	public void setJichuDao(JichuDao jichuDao) {
		this.jichuDao = jichuDao;
	}


	public KeshiDao getKeshiDao() {
		return keshiDao;
	}
	public void setKeshiDao(KeshiDao keshiDao) {
		this.keshiDao = keshiDao;
	}


	public GonggaoDao getGonggaoDao() {
		return gonggaoDao;
	}


	public void setGonggaoDao(GonggaoDao gonggaoDao) {
		this.gonggaoDao = gonggaoDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public ManagerDao getManagerDao() {
		return managerDao;
	}


	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	

	 public ArchivesDao getArchivesDao() {
		return archivesDao;
	}


	public void setArchivesDao(ArchivesDao archivesDao) {
		this.archivesDao = archivesDao;
	}

	private File uploadfile;
		
	 public File getUploadfile() {
			return uploadfile;
		}	
	 public void setUploadfile(File uploadfile) {
			this.uploadfile = uploadfile;
		}

	//user login
	public void login() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Manager manager = managerDao.selectBean(" where username='"+username+"' and password='"+password+"' and  managerlock=0 ");
		if(manager!=null){
			HttpSession session = request.getSession();
			session.setAttribute("manager", manager);
			response.setCharacterEncoding("gbk");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('Login successfully');window.location.href='index.jsp'; </script>");
		}else{
			response.setCharacterEncoding("gbk");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('Error in username or password');window.location.href='login.jsp'; </script>");
		}

	}
	
	//user logout
	public void loginout() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Exit successfully');window.location.href='login.jsp'; </script>");
	}
	
	
	//skip to change password
	public String passwordupdate(){
		this.setUrl("manager/passwordupdate.jsp");
		return SUCCESS;
	}
	
	
	//change password
	public void passwordupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		HttpSession session = request.getSession();
		Manager manager = (Manager)session.getAttribute("manager");
		Manager bean = managerDao.selectBean(" where username='"+manager.getUsername()+"' and password='"+password1+"' ");
		if(bean!=null){
			bean.setPassword(password2);
			managerDao.updateBean(bean);
			response.setCharacterEncoding("utf8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('Successful operation'); </script>");
		}else{
			response.setCharacterEncoding("utf8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('The original password is wrong, the modification failed!!!!');window.location.href='method!passwordupdate'; </script>");
		}		
	}

	  
		//skip to admin profile
		public String managerupdate(){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Manager bean = (Manager)session.getAttribute("manager");	
			request.setAttribute("bean", bean);
			this.setUrl("manager/managerupdate.jsp");
			return SUCCESS;
		}
		
		
	  
	//user list
	public String userlist(){
	   HttpServletRequest request = ServletActionContext.getRequest();
	       String username = request.getParameter("username");
	       String birthday = request.getParameter("birthday");
	       StringBuffer sb = new StringBuffer();
	       sb.append(" where ");
	       if(birthday !=null &&!"".equals(birthday)){
			     sb.append(" birthday like '"+birthday+"' ");
			     sb.append(" and ");
			     request.setAttribute("birthday", birthday);
		    }
	       if(username !=null &&!"".equals(username)){
		     sb.append(" username like '"+username+"' ");
		     sb.append(" and ");
		     request.setAttribute("username", username);
	       }
	    sb.append(" role=1 and userlock=0  order by id desc ");
		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		long total = userDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<User> list = userDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!userlist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("user/userlist.jsp");
		return SUCCESS;
	}
	
	
	//skip to user update 
	public String userupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		User bean =userDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("user/userupdate.jsp");
		return SUCCESS;
	}


	//user update
	public void userupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String truename = request.getParameter("truename");
		String telephone = request.getParameter("telephone");
		String jiguan = request.getParameter("jiguan");
		String address = request.getParameter("address");
		String xingbie = request.getParameter("xingbie");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		User bean =userDao.selectBean(" where id= "+id);
		bean.setTruename(truename);
		bean.setTelephone(telephone);
		bean.setJiguan(jiguan);
		bean.setAddress(address);
		bean.setXingbie(xingbie);
		bean.setAge(age);
		bean.setEmail(email);
		bean.setCreatetime(new Date());
		userDao.updateBean(bean);
		response.setCharacterEncoding("utf8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!userlist'; </script>");
	}
	
	
	
	//delete user
	public void userdelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		User bean =userDao.selectBean(" where id= "+id);
		bean.setUserlock(1);
		userDao.insertBean(bean);
		response.setCharacterEncoding("utf8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!userlist'; </script>");
		
	}
	

	
	//no use
	public String gonggaolist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String biaoti = request.getParameter("biaoti");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if(biaoti !=null &&!"".equals(biaoti)){
			sb.append(" biaoti like '%"+biaoti+"%' ");
			sb.append(" and ");

			request.setAttribute("biaoti", biaoti);
		}
		
		sb.append(" gonggaolock=0 order by id desc ");

		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		
		long total = gonggaoDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Gonggao> list = gonggaoDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!gonggaolist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("gonggao/gonggaolist.jsp");
		return SUCCESS;
	}
	
	
	//no use
	public String gonggaoadd(){
		this.setUrl("gonggao/gonggaoadd.jsp");
		return SUCCESS;
	}
	
	
	//no use
	public void gonggaoadd2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String biaoti = request.getParameter("biaoti");
		String content = request.getParameter("content");
		Gonggao bean = new Gonggao();
		bean.setBiaoti(biaoti);
		bean.setContent(content);
		bean.setCreatetime(new Date());
		gonggaoDao.insertBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!gonggaolist'; </script>");
		
	}
	
	
	//no use
	public void gonggaodelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Gonggao bean =gonggaoDao.selectBean(" where id= "+id);
		bean.setGonggaolock(1);
		gonggaoDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!gonggaolist'; </script>");
		
	}
	
	//no use
	public String gonggaoupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Gonggao bean =gonggaoDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("gonggao/gonggaoupdate.jsp");
		return SUCCESS;
	}
	
	
	//no use
	public void gonggaoupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String biaoti = request.getParameter("biaoti");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		Gonggao bean =gonggaoDao.selectBean(" where id= "+id);
		bean.setBiaoti(biaoti);
		bean.setContent(content);
		gonggaoDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!gonggaolist'; </script>");
		
	}
	
	//no use
	public String gonggaoupdate3(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Gonggao bean =gonggaoDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("gonggao/gonggaoupdate3.jsp");
		return SUCCESS;
	}
	

	
	//department list
	public String keshilist(){
		HttpServletRequest request = ServletActionContext.getRequest();
	
		String name = request.getParameter("name");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		if(name !=null &&!"".equals(name)){
			sb.append(" name like '%"+name+"%' ");
			sb.append(" and ");

			request.setAttribute("name", name);
		}
		sb.append(" keshilock=0 order by id desc ");
		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		
		long total = keshiDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Keshi> list = keshiDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!keshilist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("keshi/keshilist.jsp");
		return SUCCESS;
	}
	
	
	//skip to add department
	public String keshiadd(){
		this.setUrl("keshi/keshiadd.jsp");
		return SUCCESS;
	}
	
	
	//Add department
	public void keshiadd2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		Keshi bean=keshiDao.selectBean(" where  keshilock=0 and name='"+name+"' " );
		if(bean==null){
			bean = new Keshi();
			bean.setName(name);
			bean.setContent(content);
			bean.setCreatetime(new Date());
			keshiDao.insertBean(bean);
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!keshilist'; </script>");
		}else{
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('This department has been added. Please add it again.');window.location.href='method!keshilist'; </script>");	
		}	
	}
	
	
	
	//Delete department
	public void keshidelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Keshi bean =keshiDao.selectBean(" where id= "+id);
		bean.setKeshilock(1);
		keshiDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!keshilist'; </script>");
		
	}
	
	//skip to update department
	public String keshiupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Keshi bean =keshiDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("keshi/keshiupdate.jsp");
		return SUCCESS;
	}
	
	
	//update department
	public void keshiupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		Keshi bean =keshiDao.selectBean(" where id= "+id);
		bean.setName(name);
		bean.setContent(content);
		bean.setCreatetime(new Date());
		keshiDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!keshilist'; </script>");
		
	}
	
	
	
	//doctor list
	public String y_userlist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String truename = request.getParameter("truename");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		if(username !=null &&!"".equals(username)){
			sb.append(" username like '%"+username+"%' ");
			sb.append(" and ");
			request.setAttribute("username", username);
		}
		if(truename !=null &&!"".equals(truename)){
			sb.append(" truename like '%"+truename+"%' ");
			sb.append(" and ");
			request.setAttribute("truename", truename);
		}
		sb.append(" userlock=0 and role=2 order by id desc ");
		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		long total = userDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<User> list = userDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!y_userlist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("user/y_userlist.jsp");
		return SUCCESS;
	}
	
	
	 
	
	//skip to add doctor 
	public String y_useradd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Keshi> list = keshiDao.selectBeanList(0, 99, " where keshilock=0 ");
		request.setAttribute("list", list);
		this.setUrl("user/y_useradd.jsp");
		return SUCCESS;
	}
	
	
	//add doctor
	public void y_useradd2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String username = request.getParameter("username");
		String truename = request.getParameter("truename");
		String telephone = request.getParameter("telephone");
		String keshi = request.getParameter("keshi");
		String zhicheng = request.getParameter("zhicheng");
		String content = request.getParameter("content");
		String  shangchang = request.getParameter("shangchang");
		
		
		String savapath = "C:/temp/";
		String time = Util.getTime2();
		String imgpath = time+".jpg";
		File file = new File(savapath+imgpath);
		Util.copyFile(uploadfile, file);
		
		User bean=userDao.selectBean(" where  userlock=0 and username="+username);
		if(bean==null){
			bean = new User();
			bean.setUsername(username);
			bean.setTruename(truename);
			bean.setTelephone(telephone);
			bean.setKeshi(keshiDao.selectBean(" where id="+keshi));
			bean.setZhicheng(zhicheng);
			bean.setContent(content);
			bean.setShangchang(shangchang);
			bean.setRole(2);
			bean.setPassword("123456");
			bean.setImgpath(imgpath);
			bean.setCreatetime(new Date());
			userDao.insertBean(bean);
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!y_userlist'; </script>");
			
		}else{
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('The doctor has been added. Please add it again.');window.location.href='method!y_userlist'; </script>");
			
		}
		
	}
	
	
	
	//delete doctor
	public void y_userdelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		User bean =userDao.selectBean(" where id= "+id);
		bean.setUserlock(1);
		userDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!y_userlist'; </script>");
		
	}
	
	//skip to update doctor
	public String y_userupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		User bean =userDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		List<Keshi> list = keshiDao.selectBeanList(0, 99, " where keshilock=0 ");
		request.setAttribute("list", list);
		this.setUrl("user/y_userupdate.jsp");
		return SUCCESS;
	}
	
	
	//update doctor
	public void y_userupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String truename = request.getParameter("truename");
		String telephone = request.getParameter("telephone");
		String keshi = request.getParameter("keshi");
		String zhicheng = request.getParameter("zhicheng");
		String content = request.getParameter("content");
		String  shangchang = request.getParameter("shangchang");
		String id = request.getParameter("id");
		User bean =userDao.selectBean(" where id= "+id);
		bean.setTruename(truename);
		bean.setTelephone(telephone);
		bean.setKeshi(keshiDao.selectBean(" where id="+keshi));
		bean.setZhicheng(zhicheng);
		bean.setContent(content);
		bean.setShangchang(shangchang);
		bean.setCreatetime(new Date());
		userDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!y_userlist'; </script>");
		
	}
	

	
	//hospital information list
	public String jichulist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		sb.append(" jichulock=0 order by id desc ");
		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		
		long total = jichuDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Jichu> list = jichuDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!jichulist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("jichu/jichulist.jsp");
		return SUCCESS;
	}
	
	
	//no use
	public String jichuadd() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		Jichu jichu=jichuDao.selectBean(" where jichulock=0 order by id desc");
		if(jichu!=null){
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('Information has been added without adding');window.location.href='method!jichulist'; </script>");
		return null;
		}
		else{
			this.setUrl("jichu/jichuadd.jsp");
		}
		return SUCCESS;
		
	}
	
	
	// no use
	public void jichuadd2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String content = request.getParameter("content");
		
		String savapath = "C:/temp/";
		String time = Util.getTime2();
		String imgpath = time+".jpg";
		File file = new File(savapath+imgpath);
		Util.copyFile(uploadfile, file);
		Jichu bean = new Jichu();
		bean.setContent(content);
		bean.setImgpath(imgpath);
		bean.setCreatetime(new Date());
		jichuDao.insertBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!jichulist'; </script>");
		
	}
	
	
	//no use
	public String jichuupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Jichu bean =jichuDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("jichu/jichuupdate.jsp");
		return SUCCESS;
	}
	
	
	//no use
	public void jichuupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String content = request.getParameter("content");
		
		String savapath = "C:/temp/";
		String time = Util.getTime2();
		String imgpath = time+".jpg";
		File file = new File(savapath+imgpath);
		Util.copyFile(uploadfile, file);
		String id = request.getParameter("id");
		Jichu bean =jichuDao.selectBean(" where id= "+id);
		bean.setContent(content);
		bean.setImgpath(imgpath);
		bean.setCreatetime(new Date());
		jichuDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!jichulist'; </script>");
		
	}
	
	
	
	
	//doctor schedule list
	public String visitlist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String truename = request.getParameter("truename");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		if(truename !=null &&!"".equals(truename)){
			sb.append(" user.truename like '%"+truename+"%' ");
			sb.append(" and ");

			request.setAttribute("truename", truename);
		}
		sb.append(" visitlock=0 order by id desc ");
		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}	
		long total = visitDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Visit> list = visitDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!visitlist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("visit/visitlist.jsp");
		return SUCCESS;
	}
	
	
	//skip to add doctor schedule
	public String visitadd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<User> list = userDao.selectBeanList(0, 999, " where role=2 and userlock=0 ");
		request.setAttribute("list", list);
		this.setUrl("visit/visitadd.jsp");
		return SUCCESS;
	}
	
	
	//add doctor schedule
	public void visitadd2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String user = request.getParameter("user");
		User u=userDao.selectBean(" where id="+user);
		String times = request.getParameter("times");
		Integer num = Integer.parseInt(request.getParameter("num"));
			Visit	bean=visitDao.selectBean(" where user="+u.getId()+" and times='"+times+"' and visitlock=0 ");
			if(bean==null){
				bean = new Visit();
				bean.setUser(u);
				bean.setTimes(times);
				bean.setNum(num);
				bean.setStauts("Not Full");
				bean.setGztime("8:30-17:00");
				bean.setCreatetime(new Date());
				visitDao.insertBean(bean);
				response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
				PrintWriter writer = response.getWriter();
				writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!visitlist'; </script>");

			}else{
				response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
				PrintWriter writer = response.getWriter();
				writer.print("<script  language='javascript'>alert('This time period has been added by the doctor. Please add it again.');window.location.href='method!visitlist'; </script>");

			}
			
	}
	
	
	
	//delete doctor schedule
	public void visitdelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Visit bean =visitDao.selectBean(" where id= "+id);
		bean.setVisitlock(1);
		visitDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!visitlist'; </script>");
		
	}
	
	
	//vitals list
	public String archiveslist() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		StringBuffer sb = new StringBuffer();
		sb.append(" where  archiveslock=0   order by stauts desc ");
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		String where = sb.toString();
		long total = archivesDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Archives> list = archivesDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!archiveslist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("archives/archiveslist.jsp");
		return SUCCESS;
	}
	
	
	//skip to vitals 
	public String archivesupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Archives bean =archivesDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		List<User> list = userDao.selectBeanList(0, 99, " where userlock=0  and role=1 ");
		request.setAttribute("list", list);
		this.setUrl("archives/archivesupdate.jsp");
		return SUCCESS;
	}
	

	
	
	//add vitals(admin)
	public void archivesupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String user = request.getParameter("user");
		User u=userDao.selectBean(" where id="+user);
		String sg = request.getParameter("sg");
		String tz = request.getParameter("tz");
		String xa = request.getParameter("xa");
		String xt = request.getParameter("xt");
		String xz = request.getParameter("xz");
		String tnb = request.getParameter("tnb");
		String xxg = request.getParameter("xxg");
		String xy = request.getParameter("xy");
		String mb = request.getParameter("mb");
		String xint = request.getParameter("xint");
		String fhl = request.getParameter("fhl");
		String content = request.getParameter("content");
		String times = request.getParameter("times");
		Archives bean=archivesDao.selectBean(" where user="+u.getId()+"  and archiveslock=0 ");
		if(bean==null){
		bean=new Archives();
		bean.setBianhao(new Date().getTime()+"");
		bean.setSg(sg);
		bean.setTz(tz);
		bean.setXa(xa);
		bean.setXt(xt);
		bean.setXz(xz);
		bean.setTnb(tnb);
		bean.setXxg(xxg);
		bean.setXy(xy);
		bean.setMb(mb);
		bean.setXint(xint);
		bean.setFhl(fhl);
		bean.setContent(content);
		bean.setUser(u);
		bean.setTimes(times);
		bean.setStauts("Finished");
		bean.setCreatetime(new Date());
		archivesDao.insertBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!archiveslist'; </script>");
		}else{
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('The user has been checked up and the operation failed.');window.location.href='method!archivesupdate'; </script>");
		}
	}
	
	

	//delete vitals
	public void archivesdelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Archives bean =archivesDao.selectBean(" where id= "+id);
		bean.setArchiveslock(1);
		archivesDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Delete successful');window.location.href='method!archiveslist'; </script>");

	}
	
	
	//skip to vitals (admin)
	public String xq_archivesupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Archives bean =archivesDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("archives/xq_archivesupdate.jsp");
		return SUCCESS;
	}
	
	
	//medicine management
	public String productlist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String bianhao=request.getParameter("bianhao");
		String name=request.getParameter("name");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		if(bianhao!=null&&!"".equals(bianhao) ){
        	sb.append("bianhao like '%"+bianhao+"%'");
        	sb.append(" and ");
        	request.setAttribute("bianhao", bianhao);
        }
		if(name!=null&&!"".equals(name) ){
        	sb.append("name like '%"+name+"%'");
        	sb.append(" and ");
        	request.setAttribute("name", name);
        }
		 sb.append(" productlock=0 order by id desc ");
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		String where =sb.toString();
		long total = productDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!productlist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		List<Product> list = productDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where);
		request.setAttribute("list", list);
		this.setUrl("product/productlist.jsp");
		return SUCCESS;
	}
	
	
	
	//delete medicine
	public void productdelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Product bean =productDao.selectBean(" where id= "+id);
		bean.setProductlock(1);
		productDao.updateBean(bean);
		response.setCharacterEncoding("utf8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Delete successful');window.location.href='method!productlist'; </script>");
		
	}
	
	//skip to add medicine
	public String productadd(){
		this.setUrl("product/productadd.jsp");
		return SUCCESS;
	}
	
	
	//Add Medicine
	public void productadd2()throws IOException{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		String jingzhong = request.getParameter("jingzhong");
		String guige = request.getParameter("guige");
		String gongxiao = request.getParameter("gongxiao");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		Date createtime=new Date();	
		Product bean=productDao.selectBean(" where name='"+name+"' and productlock=0 ");
		if(bean==null){
		bean=new Product();
		bean.setBianhao(new Date().getTime()+"");	
		bean.setJingzhong(jingzhong);	
		bean.setGuige(guige);	
		bean.setGongxiao(gongxiao);	
		bean.setName(name);	
		bean.setPrice(Double.parseDouble(price));	
		bean.setCreatetime(createtime);	
		productDao.insertBean(bean);
		response.setCharacterEncoding("utf8");
		PrintWriter writer=response.getWriter();
		writer.print("<script language='javascript'>alert('Submit successfully');window.location.href='method!productlist'; </script> ");
		}else{
			response.setCharacterEncoding("utf8");
			PrintWriter writer=response.getWriter();
			writer.print("<script language='javascript'>alert('The name of the medicine already exists. Please add it again.');window.location.href='method!productadd'; </script> ");
		}

	   }
	
	
	//skip to update medicine
	public String productupdate(){
		HttpServletRequest request = ServletActionContext.getRequest(); 
		String id = request.getParameter("id");
		Product bean =productDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("product/productupdate.jsp");
		return SUCCESS;
	}

	
	//update medicine
	public void productupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String jingzhong = request.getParameter("jingzhong");
		String guige = request.getParameter("guige");
		String gongxiao = request.getParameter("gongxiao");
		String price = request.getParameter("price");
		String id = request.getParameter("id");
		Product bean =productDao.selectBean(" where id= "+id);	
		bean.setJingzhong(jingzhong);	
		bean.setGuige(guige);	
		bean.setGongxiao(gongxiao);	
		bean.setPrice(Double.parseDouble(price));	
		productDao.updateBean(bean);
		response.setCharacterEncoding("utf8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!productlist'; </script>");
		
	}
	
	
	//question list
	public String shitilist()  {
		HttpServletRequest request = ServletActionContext.getRequest();
		String wenti = request.getParameter("wenti");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		if(wenti!=null&&!"".equals(wenti)){
			sb.append("wenti like '%"+wenti+"%'");
			sb.append(" and ");
			request.setAttribute("wenti", wenti);
		}
		sb.append("  shitilock=0  order by id desc");
		String where = sb.toString();
		int currentpage = 1;
		int pagesize =10;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		long total = shitiDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Shiti> list = shitiDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!shitilist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
	    this.setUrl("shiti/shitilist.jsp");
		return SUCCESS;
	}
	
	

//skip to add question
	public String shitiadd() {
		this.setUrl("shiti/shitiadd.jsp");
		return SUCCESS;
	}
	
	
	
//add question
	public void shitiadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String wenti = request.getParameter("wenti");
		Shiti bean = new Shiti();
		bean.setCreatetime(new Date());
		bean.setWenti(wenti);
		shitiDao.insertBean(bean);
		response.setCharacterEncoding("utf8");response.setContentType("text/html; charset=utf8");
		response.getWriter().print("<script language=javascript>alert('Add successfully!');window.location.href='method!shitilist';</script>");	
	}
	
	
	//delete question
	public void shitidelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Shiti bean = shitiDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setShitilock(1);
		shitiDao.updateBean(bean);
		response.setCharacterEncoding("utf8");response.setContentType("text/html; charset=utf8");
		response.getWriter().print("<script language=javascript>alert('Delete successful');window.location.href='method!shitilist';</script>");
	}
	

	//the result of questionnaire
	public String kaoshilist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		sb.append(" kaoshilock=0   order by createtime desc ");
		int currentpage = 1;
		int pagesize = 20;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		String where =sb.toString();
		long total = kaoshiDao.selectBeanCount(where.replaceAll(" order by id desc", ""));
		List<Kaoshi> list = kaoshiDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!kaoshilist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("kaoshi/kaoshilist.jsp");
		return SUCCESS;
	}


	//view the result of questionnaire
	public String kaoshijilulist() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		sb.append(" kaoshi="+id+"  order by id desc ");
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		String where =sb.toString();
		long total = kaoshijiluDao.selectBeanCount(where.replaceAll(" order by id desc", ""));
		List<Kaoshijilu> list = kaoshijiluDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!kaoshijilulist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("kaoshi/kaoshijilulist.jsp");
		return SUCCESS;
	}
	
	
	
	//medical history
	public String appointlist() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String truename = request.getParameter("truename");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		if(username !=null &&!"".equals(username)){
			sb.append(" user.username like '%"+username+"%' ");
			sb.append(" and ");
			request.setAttribute("username", username);
		}
		if(truename !=null &&!"".equals(truename)){
			sb.append(" user.truename like '%"+truename+"%' ");
			sb.append(" and ");
			request.setAttribute("truename", truename);
		}
		sb.append(" appointlock=0  and  money>0 order by id desc ");//就诊情况下
		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 9;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		long total = appointDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Appoint> list = appointDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!appointlist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("appoint/appointlist.jsp");
		return SUCCESS;
	}
	
	//diagnose details(admin)
	public String xq_appoint(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Appoint bean =appointDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("appoint/xq_appoint.jsp");
		return SUCCESS;
	}
	
	
	//delete medical history(admin)
	public void appointdelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Appoint bean =appointDao.selectBean(" where id= "+id);
		bean.setAppointlock(1);
		appointDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Delete successful');window.location.href='method!appointlist'; </script>");
		
	}
	
	
	
	//skip to add doctor schedule
	public String appointadd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<User> list = userDao.selectBeanList(0, 999, " where role=1 and userlock=0 ");
		request.setAttribute("list", list);
		this.setUrl("appoint/appointadd.jsp");
		return SUCCESS;
	}
	
	
	//add medical history
	public void appointadd2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String user = request.getParameter("user");
		User u=userDao.selectBean(" where id="+user);
		String riq = request.getParameter("riq");
		String content = request.getParameter("content");
		String procontent = request.getParameter("procontent");
		String appcontent = request.getParameter("appcontent");
		Double money =Double.parseDouble( request.getParameter("money"));
		String fujian = request.getParameter("fujian");
		String fujianYuanshiming = request.getParameter("fujianYuanshiming");
		
			Appoint	bean=appointDao.selectBean(" where user="+u.getId()+" and riq='"+riq+"' and appointlock=0 ");
			if(bean==null){
				bean = new Appoint();
				bean.setUser(u);
				bean.setRiq(riq);
				bean.setContent(content);
				bean.setProcontent(procontent);
				bean.setAppcontent(appcontent);
				bean.setMoney(money);
				bean.setFujian(fujian);
				bean.setFujianYuanshiming(fujianYuanshiming);
				bean.setCreatetime(new Date());
				appointDao.insertBean(bean);
				response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
				PrintWriter writer = response.getWriter();
				writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!appointlist'; </script>");

			}else{
				response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
				PrintWriter writer = response.getWriter();
				writer.print("<script  language='javascript'>alert('This date has been added by the user. Please add it again.');window.location.href='method!appointlist'; </script>");

			}
			
	}
	
	
	//admin list
	public String managerlist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		if(username !=null &&!"".equals(username)){
			sb.append(" username like '%"+username+"%' ");
			sb.append(" and ");
			request.setAttribute("username", username);
		}
		sb.append(" managerlock=0 order by id desc ");
		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		long total = managerDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Manager> list = managerDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!managerlist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("manager/managerlist.jsp");
		return SUCCESS;
	}
	
	
	//skip to add admin
	public String manageradd(){
		this.setUrl("manager/manageradd.jsp");
		return SUCCESS;
	}
	
	
	//add admin
	public void manageradd2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Manager bean=managerDao.selectBean(" where  managerlock=0 and username='"+username+"' " );
		if(bean==null){
			bean = new Manager();
			bean.setUsername(username);
			bean.setPassword(password);
			bean.setCreatetime(new Date());
			managerDao.insertBean(bean);
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!managerlist'; </script>");
		}else{
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('This administrator has been added, Please add another');window.location.href='method!managerlist'; </script>");	
		}	
	}
	
	
	
	//delete admin
	public void managerdelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Manager bean =managerDao.selectBean(" where id= "+id);
		managerDao.deleteBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!managerlist'; </script>");
		
	}
	
	
	

	 //appointment list
	public String y_visitlist() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String riq = request.getParameter("riq");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		if(username !=null &&!"".equals(username)){
			sb.append(" user.username like '%"+username+"%' ");
			sb.append(" and ");
			request.setAttribute("username", username);
		}
		if(riq !=null &&!"".equals(riq)){
			sb.append(" riq like '%"+riq+"%' ");
			sb.append(" and ");
			request.setAttribute("riq", riq);
		}
		sb.append(" visit.visitlock=0 and content is null and appointlock=0  order by id desc ");
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		String where = sb.toString();
		long total = appointDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Appoint> list = appointDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!y_visitlist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("visit/y_visitlist.jsp");
		return SUCCESS;
	}
	
	
	//add appointment
	public String y_appointadd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Visit bean =visitDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		List<User> list = userDao.selectBeanList(0, 99, " where role=1 and userlock=0 ");
		request.setAttribute("list", list);
		this.setUrl("appoint/y_appointadd.jsp");
		return SUCCESS;
	}


	//add appointment
	public void y_appointadd2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Visit h =visitDao.selectBean(" where id= "+id);
		String times = request.getParameter("times");
		String user = request.getParameter("user");
		User u =userDao.selectBean(" where id="+user);

		Appoint b=appointDao.selectBean(" where times='"+times+"' and visitid="+h.getId()+" and appointlock=0 ");
		if(b!=null){
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('This time has been reserved. Please re-select it.');window.location.href='method!visitlist'; </script>");
			return ;
		}
		Appoint c=appointDao.selectBean(" where userid="+u.getId()+" and visit="+h.getId()+" and appointlock=0 ");
		if(c==null){
			Appoint bean = new Appoint();
			bean.setVisit(h);
			bean.setUser(u);
			bean.setNumber(1);
			bean.setTimes(times);
			bean.setRiq(h.getTimes());
			bean.setCreatetime(new Date());
			h.setBnum(h.getBnum()+1);
			if(h.getNum()-h.getBnum() >0){
				appointDao.insertBean(bean);
				visitDao.updateBean(h);
			}
			if(h.getNum()-h.getBnum() ==0){
				h.setStauts("Is Full");
				appointDao.insertBean(bean);
				visitDao.updateBean(h);
			}
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('Successful appointment');window.location.href='method!visitlist'; </script>");
		}	
		else{
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('The user has made an appointment! No need to repeat appointment');window.location.href='method!visitlist'; </script>");

		}
	}


	//delete appointment
	public void appointdelete2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Appoint bean=appointDao.selectBean(" where  id="+id);
		bean.setAppointlock(1);
		appointDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Cancellation of success');window.location.href='method!y_visitlist'; </script>");
		
	}	
	
	
	 //report
	public String tj_appointlist() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String startime = request.getParameter("startime");
		String endtime = request.getParameter("endtime");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		if(startime !=null &&!"".equals(startime)){
			sb.append(" riq >= '"+startime+"' ");
			sb.append(" and ");
			request.setAttribute("startime", startime);
		}
		if(endtime !=null &&!"".equals(endtime)){
			sb.append(" riq <= '"+endtime+"' ");
			sb.append(" and ");
			request.setAttribute("endtime", endtime);
		}
		sb.append(" appointlock=0  group by riq");
		String where = sb.toString();
		List<Appoint> list = appointDao.selectBeanList2(0, 99, where);
		request.setAttribute("list", list);
		this.setUrl("appoint/tj_appointlist.jsp");
		return SUCCESS;
	}




	
	
	
	

	
	
}
