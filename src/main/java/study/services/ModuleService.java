package study.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Page;

import study.entity.ModuleTable;

public interface ModuleService {
	
	Page<ModuleTable> findByPagination(int pageNo, int size);
	
	ModuleTable findById(int id);
	
	void deleteById(int id);
	
	boolean update(ModuleTable module);
	
	boolean save(ModuleTable module);
	
	List<ModuleTable> findAll();
	
	int totalHours();
	
	HashMap<String, Integer> sessionHours();

}
