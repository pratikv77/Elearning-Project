package study.Pojo;

public class RecordMeetPojo {
	
	private String  method;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public RecordMeetPojo(String method) {
		super();
		this.method = method;
	}

	public RecordMeetPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RecordMeetPojo [method=" + method + "]";
	}

	
}
