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
	
	
	public void loginout() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Exit successfully');window.location.href='login.jsp'; </script>");
	}
	
	
	
	public String passwordupdate(){
		this.setUrl("manager/passwordupdate.jsp");
		return SUCCESS;
	}
	
	
	
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
			writer.print("<script  language='javascript'>alert('The original password is wrong, the modification failed!!');window.location.href='method!passwordupdate'; </script>");
		}		
	}

	  
		
		public String managerupdate(){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Manager bean = (Manager)session.getAttribute("manager");	
			request.setAttribute("bean", bean);
			this.setUrl("manager/managerupdate.jsp");
			return SUCCESS;
		}
		
		
	  
	
	public String userlist(){
	   HttpServletRequest request = ServletActionContext.getRequest();
	       String username = request.getParameter("username");
	       StringBuffer sb = new StringBuffer();
	       sb.append(" where ");

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
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!userlist", "Total"+total+"条记录");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("user/userlist.jsp");
		return SUCCESS;
	}
	
	
	
	public String userupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		User bean =userDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("user/userupdate.jsp");
		return SUCCESS;
	}


	
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
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!gonggaolist", "Total"+total+"条记录");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("gonggao/gonggaolist.jsp");
		return SUCCESS;
	}
	
	
	
	public String gonggaoadd(){
		this.setUrl("gonggao/gonggaoadd.jsp");
		return SUCCESS;
	}
	
	
	
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
	
	
	public String gonggaoupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Gonggao bean =gonggaoDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("gonggao/gonggaoupdate.jsp");
		return SUCCESS;
	}
	
	
	
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
	
	
	public String gonggaoupdate3(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Gonggao bean =gonggaoDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("gonggao/gonggaoupdate3.jsp");
		return SUCCESS;
	}
	

	
	
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
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!keshilist", "Total"+total+"条记录");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("keshi/keshilist.jsp");
		return SUCCESS;
	}
	
	
	
	public String keshiadd(){
		this.setUrl("keshi/keshiadd.jsp");
		return SUCCESS;
	}
	
	
	
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
	
	
	public String keshiupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Keshi bean =keshiDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("keshi/keshiupdate.jsp");
		return SUCCESS;
	}
	
	
	
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
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!y_userlist", "Total"+total+"条记录");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("user/y_userlist.jsp");
		return SUCCESS;
	}
	
	
	 
	
	
	public String y_useradd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Keshi> list = keshiDao.selectBeanList(0, 99, " where keshilock=0 ");
		request.setAttribute("list", list);
		this.setUrl("user/y_useradd.jsp");
		return SUCCESS;
	}
	
	
	
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
	
	
	
	public String jichuupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Jichu bean =jichuDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("jichu/jichuupdate.jsp");
		return SUCCESS;
	}
	
	
	
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
	
	
	
	public String visitadd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<User> list = userDao.selectBeanList(0, 999, " where role=2 and userlock=0 ");
		request.setAttribute("list", list);
		this.setUrl("visit/visitadd.jsp");
		return SUCCESS;
	}
	
	
	
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
	
	
	
	public String archivesupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Archives bean =archivesDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("archives/archivesupdate.jsp");
		return SUCCESS;
	}
	
	
	public void archivesupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
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

		Archives bean=archivesDao.selectBean(" where id="+id);
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
		bean.setStauts("Finished");
		bean.setCreatetime(new Date());
		archivesDao.insertBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='method!archiveslist'; </script>");
	}
	
	
	
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
	
	
	public String productadd(){
		this.setUrl("product/productadd.jsp");
		return SUCCESS;
	}
	
	
	
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
			writer.print("<script language='javascript'>alert('The name of the drug already exists. Please add it again.');window.location.href='method!productadd'; </script> ");
		}

	   }
	
	
	
	public String productupdate(){
		HttpServletRequest request = ServletActionContext.getRequest(); 
		String id = request.getParameter("id");
		Product bean =productDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("product/productupdate.jsp");
		return SUCCESS;
	}

	
	
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
	
	


	public String shitiadd() {
		this.setUrl("shiti/shitiadd.jsp");
		return SUCCESS;
	}
	
	
	

	public void shitiadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String wenti = request.getParameter("wenti");
		Shiti bean = new Shiti();
		bean.setCreatetime(new Date());
		bean.setWenti(wenti);
		shitiDao.insertBean(bean);
		response.setCharacterEncoding("utf8");response.setContentType("text/html; charset=utf8");
		response.getWriter().print("<script language=javascript>alert('Added successfully');window.location.href='method!shitilist';</script>");	
	}
	
	
	
	public void shitidelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Shiti bean = shitiDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setShitilock(1);
		shitiDao.updateBean(bean);
		response.setCharacterEncoding("utf8");response.setContentType("text/html; charset=utf8");
		response.getWriter().print("<script language=javascript>alert('Delete successful');window.location.href='method!shitilist';</script>");
	}
	

	
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


	
	public String kaoshijilulist() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		sb.append(" kaoshi="+id+"  order by id desc ");
		int currentpage = 1;
		int pagesize = 6;
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
	
	
	
	
	public String appointlist() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");//用户
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
	
	
	public String xq_appoint(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Appoint bean =appointDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("appoint/xq_appoint.jsp");
		return SUCCESS;
	}
	
	
	
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
	
	
	
	
	public String appointadd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<User> list = userDao.selectBeanList(0, 999, " where role=1 and userlock=0 ");
		request.setAttribute("list", list);
		this.setUrl("appoint/appointadd.jsp");
		return SUCCESS;
	}
	
	
	
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
		
			Appoint	bean=appointDao.selectBean(" where user="+u.getId()+" and riq='"+riq+"' and appointlock=0 ");
			if(bean==null){
				bean = new Appoint();
				bean.setUser(u);
				bean.setRiq(riq);
				bean.setContent(content);
				bean.setProcontent(procontent);
				bean.setAppcontent(appcontent);
				bean.setMoney(money);
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
	
	

	
	
}
