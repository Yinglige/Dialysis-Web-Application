package model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//no use
@Entity
@Table(name="t_Gonggao")
public class Gonggao {
	

	@Id
	@GeneratedValue
	private int id;
	
	
    private String biaoti;
	
    @Column(name="content", columnDefinition="TEXT")
	private String content;
	
	private Date createtime;

	private int gonggaolock;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGonggaolock() {
		return gonggaolock;
	}

	public void setGonggaolock(int gonggaolock) {
		this.gonggaolock = gonggaolock;
	}

	public String getBiaoti() {
		return biaoti;
	}

	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	

	
}
