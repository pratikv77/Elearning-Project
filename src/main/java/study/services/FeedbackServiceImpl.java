package study.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import study.Dao.FeedbackDao;
import study.entity.FeedbackTable;

@Service
public class FeedbackServiceImpl implements FeedbackService{
	
	@Autowired
	FeedbackDao dao;

	@Override
	public FeedbackTable findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<FeedbackTable> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public boolean save(FeedbackTable feedback) {
		dao.save(feedback);
		return true;
	}

	@Override
	public Page<FeedbackTable> findByPagination(int pageNo, int size) {
		Pageable pageable = PageRequest.of(pageNo-1,size);
		  return dao.findAll(pageable);
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public boolean update(FeedbackTable feedback) {
		FeedbackTable feedbackobj=this.findById(feedback.getFeedbackId());
		feedbackobj.setFeedback(feedback.getFeedback());
		dao.save(feedbackobj);
		return true;
	}

	
	
	
	

}
