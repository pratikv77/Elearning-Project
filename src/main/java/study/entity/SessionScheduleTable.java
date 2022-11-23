package study.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the session_schedule_table database table.
 * 
 */
@Entity
@Table(name="session_schedule_table")
@NamedQuery(name="SessionScheduleTable.findAll", query="SELECT s FROM SessionScheduleTable s")
public class SessionScheduleTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="session_id")
	private int sessionId;

	//this will be set at  time of updation
	@Column(name="session_attendance")
	private String sessionAttendance;

	//need to change to string and save both time and date
	@Column(name="session_date")
	private String sessionDate;
	
	//Topic
		@Column(name="session_topic")
		private String sessionTopic;

	
	//agenda
	@Column(name="session_details")
	private String sessionDetails;

	@Column(name="session_enable_recording")
	private byte sessionEnableRecording;

	//not required change to int duration
	@Column(name="session_Duration")
	private int sessionDuration;

	//this will be set at  time of updation
	@Column(name="session_invitation_details")
	private String sessionInvitationDetails;
	
	//this will be set at  time of updation
		@Column(name="session_starturl")
		private String sessionStartUrl;

	//this will be set at  time of updation
	private byte session_isActive;

	//this will be set at  time of updation
	@Column(name="session_recording_link")
	private String sessionRecordingLink;

	

	//this will be set at  time of updation
	@Column(name="session_meetingid")
	private Long meetingId;

	

	//bi-directional many-to-one association to FacultyInfoTable
	@ManyToOne
	@JoinColumn(name="faculty_id")
	private FacultyInfoTable facultyInfoTable;
	
	@ManyToOne
	@JoinColumn(name="module_id")
	private ModuleTable moduleTable;

	//this will be set at  time of updation
	@ManyToOne
	@JoinColumn(name="feedback_id")
	private FeedbackTable feedbackTable;
	
	@ManyToOne
	@JoinColumn(name="zoom_id")
	private ZoomAccountTable zoomAccountTable;
	
	public SessionScheduleTable() {
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	
	
	public String getSessionTopic() {
		return sessionTopic;
	}

	public void setSessionTopic(String sessionTopic) {
		this.sessionTopic = sessionTopic;
	}

	public String getSessionAttendance() {
		return sessionAttendance;
	}

	public void setSessionAttendance(String sessionAttendance) {
		this.sessionAttendance = sessionAttendance;
	}

	
	public String getSessionDetails() {
		return sessionDetails;
	}

	public void setSessionDetails(String sessionDetails) {
		this.sessionDetails = sessionDetails;
	}
	
	

	public String getSessionDate() {
		return sessionDate;
	}

	public void setSessionDate(String sessionDate) {
		this.sessionDate = sessionDate;
	}

	public int getSessionDuration() {
		return sessionDuration;
	}

	public void setSessionDuration(int sessionDuration) {
		this.sessionDuration = sessionDuration;
	}

	public byte getSessionEnableRecording() {
		return sessionEnableRecording;
	}

	public void setSessionEnableRecording(byte sessionEnableRecording) {
		this.sessionEnableRecording = sessionEnableRecording;
	}


	public String getSessionInvitationDetails() {
		return sessionInvitationDetails;
	}

	public void setSessionInvitationDetails(String sessionInvitationDetails) {
		this.sessionInvitationDetails = sessionInvitationDetails;
	}
	
	

	public String getSessionStartUrl() {
		return sessionStartUrl;
	}

	public void setSessionStartUrl(String sessionStartUrl) {
		this.sessionStartUrl = sessionStartUrl;
	}

	public byte getSession_isActive() {
		return session_isActive;
	}

	public void setSession_isActive(byte session_isActive) {
		this.session_isActive = session_isActive;
	}

	public String getSessionRecordingLink() {
		return sessionRecordingLink;
	}

	public void setSessionRecordingLink(String sessionRecordingLink) {
		this.sessionRecordingLink = sessionRecordingLink;
	}

	

	public Long getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Long meetingId) {
		this.meetingId = meetingId;
	}

	public FacultyInfoTable getFacultyInfoTable() {
		return facultyInfoTable;
	}

	public void setFacultyInfoTable(FacultyInfoTable facultyInfoTable) {
		this.facultyInfoTable = facultyInfoTable;
	}

	public ModuleTable getModuleTable() {
		return moduleTable;
	}

	public void setModuleTable(ModuleTable moduleTable) {
		this.moduleTable = moduleTable;
	}

	public FeedbackTable getFeedbackTable() {
		return feedbackTable;
	}

	public void setFeedbackTable(FeedbackTable feedbackTable) {
		this.feedbackTable = feedbackTable;
	}

	public ZoomAccountTable getZoomAccountTable() {
		return zoomAccountTable;
	}

	public void setZoomAccountTable(ZoomAccountTable zoomAccountTable) {
		this.zoomAccountTable = zoomAccountTable;
	}

	@Override
	public String toString() {
		return "SessionScheduleTable [sessionId=" + sessionId + ", sessionAttendance=" + sessionAttendance
				+ ", sessionDate=" + sessionDate + ", sessionTopic=" + sessionTopic + ", sessionDetails="
				+ sessionDetails + ", sessionEnableRecording=" + sessionEnableRecording + ", sessionDuration="
				+ sessionDuration + ", sessionInvitationDetails=" + sessionInvitationDetails + ", sessionStartUrl="
				+ sessionStartUrl + ", session_isActive=" + session_isActive + ", sessionRecordingLink="
				+ sessionRecordingLink + ", meetingId=" + meetingId + ", facultyInfoTable=" + facultyInfoTable
				+ ", moduleTable=" + moduleTable + ", feedbackTable=" + feedbackTable + ", zoomAccountTable="
				+ zoomAccountTable + "]";
	}


	

}