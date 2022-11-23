package study.Controller;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import study.Pojo.KeyValue;
import study.entity.CoordinatorTable;
import study.entity.FacultyInfoTable;
import study.entity.FeedbackTable;
import study.entity.ModuleTable;
import study.entity.NoticeTable;
import study.entity.SessionScheduleTable;
import study.entity.StudentInfoTable;
import study.entity.ZoomAccountTable;
import study.services.CoordinatorServiceImpl;

import study.services.FacultyServiceImpl;
import study.services.FeedbackServiceImpl;
import study.services.ModuleServiceImpl;
import study.services.NoticeServiceImpl;
import study.services.SessionScheduleServiceImpl;
import study.services.StudentServiceImpl;
import study.services.TokenServiceImpl;
import study.services.ZoomAccountServiceImpl;
import study.services.ZoomServiceImpl;


@RestController
public class CoordinatorController {

	 
	    
	@Autowired
	CoordinatorServiceImpl cooredinatorService;
	
	@Autowired
	FacultyServiceImpl facultyService;
	
	@Autowired
	FeedbackServiceImpl feedbackService;
	
	@Autowired
	SessionScheduleServiceImpl sessionService;
	
	@Autowired
	StudentServiceImpl studentService;
	
	@Autowired
	NoticeServiceImpl noticeService;
	
	@Autowired
	ModuleServiceImpl moduleService;
	
	@Autowired
	ZoomAccountServiceImpl zoomAccountService;
	
	@Autowired
	ZoomServiceImpl zoomService;

	@Autowired
	TokenServiceImpl tokenService;
	
//	//done
		@Secured("ROLE_ADMIN")
		@GetMapping("/zoomcontrols")
		public ModelAndView zoomControls()
		{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("zoomcontrols");
			return mv;
			
		}
		
	// Coordinator functions
	
	
	
	
	
	
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/addcoordinator")
	public ModelAndView addCoordinator()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addcoordinator");
		return mv;

	}
	@Secured("ROLE_ADMIN")
	@PostMapping("/savecoordinator")
	public ModelAndView saveCoordinator(@ModelAttribute CoordinatorTable coordinator)
	{

		ModelAndView mv = new ModelAndView();

		if(cooredinatorService.save(coordinator)) {
			mv.addObject("message","Coordinator details added sucessfully!");
			mv.setViewName("addcoordinator");
			return mv;
		} 
		else
		{
			mv.addObject("message","Something went Wrong!!,Please try again");
			mv.setViewName("addcoordinator"); 
			return mv;
		}

		//mv.addObject("message","Co ordinator details added sucessfully!");
	}
	
	@RequestMapping("/viewallcoordinators")
	public ModelAndView viewAllCordinators()
	{
		ModelAndView mv = new ModelAndView();
		List<CoordinatorTable> coordinator = cooredinatorService.findAll();
		mv.addObject("coordinator",coordinator);
		
		mv.setViewName("viewcoordinator");
		return mv;

	}
	


	@Secured("ROLE_ADMIN")
	@GetMapping("/deletebyid")
	public ModelAndView deleteByCoName(@RequestParam int id )
	{
		ModelAndView mv = new ModelAndView();
		cooredinatorService.deleteByID(id);
		mv.setViewName("redirect:/viewallcoordinators");
		return mv;
		
		
	}
	
	
	//done  
	@Secured("ROLE_ADMIN")
	@GetMapping("/updatecoordinator")
	public ModelAndView updateCoordinator(@RequestParam int id)
	{
		ModelAndView mv = new ModelAndView();
		CoordinatorTable coordinator =cooredinatorService.findById(id);
				
				
		mv.addObject("coordinator", coordinator);
		mv.setViewName("updatecoordinator");
		return mv;
	}
			
			//done
	@PostMapping("/saveupdatecoordinator")
	public ModelAndView saveUpdateCoordinato(@ModelAttribute("coordinator") CoordinatorTable coordinator)
	{
		ModelAndView mv = new ModelAndView();
		if(cooredinatorService.update(coordinator))
				{
					mv.addObject("message","updated Sucessfully");
					mv.setViewName("redirect:/viewallcoordinators");
					return mv;
				}
				else
				{
					mv.addObject("message","Something went Wrong!!,Please try again");
					mv.setViewName("updatecoordinator");
					return mv;
			}
				
				
	}
			
	
	
	
	
	
	
		
	
	//Scedule and session related
	
	
	//done
	@Secured("ROLE_ADMIN")
	@GetMapping("/schedulesession")
	public ModelAndView scheduleSession()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("schedulesession");
		mv.addObject("module",moduleService.findAll());
		mv.addObject("fac",facultyService.findAll());
		mv.addObject("zoomaccount",zoomAccountService.findAll());
		return mv;
		
	}
	
	//done
	@Secured("ROLE_ADMIN")
	@PostMapping("/savesession")
	public ModelAndView saveSession(@ModelAttribute("session") SessionScheduleTable session)
	{
		ModelAndView mv = new ModelAndView();
		if(sessionService.save(session))
		{
			mv.addObject("message","Session details added sucessfully!");
			mv.addObject("module",moduleService.findAll());
			mv.addObject("fac",facultyService.findAll());
			mv.addObject("zoomaccount",zoomAccountService.findAll());
			mv.setViewName("schedulesession");
			return mv;
		}
		else
		{
			mv.addObject("error","Something went Wrong!!,Please try again");
			mv.setViewName("schedulesession");
			return mv;
		}
		
		
	}
	
	
	@GetMapping("/viewallschedule")
	 public ModelAndView viewAllSchedule() {
	  return displayAllSchedule(1);
	  
	 }
	
	//in progress need to add 
	@GetMapping("/viewschedule")
	public ModelAndView displayAllSchedule(@RequestParam int  pageNumber)
	{
		ModelAndView mv = new ModelAndView();
		  int pageSize = 4;   // How many records on per page
		  Page<SessionScheduleTable> page=sessionService.findByPagination(pageNumber, pageSize);
		  List<SessionScheduleTable> session = page.getContent();
		  mv.addObject("pageNumber", pageNumber);
		  mv.addObject("numberOfPages", page.getTotalPages());
		  mv.addObject("totalRecords", page.getTotalElements());
		  mv.addObject("session",session);
		  
		  //logic for piechart
		  HashMap<String, Double> percentcovered=new HashMap<String, Double>();
		  HashMap<String, Integer> sessionmap= sessionService.sessionHourCompleted();
		 //  Not required
		 // HashMap<String, Integer> modulemap= moduleService.sessionHours();
		  int totalhrs=moduleService.totalHours();
		  
		    int onepercent= totalhrs/100;
		    double prcentageRemaining=100;
		    
		    for (Map.Entry<String,Integer> entry : sessionmap.entrySet())
		    {
		    	percentcovered.put(entry.getKey(), (double)entry.getValue()/onepercent);
		    	prcentageRemaining-=(double)entry.getValue()/onepercent;
		    }
		    percentcovered.put("remaining", prcentageRemaining);
		    
		    JSONObject json =  new JSONObject(percentcovered);
		    System.out.println(json);
		    mv.addObject("chartdata", percentcovered);
		    
		  mv.setViewName("viewschedule");
		return mv;
		
	}
	
	
	//done
	@Secured("ROLE_ADMIN")
	@GetMapping("/deleteschedule")
	public ModelAndView deleteSchedule(@RequestParam int id)
	{
		
		sessionService.deleteSessionByID(id);
		return viewAllSchedule();
	}
	//done
	@Secured("ROLE_ADMIN")
	@GetMapping(value="/editsession")    
	public ModelAndView  edit(@RequestParam int id){  
		 ModelAndView mv = new ModelAndView();
		 SessionScheduleTable session= sessionService.findBySessionId(id);
		 mv.addObject("session",session);
		 mv.setViewName("update");
		return mv;
	    }    
	
	//done
	@Secured("ROLE_ADMIN")
	@PostMapping("/saveUpdateScedule")
	public ModelAndView saveUpdateScedule(@ModelAttribute("sessionmodel") SessionScheduleTable session)
	{
		ModelAndView mv = new ModelAndView();
		if(sessionService.update(session))
		{
			mv.addObject("message","Session details Updated sucessfully!");
			mv.setViewName("redirect:/viewallschedule");
			return mv;
		}
		else
		{
			mv.addObject("error","Something went Wrong!!,Please try again");
			mv.setViewName("redirect:/viewallschedule");
			return mv;
		}
		
		
	}

	/*
	@EventListener(ApplicationReadyEvent.class)
	public void updateSceduleZoomData()
	{
		
		//hash map youse s do i can easyli find semilar object 
		  HashMap<String, MeetingResponsePojo> map = new HashMap<String, MeetingResponsePojo>();
		  
		  List <SessionScheduleTable> sessionlist=sessionService.findAll();
		 
		//token service returns hash map with status and token
		HashMap<String, String> hmap = tokenService.getToken();
		
		String status = hmap.get("status");
		String Token = hmap.get("Token");
		
		//If status sucess then call api 
		if (status.equals("sucess")) 
		{
			String meeting = null;
			try 
			{	//API call from Dao class
				meeting = zoomService.getMettings(Token);
				//response String converted to Json Object 
				JSONObject jsonObject = new JSONObject(meeting);
				//Json Array of meetings from response is collected 
				JSONArray tsmresponse = (JSONArray) jsonObject.get("meetings");

			for (int i = 0; i < tsmresponse.length(); i++) 
			{
				ObjectMapper mapper = new ObjectMapper();
				MeetingResponsePojo[] myPojo = mapper.readValue(tsmresponse.toString(), MeetingResponsePojo[].class);
				map.put(myPojo[i].getStart_time(), myPojo[i]);
				
			}
			 for (SessionScheduleTable sessionScheduleTable : sessionlist) {
				 
					Instant then = Instant.parse(sessionScheduleTable.getSessionDate());//converts UTC string to instant
					
					
					//forsetting joining url and Meeting ID
					String key=sessionScheduleTable.getSessionDate();
					  MeetingResponsePojo meet= map.get(key);
					  if(meet!=null && sessionScheduleTable.getMeetingId()==null )
					  {
					  sessionScheduleTable.setSessionInvitationDetails(meet.getJoin_url());
					  sessionScheduleTable.setMeetingId(meet.getId());
					  sessionService.updateZoomDetails(sessionScheduleTable);
					  }
					  if(then.toEpochMilli()>System.currentTimeMillis())
					  {
						

					  }
					 
					  
				}
				 
			 

			} catch (JsonProcessingException | JSONException e) {

				e.printStackTrace();
			}
		
		}
	}
	
	*/
	
	//**************************************************************************
	
	//Student related
	
	//done
	@Secured("ROLE_ADMIN")
	@GetMapping("/addstudent")
	public ModelAndView addStudent()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addstudent");
		return mv;
		
	}
	
	
	//done
	@Secured("ROLE_ADMIN")
	@PostMapping("/savestudent")
	public ModelAndView saveStudent(@ModelAttribute("student")StudentInfoTable student)
	{
		ModelAndView mv = new ModelAndView();
		System.out.println(student);
		if(studentService.save(student))
		{
			mv.addObject("message","Student details added sucessfully!");
			mv.setViewName("addstudent");
			return mv;
		}
		else
		{
			mv.addObject("error","Something went Wrong!!,Please try again");
			mv.setViewName("addstudent");
			return mv;
		}

	}
	
	//done

	 @GetMapping("/viewallstudents")
	 public ModelAndView viewAllStudents() {
	  return displayStudents(1);
	  
	 }
	
	//done

	@GetMapping("/studentpage")
	public ModelAndView displayStudents(@RequestParam int  pageNumber)
		{
			ModelAndView mv = new ModelAndView();
			int pageSize = 5;   // How many records on per page
			  Page<StudentInfoTable> page= studentService.findByPagination(pageNumber, pageSize);
			  List<StudentInfoTable> student = page.getContent();
			  mv.addObject("pageNumber", pageNumber);
			  mv.addObject("numberOfPages", page.getTotalPages());
			  mv.addObject("totalRecords", page.getTotalElements());
			  mv.addObject("student",student);
			  mv.setViewName("viewstudents");
			return mv;
			
		}
	
	//done
	@Secured("ROLE_ADMIN")
		@GetMapping("/updatestudent")
		public ModelAndView updateStudent(@RequestParam int id)
		{
			ModelAndView mv = new ModelAndView();
			StudentInfoTable student=studentService.findByID(id);
			
			
			mv.addObject("student", student);
			mv.setViewName("updatestudent");
			return mv;
		}
		
		//done
	@Secured("ROLE_ADMIN")
		@PostMapping("/saveupdatestudent")
		public ModelAndView saveUpdateStudent(@ModelAttribute("student") StudentInfoTable student)
		{
			ModelAndView mv = new ModelAndView();
			if(studentService.update(student))
			{
				mv.addObject("message","updated Sucessfully");
				mv.setViewName("redirect:/viewallstudents");
				return mv;
			}
			else
			{
				mv.addObject("message","Something went Wrong!!,Please try again");
				mv.setViewName("redirect:/viewallstudents");
				return mv;
			}
			
			
		}
		
	@Secured("ROLE_ADMIN")
	@GetMapping("/deletestudent")
	public ModelAndView deleteStudent(@RequestParam int id)
	{
			studentService.deleteById(id);
			return viewAllStudents();
	}

	
	//*******************************************************************************
	
	//Module related
	
	//done	
	@Secured("ROLE_ADMIN")
	@GetMapping("/addmodule")
	public ModelAndView addModule()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addmodule");
		return mv;
		
	}
	
	//done
	@Secured("ROLE_ADMIN")
	@PostMapping("/savemodule")
	public ModelAndView saveModule(@ModelAttribute("module") ModuleTable module)
	{
		ModelAndView mv = new ModelAndView();
		
		if(moduleService.save(module))
		{
			mv.addObject("message","Module details added sucessfully!");
			mv.setViewName("redirect:/viewallmodule");
			return mv;
		}
		else
		{
			mv.addObject("message","Something went Wrong!!,Please try again");
			mv.setViewName("redirect:/viewallmodule");
			return mv;
		}
		
		
	}
	
	//done
	 @GetMapping("/viewallmodule")
	 public ModelAndView viewAllModule() {
	  return display(1);
	  
	 }
	//done
	 @GetMapping("/modulepage")
	 public ModelAndView display(@RequestParam int  pageNumber) {
	  ModelAndView mv = new ModelAndView();
	  int pageSize = 4;   // How many records on per page
	  Page<ModuleTable> page= moduleService.findByPagination(pageNumber, pageSize);
	  List<ModuleTable> module = page.getContent();
	  mv.addObject("pageNumber", pageNumber);
	  mv.addObject("numberOfPages", page.getTotalPages());
	  mv.addObject("totalRecords", page.getTotalElements());
	  mv.addObject("module",module);
	  mv.setViewName("viewmodules");
	  return mv;
	  
	 }

	//done
	 @Secured("ROLE_ADMIN")
	@GetMapping("/updatemodule")
	public ModelAndView updateModule(@RequestParam int id)
	{
		ModelAndView mv = new ModelAndView();
		ModuleTable module=	moduleService.findById(id);
		
		
		mv.addObject("module", module);
		mv.setViewName("updatemodule");
		return mv;
	}
	
	//done
	 @Secured("ROLE_ADMIN")
	@PostMapping("/saveupdatemodule")
	public ModelAndView saveUpdateModule(@ModelAttribute("module") ModuleTable module)
	{
		ModelAndView mv = new ModelAndView();
		
		if(moduleService.update(module))
		{
			return viewAllModule();
		}
		else
		{
			mv.addObject("error","Something went Wrong!!,Please try again");
			mv.setViewName("updatemodule");
			return mv;
		}
		
		
	}
	 @Secured("ROLE_ADMIN")
	@GetMapping("/deletemodule")
	public ModelAndView deleteModule(@RequestParam int id)
	{
			moduleService.deleteById(id);
			return viewAllModule();
	}

	
	
	
	
	//***********************************************************************************
	
	//Zoom Account related
	
	//done
	 @Secured("ROLE_ADMIN")
	@GetMapping("/addzoomaccount")
	public ModelAndView addZoomAccount()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addzoomaccount");
		return mv;
		
	}
	//done
	 @Secured("ROLE_ADMIN")
	@PostMapping("/savezoomaccount")
	public ModelAndView saveZoomAccount(@ModelAttribute("zoomaccount") ZoomAccountTable zoom)
	{
		ModelAndView mv = new ModelAndView();
		if(zoomAccountService.save(zoom))
		{
			mv.addObject("message","Zoom Account added sucessfully!");
			mv.setViewName("redirect:/viewAccounts");
			return mv;
		}
		else
		{
			mv.addObject("error","Something went Wrong!!,Please try again");
			mv.setViewName("redirect:/viewAccounts");
			return mv;
		}
		
		
	}
	
	//done
	 @Secured("ROLE_ADMIN")
		@GetMapping("/viewAccounts")
		public ModelAndView viewAccounts()
		{
			ModelAndView mv = new ModelAndView();
			
			mv.addObject("accounts",zoomAccountService.findAll());
			mv.setViewName("viewAccounts");
			return mv;
			
		}
		
		//done
		@Secured("ROLE_ADMIN")
		@GetMapping("/deleteaccount")
		public ModelAndView deleteAccount(@RequestParam int id)
		{
				ModelAndView mv = new ModelAndView();
				zoomAccountService.deleteById(id);
				mv.setViewName("redirect:/viewAccounts");
				return mv;
		}


		//done
		@Secured("ROLE_ADMIN")
		@GetMapping("/updateaccount")
		public ModelAndView updateAccount(@RequestParam int id)
		{
			ModelAndView mv = new ModelAndView();
			ZoomAccountTable zoom=	zoomAccountService.findById(id);
			
			
			mv.addObject("zoom", zoom);
			mv.setViewName("updateaccount");
			return mv;
		}
		
		//done
		@Secured("ROLE_ADMIN")
		@PostMapping("/saveupdateaccount")
		public ModelAndView saveUpdateAccount(@ModelAttribute("zoomaccount") ZoomAccountTable zoomaccount)
		{
			ModelAndView mv = new ModelAndView();
			if(zoomAccountService.update(zoomaccount))
			{
				
				mv.addObject("message","Updated Sucsesfully");
				mv.setViewName("redirect:/viewAccounts");
				return mv;
			}
			else
			{
				mv.addObject("error","Something went Wrong!!,Please try again");
				mv.setViewName("updatemodule");
				return mv;
			}
			
			
		}
		
		
		
	//*************************************************************************************
	
	//Faculty related
	
	//done
		@Secured("ROLE_ADMIN")
	@GetMapping("/addfaculty")
	public ModelAndView addFaculty()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addfaculty");
		return mv;
		
	}
	
	//done
		@Secured("ROLE_ADMIN")
	@PostMapping("/savefaculty")
	public ModelAndView saveFaculty(@ModelAttribute("faculty") FacultyInfoTable faculty)
	{
		ModelAndView mv = new ModelAndView();
		System.out.println(faculty);
		if(facultyService.save(faculty))
		{
			mv.addObject("message","Faculty details added sucessfully!");
			mv.setViewName("addfaculty");
			return mv;
		}
		else
		{
			mv.addObject("error","Something went Wrong!!,Please try again");
			mv.setViewName("addfaculty");
			return mv;
		}
		
		
	}
	
	//done
		
		 @GetMapping("/viewallfaculty")
		 public ModelAndView viewAllFaculty() {
		  return displayFaculty(1);
		  
		 }
		
		//done
			@GetMapping("/facultypage")
			public ModelAndView displayFaculty(@RequestParam int  pageNumber)
				{
				
					ModelAndView mv = new ModelAndView();
					int pageSize = 4;   // How many records on per page
					  Page<FacultyInfoTable> page= facultyService.findByPagination(pageNumber, pageSize);
					  List<FacultyInfoTable> faculty = page.getContent();
					  mv.addObject("pageNumber", pageNumber);
					  mv.addObject("numberOfPages", page.getTotalPages());
					  mv.addObject("totalRecords", page.getTotalElements());
					  mv.addObject("faculty",faculty);
					  mv.setViewName("viewfaculty");
					return mv;
					
				}
			
			//done
			@Secured("ROLE_ADMIN")
			@GetMapping("/deletefaculty")
			public ModelAndView deleteFaculty(@RequestParam int id)
			{
					ModelAndView mv = new ModelAndView();
					facultyService.deleteById(id);
					mv.setViewName("redirect:/viewallfaculty");
					return mv;
			}
			
	
			
			
			
			//done
			@Secured("ROLE_ADMIN")
			@GetMapping("/updatefaculty")
			public ModelAndView updateFaculty(@RequestParam int id)
			{
				ModelAndView mv = new ModelAndView();
				FacultyInfoTable faculty=	facultyService.findById(id);
				
				
				mv.addObject("faculty", faculty);
				mv.setViewName("updatefaculty");
				return mv;
				
			}
			
			//done
			@Secured("ROLE_ADMIN")
			@PostMapping("/saveupdatefaculty")
			public ModelAndView saveUpdateFaculty(@ModelAttribute("faculty") FacultyInfoTable faculty)
			{
				ModelAndView mv = new ModelAndView();
				if(facultyService.update(faculty))
				{
					
					mv.addObject("message","Updated Sucsesfully");
					mv.setViewName("redirect:/viewallfaculty");
					return mv;
				}
				else
				{
					mv.addObject("error","Something went Wrong!!,Please try again");
					mv.setViewName("updatefaculty");
					return mv;
				}
				
				
			}
	//***************************************************************************************
	
	//Notice related
			@Secured("ROLE_ADMIN")
	@GetMapping("/addNotice")
	public ModelAndView addNotice()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addNotice");
		return mv;
		
	}
			@Secured("ROLE_ADMIN")
	@PostMapping("/addNoticeDetails")
	public ModelAndView addNoticeDetails(@RequestBody NoticeTable notice)
	{
		ModelAndView mv = new ModelAndView();
		if(noticeService.save(notice))
		{
			mv.addObject("message","Notice details added sucessfully!");
			mv.setViewName("addNotice");
			return mv;
		}
		else
		{
			mv.addObject("error","Something went Wrong!!,Please try again");
			mv.setViewName("addNotice");
			return mv;
		}
		
		
	}
	
	@GetMapping("/viewNotice")
	public ModelAndView viewNotice()
	{
		ModelAndView mv = new ModelAndView();
		List<NoticeTable> notice = noticeService.findAll();
		mv.addObject("ntc",notice);
		/*
		 * ModelAndView mv = new ModelAndView(); mv.setViewName("viewNotice"); return
		 * mv;
		 */
		mv.setViewName("viewNotice");
		return mv;
		
	}
	@Secured("ROLE_ADMIN")
	@PostMapping("/updatenoticedetails")
	public ModelAndView updateNoticeDetails(@RequestParam int id,@RequestParam String str)
	{
		ModelAndView mv = new ModelAndView();
		if(noticeService.update(id))
		{
			NoticeTable table = new NoticeTable();
			table.setNotice_description(str);
			mv.addObject("message","Notice details updated sucessfully!");
			mv.setViewName("viewNotice");
			return mv;
		}
		else
		{
			mv.addObject("error","Something went Wrong!!,Please try again");
			mv.setViewName("viewNotice");
			return mv;
		}
		
		
	}
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/deletenotice")
	public ModelAndView deleteNotice(@RequestParam int id)
	{
		ModelAndView mv = new ModelAndView();
		if(noticeService.deleteById(id))
		{
			mv.addObject("message","Notice deleted sucessfully!!");
			mv.setViewName("viewNotice");
			return mv;
		}
		else
		{
			mv.addObject("error","Something went Wrong!!,Please try again");
			mv.setViewName("viewNotice");
			return mv;
		}
		
	}
	
	
	//*********************************************************************************************
	
	//Feedback related   
	
	@Secured({ "ROLE_ADMIN", "ROLE_FACULTY" })
	@GetMapping("/viewallfeedback")
	 public ModelAndView viewAllFeedback() {
	  return displayAllFeedback(1);
	  
	 }
	
	//in progress need to add 
	@Secured({ "ROLE_ADMIN", "ROLE_FACULTY" })
	@GetMapping("/viewfeedback")
	public ModelAndView displayAllFeedback(@RequestParam int  pageNumber)
	{
		ModelAndView mv = new ModelAndView();
		  int pageSize = 5;   // How many records on per page
		  Page<FeedbackTable> page= feedbackService.findByPagination(pageNumber, pageSize);
		  List<FeedbackTable> feedback = page.getContent();
		  mv.addObject("pageNumber", pageNumber);
		  mv.addObject("numberOfPages", page.getTotalPages());
		  mv.addObject("totalRecords", page.getTotalElements());
		  mv.addObject("feedback",feedback);
		  mv.setViewName("viewfeedback");
		return mv;
		
	}
	
	

	
	
}
