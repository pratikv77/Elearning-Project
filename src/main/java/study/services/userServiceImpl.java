package study.services;

import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import study.Dao.CoordinatorDao;
import study.Dao.FacultyDao;
import study.Dao.StudentDao;
import study.entity.CoordinatorTable;
import study.entity.FacultyInfoTable;
import study.entity.StudentInfoTable;

@Service
public class userServiceImpl implements userService{
	
	@Autowired
	private CoordinatorDao coordinatorDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private FacultyDao facultyDao;
	@Autowired
	EmailServiceImpl emailImpl;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	


	Random random = new Random(1000);
	
	@Override
	public boolean isUserPresent(String username) {
		
		CoordinatorTable coordinator = coordinatorDao.findByCoordinatorEmail(username);
		StudentInfoTable stud=studentDao.findByStudentEmail(username);
		FacultyInfoTable faculty= facultyDao.findByFacultyEmail(username);
		
		if(coordinator!=null || stud !=null || faculty != null )
		return true;
		
		else
			return false;
	}


	
	@Override
	public int sendOtp(String email) {
	
		int otp=this.random.nextInt(9999);
		String sub="OTP to reset password";
		String body="Please find the following OTP to reset your password :"+otp;
		try {
			emailImpl.sendMailWithAttachment(email, body, sub);
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		System.out.println("OTP"+otp);
		
		return otp;
	}



	@Override
	public boolean changePass(String pass, String username) {
		System.out.println(pass+""+username);
		CoordinatorTable coordinator = coordinatorDao.findByCoordinatorEmail(username);
		StudentInfoTable stud=studentDao.findByStudentEmail(username);
		FacultyInfoTable faculty= facultyDao.findByFacultyEmail(username);
		
		if(coordinator!=null)
		{
			
			coordinator.setCoordinatorPassword(this.bCryptPasswordEncoder.encode(pass));
			coordinatorDao.save(coordinator);
			return true;
			
		}
		else if(stud!=null)
		{
			
			stud.setStudentPassword(this.bCryptPasswordEncoder.encode(pass));
			studentDao.save(stud);
			return true;
			
		}
		else if(faculty!=null)
		{
			
			faculty.setFacultyPassword(this.bCryptPasswordEncoder.encode(pass));
			facultyDao.save(faculty);
			return true;
		
		}
		else {
		return false;
		}
	}



	
}
