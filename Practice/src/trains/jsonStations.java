package trains;

import java.util.List;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;


public class jsonStations {
	
	public static final String TAG = jsonStations.class.getSimpleName();
	String json = "{stations:[{\"station\":{\"stationid\": \"Boston\",\"trackid1\": \"S1-1\",\"trackid2\": \"S1-2\",\"trackid3\": \"S1-3\",\"trackid4\": \"S1-4\",\"isalive\": \"Y\"}},{\"station\":{\"stationid\": \"Alewife\",\"trackid1\": \"S5-1\",\"trackid2\": \"S5-2\",\"trackid3\": \"null\",\"trackid4\": \"null\",\"isalive\": \"Y\"}},{\"station\":{\"stationid\": \"Meford\",\"trackid1\": \"S10-1\",\"trackid2\": \"S10-2\",\"trackid3\": \"null\",\"trackid4\": \"null\",\"isalive\": \"Y\"}},{\"station\":{\"stationid\": \"Melrose\",\"trackid1\": \"S19-1\",\"trackid2\": \"S19-2\",\"trackid3\": \"null\",\"trackid4\": \"null\",\"isalive\": \"Y\"}},{\"station\":{\"stationid\":\"Stoneham\",\"trackid1\":\"S25-1\",\"trackid2\":\"S25-2\",\"trackid3\":\"S25-3\",\"trackid4\":\"null\",\"isalive\":\"Y\"}},{\"station\":{\"stationid\":\"Reading\",\"trackid1\":\"S29-1\",\"trackid2\": \"S29-2\",\"trackid3\": \"null\",\"trackid4\": \"null\",\"isalive\": \"Y\"}}]}";
	JsonParsestations_data jsonParsestations_data = new Gson().fromJson(json, JsonParsestations_data.class);
	
	public void setupData() {
       
		if (jsonParsestations_data != null && jsonParsestations_data.getData() != null) {
            for (Station_data data : jsonParsestations_data.getData()) {
                System.out.println(TAG + "Station_data: " + data.toString());
            }
        } else {
        	System.out.println("\nStation data is borked\n");
        }
	}
	
	public class JsonParsestations_data {
		
		@SerializedName("stations") List<Station_data> data;

        public JsonParsestations_data(List<Station_data> data) {
            super();
            this.data = data;
        }

        public List<Station_data> getData() {
            return data;
        }

        public void setResult(List<Station_data> data) {
            this.data = data;
        }
		
	}
	
	public class Station_data {
		
		@SerializedName("station")
		private station stations;
		
		public Station_data(station stations) {
			super();
			this.stations = stations;
		}
		
		public station getStation() {
			return stations;
		}
		
		public void setStation(station stations) {
			this.stations = stations;
		}
		
		@Override
		public String toString() {
			return "Station_data [stations=" + stations + "]";
		}
		
	}
	
	public class station {
		
		@SerializedName("stationid")
		private String stationid;
		
		@SerializedName("trackid1")
		private String trackid1;
		
		@SerializedName("trackid2")
		private String trackid2;
		
		@SerializedName("trackid3")
		private String trackid3;
		
		@SerializedName("trackid4")
		private String trackid4;
		
		@SerializedName("isalive")
		private Boolean isalive;
		
		public station(String stationid, String trackid1, String trackid2, String trackid3, String trackid4, Boolean isalive) {
			super();
			this.stationid = stationid;
			this.trackid1 = trackid1;
			this.trackid2 = trackid2;
			this.trackid3 = trackid3;
			this.trackid4 = trackid4;
		}
		
		public String getStationId() {
			return stationid;
		}
		
		public void setStationId(String stationid) {
			this.stationid = stationid;
		}
		
		public String getTrackId1() {
			return trackid1;
		}
		
		public void setTrackId1(String trackid1) {
			this.trackid1 = trackid1;
		}
		
		public String getTrackId2() {
			return trackid2;
		}
		
		public void setTrackId2(String trackid2) {
			this.trackid2 = trackid2;
		}
		
		public String getTrackId3() {
			return trackid3;
		}
		
		public void setTrackId3(String trackid3) {
			this.trackid3 = trackid3;
		}
		
		public String getTrackId4() {
			return trackid4;
		}
		
		public void setTrackId4(String trackid4) {
			this.trackid4 = trackid4;
		}
		
		@Override 
		public String toString() {
			return "stations [stationid = " + stationid + " trackid1 = " + trackid1 + " trackid2 = " + trackid2 + " trackid3 = " + trackid3 + " trackid4 = " + trackid4 + " ]";

		}

		} 

	}
	

