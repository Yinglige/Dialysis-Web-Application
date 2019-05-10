package model;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_Visit")
public class Visit {
	

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(name="userid")
    private User user;
	
	private String times;
    private int num;
    private String gztime;
	private Date createtime;
	private String stauts;	
	private int bnum;
	private int visitlock;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getGztime() {
		return gztime;
	}
	public void setGztime(String gztime) {
		this.gztime = gztime;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getVisitlock() {
		return visitlock;
	}
	public void setVisitlock(int visitlock) {
		this.visitlock = visitlock;
	}
	public String getStauts() {
		return stauts;
	}
	public void setStauts(String stauts) {
		this.stauts = stauts;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	
	

	
}
