package study.services;

import java.util.List;

import org.springframework.stereotype.Service;

import study.entity.NoticeTable;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Override
	public NoticeTable findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(int id) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean save(NoticeTable notice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<NoticeTable> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
