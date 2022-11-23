package study.services;

import java.util.List;

import org.springframework.data.domain.Page;

import study.entity.FeedbackTable;

public interface FeedbackService {
	
	Page<FeedbackTable> findByPagination(int pageNo, int size);
	
	
	FeedbackTable findById(int id);
	
	List<FeedbackTable> findAll();
	
	boolean save(FeedbackTable feedback);
	
	void deleteById(int id);
	
	boolean update(FeedbackTable feedback);
	

}
