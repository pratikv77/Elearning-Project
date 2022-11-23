package study.services;

import java.util.List;

import org.springframework.data.domain.Page;

import study.entity.StudentInfoTable;

public interface StudentService {
	
	Page<StudentInfoTable> findByPagination(int pageNo, int size);
	
	
	StudentInfoTable findByStudentEmail(String email);
	
	StudentInfoTable findByID(int id);
	
	List<StudentInfoTable> findAll();
	
	boolean save(StudentInfoTable student);
	
	void deleteById(int id);
	
	boolean update(StudentInfoTable student);
	
	

}
