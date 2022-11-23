package study.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import study.Dao.FacultyDao;
import study.entity.FacultyInfoTable;

@Service
public class FacultyServiceImpl implements FacultyService{
	
	@Autowired
	FacultyDao dao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	

	@Override
	public FacultyInfoTable findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	

	
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		if(dao.existsById(id))
			dao.deleteById(id);	
	}
	@Override
	public List<FacultyInfoTable> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public FacultyInfoTable findByEmail(String email) {
		return dao.findByFacultyEmail(email);
	
		
		
	}

	@Override
	public boolean update(FacultyInfoTable faculty) {
		// TODO Auto-generated method
		FacultyInfoTable fa = this.findById(faculty.getFacultyId());
		fa.setFacultyFname(faculty.getFacultyFname());
		fa.setFacultyPassword(this.bCryptPasswordEncoder.encode(fa.getFacultyPassword()));
		fa.setFacultyLname(faculty.getFacultyLname());
		fa.setFacultyEducation(faculty.getFacultyEducation());
		fa.setFacultyEmail(faculty.getFacultyEmail());
		fa.setFacultyCity(faculty.getFacultyCity());
		fa.setFacultyAddress(faculty.getFacultyAddress());
		fa.setFacultyCity(faculty.getFacultyCity());
		fa.setFacultyPincode(faculty.getFacultyPincode());
		fa.setFacultyMobileNo(faculty.getFacultyMobileNo());
		fa.setFacultyExperienceInYears(faculty.getFacultyExperienceInYears());
		dao.save(fa);
		return true;
	}

	@Override
	public boolean save(FacultyInfoTable faculty) {
		faculty.setRole("ROLL_FACULTY");
		faculty.setFacultyPassword(this.bCryptPasswordEncoder.encode(faculty.getFacultyPassword()));
		dao.save(faculty);
		return true;
	}




	@Override
	public Page<FacultyInfoTable> findByPagination(int pageNo, int size) {
		Pageable pageable = PageRequest.of(pageNo-1,size);
		  return dao.findAll(pageable);
	}
	
	

}
