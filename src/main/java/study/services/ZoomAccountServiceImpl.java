package study.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.Dao.ZoomAccountDao;
import study.entity.ZoomAccountTable;

@Service
public class ZoomAccountServiceImpl implements ZoomAccountService{
	
	
	@Autowired
	ZoomAccountDao dao;

	@Override
	public ZoomAccountTable findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
		
	
		
	}

	@Override
	public boolean update(ZoomAccountTable zoom) {
		ZoomAccountTable zoomobj = this.findById(zoom.getZoom_id());
		zoomobj.setZoom_username(zoom.getZoom_username());
		zoomobj.setZoom_password(zoom.getZoom_password());
		zoomobj.setZoom_account_details(zoom.getZoom_account_details());
		dao.save(zoomobj);
		return true;
	}

	@Override
	public boolean save(ZoomAccountTable zoom) {
		dao.save(zoom);
		return true;
	}

	@Override
	public List<ZoomAccountTable> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
