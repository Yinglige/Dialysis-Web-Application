package action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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
import model.Product;
import model.Shiti;
import model.User;
import model.Visit;

import org.apache.struts2.ServletActionContext;
import util.Pager;

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


public class IndexAction extends ActionSupport{


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




	
	public  String  gonggao(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Gonggao> list =gonggaoDao.selectBeanList(0, 10, " where gonggaolock=0 order by id desc ");
		request.setAttribute("list", list);
		this.setUrl("index.jsp");
		return "success";

	}

	
	public String sy_gonggaolist(){
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
		int pagesize = 5;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}

		long total = gonggaoDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Gonggao> list = gonggaoDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "indexmethod!sy_gonggaolist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("sy_gonggaolist.jsp");
		return SUCCESS;
	}

	
	public String xq_gonggao(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Gonggao bean =gonggaoDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("xq_gonggao.jsp");
		return SUCCESS;
	}




	// 用户登录操作
	public void ulogin() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Integer role = Integer.parseInt(request.getParameter("role"));
		User bean = userDao.selectBean("  where  username='"+ username + "' and password='" + password + "' and userlock=0  and role="+role+" ");
		if (bean != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", bean);
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer
			.print("<script  language='javascript'>alert('Login successfully！');window.location.href='index.jsp'; </script>");
		} else {
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer
			.print("<script  language='javascript'>alert('Error in username or password! Login failed');window.location.href='index.jsp'; </script>");
		}

	}

	
	public void uloginout() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Logout successfully！');window.location.href='index.jsp'; </script>");

	}


	
	public void register() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String truename = request.getParameter("truename");
		String telephone = request.getParameter("telephone");
		String jiguan = request.getParameter("jiguan");
		String address = request.getParameter("address");
		String xingbie = request.getParameter("xingbie");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		User bean = userDao.selectBean(" where username='"+username+"' ");
		if(bean==null){
			bean = new User();
			bean.setUsername(username);
			bean.setPassword(password);
			bean.setTruename(truename);
			bean.setTelephone(telephone);
			bean.setJiguan(jiguan);
			bean.setAddress(address);
			bean.setXingbie(xingbie);
			bean.setAge(age);
			bean.setEmail(email);
			bean.setRole(1);
			bean.setCreatetime(new Date());
			userDao.insertBean(bean);

			response.setCharacterEncoding("gbk");
			response.getWriter().write("Successful registration! Your User Name"+bean.getUsername()+"");
		}else{
			response.setCharacterEncoding("gbk");
			response.getWriter().write("Submission failed. The user has registered. Please re-register.");
		}

	}

	
	public String userupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");	
		User bean =userDao.selectBean(" where id= "+user.getId());
		request.setAttribute("bean", bean);
		this.setUrl("userupdate.jsp");
		return SUCCESS;
	}


	
	public void userupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String password = request.getParameter("password");
		String truename = request.getParameter("truename");
		String telephone = request.getParameter("telephone");
		String jiguan = request.getParameter("jiguan");
		String address = request.getParameter("address");
		String xingbie = request.getParameter("xingbie");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		User bean =userDao.selectBean(" where id= "+id);
		bean.setPassword(password);
		bean.setTruename(truename);
		bean.setTelephone(telephone);
		bean.setJiguan(jiguan);
		bean.setAddress(address);
		bean.setXingbie(xingbie);
		bean.setAge(age);
		bean.setEmail(email);
		bean.setCreatetime(new Date());
		userDao.insertBean(bean);
		response.setCharacterEncoding("gbk");
		response.getWriter().write("Profile modified Successful");
	}




	
	public String sy_user() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String truename = request.getParameter("truename");
		String keshi = request.getParameter("keshi");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		if(truename !=null &&!"".equals(truename)){
			sb.append(" truename like '%"+truename+"%' ");
			sb.append(" and ");
			request.setAttribute("truename", truename);
		}
		if(keshi !=null &&!"".equals(keshi)){
			sb.append(" keshi.id like '%"+keshi+"%' ");
			sb.append(" and ");
			request.setAttribute("keshi", keshi);
		}
		sb.append(" userlock=0 and role=2 order by id desc ");
		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 9;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		long total = userDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<User> list = userDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		List<Keshi> keshilist = keshiDao.selectBeanList(0, 99, " where keshilock=0 ");
		request.setAttribute("keshilist", keshilist);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "indexmethod!sy_user", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("sy_user.jsp");
		return SUCCESS;
	}

	
	public String xq_user(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		User bean =userDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("xq_user.jsp");
		return SUCCESS;
	}




	
	public String xq_jichu(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Jichu> list = jichuDao.selectBeanList(0, 9, " where jichulock=0");
		request.setAttribute("list", list);
		this.setUrl("xq_jichu.jsp");
		return SUCCESS;
	}



	
	public String sy_visit() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String keshi = request.getParameter("keshi");
		String truename = request.getParameter("truename");
		String times = request.getParameter("times");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		if(truename !=null &&!"".equals(truename)){
			sb.append(" user.truename like '%"+truename+"%' ");
			sb.append(" and ");
			request.setAttribute("truename", truename);
		}
		if(keshi !=null &&!"".equals(keshi)){
			sb.append(" user.keshi.id like '%"+keshi+"%' ");
			sb.append(" and ");
			request.setAttribute("keshi", keshi);
		}
		if(times !=null &&!"".equals(times)){
			sb.append(" times like '%"+times+"%' ");
			sb.append(" and ");
			request.setAttribute("times", times);
		}
		sb.append(" visitlock=0  order by id desc ");
		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 9;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		long total = visitDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Visit> list = visitDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		List<Keshi> keshilist = keshiDao.selectBeanList(0, 99, " where keshilock=0 ");
		request.setAttribute("keshilist", keshilist);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "indexmethod!sy_visit", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("sy_visit.jsp");
		return SUCCESS;
	}




	public String appointadd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Visit bean =visitDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("appointadd.jsp");
		return SUCCESS;
	}


	
	public void appointadd2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Visit h =visitDao.selectBean(" where id= "+id);
		String times = request.getParameter("times");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");	

		if(user==null){
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('Please login first.');" +"window.location.href='index.jsp'; </script>");
			return ;
		}

		Appoint b=appointDao.selectBean(" where times='"+times+"' and visitid="+h.getId()+" and appointlock=0 ");
		if(b!=null){
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('This time has been reserved. Please re-select it.');window.location.href='indexmethod!sy_visit'; </script>");
			return ;
		}
		Appoint c=appointDao.selectBean(" where userid="+user.getId()+" and visitid="+h.getId()+" and appointlock=0 ");
		if(c==null){
			Appoint bean = new Appoint();
			bean.setVisit(h);
			bean.setUser(user);
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
			writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='indexmethod!sy_visit'; </script>");
		}	
		else{
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('You have an appointment! No need to repeat appointments');window.location.href='indexmethod!sy_visit'; </script>");

		}
	}


	
	public void appointdelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Visit h =visitDao.selectBean(" where id= "+id);
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");	
		if(user==null){
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('Please login first.');" +"window.location.href='index.jsp'; </script>");
			return ;
		}
		Appoint bean=appointDao.selectBean(" where userid="+user.getId()+" and visitid="+h.getId()+" and appointlock=0 ");
		if(bean!=null){
			bean.setAppointlock(1);
			h.setBnum(h.getBnum()-1);
			h.setStauts("Not Full");
			appointDao.updateBean(bean);
			visitDao.updateBean(h);
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('Cancellation of success');window.location.href='indexmethod!my_visitlist'; </script>");
		}  
		else{
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('Not Exist ');window.location.href='indexmethod!my_visitlist'; </script>");

		}
	}	




	
	public String my_visitlist() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");	
		if(user==null){
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('Please login first.');" +"window.location.href='index.jsp'; </script>");
			return null;
		}	
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		sb.append(" visit.visitlock=0 and content is null and appointlock=0 and user="+user.getId()+" order by id desc ");
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		String where = sb.toString();
		long total = appointDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Appoint> list = appointDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "indexmethod!my_visitlist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("my_visitlist.jsp");
		return SUCCESS;
	}

	
	public String my_visitlist2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Appoint bean =appointDao.selectBean(" where id= "+id);
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");	

		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		if(user.getRole()==1){
			sb.append("  content is not null and appointlock=0 and user="+user.getId()+" order by id desc ");
		}
		if(user.getRole()==2){
			sb.append("  content is not null and appointlock=0 and user="+bean.getUser().getId()+" order by id desc ");	
		}
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		String where = sb.toString();
		long total = appointDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Appoint> list = appointDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "indexmethod!my_visitlist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("my_visitlist2.jsp");
		return SUCCESS;
	}


	
	public String sy_appoint() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");	
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		sb.append(" visit.user="+user.getId()+"  and content is null order by id desc ");
		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 9;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		long total = appointDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Appoint> list = appointDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "indexmethod!sy_appoint", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("sy_appoint.jsp");
		return SUCCESS;
	}

	
	public String appointupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Appoint bean =appointDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		List<Product> productlist = productDao.selectBeanList(0, 99, " where productlock=0 ");
		request.setAttribute("productlist", productlist);
		this.setUrl("appointupdate.jsp");
		return SUCCESS;
	}

	
	public void appointupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		String appcontent = request.getParameter("appcontent");

		//药品
		double yaopin=0;
		StringBuffer sb = new StringBuffer();
		String product[] = request.getParameterValues("product");
		if(product==null){
			writer.print("<script language='javascript'>alert('Medications are required. Please add them again. ');window.location.href='indexmethod!appointupdate?id="+id+"'; </script> ");
			return;
		}
		if(product!=null){

			for (int i = 0; i < product.length; i++) {

				Product w=productDao.selectBean(" where productlock=0 and id="+product[i]);
				String pb =request.getParameter("pb"+product[i]);
				productDao.updateBean(w);
				sb.append( "Medication Name："+ w.getName()+"，Amount："+pb+"，Cost："+w.getPrice()* Integer.parseInt(pb) +"元。\t");	
				yaopin =yaopin+(w.getPrice()* Integer.parseInt(pb));
			}
		}

		Appoint bean =appointDao.selectBean(" where id= "+id);
		bean.setContent(content);
		bean.setMoney(yaopin);
		bean.setProcontent(sb.toString());
		bean.setAppcontent(appcontent);
		appointDao.updateBean(bean);
		writer.print("<script  language='javascript'>alert(' Input Successful ');window.location.href='indexmethod!sy_appoint'; </script>");

	}




	
	public String sy_appoint2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");	
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		sb.append(" visit.user="+user.getId()+"  and content!=null order by id desc ");
		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 9;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		long total = appointDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Appoint> list = appointDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "indexmethod!sy_appoint2", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("sy_appoint2.jsp");
		return SUCCESS;
	}


	
	public String xq_appointupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Appoint bean =appointDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("xq_appointupdate.jsp");
		return SUCCESS;
	}



	
	public String my_archiveslist() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");	
		StringBuffer sb = new StringBuffer();
		sb.append(" where  archiveslock=0  and user="+user.getId()+" order by stauts desc ");
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		String where = sb.toString();
		long total = archivesDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Archives> list = archivesDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "indexmethod!my_archiveslist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("my_archiveslist.jsp");
		return SUCCESS;
	}


	
	public String archivesadd() throws IOException{
		this.setUrl("archivesadd.jsp");
		return SUCCESS;
	}


	
	public void archivesadd2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");	
		String times = request.getParameter("times");

		Archives bean=archivesDao.selectBean(" where user="+user.getId()+"  and times='"+times+"' ");
		if(bean==null){
			bean = new Archives();
			bean.setUser(user);
			bean.setTimes(times);
			bean.setBianhao(new Date().getTime()+"");
			bean.setStauts("Booked");
			bean.setCreatetime(new Date());
			archivesDao.insertBean(bean);
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('Submit successfully');window.location.href='indexmethod!my_archiveslist'; </script>");
		}else{
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('This date has been reserved by the user. Please re-select it.');window.location.href='indexmethod!my_archiveslist'; </script>");
		}
	}


	
	public void archivesdelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Archives bean =archivesDao.selectBean(" where id= "+id);
		bean.setArchiveslock(1);
		archivesDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('Cancellation of success');window.location.href='indexmethod!my_archiveslist'; </script>");

	}


	
	public String xq_archives(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Archives bean =archivesDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("xq_archives.jsp");
		return SUCCESS;
	}
	
	
	
	public String xq_archives2(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Archives bean =archivesDao.selectBean(" where user="+id);
		request.setAttribute("bean", bean);
		this.setUrl("xq_archives2.jsp");
		return SUCCESS;
	}


	
	private static List<Shiti> suiji(List<Shiti> list,int num){
		Collections.shuffle(list);
		List<Shiti> list2 = new ArrayList<Shiti>();
		if(list.size()<=num){
			num = list.size();
		}
		for(int i=0;i<num;i++){
			list2.add(list.get(i));
		}
		return list2;
	}



	
	public String kaoshiadd() throws IOException   {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session  = request.getSession();
		User user = (User) session.getAttribute("user");
		Kaoshi  bean = kaoshiDao.selectBean(" where kaoshilock=0 and user="+user.getId()+" ");
		if(bean!=null){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf8");response.setContentType("text/html; charset=utf8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert(' You have participated in this survey and need not repeat it.');window.location.href='index.jsp'; </script>");
			return null;
		}
		long s = shitiDao.selectBeanCount(" where shitilock=0 ");
		if(s<6){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf8");response.setContentType("text/html; charset=utf8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert(' The number of questionnaires was not reached and the questionnaire was not open.');window.location.href='index.jsp'; </script>");
			return null;
		}
		
		List<Shiti> list1 = IndexAction.suiji(shitiDao.selectBeanList(0, 9999, " where  shitilock=0 "), 6);
		request.setAttribute("list1", list1);
		this.setUrl("kaoshiadd.jsp");
		return SUCCESS;

	}




	
	public void kaoshiadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session  = request.getSession();
		User user = (User) session.getAttribute("user");
		Kaoshi bean = new Kaoshi();
		bean.setCreatetime(new Date());
		bean.setBianhao(new Date().getTime()+"");		
		bean.setUser(user);
		kaoshiDao.insertBean(bean);

		for(int i=0;i<6;i++){
			Shiti shiti = shitiDao.selectBean(" where id= "+request.getParameter("xzid"+i));
			String wodedaan = request.getParameter("xzdaan"+i);
			Kaoshijilu jilu = new Kaoshijilu();
			jilu.setCreatetime(new Date());
			jilu.setKaoshi(bean);
			jilu.setShiti(shiti);
			jilu.setWodedaan(wodedaan);
			kaoshijiluDao.insertBean(jilu);
			kaoshiDao.updateBean(bean);
		}
		response.setCharacterEncoding("utf8");response.setContentType("text/html; charset=utf8");
		response.getWriter().print("<script language=javascript>alert('End of questionnaire');</script>");
	}




	
	public String y_kaoshilist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		User user =userDao.selectBean(" where id= "+id);	
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		sb.append(" kaoshilock=0 and user="+user.getId()+"  order by createtime desc ");
		int currentpage = 1;
		int pagesize = 20;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		String where =sb.toString();
		long total = kaoshiDao.selectBeanCount(where.replaceAll(" order by id desc", ""));
		List<Kaoshi> list = kaoshiDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "indexmethod!y_kaoshilist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("y_kaoshilist.jsp");
		return SUCCESS;
	}


	
	public String y_kaoshijilulist() throws IOException{
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
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "indexmethod!y_kaoshijilulist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("y_kaoshijilulist.jsp");
		return SUCCESS;
	}


	
	public String hz_userlist(){
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
		sb.append(" userlock=0 and role=1 order by id desc ");
		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		long total = userDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<User> list = userDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "indexmethod!hz_userlist", "Total"+total+"Records");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("hz_userlist.jsp");
		return SUCCESS;
	}
	
	
	






}
