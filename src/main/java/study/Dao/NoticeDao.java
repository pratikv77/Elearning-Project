package study.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import study.entity.NoticeTable;

@Repository
public interface NoticeDao extends JpaRepository<NoticeTable, Integer>{
	

	
}
