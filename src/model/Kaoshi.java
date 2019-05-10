package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_Kaoshi")
public class Kaoshi implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private String bianhao;
	
	private User user;
	
	private Date createtime;
	
	private int kaoshilock;
	
	
	

	@ManyToOne
	@JoinColumn(name="userid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getKaoshilock() {
		return kaoshilock;
	}

	public void setKaoshilock(int kaoshilock) {
		this.kaoshilock = kaoshilock;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getBianhao() {
		return bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}


	
	
	
}
