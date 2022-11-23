package study.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import study.entity.SessionScheduleTable;
@Repository
public interface SessionScheduleDao extends JpaRepository<SessionScheduleTable, Integer> {
	
	SessionScheduleTable findBySessionId(int id);
	
	@Query(value = "SELECT module_table.module_name, SUM(s.session_duration) FROM session_schedule_table AS s JOIN module_table ON s.module_id = module_table.module_id GROUP BY s.module_id ", nativeQuery = true)
	List<Object[]> sessionHourCompleted();

}
