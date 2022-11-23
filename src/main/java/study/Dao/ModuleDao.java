package study.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import study.entity.ModuleTable;

@Repository
public interface ModuleDao extends JpaRepository<ModuleTable, Integer> {
	
	List<ModuleTable> findByModuleName(String name);

	@Query(value = "SELECT SUM(m.module_hours) FROM module_table AS m", nativeQuery = true)
	int totalHours();
	
	@Query(value = "SELECT m.module_name, m.module_hours FROM module_table AS m ", nativeQuery = true)
	List<Object[]> sessionHours();

}
 