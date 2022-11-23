package study.Controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import study.entity.FeedbackTable;
import study.services.FeedbackService;

@RestController
public class StudentInfoController {


	
	@Autowired
	FeedbackService feedbackService;
	
	
	
	
	//done
	@Secured("ROLE_STUDENT")
	@GetMapping("/addfeedback")
	public ModelAndView addFeedback(@RequestParam int  id)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("moduleid",id);
		mv.setViewName("addfeedback");
		return mv;
		
	}
	
	//done
	@Secured("ROLE_STUDENT")
	@PostMapping("/savefeedback")
	public ModelAndView saveFeedback(@ModelAttribute("feedbackobj") FeedbackTable feedbackobj)
	{
		ModelAndView mv = new ModelAndView();
		if(feedbackService.save(feedbackobj))
		{
			mv.addObject("message","Feedback added sucessfully!");
			mv.setViewName("redirect:/viewallschedule");
			return mv;
		}
		else
		{
			mv.addObject("error","Something went Wrong!!,Please try again");
			mv.setViewName("addfeedback");
			return mv;
		}
		
		
	}
	
	

	//done
	@Secured("ROLE_STUDENT")
	@GetMapping("/updatefeedback")
	public ModelAndView updateFeedback(@RequestParam int id)
	{
		ModelAndView mv = new ModelAndView();
		FeedbackTable feedback=	feedbackService.findById(id);
		
		
		mv.addObject("feedback", feedback);
		mv.setViewName("updatefeedback");
		return mv;
		
	}
	
	//done
	@Secured("ROLE_STUDENT")
	@PostMapping("/saveupdatefeedback")
	public ModelAndView saveUpdateFeedback(@ModelAttribute("feedbackobj") FeedbackTable feedback)
	{
		ModelAndView mv = new ModelAndView();
		if(feedbackService.update(feedback))
		{
			
			mv.addObject("message","Updated Sucsesfully");
			mv.setViewName("redirect:/viewallfeedback");
			return mv;
		}
		else
		{
			mv.addObject("error","Something went Wrong!!,Please try again");
			mv.setViewName("updatefeedback");
			return mv;
		}
		
		
	}
	
	
	//done
	@Secured("ROLE_STUDENT")
	@GetMapping("/deletefeedback")
	public ModelAndView deleteFeedback(@RequestParam int id)
	{
			ModelAndView mv = new ModelAndView();
			feedbackService.deleteById(id);
			mv.setViewName("redirect:/viewallfeedback");
			return mv;
	}
	
	
	
	 
	
	
	
}
