package trains;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class jsonSwitches {
	
	public static final String TAG = jsonSwitches.class.getSimpleName();
	
	public static void main(String args[]) {
		
		String json = "{switch:[{\"switches\":{\"switchid\": \"SW-1\",\"pretrack1\": \"S2-1\",\"pretrack2\": \"S2-2\",\"posttrack1\": \"S3-1\",\"posttrack2\": \"null\",\"isallocated\": \"N\",\"isalive\": \"Y\"},\"switches\": {\"switchid\": \"SW-2\",\"pretrack1\": \"S2-3\",\"pretrack2\": \"S2-4\",\"posttrack1\": \"S3-2\",\"posttrack2\": \"null\",\"isallocated\": \"N\",\"isalive\": \"Y\"},\"switches\": {\"switchid\": \"SW-3\",\"pretrack1\": \"S3-1\",\"pretrack2\": \"S3-2\",\"posttrack1\": \"S4-1\",\"posttrack2\": \"null\",\"isallocated\": \"N\",\"isalive\": \"Y\"},\"switches\": {\"switchid\": \"SW-4\",\"pretrack1\": \"S3-1\",\"pretrack2\": \"S3-2\",\"posttrack1\": \"S4-2\",\"posttrack2\": \"null\",\"isallocated\": \"N\",\"isalive\": \"Y\"},\"switches\": {\"switchid\": \"SW-5\",\"pretrack1\": \"S4-1\",\"pretrack2\": \"S4-2\",\"posttrack1\": \"S5-1\",\"posttrack2\": \"null\",\"isallocated\": \"N\",\"isalive\": \"Y\"},\"switches\": {\"switchid\": \"SW-6\",\"pretrack1\": \"S4-1\",\"pretrack2\": \"S4-2\",\"posttrack1\": \"S5-2\",\"posttrack2\": \"null\",\"isallocated\": \"N\",\"isalive\": \"Y\"},\"switches\": {\"switchid\": \"SW-7\",\"pretrack1\": \"S6-1\",\"pretrack2\": \"S6-2\",\"posttrack1\": \"S7-1\",\"posttrack2\": \"null\",\"isallocated\": \"N\",\"isalive\": \"Y\"},\"switches\": {\"switchid\": \"SW-8\",\"pretrack1\": \"S7-1\",\"pretrack2\": \"null\",\"posttrack1\": \"S8-1\",\"posttrack2\": \"S8-2\",\"isallocated\": \"N\",\"isalive\": \"Y\"},\"switches\": {\"switchid\": \"SW-9\",\"pretrack1\": \"S8-1\",\"pretrack2\": \"S8-2\",\"posttrack1\": \"S9-1\",\"posttrack2\": \"null\",\"isallocated\": \"N\",\"isalive\": \"Y\"},\"switches\": {\"switchid\": \"SW-10\",\"pretrack1\": \"S9-1\",\"pretrack2\": \"null\",\"posttrack1\": \"S10-1\",\"posttrack2\": \"S1-2\",\"isallocated\": \"N\",\"isalive\": \"Y\"},\"switches\": {\"switchid\": \"SW-11\",\"pretrack1\": \"S10-1\",\"pretrack2\": \"S10-2\",\"posttrack1\": \"S11-1\",\"posttrack2\": \"null\",\"isallocated\": \"N\",\"isalive\": \"Y\"},\"switches\": {\"switchid\": \"SW-14\",\"pretrack1\": \"S18-1\",\"pretrack2\": \"null\",\"posttrack1\": \"S19-1\",\"posttrack2\": \"S19-2\",\"isallocated\": \"N\",\"isalive\": \"Y\"},\"switches\": {\"switchid\": \"SW-15\",\"pretrack1\": \"S19-1\",\"pretrack2\": \"S19-2\",\"posttrack1\": \"S20-1\",\"posttrack2\": \"null\",\"isallocated\": \"N\",\"isalive\": \"Y\"},\"switches\": {\"switchid\": \"SW-16\",\"pretrack1\": \"S21-1\",\"pretrack2\": \"null\",\"posttrack1\": \"S22-1\",\"posttrack2\": \"S22-2\",\"isallocated\": \"N\",\"isalive\": \"Y\"},\"switches\": {\"switchid\": \"SW-17\",\"pretrack1\": \"S22-1\",\"pretrack2\": \"S22-2\",\"posttrack1\": \"S23-1\",\"posttrack2\": \"null\",\"isallocated\": \"N\",\"isalive\": \"Y\"},\"switches\": {\"switchid\": \"SW-18\",\"pretrack1\": \"S23-1\",\"pretrack2\": \"null\",\"posttrack1\": \"S25-1\",\"posttrack2\": \"S25-2\",\"isallocated\": \"N\",\"isalive\": \"Y\"},\"switches\": {\"switchid\": \"SW-19\",\"pretrack1\": \"S24-1\",\"pretrack2\": \"null\",\"posttrack1\": \"S25-2\",\"posttrack2\": \"S25-3\",\"isallocated\": \"N\",\"isalive\": \"Y\"},\"switches\": {\"switchid\": \"SW-20\",\"pretrack1\": \"S25-2\",\"pretrack2\": \"S25-3\",\"posttrack1\": \"S26-1\",\"posttrack2\": \"null\",\"isallocated\": \"N\",\"isalive\": \"Y\"},\"switches\": {\"switchid\": \"SW-21\",\"pretrack1\": \"S28-1\",\"pretrack2\": \"null\",\"posttrack1\": \"S29-1\",\"posttrack2\": \"S29-2\",\"isallocated\": \"N\",\"isalive\": \"Y\"}}]}";
		
		
		JsonParseswitches_data jsonParseswitches_data = new Gson().fromJson(json, JsonParseswitches_data.class);

        if (jsonParseswitches_data != null && jsonParseswitches_data.getData() != null) {
            for (Switch_data data : jsonParseswitches_data.getData()) {
                System.out.println(TAG + "Switch_data: " + data.toString());
            }
            
        } else {
        	System.out.println("You fucked up");
        }
	}
	
	public class JsonParseswitches_data {
		
		@SerializedName("switch")
        private List<Switch_data> data;

        public JsonParseswitches_data(List<Switch_data> data) {
            super();
            this.data = data;
        }

        public List<Switch_data> getData() {
            return data;
        }

        public void setResult(List<Switch_data> data) {
            this.data = data;
        }
		
	}
	
	public class Switch_data {
		
		@SerializedName("switches")
		private switches switches;
		
		public Switch_data(switches switches) {
			super();
			this.switches = switches;
		}
		
		public switches getSwitches() {
			return switches;
		}
		
		public void setSwitches(switches switches) {
			this.switches = switches;
		}
		
		@Override
		public String toString() {
			return "Switch_data [switches=" + switches + "]";
		}
		
	}
	
	public class switches {
		
		@SerializedName("switchid")
		private String switchid;
		
		@SerializedName("pretrack1")
		private String pretrack1;
		
		@SerializedName("pretrack2")
		private String pretrack2;
		
		@SerializedName("posttrack1")
		private String posttrack1;
		
		@SerializedName("postrack2")
		private String posttrack2;
		
		@SerializedName("isallocated")
		private Boolean isallocated;
		
		@SerializedName("isalive")
		private Boolean isalive;
		
		
		
		public switches(String switchid, String pretrack1, String pretrack2, String posttrack1, String posttrack2, Boolean isalive, Boolean isallocated) {
			super();
			this.switchid = switchid;
			this.pretrack1 = pretrack1;
			this.pretrack2 = pretrack2;
			this.posttrack1 = posttrack1;
			this.posttrack2 = posttrack2;
			this.isalive = isalive;
			this.isallocated = isallocated;
		}
		
		public String getSwitchId() {
			return switchid;
		}
		
		public void setSwitchId(String switchid) {
			this.switchid = switchid;
		}
		
		public String getpretrack1() {
			return pretrack1;
		}
		
		public void setpretrack1(String pretrack1) {
			this.pretrack1 = pretrack1;
		}
		
		public String getpretrack2() {
			return pretrack2;
		}
		
		public void setpretrack2(String pretrack2) {
			this.pretrack2 = pretrack2;
		}
		
		public String getposttrack1() {
			return posttrack1;
		}
		
		public void setposttrack1(String posttrack1) {
			this.posttrack1 = posttrack1;
		}
		
		public String getposttrack2() {
			return posttrack2;
		}
		
		public void setposttrack2(String posttrack2) {
			this.posttrack2 = posttrack2;
		}
		
		public Boolean getisallocated() {
			return isallocated;
		}
		
		public void setisallocated(boolean isallocated) {
			this.isallocated = isallocated;
		}
		
		public Boolean getisalive() {
			return isalive;
		}
		
		public void setisalive(boolean isalive) {
			this.isalive = isalive;
		}
		
		@Override 
		public String toString() {
			return "stations [switchid = " +switchid+ "\npretrack1 = " +pretrack1+ "\npretrack2 = " +pretrack2+ "\nposttrack1 = " +posttrack1+ "\npostrack2 = " +posttrack2+ "\nisallocated = " +isallocated+ "\nisalive = " +isalive+  "]";
		}
	}
	
}
