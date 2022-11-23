package study.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import study.Dao.ModuleDao;
import study.entity.ModuleTable;

@Service
public class ModuleServiceImpl implements ModuleService{
	
	@Autowired
	ModuleDao dao;

	

	@Override
	public ModuleTable findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public boolean update(ModuleTable module) {
		ModuleTable moduleobj=	this.findById(module.getModule_id());
		moduleobj.setModule_details(module.getModule_details());
		moduleobj.setModule_hours(module.getModule_hours());
		moduleobj.setModuleName(module.getModuleName());
		return true;
	}

	@Override
	public boolean save(ModuleTable module) {
		
		 dao.save(module);
		return true;
		 
	}

	@Override
	public List<ModuleTable> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Page<ModuleTable> findByPagination(int pageNo, int size) {
		Pageable pageable = PageRequest.of(pageNo-1,size);
		  return dao.findAll(pageable);
	}

	@Override
	public int totalHours() {
		
		return dao.totalHours();
	}

	@Override
	public HashMap<String, Integer> sessionHours() {
		
			
			HashMap<String, Integer> map=new HashMap<>();
			
			List<Object[]> list= dao.sessionHours();
			 
			  for (Object[] keyValue : list) {
				  System.out.println(keyValue[0].toString()+" "+ Integer.parseInt(keyValue[1].toString()));
				  map.put(keyValue[0].toString(), Integer.parseInt(keyValue[1].toString()));
				  
			}
			
			return map;
		}

	

}
