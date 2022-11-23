package study.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import java.util.Arrays;
import java.util.List;


/**
 * The persistent class for the student_info_table database table.
 * 
 */
@Entity
@Table(name="student_info_table")
@NamedQuery(name="StudentInfoTable.findAll", query="SELECT s FROM StudentInfoTable s")
public class StudentInfoTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="student_id")
	private int studentId;
		
	private String role;

	@Column(name="student_address")
	private String studentAddress;

	@Column(name="student_city")
	private String studentCity;

	@Column(name="student_date_of_birth")
	private Date studentDateOfBirth;

	@Column(name="student_education")
	private String studentEducation;

	@Column(name="student_fname")
	private String studentFname;
	
	@Column(name="student_mname")
	private String studentMname;

	@Column(name="student_gender")
	private String studentGender;

	@Lob
	@Column(name="student_image")
	private byte[] studentImage;

	@Column(name="student_lname")
	private String studentLname;

	@Column(name="student_mobile_no")
	private String studentMobileNo;

	@Column(name="student_password")
	private String studentPassword;

	@Column(name="student_pincode")
	private int studentPincode;

	@Column(name="student_prn_no")
	private String studentPrnNo;

	@Column(name="student_email")
	private String studentEmail;

	//bi-directional many-to-one association to FeedbackTable
	@OneToMany(mappedBy="studentInfoTable")
	private List<FeedbackTable> feedbackTables;

	public StudentInfoTable() {
	}

	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStudentAddress() {
		return this.studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentCity() {
		return this.studentCity;
	}

	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}

	public Date getStudentDateOfBirth() {
		return this.studentDateOfBirth;
	}

	public void setStudentDateOfBirth(Date studentDateOfBirth) {
		this.studentDateOfBirth = studentDateOfBirth;
	}

	public String getStudentEducation() {
		return this.studentEducation;
	}

	public void setStudentEducation(String studentEducation) {
		this.studentEducation = studentEducation;
	}

	public String getStudentFname() {
		return this.studentFname;
	}

	public void setStudentFname(String studentFname) {
		this.studentFname = studentFname;
	}

	
	
	public String getStudentMname() {
		return studentMname;
	}

	public void setStudentMname(String studentMname) {
		this.studentMname = studentMname;
	}

	public String getStudentGender() {
		return this.studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public byte[] getStudentImage() {
		return this.studentImage;
	}

	public void setStudentImage(byte[] studentImage) {
		this.studentImage = studentImage;
	}

	public String getStudentLname() {
		return this.studentLname;
	}

	public void setStudentLname(String studentLname) {
		this.studentLname = studentLname;
	}

	public String getStudentMobileNo() {
		return this.studentMobileNo;
	}

	public void setStudentMobileNo(String studentMobileNo) {
		this.studentMobileNo = studentMobileNo;
	}

	public String getStudentPassword() {
		return this.studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public int getStudentPincode() {
		return this.studentPincode;
	}

	public void setStudentPincode(int studentPincode) {
		this.studentPincode = studentPincode;
	}

	public String getStudentPrnNo() {
		return this.studentPrnNo;
	}

	public void setStudentPrnNo(String studentPrnNo) {
		this.studentPrnNo = studentPrnNo;
	}

	
	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public List<FeedbackTable> getFeedbackTables() {
		return this.feedbackTables;
	}

	public void setFeedbackTables(List<FeedbackTable> feedbackTables) {
		this.feedbackTables = feedbackTables;
	}

	public FeedbackTable addFeedbackTable(FeedbackTable feedbackTable) {
		getFeedbackTables().add(feedbackTable);
		feedbackTable.setStudentInfoTable(this);

		return feedbackTable;
	}

	public FeedbackTable removeFeedbackTable(FeedbackTable feedbackTable) {
		getFeedbackTables().remove(feedbackTable);
		feedbackTable.setStudentInfoTable(null);

		return feedbackTable;
	}

	@Override
	public String toString() {
		return "StudentInfoTable [studentId=" + studentId + ", role=" + role + ", studentAddress=" + studentAddress
				+ ", studentCity=" + studentCity + ", studentEducation="
				+ studentEducation + ", studentFname=" + studentFname + ", studentGender=" + studentGender
				+ ", studentImage=" + Arrays.toString(studentImage) + ", studentLname=" + studentLname
				+ ", studentMobileNo=" + studentMobileNo + ", studentPassword=" + studentPassword + ", studentPincode="
				+ studentPincode + ", studentPrnNo=" + studentPrnNo + ", studentEmail=" + studentEmail
				+ ", feedbackTables=" + feedbackTables + "]";
	}
	
	

}