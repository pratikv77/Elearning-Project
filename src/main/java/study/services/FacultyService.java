package study.services;

import java.util.List;

import org.springframework.data.domain.Page;

import study.entity.FacultyInfoTable;

public interface FacultyService {
	
	Page<FacultyInfoTable> findByPagination(int pageNo, int size);
	
	
	FacultyInfoTable findByEmail(String email);
	
	FacultyInfoTable findById(int id);
	
	void deleteById(int id);
	
	boolean update(FacultyInfoTable faculty);
	
	boolean save(FacultyInfoTable faculty);
	
	List<FacultyInfoTable> findAll();
	
	

}
