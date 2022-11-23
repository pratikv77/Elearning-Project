package study.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import study.Dao.SessionScheduleDao;
import study.Pojo.MeetingStartPojo;
import study.entity.SessionScheduleTable;

@Service
public class SessionScheduleServiceImpl implements SessionScheduleService{
	
	@Autowired
	SessionScheduleDao dao;

	@Override
	public SessionScheduleTable findBySessionId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<SessionScheduleTable> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public boolean save(SessionScheduleTable session) {
		// TODO Auto-generated method stub
		 dao.save(session);
		 return true;
	}

	@Override
	public boolean update(SessionScheduleTable session) {
		
		SessionScheduleTable sessionobj=dao.findById(session.getSessionId()).get();
		sessionobj.setSessionTopic(session.getSessionTopic());
		sessionobj.setSessionDate(session.getSessionDate());
		sessionobj.setSessionDetails(session.getSessionDetails());
		sessionobj.setSessionDuration(session.getSessionDuration());
		sessionobj.setSession_isActive(session.getSession_isActive());
		sessionobj.setSessionAttendance(session.getSessionAttendance());
		dao.save(sessionobj);
		 return true;
	}

	@Override
	public void deleteSessionByID(int id) {
		// TODO Auto-generated method stub
		 dao.deleteById(id);
		
	}

	@Override
	public Page<SessionScheduleTable> findByPagination(int pageNo, int size) {
		Pageable pageable = PageRequest.of(pageNo-1,size);
		  return dao.findAll(pageable);
	}

	public void updateZoomDetails(SessionScheduleTable sessionScheduleTable) {
		SessionScheduleTable sessionobj=dao.findById(sessionScheduleTable.getSessionId()).get();
		sessionobj.setSessionInvitationDetails(sessionScheduleTable.getSessionInvitationDetails());
		sessionobj.setMeetingId(sessionScheduleTable.getMeetingId());
		sessionobj.setSessionDate(sessionScheduleTable.getSessionDate());
		sessionobj.setSessionStartUrl(sessionScheduleTable.getSessionStartUrl());
		
		dao.save(sessionobj);
		
	}

	@Override
	public HashMap<String, Integer> sessionHourCompleted() {
		
		HashMap<String, Integer> map=new HashMap<>();
		
		List<Object[]> list= dao.sessionHourCompleted();
		 
		  for (Object[] keyValue : list) {
			  System.out.println(keyValue[0].toString()+" "+ Integer.parseInt(keyValue[1].toString()));
			  map.put(keyValue[0].toString(), Integer.parseInt(keyValue[1].toString()));
			  
		}
		
		return map;
	}

	
	

}
