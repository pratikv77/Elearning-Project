package study.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "zoom_account_table")
public class ZoomAccountTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "zoom_id")
	private int zoom_id;

	@Column(name = "zoom_account_details")
	private  String zoom_account_details;

	@Column(name = "zoom_password")
	private String zoom_password;

	@Column(name = "zoom_username")
	private String zoom_username;

	@OneToMany(mappedBy = "zoomAccountTable")
	private List<SessionScheduleTable> sessionScheduleTables;

	public int getZoom_id() {
		return zoom_id;
	}

	public void setZoom_id(int zoom_id) {
		this.zoom_id = zoom_id;
	}

	public String getZoom_account_details() {
		return zoom_account_details;
	}

	public void setZoom_account_details(String zoom_account_details) {
		this.zoom_account_details = zoom_account_details;
	}

	public String getZoom_password() {
		return zoom_password;
	}

	public void setZoom_password(String zoom_password) {
		this.zoom_password = zoom_password;
	}

	public String getZoom_username() {
		return zoom_username;
	}

	public void setZoom_username(String zoom_username) {
		this.zoom_username = zoom_username;
	}

}
