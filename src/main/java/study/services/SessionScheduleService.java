package study.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Page;

import study.entity.SessionScheduleTable;

public interface SessionScheduleService {
	
	Page<SessionScheduleTable> findByPagination(int pageNo, int size);
	
	SessionScheduleTable findBySessionId(int id);
	
	List<SessionScheduleTable> findAll();
	
	boolean save(SessionScheduleTable session);
	
	boolean update(SessionScheduleTable session);
	
	void deleteSessionByID(int id);
	
	HashMap<String, Integer> sessionHourCompleted();
	
	
	

}
