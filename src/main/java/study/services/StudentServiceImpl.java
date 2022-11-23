package study.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import study.Dao.StudentDao;
import study.entity.StudentInfoTable;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao dao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@Override
	public StudentInfoTable findByID(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<StudentInfoTable> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public boolean save(StudentInfoTable student) {
		// TODO Auto-generated method stub
		student.setRole("ROLE_STUDENT");
		student.setStudentPassword(this.bCryptPasswordEncoder.encode(student.getStudentPassword()));
		dao.save(student);
		return true;
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public boolean update(StudentInfoTable student) {
		// TODO Auto-generated method
		StudentInfoTable std = dao.findById(student.getStudentId()).get();
		std.setStudentFname(student.getStudentFname());
		std.setStudentLname(student.getStudentLname());
		std.setStudentDateOfBirth(student.getStudentDateOfBirth() );
		std.setStudentGender(student.getStudentGender());
		std.setStudentEducation(student.getStudentEducation());
		std.setStudentAddress(student.getStudentAddress());
		std.setStudentPincode(student.getStudentPincode());
		std.setStudentCity(student.getStudentCity());
		std.setStudentPrnNo(student.getStudentPrnNo());
		std.setStudentMobileNo(student.getStudentMobileNo());
		std.setStudentEmail(student.getStudentEmail());
		dao.save(std);
		return true;
	}

	@Override
	public StudentInfoTable findByStudentEmail(String email) {
		
		
		return dao.findByStudentEmail(email);
		
	}

	@Override
	public Page<StudentInfoTable> findByPagination(int pageNo, int size) {
		Pageable pageable = PageRequest.of(pageNo-1,size);
		  return dao.findAll(pageable);
	}
	
	

}
