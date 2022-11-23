package study.services;

import java.io.IOException;

import org.springframework.boot.configurationprocessor.json.JSONException;

import study.entity.SessionScheduleTable;

public interface ZoomService {
	
	public String getMettings(String token);
	
	public String createMeeting(String token,SessionScheduleTable scedule) ;
	
	public String recording(String token,String method,String meetingId) throws IOException, InterruptedException, JSONException ;

}
