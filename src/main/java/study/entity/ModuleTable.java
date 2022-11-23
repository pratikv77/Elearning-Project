package study.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="module_table")
public class ModuleTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="module_id")
	private int module_id;
	
	@Column(name="module_details")
	private String module_details;
	
	@Column(name="module_hours")
	private int module_hours;
	
	@Column(name="module_name")
	private String moduleName;
	
	@OneToMany(mappedBy="moduleTable")
	private List<FeedbackTable> feedbackTables;
	
	
	@OneToMany(mappedBy="moduleTable")
	private List<SessionScheduleTable> sessionScheduleTables;
	
	public int getModule_id() {
		return module_id;
	}

	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}

	public String getModule_details() {
		return module_details;
	}

	public void setModule_details(String module_details) {
		this.module_details = module_details;
	}
	
	

	public int getModule_hours() {
		return module_hours;
	}

	public void setModule_hours(int module_hours) {
		this.module_hours = module_hours;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public List<SessionScheduleTable> getSessionScheduleTables() {
		return sessionScheduleTables;
	}

	public void setSessionScheduleTables(List<SessionScheduleTable> sessionScheduleTables) {
		this.sessionScheduleTables = sessionScheduleTables;
	}

	@Override
	public String toString() {
		return "ModuleTable [module_id=" + module_id + ", module_details=" + module_details + ", module_hours="
				+ module_hours + ", moduleName=" + moduleName + ", feedbackTables=" + feedbackTables
				+ ", sessionScheduleTables=" + sessionScheduleTables + "]";
	}



	
	
	
	

}
