package study.Controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import study.services.userServiceImpl;


@Controller
@SessionAttributes({"OTP","email"})
public class UserController {
	
	@Autowired
	userServiceImpl userimpl;
	
	
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/forgot")
	public String forgot()
	{
		
		return "forgot_pass";
	}
	
	@PostMapping("/send-otp")
	public ModelAndView sendOtp(@RequestParam String email)
	{
		ModelAndView mv = new ModelAndView();
		boolean flag = false;
		int otp = 0;
		
		if(userimpl.isUserPresent(email)  )
		{
			otp =userimpl.sendOtp(email);
			flag = true;
		}
		
		if(flag) {
			mv.addObject("OTP", otp);
			mv.addObject("email", email);
			mv.addObject("message", "We have sent OTP to your registered Email ID");
			mv.setViewName("varify_otp");
			
			return mv ;
			
		}
		else {
			mv.addObject("error", "invalid email!! user not present");
			mv.setViewName("forgot_pass");
			return mv;
		}
		
	
	}
	
	@PostMapping("/verify-otp")
	public ModelAndView verifyOtp(@RequestParam int otp,@ModelAttribute("OTP") int sessionotp)
	{
		ModelAndView mv = new ModelAndView();
		if(sessionotp==otp)
		{
			mv.setViewName("changepassword");
			return mv;
		}
		else
		{
			mv.addObject("error", "invalid OTP");
			mv.setViewName("varify_otp");
			return mv;
		}

	}
	
	@PostMapping("/changepass")
	public ModelAndView changePass(@RequestParam String pass,@ModelAttribute("email")String email)
	{
		ModelAndView mv = new ModelAndView();
		if(userimpl.changePass(pass,email))
		{
			mv.addObject("message", "Password reset sucsessfully... please login");
			mv.setViewName("login");
			return mv;
		}
		else {
			
			mv.addObject("error", "Somthing went wrong try again");
			mv.setViewName("changepassword");
			return mv;
			
		}
		
	}
	
	
	@GetMapping("/home")
	public String home()
	{
		return "index";
	}

}
