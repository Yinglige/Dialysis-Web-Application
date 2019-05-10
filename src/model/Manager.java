package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_Manager")
public class Manager implements Serializable{
	
	private static final long serialVersionUID = -117947798302585032L;

	private int id;
	
	private String username;
	
	private String password;

	private Date createtime;
	
	private int managerlock;


	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getManagerlock() {
		return managerlock;
	}

	public void setManagerlock(int managerlock) {
		this.managerlock = managerlock;
	}

	

	
}
