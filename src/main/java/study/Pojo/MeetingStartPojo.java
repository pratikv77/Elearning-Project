package study.Pojo;

public class MeetingStartPojo {
	
	private int sessionid;
	private String start_url;
	private String join_url;
	private String start_time;
	private long id;
	
	
	
	public MeetingStartPojo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public MeetingStartPojo(int sessionid, String start_url, String join_url, String start_time, long id) {
		super();
		this.sessionid = sessionid;
		this.start_url = start_url;
		this.join_url = join_url;
		this.start_time = start_time;
		this.id = id;
	}



	public int getSessionid() {
		return sessionid;
	}



	public void setSessionid(int sessionid) {
		this.sessionid = sessionid;
	}



	public String getStart_url() {
		return start_url;
	}



	public void setStart_url(String start_url) {
		this.start_url = start_url;
	}



	public String getJoin_url() {
		return join_url;
	}



	public void setJoin_url(String join_url) {
		this.join_url = join_url;
	}



	public String getStart_time() {
		return start_time;
	}



	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "MeetingStartPojo [sessionid=" + sessionid + ", start_url=" + start_url + ", join_url=" + join_url
				+ ", start_time=" + start_time + ", id=" + id + "]";
	}
	

	
}
