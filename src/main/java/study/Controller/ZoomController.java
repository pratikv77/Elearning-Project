package study.Controller;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;

import study.Pojo.MeetingResponsePojo;
import study.entity.SessionScheduleTable;
import study.services.SessionScheduleServiceImpl;
import study.services.TokenServiceImpl;
import study.services.ZoomServiceImpl;

@Controller
@EnableScheduling
@SessionAttributes("meetingpojo")
public class ZoomController {

	@Autowired
	ZoomServiceImpl zoomService;

	@Autowired
	TokenServiceImpl tokenService;

	@Autowired
	SessionScheduleServiceImpl sessionService;

	@GetMapping("/listmeeting")
	public ModelAndView getMeeting() {
		ModelAndView mv = new ModelAndView();
		// to take list of all meeting
		List<MeetingResponsePojo> list = new ArrayList<MeetingResponsePojo>();

		Instant then = Instant.parse("2022-03-23T23:30:00Z");// converts UTC string to instant
		System.currentTimeMillis();// gives current time in Milliseconds
		then.toEpochMilli();// converts Instant to Milliseconds

		// token service returns hash map with status and token
		HashMap<String, String> hmap = tokenService.getToken();

		String status = hmap.get("status");
		String Token = hmap.get("Token");

		// If status sucess then call api
		if (status.equals("sucess")) {
			String meeting = null;
			try { // API call from Dao class
				meeting = zoomService.getMettings(Token);
				// response String converted to Json Object
				JSONObject jsonObject = new JSONObject(meeting);
				// Json Array of meetings from response is collected
				JSONArray tsmresponse = (JSONArray) jsonObject.get("meetings");

				for (int i = 0; i < tsmresponse.length(); i++) {
					ObjectMapper mapper = new ObjectMapper();
					MeetingResponsePojo[] myPojo = mapper.readValue(tsmresponse.toString(),
							MeetingResponsePojo[].class);
					list.add(myPojo[i]);
				}

			} catch (JsonProcessingException | JSONException e) {

				e.printStackTrace();
			} finally {

			}

			mv.addObject("message", "sucess");
			mv.addObject("meeting", list);
			mv.setViewName("viewmeetinglist");
			return mv;

		} else {
			//mv.addObject("status", "error");
			mv.addObject("error", "Token expired try again");
			mv.setViewName("viewmeetinglist");
			return mv;

		}

	}

	@Scheduled(fixedRate = 180000)
	@GetMapping("/createmeeting")
	public void createMeeting() {
		ModelAndView mv = new ModelAndView();
		// to take list of all meeting
		System.out.println("create meeting method called");
		List<SessionScheduleTable> list = sessionService.findAll();

		for (SessionScheduleTable sessionScheduleTable : list) {

			Instant then = Instant.parse(sessionScheduleTable.getSessionDate());

			if ((then.toEpochMilli() - 19765020) > System.currentTimeMillis()
					&& (then.toEpochMilli() - 19765020) < (System.currentTimeMillis() + 300000)) {

				// token service returns hash map with status and token
				HashMap<String, String> hmap = tokenService.getToken();

				String status = hmap.get("status");
				String Token = hmap.get("Token");

				// If status sucess then call view
				if (status.equals("sucess")) {
					String meeting = null;
					try { // API call from Dao class

						meeting = zoomService.createMeeting(Token, sessionScheduleTable);
						// response String converted to Json Object
						JSONObject jsonObject = new JSONObject(meeting);

						if (jsonObject != null) {
							this.updateSceduleZoomData(sessionScheduleTable.getSessionId(),
									jsonObject.get("start_url").toString(), jsonObject.get("join_url").toString(),
									jsonObject.get("start_time").toString(),
									Long.parseLong(jsonObject.get("id").toString()));
							
						}

					} catch (JSONException e) {

						e.printStackTrace();
					}

				}
			} // end of if

		} // end of for loop

	}

	@GetMapping("/startmeeting")
	public void startMeeting() {
		List<SessionScheduleTable> list = sessionService.findAll();

		/*
		 * This is the best way I found for this problem, since it does not matter where
		 * the browser is installed or whatever, java communicates with the operating
		 * system and makes a request to run the default browser.
		 */
		System.out.println("Start meeting called");
		for (SessionScheduleTable sessionScheduleTable : list) {

			Instant then = Instant.parse(sessionScheduleTable.getSessionDate());
			Instant now=Instant.now();

			if (then.toEpochMilli() > now.minusMillis(300000).toEpochMilli()
					&& then.toEpochMilli()  < (now.plusMillis(300000).toEpochMilli())
					&& sessionScheduleTable.getSessionStartUrl() != null && sessionScheduleTable.getSession_isActive()!=1) {
				System.out.println("Start meeting called inside if condition");
				try {

					String url = sessionScheduleTable.getSessionStartUrl();
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				} catch (IOException e) {
					e.printStackTrace();
					
					
				}
				SessionScheduleTable session=	sessionService.findBySessionId(sessionScheduleTable.getSessionId());
				session.setSession_isActive((byte) 1);
				sessionService.update(session);

			}
		}

	}

	public void updateSceduleZoomData(int id, String start_url, String join_url, String start_time, long meetingid) {

		List<SessionScheduleTable> sessionlist = sessionService.findAll();
		for (SessionScheduleTable sessionScheduleTable : sessionlist) {

			if (sessionScheduleTable.getSessionId() == id) {
				sessionScheduleTable.setSessionInvitationDetails(join_url);
				sessionScheduleTable.setMeetingId(meetingid);
				sessionScheduleTable.setSessionStartUrl(start_url);
				sessionScheduleTable.setSessionDate(start_time);
				sessionService.updateZoomDetails(sessionScheduleTable);
			}

		}
	}

	@GetMapping("/recording")
	public ModelAndView recordMeeting() throws IOException, InterruptedException, JSONException {
		ModelAndView mv = new ModelAndView();
		// to take list of all meeting

		// token service returns hash map with status and token

		HashMap<String, String> hmap = tokenService.getToken();

		String status = hmap.get("status");
		String Token = hmap.get("Token");

		// If status sucess then call api
		if (status.equals("sucess")) {
			String meeting = null;
			meeting = zoomService.recording(Token, "recording.start", "87626249021");
			try { // API call from Dao class

				// response String converted to Json Object
				JSONObject jsonObject = new JSONObject(meeting);

				System.out.println("Start recording API " + jsonObject);
			} catch (JSONException e) {

				e.printStackTrace();
			}

			mv.addObject("CreateStatus", "sucess");
			mv.addObject("message", "Meeting Created Sucessfully");
			mv.setViewName("zoomcontrols");
			return mv;
		} else {
			mv.addObject("CreateStatus", "error");
			mv.addObject("error", "Token expired...refresh token");
			mv.setViewName("zoomcontrols");
			return mv;
		}

	}

	@GetMapping("/stoprecording")
	public ModelAndView stoprecordMeeting() throws IOException, InterruptedException, JSONException {
		ModelAndView mv = new ModelAndView();
		// to take list of all meeting

		// token service returns hash map with status and token
		HashMap<String, String> hmap = tokenService.getToken();

		String status = hmap.get("status");
		String Token = hmap.get("Token");

		// If status sucess then call api
		if (status.equals("sucess")) {
			String meeting = null;
			meeting = zoomService.recording(Token, "recording.stop", "85228410200");

			// try
			// { //API call from Dao class
			//
			// //response String converted to Json Object
			// //JSONObject jsonObject = new JSONObject(meeting);
			//
			// //System.out.println("Strt recording API "+jsonObject);
			// } catch (JSONException e) {
			//
			// e.printStackTrace();
			// }

			mv.addObject("CreateStatus", "sucess");
			mv.addObject("message", "Recording started Sucessfully");
			mv.setViewName("zoomcontrols");
			return mv;

		} else {
			mv.addObject("CreateStatus", "error");
			mv.addObject("error", "Somthing went wrong");
			mv.setViewName("zoomcontrols");
			return mv;

		}

	}

}
