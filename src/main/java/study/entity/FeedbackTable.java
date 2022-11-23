package  study.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the feedback_table database table.
 * 
 */
@Entity
@Table(name="feedback_table")
@NamedQuery(name="FeedbackTable.findAll", query="SELECT f FROM FeedbackTable f")
public class FeedbackTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="feedback_id")
	private int feedbackId;

	@Column(name="feedback")
	private String feedback;

	@ManyToOne
	@JoinColumn(name="module_id")
	private ModuleTable moduleTable;

	//bi-directional many-to-one association to StudentInfoTable
	@ManyToOne
	@JoinColumn(name="student_id")
	private StudentInfoTable studentInfoTable;
	
	@OneToMany(mappedBy="feedbackTable")
	private List<SessionScheduleTable> sessionScheduleTables;

	public FeedbackTable() {
	}

	public int getFeedbackId() {
		return this.feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public ModuleTable getModuleTable() {
		return moduleTable;
	}

	public void setModuleTable(ModuleTable moduleTable) {
		this.moduleTable = moduleTable;
	}

	public List<SessionScheduleTable> getSessionScheduleTables() {
		return sessionScheduleTables;
	}

	public void setSessionScheduleTables(List<SessionScheduleTable> sessionScheduleTables) {
		this.sessionScheduleTables = sessionScheduleTables;
	}

	public StudentInfoTable getStudentInfoTable() {
		return this.studentInfoTable;
	}

	public void setStudentInfoTable(StudentInfoTable studentInfoTable) {
		this.studentInfoTable = studentInfoTable;
	}

}