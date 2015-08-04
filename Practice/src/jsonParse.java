package trains;

import java.util.List;


import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class jsonParse {

    public static final String TAG = jsonParse.class.getSimpleName();

    public static void main() {


        String json = "{results:[{\"track\":{\"supplier_catalog_id\": \"139\",\"distributor_id\": \"57\",\"distributor_asking_price\": \"999.99\",\"supplier_id\": null,\"product_name\": \"jjjjjjjj j j j j j j  jj j jjjjjjjjjjjj\",\"product_description\": \"kkkkkkkkkkkkkk k k  k k\"},\"image_details\": {\"isCustomImageProvided\": 0,\"isImageUploadedTo\": 1}}]}";

        JsonParsetrack_data jsonParsetrack_data = new Gson().fromJson(json, JsonParsetrack_data.class);

        if (jsonParsetrack_data != null && jsonParsetrack_data.getData() != null) {
            for (Track_data data : jsonParsetrack_data.getData()) {
                System.out.println(TAG + "Track_data: " + data.toString());
            }
        }
    }

    public class JsonParsetrack_data {

        @SerializedName("track_data")
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
            return "Track_data [tracks=" + tracks + "]";
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


        @Override
        public String toString() {
            return "track [  ]";
        }

    }

}
