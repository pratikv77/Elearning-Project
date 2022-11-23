package study.services;

import java.util.List;
import study.entity.NoticeTable;

public interface NoticeService {
	

	
	NoticeTable findById(int id);
	
	boolean deleteById(int id);
	
	boolean update(int id);
	
	boolean save(NoticeTable notice);
	
	List<NoticeTable> findAll();
	
	void deleteAll();

}
