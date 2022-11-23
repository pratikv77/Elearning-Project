package study.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Arrays;
import java.util.List;


/**
 * The persistent class for the faculty_info_table database table.
 * 
 */
@Entity
@Table(name="faculty_info_table")
@NamedQuery(name="FacultyInfoTable.findAll", query="SELECT f FROM FacultyInfoTable f")
public class FacultyInfoTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="faculty_id")
	private int facultyId;

	@Column(name="faculty_address")
	private String facultyAddress;

	@Column(name="faculty_city")
	private String facultyCity;

	@Column(name="faculty_education")
	private String facultyEducation;

	@Column(name="faculty_experience_in_years")
	private String facultyExperienceInYears;

	@Column(name="faculty_fname")
	private String facultyFname;

	@Lob
	@Column(name="faculty_image")
	private byte[] facultyImage;

	@Column(name="faculty_lname")
	private String facultyLname;

	@Column(name="faculty_mobile_no")
	private String facultyMobileNo;

	@Column(name="faculty_password")
	private String facultyPassword;

	@Column(name="faculty_pincode")
	private int facultyPincode;

	@Column(name="faculty_email")
	private String facultyEmail;

	private String role;

	//bi-directional many-to-one association to SessionScheduleTable
	@OneToMany(mappedBy="facultyInfoTable")
	private List<SessionScheduleTable> sessionScheduleTables;

	public FacultyInfoTable() {
	}

	public int getFacultyId() {
		return this.facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyAddress() {
		return this.facultyAddress;
	}

	public void setFacultyAddress(String facultyAddress) {
		this.facultyAddress = facultyAddress;
	}

	public String getFacultyCity() {
		return this.facultyCity;
	}

	public void setFacultyCity(String facultyCity) {
		this.facultyCity = facultyCity;
	}

	public String getFacultyEducation() {
		return this.facultyEducation;
	}

	public void setFacultyEducation(String facultyEducation) {
		this.facultyEducation = facultyEducation;
	}

	public String getFacultyExperienceInYears() {
		return this.facultyExperienceInYears;
	}

	public void setFacultyExperienceInYears(String facultyExperienceInYears) {
		this.facultyExperienceInYears = facultyExperienceInYears;
	}

	public String getFacultyFname() {
		return this.facultyFname;
	}

	public void setFacultyFname(String facultyFname) {
		this.facultyFname = facultyFname;
	}

	public byte[] getFacultyImage() {
		return this.facultyImage;
	}

	public void setFacultyImage(byte[] facultyImage) {
		this.facultyImage = facultyImage;
	}

	public String getFacultyLname() {
		return this.facultyLname;
	}

	public void setFacultyLname(String facultyLname) {
		this.facultyLname = facultyLname;
	}

	public String getFacultyMobileNo() {
		return this.facultyMobileNo;
	}

	public void setFacultyMobileNo(String facultyMobileNo) {
		this.facultyMobileNo = facultyMobileNo;
	}


	public String getFacultyPassword() {
		return facultyPassword;
	}

	public void setFacultyPassword(String facultyPassword) {
		this.facultyPassword = facultyPassword;
	}

	public int getFacultyPincode() {
		return this.facultyPincode;
	}

	public void setFacultyPincode(int facultyPincode) {
		this.facultyPincode = facultyPincode;
	}

	

	public String getFacultyEmail() {
		return facultyEmail;
	}

	public void setFacultyEmail(String facultyEmail) {
		this.facultyEmail = facultyEmail;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

	public List<SessionScheduleTable> getSessionScheduleTables() {
		return this.sessionScheduleTables;
	}

	public void setSessionScheduleTables(List<SessionScheduleTable> sessionScheduleTables) {
		this.sessionScheduleTables = sessionScheduleTables;
	}

	public SessionScheduleTable addSessionScheduleTable(SessionScheduleTable sessionScheduleTable) {
		getSessionScheduleTables().add(sessionScheduleTable);
		sessionScheduleTable.setFacultyInfoTable(this);

		return sessionScheduleTable;
	}

	public SessionScheduleTable removeSessionScheduleTable(SessionScheduleTable sessionScheduleTable) {
		getSessionScheduleTables().remove(sessionScheduleTable);
		sessionScheduleTable.setFacultyInfoTable(null);

		return sessionScheduleTable;
	}

	@Override
	public String toString() {
		return "FacultyInfoTable [facultyId=" + facultyId + ", facultyAddress=" + facultyAddress + ", facultyCity="
				+ facultyCity + ", facultyEducation=" + facultyEducation + ", facultyExperienceInYears="
				+ facultyExperienceInYears + ", facultyFname=" + facultyFname + ", facultyImage="
				+ Arrays.toString(facultyImage) + ", facultyLname=" + facultyLname + ", facultyMobileNo="
				+ facultyMobileNo + ", facultyPassword=" + facultyPassword + ", facultyPincode=" + facultyPincode
				+ ", facultyEmail=" + facultyEmail + ", role=" + role + ", sessionScheduleTables="
				+ sessionScheduleTables + "]";
	}
	
	

}