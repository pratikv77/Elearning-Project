package study.Pojo;

public class MeetingResponsePojo {
	
		private String uuid;
		private long id;
		private String host_id;
		private String topic;
		private int type;
		private String start_time;
		private String duration;
		private String timezone;
		private String agenda;
		private String created_at;
		private String join_url;
		public MeetingResponsePojo() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getUuid() {
			return uuid;
		}
		public void setUuid(String uuid) {
			this.uuid = uuid;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getHost_id() {
			return host_id;
		}
		public void setHost_id(String host_id) {
			this.host_id = host_id;
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
		public String getStart_time() {
			return start_time;
		}
		public void setStart_time(String start_time) {
			this.start_time = start_time;
		}
		public String getDuration() {
			return duration;
		}
		public void setDuration(String duration) {
			this.duration = duration;
		}
		public String getTimezone() {
			return timezone;
		}
		public void setTimezone(String timezone) {
			this.timezone = timezone;
		}
		public String getAgenda() {
			return agenda;
		}
		public void setAgenda(String agenda) {
			this.agenda = agenda;
		}
		public String getCreated_at() {
			return created_at;
		}
		public void setCreated_at(String created_at) {
			this.created_at = created_at;
		}
		public String getJoin_url() {
			return join_url;
		}
		public void setJoin_url(String join_url) {
			this.join_url = join_url;
		}
		@Override
		public String toString() {
			return "MeetingResponsePojo [uuid=" + uuid + ", id=" + id + ", host_id=" + host_id + ", topic=" + topic
					+ ", type=" + type + ", start_time=" + start_time + ", duration=" + duration + ", timezone="
					+ timezone + ", agenda=" + agenda + ", created_at=" + created_at + ", join_url=" + join_url + "]";
		}
		
	
}
