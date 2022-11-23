package study.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import study.Dao.CoordinatorDao;
import study.entity.CoordinatorTable;

@Service
public class CoordinatorServiceImpl implements CoordinatorService {
	
	@Autowired
	CoordinatorDao dao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public CoordinatorTable findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<CoordinatorTable> findAll() {
		
		return dao.findAll();
		
	}

	@Override
	public boolean save(CoordinatorTable coordinator) {
		// TODO Auto-generated method stub
		coordinator.setRole("ROLE_ADMIN");
		coordinator.setCoordinatorPassword(this.bCryptPasswordEncoder.encode(coordinator.getCoordinatorPassword()));
		 dao.save(coordinator);
		 return true;
	}

	@Override
	public void deleteByID(int id) {
		// TODO Auto-generated method stub
		if(dao.existsById(id))
			dao.deleteById(id);
		
	}

	@Override
	public boolean update(CoordinatorTable coordinator) {
		// TODO Auto-generated method
		CoordinatorTable co = dao.findById(coordinator.getCoordinatorId()).get();
		co.setCoordinatorIsActive(coordinator.getCoordinatorIsActive());
		co.setCoordinatorEmail(coordinator.getCoordinatorEmail());
		dao.save(co);
		return true;
	}

	@Override
	public CoordinatorTable findByEmail(String email) {
	
		
		return dao.findByCoordinatorEmail(email);
		// TODO Auto-generated method stub
	
		
	}

	

	

}
