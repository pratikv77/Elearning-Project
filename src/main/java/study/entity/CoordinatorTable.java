package study.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the coordinator_table database table.
 * 
 */
@Entity
@Table(name="coordinator_table")
@NamedQuery(name="CoordinatorTable.findAll", query="SELECT c FROM CoordinatorTable c")
public class CoordinatorTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="coordinator_id")
	private int coordinatorId;

	@Column(name="coordinator_fname")
	private String coordinatorFname;

	@Column(name="coordinator_is_active")
	private byte coordinatorIsActive;

	@Column(name="coordinator_lname")
	private String coordinatorLname;

	@Column(name="coordinator_password")
	private String coordinatorPassword;

	@Column(name="coordinator_email")
	private String coordinatorEmail;

	@Column(name="role")
	private String role;

	public CoordinatorTable() {
	}

	public int getCoordinatorId() {
		return this.coordinatorId;
	}

	public void setCoordinatorId(int coordinatorId) {
		this.coordinatorId = coordinatorId;
	}

	public String getCoordinatorFname() {
		return this.coordinatorFname;
	}

	public void setCoordinatorFname(String coordinatorFname) {
		this.coordinatorFname = coordinatorFname;
	}

	public byte getCoordinatorIsActive() {
		return this.coordinatorIsActive;
	}

	public void setCoordinatorIsActive(byte coordinatorIsActive) {
		this.coordinatorIsActive = coordinatorIsActive;
	}

	public String getCoordinatorLname() {
		return this.coordinatorLname;
	}

	public void setCoordinatorLname(String coordinatorLname) {
		this.coordinatorLname = coordinatorLname;
	}

	public String getCoordinatorPassword() {
		return this.coordinatorPassword;
	}

	public void setCoordinatorPassword(String coordinatorPassword) {
		this.coordinatorPassword = coordinatorPassword;
	}
	
	public String getCoordinatorEmail() {
		return coordinatorEmail;
	}

	public void setCoordinatorEmail(String coordinatorEmail) {
		this.coordinatorEmail = coordinatorEmail;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}