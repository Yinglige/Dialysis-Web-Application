package model;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Vitals
@Entity
@Table(name="t_Archives")
public class Archives {
	

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;
	
	private String bianhao;//ID
	private String stauts;//Vitals status
	private String times;
    private String sg;//Height(Feet)
	private String tz;//Weight(Pound)
	private String xa;//Blood type
	private String xt;//Systolic
	private String xz;//Diastolic
	private String tnb;//Diabete
	private String xxg;//Heart Disease
	private String xy;//Emphysema (COPD)
	private String mb;//Pulse(bpm)
	private String xint;//Respirations
	private String fhl;//BMI
	private String content;//Summary
	private Date createtime;//Creattiem

	private int archiveslock;//  0 not delete 1 deleted
	
	
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

	public String getSg() {
		return sg;
	}

	public void setSg(String sg) {
		this.sg = sg;
	}

	public String getTz() {
		return tz;
	}

	public void setTz(String tz) {
		this.tz = tz;
	}

	public String getXa() {
		return xa;
	}

	public void setXa(String xa) {
		this.xa = xa;
	}

	public String getXt() {
		return xt;
	}

	public void setXt(String xt) {
		this.xt = xt;
	}

	public String getXz() {
		return xz;
	}

	public void setXz(String xz) {
		this.xz = xz;
	}

	public String getTnb() {
		return tnb;
	}

	public void setTnb(String tnb) {
		this.tnb = tnb;
	}

	public String getXxg() {
		return xxg;
	}

	public void setXxg(String xxg) {
		this.xxg = xxg;
	}

	

	public String getXy() {
		return xy;
	}

	public void setXy(String xy) {
		this.xy = xy;
	}

	public String getMb() {
		return mb;
	}

	public void setMb(String mb) {
		this.mb = mb;
	}

	public String getXint() {
		return xint;
	}

	public void setXint(String xint) {
		this.xint = xint;
	}

	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getArchiveslock() {
		return archiveslock;
	}

	public void setArchiveslock(int archiveslock) {
		this.archiveslock = archiveslock;
	}

	public String getBianhao() {
		return bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getFhl() {
		return fhl;
	}

	public void setFhl(String fhl) {
		this.fhl = fhl;
	}

	public String getStauts() {
		return stauts;
	}

	public void setStauts(String stauts) {
		this.stauts = stauts;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	

	
}
