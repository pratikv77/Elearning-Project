package study.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.Pojo.ZoomDetailsPojo;
import study.services.TokenServiceImpl;

@Controller
public class TokenController {

	@Autowired
	ZoomDetailsPojo details;

	@Autowired
	TokenServiceImpl tokenService;
	
	@GetMapping("/zoom")
	public ModelAndView zoom() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("zoomcontrols");
		return mv;

	}

	@GetMapping("/code")
	public ModelAndView code() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("client_id", details.getApiKey());
		mv.setViewName("zoomcontrols");
		return mv;

	}

	@GetMapping("/getcode")
	public ModelAndView getCode(@RequestParam("code") String code) {
		ModelAndView mv = new ModelAndView();
		
		if (tokenService.createToken(code)) 
		{
			mv.addObject("message", "Token created sucessfully");
		} 
		else 
		{
			mv.addObject("error", "error somthing went wrong!!!");
		}
		mv.setViewName("zoomcontrols");
		
		return mv;
	}

	@GetMapping("/refresh")
	public ModelAndView refresh() {
		ModelAndView mv = new ModelAndView();
		
		if (tokenService.refreshToken()) 
		{
			mv.addObject("message", "Token refreshed sucessfully");
		} 
		else 
		{
			mv.addObject("error", "error somthing went wrong!!!");
		}
		mv.setViewName("zoomcontrols");
		
		return mv;

	}

}
