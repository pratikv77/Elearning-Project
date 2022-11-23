package study.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import study.entity.CoordinatorTable;

@Repository
public interface CoordinatorDao extends JpaRepository<CoordinatorTable, Integer> {

	
	CoordinatorTable findByCoordinatorEmail(String email);
	
	
}
