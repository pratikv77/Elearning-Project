  package study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import study.Dao.CoordinatorDao;
import study.Dao.FacultyDao;
import study.Dao.StudentDao;
import study.Pojo.User;
import study.entity.CoordinatorTable;
import study.entity.FacultyInfoTable;
import study.entity.StudentInfoTable;




@Service
public class CustomUserDetailService implements UserDetailsService {
	
	
	@Autowired
	private CoordinatorDao coordinatorDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private FacultyDao facultyDao;

	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user= new User();
		CoordinatorTable coordinator = coordinatorDao.findByCoordinatorEmail(username);
		StudentInfoTable stud=studentDao.findByStudentEmail(username);
		FacultyInfoTable faculty= facultyDao.findByFacultyEmail(username);
		
		if(coordinator!=null)
		{
			user.setUsername(coordinator.getCoordinatorEmail());
			user.setPassword(coordinator.getCoordinatorPassword());
			user.setRole(coordinator.getRole());
			user.setName(coordinator.getCoordinatorFname());
			user.setId(coordinator.getCoordinatorId());
		}
		else if(stud!=null)
		{
			user.setUsername(stud.getStudentEmail());
			user.setPassword(stud.getStudentPassword());
			user.setRole(stud.getRole());
			user.setName(stud.getStudentFname());
			user.setId(stud.getStudentId());
		}
		else if(faculty!=null)
		{
			user.setUsername(faculty.getFacultyEmail());
			user.setPassword(faculty.getFacultyPassword());
			user.setRole(faculty.getRole());
			user.setName(faculty.getFacultyFname());
			user.setId(faculty.getFacultyId());
			
		}
		
		if(coordinator==null && stud==null && faculty==null) {
			throw new UsernameNotFoundException(username+"No such user");
		}
		
		return new CustomUserDetail(user);
	}

}
