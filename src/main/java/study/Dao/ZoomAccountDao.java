package study.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import study.entity.ZoomAccountTable;

@Repository
public interface ZoomAccountDao extends JpaRepository<ZoomAccountTable, Integer>{
	
	

}
