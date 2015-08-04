package trains;
public class train {
	public String id;
	public String location;
	public boolean isAlive;
	public String destination;
	
	faultLayer faultLayer;

	public train(String id, String location, boolean isAlive, String destination) {
		
		this.id = id;
		
		if(faultLayer.getTrackisallocated(location) == false) {
			this.location = location;
		}
		
		this.isAlive = isAlive;
		
		if(faultLayer.getTrackisallocated(destination) == false) {
			this.destination = destination;
		}
		
	}

	public String getLocation() {
		return faultLayer.gettrackid();
	}

	public void setLocation(String location) {

		if(faultLayer.getTrackisallocated(location) == false) {
			faultLayer.setTrackisallocated(location) == true;
		}
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		
		String track1 = faultLayer.getStationtrackid1(destination);
		String track2 = faultLayer.getStationtrackid2(destination);
		String track3 = faultLayer.getStationtrackid3(destination);
		String track4 = faultLayer.getStationtrackid4(destination);
		
		
		if(faultLayer.getTrackisallocated(track1) == true) {
			if(faultLayer.getTrackisallocated(track2) == true) {
				if(track3 != null) {
					if(faultLayer.getTrackisallocated(track3) == true) {
						if(track4 != null) {
							if(faultLayer.getTrackisallocated(track4) == true) {
								//wait
							} else {
								/faultLayer.setTrackisallocated(track4) = true;
							}
						} else {
							//wait
						}
					} else {
						faultLayer.setTrackisallocated(track3) = true;
					}
				} else {
					//wait
				}
			} else {
				faultLayer.setTrackisallocated(track2) = true;
			}
		} else {
			faultLayer.setTrackisallocated(track1) = true;
		}
	}

	public boolean isAlive() {
		return true;
	}
	
	public void setisAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPretrack1() {
		return faultLayer.getTrackpretrack1(location);
	}
	
	public String getPretrack2() {
		return faultLayer.getTrackpretrack2(location);
	}
	
	public String getPosttrack1(String newLocation) {
		return faultLayer.getTrackposttrack1(newLocation);
	}
	
	public String getPosttrack2(String newLocation) {
		return faultLayer.getTrackposttrack1(newLocation);
	}
	
	public void planPath() {
		
		String nextLocation = location;
		
		if((getPosttrack1(nextLocation) != getDestination()) && (getPosttrack2(nextLocation) != getDestination())) {
			
			nextLocation = getPosttrack1(nextLocation);
			
			if((getPosttrack1(nextLocation) != getDestination()) && (getPosttrack2(nextLocation) != getDestination())) {
				
			}
		}
	}
	
	@Override
	public String toString() {
		return "train [id=" + id + ", location=" + location + ", isAlive="
				+ isAlive + ", destination=" + destination + "]";
	}

	public static void main(String[] args) {
		train train = new train("Train1", "S1-1", true, "S1-2");
		System.out.println(train.toString());
	}

}