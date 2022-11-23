package study.Pojo;

import java.util.List;

public class ZoomMeetingResponsePojo {

	private Integer page_size;

	public Integer total_records;

	public String next_page_token;

	public List<MeetingResponsePojo> meetings;

	public ZoomMeetingResponsePojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getPage_size() {
		return page_size;
	}

	public void setPage_size(Integer page_size) {
		this.page_size = page_size;
	}

	public Integer getTotal_records() {
		return total_records;
	}

	public void setTotal_records(Integer total_records) {
		this.total_records = total_records;
	}

	public String getNext_page_token() {
		return next_page_token;
	}

	public void setNext_page_token(String next_page_token) {
		this.next_page_token = next_page_token;
	}

	public List<MeetingResponsePojo> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<MeetingResponsePojo> meetings) {
		this.meetings = meetings;
	}

	@Override
	public String toString() {
		return "ZoomMeetingResponsePojo [page_size=" + page_size + ", total_records=" + total_records
				+ ", next_page_token=" + next_page_token + ", meetings=" + meetings + "]";
	}
	

}
