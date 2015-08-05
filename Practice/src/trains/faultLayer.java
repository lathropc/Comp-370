package trains;

public class faultLayer {
	
	jsonTracks jsonTracks = new jsonTracks();
	jsonSwitches jsonSwitches = new jsonSwitches();
	jsonStations jsonStations = new jsonStations();

	public void setupTracks() {
		jsonTracks.setupData(); // Init data from track json file, prints them.
	}
    public void setupSwitches() {
		jsonSwitches.setupData();
	}
    public void setupStations() {
		jsonStations.setupData();
	}
	
	//Code to find which track, switch, station we are on
	
	public int findTrack(String id) {
		for(int i = 0; i < jsonTracks.jsonParsetrack_data.data.size(); i++) {
			//System.out.println("String id = " + id + " json id = " + jsonTracks.jsonParsetrack_data.data.get(i).getTrack().gettrackid());
			if(jsonTracks.jsonParsetrack_data.data.get(i).getTrack().gettrackid().equals(id))
				return i;
		}
		//failed
		return (-1);
	}
	public int findSwitch(String id) {
		for(int i = 0; i < jsonTracks.jsonParsetrack_data.data.size(); i++) {
			if(jsonSwitches.jsonParseswitches_data.data.get(i).getSwitches().getSwitchId().equals(id))
				return i;
		}
		//failed
		return (-1);

	}
	public int findStation(String id) {
		for(int i = 0; i < jsonStations.jsonParsestations_data.data.size(); i++) {
			if(jsonStations.jsonParsestations_data.data.get(i).getStation().getStationId().equals(id))
				return i;
		}
		//failed
		return (-1);

	}
	
	//Track accessors and mutators
	
	public String getTrackpretrack1(String id) {
        int tk = findTrack(id);
        if(tk < 0) {
        	System.out.println("Incorrect ID");
        	return "FALSE ID";
        } else
        	return jsonTracks.jsonParsetrack_data.data.get(tk).getTrack().getpretrack1();
    }
    public String getTrackpretrack2(String id){
        int tk = findTrack(id);
        if(tk < 0) {
        	System.out.println("Incorrect ID");
        	return "FALSE ID";
        } else
        	return jsonTracks.jsonParsetrack_data.data.get(tk).getTrack().getpretrack2();
    }
    public String getTrackposttrack1(String id){
        int tk = findTrack(id);
        if(tk < 0) {
        	System.out.println("Incorrect ID");
        	return "FALSE ID";
        } else
        	return jsonTracks.jsonParsetrack_data.data.get(tk).getTrack().getposttrack1();
    }
    public String getTrackposttrack2(String id){
        int tk = findTrack(id);
        if(tk < 0) {
        	System.out.println("Incorrect ID");
        	return "FALSE ID";
        } else
        	return jsonTracks.jsonParsetrack_data.data.get(tk).getTrack().getposttrack2();
    }
    public boolean getTrackisallocated(String id){
        int tk = findTrack(id);
        if(tk < 0) {
        	System.out.println("Incorrect ID");
        	return false;
        } else
        	return jsonTracks.jsonParsetrack_data.data.get(tk).getTrack().getisallocated();
    }
    public void setTrackisallocated(String id, boolean isallocated){
        int tk = findTrack(id);
        if(tk < 0) {
        	System.out.println("Incorrect ID");
        	return;
        } else
        	jsonTracks.jsonParsetrack_data.data.get(tk).getTrack().setisallocated(isallocated);
    }
    public boolean getTrackisalive(String id){
        int tk = findTrack(id);
        if(tk < 0) {
        	System.out.println("Incorrect ID");
        	return false;
        } else
        	return jsonTracks.jsonParsetrack_data.data.get(tk).getTrack().getisalive();
    }
    public void setTrackisalive(String id, boolean isalive){
        int tk = findTrack(id);
        if(tk < 0){
        	System.out.println("Incorrect ID");
        	return;
        } else
        	jsonTracks.jsonParsetrack_data.data.get(tk).getTrack().setisalive(isalive);
    }
	
	//Switch accessors and mutators
	
	//TODO: ADD SWITCH POINTER
	
	
	public String getSwitchpretrack1(String id) {
		int tk = findSwitch(id);
        return jsonSwitches.jsonParseswitches_data.data.get(tk).getSwitches().getpretrack1();
    }
    public String getSwitchpretrack2(String id) {
    	int tk = findSwitch(id);
        return jsonSwitches.jsonParseswitches_data.data.get(tk).getSwitches().getpretrack2();
    }
    public String getSwitchposttrack1(String id) {
    	int tk = findSwitch(id);
        return jsonSwitches.jsonParseswitches_data.data.get(tk).getSwitches().getposttrack1();
    }
    public String getSwitchposttrack2(String id) {
    	int tk = findSwitch(id);
        return jsonSwitches.jsonParseswitches_data.data.get(tk).getSwitches().getposttrack2();
    }
    public boolean getSwitchisallocated(String id) {
    	int tk = findSwitch(id);
        return jsonSwitches.jsonParseswitches_data.data.get(tk).getSwitches().getisallocated();
    }
    public void setSwitchisallocated(String id, boolean isallocated) {
    	int tk = findSwitch(id);
        jsonSwitches.jsonParseswitches_data.data.get(tk).getSwitches().setisallocated(isallocated);
    }
    public boolean getSwitchisalive(String id) {
    	int tk = findSwitch(id);
        return jsonSwitches.jsonParseswitches_data.data.get(tk).getSwitches().getisalive();
    }
    public void setSwitchisalive(String id, boolean isalive) {
    	int tk = findSwitch(id);
        jsonSwitches.jsonParseswitches_data.data.get(tk).getSwitches().setisalive(isalive);
    }

    //Station accessors and mutators
    
	public String getStationId(String id) {
		int tk = findStation(id);
		if(tk < 0) {
			System.out.println("Station ID is wrong");
			return "FALSE ID";
		} else
			return jsonStations.jsonParsestations_data.data.get(tk).getStation().getStationId();
	}
	public String getTrackId1(String id) {
		int tk = findStation(id);
		if(tk < 0) {
			System.out.println("Station ID is wrong");
			return "FALSE ID";
		} else
			return jsonStations.jsonParsestations_data.data.get(tk).getStation().getTrackId1();
	}
	public String getTrackId2(String id) {
		int tk = findStation(id);
		if(tk < 0) {
			System.out.println("Station ID is wrong");
			return "FALSE ID";
		} else
			return jsonStations.jsonParsestations_data.data.get(tk).getStation().getTrackId2();
	}
	public String getTrackId3(String id) {
		int tk = findStation(id);
		if(tk < 0) {
			System.out.println("Station ID is wrong");
			return "FALSE ID";
		} else
			return jsonStations.jsonParsestations_data.data.get(tk).getStation().getTrackId3();
	}
	public String getTrackId4(String id) {
		int tk = findStation(id);
		if(tk < 0) {
			System.out.println("Station ID is wrong");
			return "FALSE ID";
		} else
			return jsonStations.jsonParsestations_data.data.get(tk).getStation().getTrackId4();
	}

    
    
	
	
}
