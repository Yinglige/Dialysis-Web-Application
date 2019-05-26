package model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//Department
@Entity
@Table(name="t_Keshi")
public class Keshi {
	
	private static final long serialVersionUID = -7141419035239709511L;
	
	@Id
	@GeneratedValue
	private int id;
    private String name;//Department name
    private String content;//Department introduction
	private Date createtime;
	private int keshilock;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getKeshilock() {
		return keshilock;
	}

	public void setKeshilock(int keshilock) {
		this.keshilock = keshilock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
}
