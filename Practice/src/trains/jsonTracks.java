package trains;

import java.util.List;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class jsonTracks {

    public static final String TAG = jsonTracks.class.getSimpleName();

    public void setupData() {
    	System.out.println("IN MAIN");
    	String json = "{tracks:[{\"track\":{\"trackid\": \"S1-1\",\"pretrack1\": \"null\",\"pretrack2\": \"null\",\"posttrack1\": \"S2-1\",\"posttrack2\": \"null\",\"isallocated\": \"N\",\"isalive\": \"Y\"}},{\"track\":{\"trackid\": \"S1-1\",\"pretrack1\": \"null\",\"pretrack2\": \"null\",\"posttrack1\": \"S2-1\",\"posttrack2\": \"null\",\"isallocated\": \"N\",\"isalive\": \"Y\"}}]}";
        JsonParsetrack_data jsonParsetrack_data = new Gson().fromJson(json, JsonParsetrack_data.class);

        if (jsonParsetrack_data != null && jsonParsetrack_data.getData() != null) {
            for (Track_data data : jsonParsetrack_data.getData()) {
                System.out.println(TAG + "Track_data: " + data.toString());
            }
        }
        else{
        	System.out.println("Data is shit");
        }
        
        System.out.println("First track id: " + jsonParsetrack_data.data.get(0).getTrack().getTrackId());
        
    }

    public class JsonParsetrack_data {

        @SerializedName("tracks")
        private List<Track_data> data;

        public JsonParsetrack_data(List<Track_data> data) {
            super();
            this.data = data;
        }

        public List<Track_data> getData() {
            return data;
        }

        public void setResult(List<Track_data> data) {
            this.data = data;
        }

    }

    public class Track_data {

        @SerializedName("track")
        private track tracks;

        public Track_data(track tracks) {
            super();
            this.tracks = tracks;
        }

        public track getTrack() {
            return tracks;
        }

        public void setTrack(track tracks) {
            this.tracks = tracks;
        }

        @Override
        public String toString() {
            return "Track_data [tracks= " + tracks + "]";
        }

    }

    public class track {

        @SerializedName("trackid")
        private String trackid;

        @SerializedName("pretrack1")
        private String pretrack1;

        @SerializedName("pretrack2")
        private String pretrack2;

        @SerializedName("posttrack1")
        private String posttrack1;

        @SerializedName("posttrack2")
        private String posttrack2;

        @SerializedName("isallocated")
        private Boolean isallocated;
        
        @SerializedName("isalive")
        private Boolean isalive;

        public track(String trackid, String pretrack1, String pretrack2, String posttrack1, String posttrack2, Boolean isallocated, Boolean isalive) {
            super();
            this.trackid = trackid;
            this.pretrack1 = pretrack1;
            this.pretrack2 = pretrack2;
            this.posttrack1 = posttrack1;
            this.posttrack2 = posttrack2;
            this.isallocated = isallocated;
            this.isalive = isalive;
        }

        public String getTrackId() {
            return trackid;
        }
        public void setTrackId(String trackid) {
            this.trackid = trackid;
        }
        public String getpretrack1() {
            return pretrack1;
        }
        public void setpretrack1(String pretrack1) {
            this.pretrack1 = pretrack1;
        }
        public String getpretrack2(){
        	return pretrack2;
        }
        public void setpretrack2(String pretrack2){
        	this.pretrack2 = pretrack2;
        }
        public String getposttrack1(){
        	return posttrack1;
        }
        public void setposttrack1(String posttrack1){
        	this.posttrack1 = posttrack1;
        }
        public String getposttrack2(){
        	return posttrack2;
        }
        public void setposttrack2(String posttrack2){
        	this.posttrack2 = posttrack2;
        }
        public boolean getisallocated(){
        	return isallocated;
        }
        public void setisallocated(boolean isallocated){
        	this.isallocated = isallocated;
        }
        public boolean getisalive(){
        	return isalive;
        }
        public void setisalive(boolean isalive){
        	this.isalive = isalive;
        }

        @Override
        public String toString() {
            return "track [trackid = " + trackid + " pretrack1 = " + pretrack1 + " pretrack2 = " + pretrack2 + " posttrack1 = " + posttrack1 + " posttrack2 = " + posttrack2 + " isallocated = " +isallocated + " isalive = " + isalive + "]";
        }

    }

}

