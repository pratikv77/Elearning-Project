package study.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import study.entity.FacultyInfoTable;

@Repository
public interface FacultyDao extends JpaRepository<FacultyInfoTable,Integer> {

	FacultyInfoTable findByFacultyEmail(String email);
	
	
	
	
}
