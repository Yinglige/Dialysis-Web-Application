package model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_Appoint")
public class Appoint {
	

	@Id
	@GeneratedValue
	    private int id;
	
	    private String riq;
	    private String times;

		@ManyToOne
		@JoinColumn(name="visitid")
		private Visit visit;
		@ManyToOne
		@JoinColumn(name="userid")
		private User  user;
		private int number;
		@Column(name="content", columnDefinition="TEXT")
		private String content;
		private String procontent;
		private String appcontent;
		private double money;
		private Date createtime;
		private int appointlock;
	
	
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getAppointlock() {
		return appointlock;
	}

	public void setAppointlock(int appointlock) {
		this.appointlock = appointlock;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getProcontent() {
		return procontent;
	}

	public void setProcontent(String procontent) {
		this.procontent = procontent;
	}

	public String getAppcontent() {
		return appcontent;
	}

	public void setAppcontent(String appcontent) {
		this.appcontent = appcontent;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getRiq() {
		return riq;
	}

	public void setRiq(String riq) {
		this.riq = riq;
	}

	
	
	
}
