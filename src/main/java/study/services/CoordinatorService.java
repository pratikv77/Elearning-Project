package study.services;

import java.util.List;

import study.entity.CoordinatorTable;


public interface CoordinatorService {
	
	CoordinatorTable findByEmail(String email);
	
	CoordinatorTable findById(int id);
	
	List<CoordinatorTable> findAll();
	
	boolean save(CoordinatorTable crd);
	
	void deleteByID(int id);
	
	boolean update(CoordinatorTable crd);

}
