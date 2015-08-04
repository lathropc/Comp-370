package trains;

import trains.jsonTracks.Track_data;

public class Test {

	public static void main(String[] args) {

		Tracks tracks = new Tracks(10, 10);

		train train = new train("First Train", "S1-1", true, 0);
		tracks.addTrain(train);
		
		jsonTracks jsonTracks = new jsonTracks();
		jsonTracks.setupData();  //loads data into track_data objects. prints them
	    
		//for (Track_data data : jsonParsetrack_data.getData()){}
		//System.out.println(jsonTracks.track.getTrackId());

	}
}
