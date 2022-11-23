package study.Pojo;

public class KeyValue {
	
		private int moduleid;
		private int duration;
		
		
		
		public KeyValue() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		public KeyValue(int moduleid, int duration) {
			super();
			this.moduleid = moduleid;
			this.duration = duration;
		}


		public int getModuleid() {
			return moduleid;
		}
		public void setModuleid(int moduleid) {
			this.moduleid = moduleid;
		}
		public int getDuration() {
			return duration;
		}
		public void setDuration(int duration) {
			this.duration = duration;
		}


		@Override
		public String toString() {
			return "KeyValue [moduleid=" + moduleid + ", duration=" + duration + "]";
		}
		
		

}
