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
@Table(name="t_Kaoshijilu")
public class Kaoshijilu implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private Shiti shiti;

	private String wodedaan;
	
	private Kaoshi kaoshi;
	
	private Date createtime;
	
	

	
	
	
	@ManyToOne
	@JoinColumn(name="kaoshiid")
	public Kaoshi getKaoshi() {
		return kaoshi;
	}

	public void setKaoshi(Kaoshi kaoshi) {
		this.kaoshi = kaoshi;
	}

	@ManyToOne
	@JoinColumn(name="shitiid")
	public Shiti getShiti() {
		return shiti;
	}

	public void setShiti(Shiti shiti) {
		this.shiti = shiti;
	}

	

	public String getWodedaan() {
		return wodedaan;
	}

	public void setWodedaan(String wodedaan) {
		this.wodedaan = wodedaan;
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

	
	
	
}
