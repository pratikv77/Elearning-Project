package study.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import study.entity.StudentInfoTable;
@Repository
public interface StudentDao extends JpaRepository<StudentInfoTable, Integer>{
	
	StudentInfoTable findByStudentEmail(String email);
	
	//StudentInfoTable findById(int id);
	
	
	

}
