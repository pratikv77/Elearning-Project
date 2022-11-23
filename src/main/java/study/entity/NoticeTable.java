package study.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notice_table")
public class NoticeTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="notice_id")
	private int notice_id;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="notice_description")
	private String notice_description;
	
	@Column(name="notice_file")
	private byte[] notice_file;
	
	@Column(name="notice_data")
	private String notice_data;
	
	@Column(name="notice_status")
	private String notice_status;

	public int getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNotice_description() {
		return notice_description;
	}

	public void setNotice_description(String notice_description) {
		this.notice_description = notice_description;
	}

	public byte[] getNotice_file() {
		return notice_file;
	}

	public void setNotice_file(byte[] notice_file) {
		this.notice_file = notice_file;
	}

	public String getNotice_data() {
		return notice_data;
	}

	public void setNotice_data(String notice_data) {
		this.notice_data = notice_data;
	}

	public String getNotice_status() {
		return notice_status;
	}

	public void setNotice_status(String notice_status) {
		this.notice_status = notice_status;
	}
	
	

}
