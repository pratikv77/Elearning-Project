package study.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zoom_acesstoken_tbl")
public class Token {
	
	@Id
	@Column(name = "token_id")
	private int id ;
	
	@Column(columnDefinition="LONGTEXT")
	private String access_token;
	
	@Column(columnDefinition="LONGTEXT")
	private String refresh_token;
	
	@Column(name = "token_expires_in")
	private long expires_in;
	
	public Token() {
		super();
		
	}
	public Token(String access_token, String refresh_token, long expires_in) {
		super();
	
		this.access_token = access_token;
		this.refresh_token = refresh_token;
		this.expires_in = expires_in;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}
	
	
	

	
}
