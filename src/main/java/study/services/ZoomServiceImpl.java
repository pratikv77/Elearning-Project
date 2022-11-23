package study.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpResponse;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import study.Pojo.RecordMeetPojo;
import study.entity.SessionScheduleTable;
import study.Pojo.CreateMeetingPojo;





@Service
public class ZoomServiceImpl implements ZoomService {

	public String getMettings(String token){

		String url = "https://api.zoom.us/v2/users/me/meetings";
		RestTemplate restTemplate = new RestTemplate();
		// Use the access token for authentication
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<String> zoomData = restTemplate.exchange(url, HttpMethod.GET, entity,
				String.class);

		return zoomData.getBody();

	}//end of getMeeting method

	public String createMeeting(String token,SessionScheduleTable scedule) {

		String url = "https://api.zoom.us/v2/users/me/meetings";
		RestTemplate restTemplate = new RestTemplate();
		
		CreateMeetingPojo meeting= new CreateMeetingPojo(scedule.getSessionTopic(),scedule.getSessionDate(),scedule.getSessionDetails());
		// Use the access token for authentication
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + token);
		headers.add("content-type", "application/json");
		
		HttpEntity<CreateMeetingPojo> entity = new HttpEntity<>(meeting,headers);

		ResponseEntity<String> zoomData = restTemplate.exchange(url, HttpMethod.POST, entity,
				String.class);

		return zoomData.getBody();

	}//end of createMeeting method 
	
	public String recording(String token,String method,String meetingId) throws IOException, InterruptedException, JSONException {

		String url = "https://api.zoom.us/v2/live_meetings/"+meetingId+"/events";
//		RestTemplate restTemplate = new RestTemplate();
		RecordMeetPojo meeting= new RecordMeetPojo(method);
	
		// Use the access token for authentication
		HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
		
		JSONObject obj = new JSONObject();
		obj.put("method", method);
	
		
		BodyPublisher jsonPayload = HttpRequest.BodyPublishers.ofString(obj.toString());
		
		System.out.println("jsonPayload Obj"+jsonPayload);
		
				 HttpRequest request = HttpRequest.newBuilder()
                 .uri(URI.create(url))
                 .method("PATCH", jsonPayload)
                 .header("Authorization", "Bearer " + token)
                 .header("Content-Type", "application/json")
                 .build();
				 
				 HttpResponse<String> response = httpClient.send(request,HttpResponse.BodyHandlers.ofString());
				 
				 System.out.println(response);
				 
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Authorization", "Bearer " + token);
//		headers.add("content-type", "application/json");
//		System.out.println("Header"+headers);
//		HttpEntity<RecordMeetPojo> entity = new HttpEntity<>(meeting,headers);
//		System.out.println("http entotiy"+entity);
//		
//
//		ResponseEntity<String> zoomData = restTemplate.exchange(url, HttpMethod.PATCH, entity,
//				String.class);

		return response.body();

	}//end of createMeeting method 
}
