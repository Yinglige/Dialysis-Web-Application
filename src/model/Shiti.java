package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_Shiti")
public class Shiti implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	 
	private String wenti;
	
	private Date createtime;
	
	private int shitilock;
	


	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getShitilock() {
		return shitilock;
	}

	public void setShitilock(int shitilock) {
		this.shitilock = shitilock;
	}

	

	public String getWenti() {
		return wenti;
	}

	public void setWenti(String wenti) {
		this.wenti = wenti;
	}

	


	
	
}
