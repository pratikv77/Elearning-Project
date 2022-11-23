package study.services;

import java.util.List;

import study.entity.ZoomAccountTable;

public interface ZoomAccountService  {
	
	
	ZoomAccountTable findById(int id);
	
	void deleteById(int id);
	
	boolean update(ZoomAccountTable zoom);
	
	boolean save(ZoomAccountTable zoom);
	
	List<ZoomAccountTable> findAll();


}
