package model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_Jichu")
public class Jichu {
	

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="content", columnDefinition="TEXT")
    private String content;
	private String imgpath;
	private Date createtime;
	private int jichulock;
	
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public int getJichulock() {
		return jichulock;
	}

	public void setJichulock(int jichulock) {
		this.jichulock = jichulock;
	}

	
}
