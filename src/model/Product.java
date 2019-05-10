package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="t_Product")
public class Product implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private String bianhao;
	
	private String name;
	
	private String jingzhong;
	
	private String guige;
	
	private String gongxiao;
	
	private double price;
	
	private Date createtime;
	
	private int productlock;

	
	

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

	public int getProductlock() {
		return productlock;
	}

	public void setProductlock(int productlock) {
		this.productlock = productlock;
	}

	public String getBianhao() {
		return bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJingzhong() {
		return jingzhong;
	}

	public void setJingzhong(String jingzhong) {
		this.jingzhong = jingzhong;
	}

	public String getGuige() {
		return guige;
	}

	public void setGuige(String guige) {
		this.guige = guige;
	}

	public String getGongxiao() {
		return gongxiao;
	}

	public void setGongxiao(String gongxiao) {
		this.gongxiao = gongxiao;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	

	

}
