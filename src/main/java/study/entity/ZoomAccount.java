package study.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zoom_account_table")
public class ZoomAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="zoom_id")
	private int id;
	
	@Column(name="zoom_account_details")
	private String accDetails;
	
	@Column(name="zoom_username")
	private String uname;
	
	@Column(name="zoom_password")
	private String pass;
	
	
	public ZoomAccount(int id, String accDetails, String uname, String pass) {
		super();
		this.id = id;
		this.accDetails = accDetails;
		this.uname = uname;
		this.pass = pass;
	}
	
	
	public ZoomAccount() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccDetails() {
		return accDetails;
	}
	public void setAccDetails(String accDetails) {
		this.accDetails = accDetails;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}


	@Override
	public String toString() {
		return "id=" + id + ", accDetails=" + accDetails + ", uname=" + uname + ", pass=" + pass ;
	}
	
	

}
