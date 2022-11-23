package study.Pojo;



public class CreateMeetingPojo {

	//="Trial_Meeting by java"
  private String topic;
    
  //this shoud be fix hardcoaded here
   private int type=2;
	
   //"2022-03-23T23:30:00Z"
   private String startTime; 

    //hardcoded for now
   private int duration=15;
   
  //this shoud be fix hardcoaded here
   private String scheduleFor="elearningiet6@gmail.com";

   //this shoud be fix hardcoaded here
   private String timezone="IN";
	
   //this shoud be fix hardcoaded here
    private String password="test";
	
    //="To chek the create metting works or not in final stage"
    private String agenda;

    
    
	public CreateMeetingPojo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CreateMeetingPojo(String topic, String startTime, String agenda) {
		super();
		this.topic = topic;
		this.startTime = startTime;
		this.agenda = agenda;
	}



	public String getTopic() {
		return topic;
	}



	public void setTopic(String topic) {
		this.topic = topic;
	}



	public int getType() {
		return type;
	}



	public void setType(int type) {
		this.type = type;
	}



	public String getStartTime() {
		return startTime;
	}



	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}



	public int getDuration() {
		return duration;
	}



	public void setDuration(int duration) {
		this.duration = duration;
	}



	public String getScheduleFor() {
		return scheduleFor;
	}



	public void setScheduleFor(String scheduleFor) {
		this.scheduleFor = scheduleFor;
	}



	public String getTimezone() {
		return timezone;
	}



	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getAgenda() {
		return agenda;
	}



	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}



	@Override
	public String toString() {
		return "meetingPojo { topic=" + topic + ", type=" + type + ", startTime=" + startTime + ", duration=" + duration
				+ ", scheduleFor=" + scheduleFor + ", timezone=" + timezone + ", password=" + password + ", agenda="
				+ agenda + "}";
	}
	
	
	
	
}
