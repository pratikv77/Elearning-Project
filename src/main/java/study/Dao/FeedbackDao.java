package study.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import study.entity.FeedbackTable;

@Repository
public interface FeedbackDao extends JpaRepository<FeedbackTable, Integer> {

	
	
}
