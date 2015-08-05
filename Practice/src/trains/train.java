package trains;

import java.util.ArrayList;

public class train {
	
	ArrayList<String> correctPath = new ArrayList<String>(); 
	public String id;
	public String location;
	public boolean isAlive;
	public String destination;
	public String path;
	
	faultLayer faultLayer = new faultLayer();

	public train(String id, String location, boolean isAlive, String destination) {
		
		this.id = id;

		if(faultLayer.getTrackisallocated(location) == false) {
			this.location = location;
			faultLayer.setTrackisallocated(location, true);
		}
		

		this.isAlive = isAlive;
		
		if(faultLayer.getTrackisallocated(destination) == false) {
			this.destination = destination;
			faultLayer.setTrackisallocated(location, true);
		}
		
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {

		if(faultLayer.getTrackisallocated(location) == false) {
			faultLayer.setTrackisallocated(location, true);
			location = this.location; 
		}
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		
		String track1 = faultLayer.getTrackId1(destination);
		String track2 = faultLayer.getTrackId2(destination);
		String track3 = faultLayer.getTrackId3(destination);
		String track4 = faultLayer.getTrackId4(destination);
		
		
		if(faultLayer.getTrackisallocated(track1) == true) {
			if(faultLayer.getTrackisallocated(track2) == true) {
				if(track3 != null) {
					if(faultLayer.getTrackisallocated(track3) == true) {
						if(track4 != null) {
							if(faultLayer.getTrackisallocated(track4) == true) {
								//wait
							} else {
								faultLayer.setTrackisallocated(track4, true);
								faultLayer.getTrackId4(destination);
							}
						} else {
							//wait
						}
					} else {
						faultLayer.setTrackisallocated(track3, true);
						faultLayer.getTrackId3(destination);
					}
				} else {
					//wait
				}
			} else {
				faultLayer.setTrackisallocated(track2, true);
				faultLayer.getTrackId2(destination);
			}
		} else {
			faultLayer.setTrackisallocated(track1, true);
			faultLayer.getTrackId1(destination);
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
	
	public String getPosttrack1(String location) {
		return faultLayer.getTrackposttrack1(location);
	}
	
	public String getPosttrack2(String locatoin) {
		return faultLayer.getTrackposttrack1(location);
	}
	
	public void handleSwitches(ArrayList<String> correctPath){
		for(int i = 0; i < correctPath.size(); i++){
			for(int a = 1; a < 22; a++){
				
				if(((faultLayer.getSwitchpretrack1("SW-" + a).equals(correctPath.get(0))) && (faultLayer.getSwitchposttrack1("SW-" + a).equals(correctPath.get(0)))) ||
						((faultLayer.getSwitchpretrack1("SW-" + a).equals(correctPath.get(0))) && (faultLayer.getSwitchposttrack2("SW-" + a).equals(correctPath.get(0)))) ||
							((faultLayer.getSwitchpretrack2("SW-" + a).equals(correctPath.get(0))) && (faultLayer.getSwitchposttrack1("SW-" + a).equals(correctPath.get(0)))) ||
								((faultLayer.getSwitchpretrack2("SW-" + a).equals(correctPath.get(0))) && (faultLayer.getSwitchposttrack2("SW-" + a).equals(correctPath.get(0))))){
					//TODO: ensure switch is set to the right place, add to switch array
					System.out.println("SW-" + a + " Is in our path, switching accordingly");
				}
			}
		}
	}
	
	
	public void planPath() {
		
		
		
		System.out.println("Starting location " + location + " Destination " + destination);
		//first
		if(!getPosttrack1(location).equals(destination)) {
			path = getPosttrack1(location);
			correctPath.add(path);
			if(!getPosttrack1(path).equals(destination)) {
				path = getPosttrack1(path);
				correctPath.add(path);
				if(!getPosttrack1(path).equals(destination)) {
					path = getPosttrack1(path);
					correctPath.add(path);
					if(!getPosttrack1(path).equals(destination)) {
						path = getPosttrack1(path);
						correctPath.add(path);
						if(!getPosttrack1(path).equals(destination)) {
							correctPath.clear();
							
							//second
							if(!getPosttrack1(location).equals(destination)) {
								path = getPosttrack1(location);
								correctPath.add(path);
								if(!getPosttrack1(path).equals(destination)) {
									path = getPosttrack1(path);
									correctPath.add(path);
									if(!getPosttrack1(path).equals(destination)) {
										path = getPosttrack1(path);
										correctPath.add(path);
										if(!getPosttrack1(path).equals(destination)) {
											path = getPosttrack1(path);
											correctPath.add(path);
											if(!getPosttrack2(path).equals(destination)) {
												correctPath.clear();
												
												//third
												if(!getPosttrack1(location).equals(destination)) {
													path = getPosttrack1(location);
													correctPath.add(path);
													if(!getPosttrack1(path).equals(destination)) {
														path = getPosttrack1(path);
														correctPath.add(path);
														if(!getPosttrack1(path).equals(destination)) {
															path = getPosttrack1(path);
															correctPath.add(path);
															if(!getPosttrack2(path).equals(destination)) {
																path = getPosttrack2(path);
																correctPath.add(path);
																if(!getPosttrack1(path).equals(destination)) {
																	correctPath.clear();
																	
																	//fourth
																	if(!getPosttrack1(location).equals(destination)) {
																		path = getPosttrack1(location);
																		correctPath.add(path);
																		if(!getPosttrack1(path).equals(destination)) {
																			path = getPosttrack1(path);
																			correctPath.add(path);
																			if(!getPosttrack1(path).equals(destination)) {
																				path = getPosttrack1(path);
																				correctPath.add(path);
																				if(!getPosttrack2(path).equals(destination)) {
																					path = getPosttrack2(path);
																					correctPath.add(path);
																					if(!getPosttrack2(path).equals(destination)) {
																						correctPath.clear();
																						
																						//fifth
																						if(!getPosttrack1(location).equals(destination)) {
																							path = getPosttrack1(location);
																							correctPath.add(path);
																							if(!getPosttrack1(path).equals(destination)) {
																								path = getPosttrack1(path);
																								correctPath.add(path);
																								if(!getPosttrack2(path).equals(destination)) {
																									path = getPosttrack2(path);
																									correctPath.add(path);
																									if(!getPosttrack1(path).equals(destination)) {
																										path = getPosttrack1(path);
																										correctPath.add(path);
																										if(!getPosttrack1(path).equals(destination)) {
																											correctPath.clear();
																											
																											//sixth
																											if(!getPosttrack1(location).equals(destination)) {
																												path = getPosttrack1(location);
																												correctPath.add(path);
																												if(!getPosttrack1(path).equals(destination)) {
																													path = getPosttrack1(path);
																													correctPath.add(path);
																													if(!getPosttrack2(path).equals(destination)) {
																														path = getPosttrack2(path);
																														correctPath.add(path);
																														if(!getPosttrack1(path).equals(destination)) {
																															path = getPosttrack1(path);
																															correctPath.add(path);
																															if(!getPosttrack2(path).equals(destination)) {
																																correctPath.clear();
																																
																																//seventh
																																if(!getPosttrack1(location).equals(destination)) {
																																	path = getPosttrack1(location);
																																	correctPath.add(path);
																																	if(!getPosttrack1(path).equals(destination)) {
																																		path = getPosttrack1(path);
																																		correctPath.add(path);
																																		if(!getPosttrack2(path).equals(destination)) {
																																			path = getPosttrack2(path);
																																			correctPath.add(path);
																																			if(!getPosttrack2(path).equals(destination)) {
																																				path = getPosttrack2(path);
																																				correctPath.add(path);
																																				if(!getPosttrack1(path).equals(destination)) {
																																					correctPath.clear();
																																					
																																					//eight
																																					if(!getPosttrack1(location).equals(destination)) {
																																						path = getPosttrack1(location);
																																						correctPath.add(path);
																																						if(!getPosttrack1(path).equals(destination)) {
																																							path = getPosttrack1(path);
																																							correctPath.add(path);
																																							if(!getPosttrack2(path).equals(destination)) {
																																								path = getPosttrack2(path);
																																								correctPath.add(path);
																																								if(!getPosttrack2(path).equals(destination)) {
																																									path = getPosttrack2(path);
																																									correctPath.add(path);
																																									if(!getPosttrack2(path).equals(destination)) {
																																										correctPath.clear();
																																										
																																										//nine
																																										if(!getPosttrack1(location).equals(destination)) {
																																											path = getPosttrack1(location);
																																											correctPath.add(path);
																																											if(!getPosttrack2(path).equals(destination)) {
																																												path = getPosttrack2(path);
																																												correctPath.add(path);
																																												if(!getPosttrack1(path).equals(destination)) {
																																													path = getPosttrack1(path);
																																													correctPath.add(path);
																																													if(!getPosttrack1(path).equals(destination)) {
																																														path = getPosttrack1(path);
																																														correctPath.add(path);
																																														if(!getPosttrack1(path).equals(destination)) {
																																															correctPath.clear();
																																															
																																															//ten
																																															if(!getPosttrack1(location).equals(destination)) {
																																																path = getPosttrack1(location);
																																																correctPath.add(path);
																																																if(!getPosttrack2(path).equals(destination)) {
																																																	path = getPosttrack2(path);
																																																	correctPath.add(path);
																																																	if(!getPosttrack1(path).equals(destination)) {
																																																		path = getPosttrack1(path);
																																																		correctPath.add(path);
																																																		if(!getPosttrack1(path).equals(destination)) {
																																																			path = getPosttrack1(path);
																																																			correctPath.add(path);
																																																			if(!getPosttrack2(path).equals(destination)) {
																																																				correctPath.clear();
																																																				
																																																				//eleven
																																																				if(!getPosttrack1(location).equals(destination)) {
																																																					path = getPosttrack1(location);
																																																					correctPath.add(path);
																																																					if(!getPosttrack2(path).equals(destination)) {
																																																						path = getPosttrack2(path);
																																																						correctPath.add(path);
																																																						if(!getPosttrack1(path).equals(destination)) {
																																																							path = getPosttrack1(path);
																																																							correctPath.add(path);
																																																							if(!getPosttrack2(path).equals(destination)) {
																																																								path = getPosttrack2(path);
																																																								correctPath.add(path);
																																																								if(!getPosttrack1(path).equals(destination)) {
																																																									correctPath.clear();
																																																									
																																																									//twelve
																																																									if(!getPosttrack1(location).equals(destination)) {
																																																										path = getPosttrack1(location);
																																																										correctPath.add(path);
																																																										if(!getPosttrack2(path).equals(destination)) {
																																																											path = getPosttrack2(path);
																																																											correctPath.add(path);
																																																											if(!getPosttrack1(path).equals(destination)) {
																																																												path = getPosttrack1(path);
																																																												correctPath.add(path);
																																																												if(!getPosttrack2(path).equals(destination)) {
																																																													path = getPosttrack2(path);
																																																													correctPath.add(path);
																																																													if(!getPosttrack2(path).equals(destination)) {
																																																														correctPath.clear();
																																																														
																																																														//thirteen
																																																														if(!getPosttrack1(location).equals(destination)) {
																																																															path = getPosttrack1(location);
																																																															correctPath.add(path);
																																																															if(!getPosttrack2(path).equals(destination)) {
																																																																path = getPosttrack2(path);
																																																																correctPath.add(path);
																																																																if(!getPosttrack2(path).equals(destination)) {
																																																																	path = getPosttrack2(path);
																																																																	correctPath.add(path);
																																																																	if(!getPosttrack1(path).equals(destination)) {
																																																																		path = getPosttrack1(path);
																																																																		correctPath.add(path);
																																																																		if(!getPosttrack1(path).equals(destination)) {
																																																																			correctPath.clear();
																																																																			
																																																																			//fourteen
																																																																			if(!getPosttrack1(location).equals(destination)) {
																																																																				path = getPosttrack1(location);
																																																																				correctPath.add(path);
																																																																				if(!getPosttrack2(path).equals(destination)) {
																																																																					path = getPosttrack2(path);
																																																																					correctPath.add(path);
																																																																					if(!getPosttrack2(path).equals(destination)) {
																																																																						path = getPosttrack2(path);
																																																																						correctPath.add(path);
																																																																						if(!getPosttrack1(path).equals(destination)) {
																																																																							path = getPosttrack1(path);
																																																																							correctPath.add(path);
																																																																							if(!getPosttrack2(path).equals(destination)) {
																																																																								correctPath.clear();
																																																																								
																																																																								//fifteen
																																																																								if(!getPosttrack1(location).equals(destination)) {
																																																																									path = getPosttrack1(location);
																																																																									correctPath.add(path);
																																																																									if(!getPosttrack2(path).equals(destination)) {
																																																																										path = getPosttrack2(path);
																																																																										correctPath.add(path);
																																																																										if(!getPosttrack2(path).equals(destination)) {
																																																																											path = getPosttrack2(path);
																																																																											correctPath.add(path);
																																																																											if(!getPosttrack2(path).equals(destination)) {
																																																																												path = getPosttrack2(path);
																																																																												correctPath.add(path);
																																																																												if(!getPosttrack1(path).equals(destination)) {
																																																																													correctPath.clear();
																																																																													
																																																																													//sixteen
																																																																													if(!getPosttrack1(location).equals(destination)) {
																																																																														path = getPosttrack1(location);
																																																																														correctPath.add(path);
																																																																														if(!getPosttrack2(path).equals(destination)) {
																																																																															path = getPosttrack2(path);
																																																																															correctPath.add(path);
																																																																															if(!getPosttrack2(path).equals(destination)) {
																																																																																path = getPosttrack2(path);
																																																																																correctPath.add(path);
																																																																																if(!getPosttrack2(path).equals(destination)) {
																																																																																	path = getPosttrack2(path);
																																																																																	correctPath.add(path);
																																																																																	if(!getPosttrack2(path).equals(destination)) {
																																																																																		correctPath.clear();
																																																																																		
																																																																																		//first
																																																																																		if(!getPosttrack2(location).equals(destination)) {
																																																																																			path = getPosttrack2(location);
																																																																																			correctPath.add(path);
																																																																																			if(!getPosttrack1(path).equals(destination)) {
																																																																																				path = getPosttrack1(path);
																																																																																				correctPath.add(path);
																																																																																				if(!getPosttrack1(path).equals(destination)) {
																																																																																					path = getPosttrack1(path);
																																																																																					correctPath.add(path);
																																																																																					if(!getPosttrack1(path).equals(destination)) {
																																																																																						path = getPosttrack1(path);
																																																																																						correctPath.add(path);
																																																																																						if(!getPosttrack1(path).equals(destination)) {
																																																																																							correctPath.clear();
																																																																																							
																																																																																							//second
																																																																																							if(!getPosttrack2(location).equals(destination)) {
																																																																																								path = getPosttrack2(location);
																																																																																								correctPath.add(path);
																																																																																								if(!getPosttrack1(path).equals(destination)) {
																																																																																									path = getPosttrack1(path);
																																																																																									correctPath.add(path);
																																																																																									if(!getPosttrack1(path).equals(destination)) {
																																																																																										path = getPosttrack1(path);
																																																																																										correctPath.add(path);
																																																																																										if(!getPosttrack1(path).equals(destination)) {
																																																																																											path = getPosttrack1(path);
																																																																																											correctPath.add(path);
																																																																																											if(!getPosttrack2(path).equals(destination)) {
																																																																																												correctPath.clear();
																																																																																												
																																																																																												//third
																																																																																												if(!getPosttrack2(location).equals(destination)) {
																																																																																													path = getPosttrack2(location);
																																																																																													correctPath.add(path);
																																																																																													if(!getPosttrack1(path).equals(destination)) {
																																																																																														path = getPosttrack1(path);
																																																																																														correctPath.add(path);
																																																																																														if(!getPosttrack1(path).equals(destination)) {
																																																																																															path = getPosttrack1(path);
																																																																																															correctPath.add(path);
																																																																																															if(!getPosttrack2(path).equals(destination)) {
																																																																																																path = getPosttrack2(path);
																																																																																																correctPath.add(path);
																																																																																																if(!getPosttrack1(path).equals(destination)) {
																																																																																																	correctPath.clear();
																																																																																																	
																																																																																																	//fourth
																																																																																																	if(!getPosttrack2(location).equals(destination)) {
																																																																																																		path = getPosttrack2(location);
																																																																																																		correctPath.add(path);
																																																																																																		if(!getPosttrack1(path).equals(destination)) {
																																																																																																			path = getPosttrack1(path);
																																																																																																			correctPath.add(path);
																																																																																																			if(!getPosttrack1(path).equals(destination)) {
																																																																																																				path = getPosttrack1(path);
																																																																																																				correctPath.add(path);
																																																																																																				if(!getPosttrack2(path).equals(destination)) {
																																																																																																					path = getPosttrack2(path);
																																																																																																					correctPath.add(path);
																																																																																																					if(!getPosttrack2(path).equals(destination)) {
																																																																																																						correctPath.clear();
																																																																																																						
																																																																																																						//fifth
																																																																																																						if(!getPosttrack2(location).equals(destination)) {
																																																																																																							path = getPosttrack2(location);
																																																																																																							correctPath.add(path);
																																																																																																							if(!getPosttrack1(path).equals(destination)) {
																																																																																																								path = getPosttrack1(path);
																																																																																																								correctPath.add(path);
																																																																																																								if(!getPosttrack2(path).equals(destination)) {
																																																																																																									path = getPosttrack2(path);
																																																																																																									correctPath.add(path);
																																																																																																									if(!getPosttrack1(path).equals(destination)) {
																																																																																																										path = getPosttrack1(path);
																																																																																																										correctPath.add(path);
																																																																																																										if(!getPosttrack1(path).equals(destination)) {
																																																																																																											correctPath.clear();
																																																																																																											
																																																																																																											//sixth
																																																																																																											if(!getPosttrack2(location).equals(destination)) {
																																																																																																												path = getPosttrack2(location);
																																																																																																												correctPath.add(path);
																																																																																																												if(!getPosttrack1(path).equals(destination)) {
																																																																																																													path = getPosttrack1(path);
																																																																																																													correctPath.add(path);
																																																																																																													if(!getPosttrack2(path).equals(destination)) {
																																																																																																														path = getPosttrack2(path);
																																																																																																														correctPath.add(path);
																																																																																																														if(!getPosttrack1(path).equals(destination)) {
																																																																																																															path = getPosttrack1(path);
																																																																																																															correctPath.add(path);
																																																																																																															if(!getPosttrack2(path).equals(destination)) {
																																																																																																																correctPath.clear();
																																																																																																																
																																																																																																																//seventh
																																																																																																																if(!getPosttrack2(location).equals(destination)) {
																																																																																																																	path = getPosttrack2(location);
																																																																																																																	correctPath.add(path);
																																																																																																																	if(!getPosttrack1(path).equals(destination)) {
																																																																																																																		path = getPosttrack1(path);
																																																																																																																		correctPath.add(path);
																																																																																																																		if(!getPosttrack2(path).equals(destination)) {
																																																																																																																			path = getPosttrack2(path);
																																																																																																																			correctPath.add(path);
																																																																																																																			if(!getPosttrack2(path).equals(destination)) {
																																																																																																																				path = getPosttrack2(path);
																																																																																																																				correctPath.add(path);
																																																																																																																				if(!getPosttrack1(path).equals(destination)) {
																																																																																																																					correctPath.clear();
																																																																																																																					
																																																																																																																					//eight
																																																																																																																					if(!getPosttrack2(location).equals(destination)) {
																																																																																																																						path = getPosttrack2(location);
																																																																																																																						correctPath.add(path);
																																																																																																																						if(!getPosttrack1(path).equals(destination)) {
																																																																																																																							path = getPosttrack1(path);
																																																																																																																							correctPath.add(path);
																																																																																																																							if(!getPosttrack2(path).equals(destination)) {
																																																																																																																								path = getPosttrack2(path);
																																																																																																																								correctPath.add(path);
																																																																																																																								if(!getPosttrack2(path).equals(destination)) {
																																																																																																																									path = getPosttrack2(path);
																																																																																																																									correctPath.add(path);
																																																																																																																									if(!getPosttrack2(path).equals(destination)) {
																																																																																																																										correctPath.clear();
																																																																																																																										
																																																																																																																										//nine
																																																																																																																										if(!getPosttrack2(location).equals(destination)) {
																																																																																																																											path = getPosttrack2(location);
																																																																																																																											correctPath.add(path);
																																																																																																																											if(!getPosttrack2(path).equals(destination)) {
																																																																																																																												path = getPosttrack2(path);
																																																																																																																												correctPath.add(path);
																																																																																																																												if(!getPosttrack1(path).equals(destination)) {
																																																																																																																													path = getPosttrack1(path);
																																																																																																																													correctPath.add(path);
																																																																																																																													if(!getPosttrack1(path).equals(destination)) {
																																																																																																																														path = getPosttrack1(path);
																																																																																																																														correctPath.add(path);
																																																																																																																														if(!getPosttrack1(path).equals(destination)) {
																																																																																																																															correctPath.clear();
																																																																																																																															
																																																																																																																															//ten
																																																																																																																															if(!getPosttrack2(location).equals(destination)) {
																																																																																																																																path = getPosttrack2(location);
																																																																																																																																correctPath.add(path);
																																																																																																																																if(!getPosttrack2(path).equals(destination)) {
																																																																																																																																	path = getPosttrack2(path);
																																																																																																																																	correctPath.add(path);
																																																																																																																																	if(!getPosttrack1(path).equals(destination)) {
																																																																																																																																		path = getPosttrack1(path);
																																																																																																																																		correctPath.add(path);
																																																																																																																																		if(!getPosttrack1(path).equals(destination)) {
																																																																																																																																			path = getPosttrack1(path);
																																																																																																																																			correctPath.add(path);
																																																																																																																																			if(!getPosttrack2(path).equals(destination)) {
																																																																																																																																				correctPath.clear();
																																																																																																																																				
																																																																																																																																				//eleven
																																																																																																																																				if(!getPosttrack2(location).equals(destination)) {
																																																																																																																																					path = getPosttrack2(location);
																																																																																																																																					correctPath.add(path);
																																																																																																																																					if(!getPosttrack2(path).equals(destination)) {
																																																																																																																																						path = getPosttrack2(path);
																																																																																																																																						correctPath.add(path);
																																																																																																																																						if(!getPosttrack1(path).equals(destination)) {
																																																																																																																																							path = getPosttrack1(path);
																																																																																																																																							correctPath.add(path);
																																																																																																																																							if(!getPosttrack2(path).equals(destination)) {
																																																																																																																																								path = getPosttrack2(path);
																																																																																																																																								correctPath.add(path);
																																																																																																																																								if(!getPosttrack1(path).equals(destination)) {
																																																																																																																																									correctPath.clear();
																																																																																																																																									
																																																																																																																																									//twelve
																																																																																																																																									if(!getPosttrack2(location).equals(destination)) {
																																																																																																																																										path = getPosttrack2(location);
																																																																																																																																										correctPath.add(path);
																																																																																																																																										if(!getPosttrack2(path).equals(destination)) {
																																																																																																																																											path = getPosttrack2(path);
																																																																																																																																											correctPath.add(path);
																																																																																																																																											if(!getPosttrack1(path).equals(destination)) {
																																																																																																																																												path = getPosttrack1(path);
																																																																																																																																												correctPath.add(path);
																																																																																																																																												if(!getPosttrack2(path).equals(destination)) {
																																																																																																																																													path = getPosttrack2(path);
																																																																																																																																													correctPath.add(path);
																																																																																																																																													if(!getPosttrack2(path).equals(destination)) {
																																																																																																																																														correctPath.clear();
																																																																																																																																														
																																																																																																																																														//thirteen
																																																																																																																																														if(!getPosttrack2(location).equals(destination)) {
																																																																																																																																															path = getPosttrack2(location);
																																																																																																																																															correctPath.add(path);
																																																																																																																																															if(!getPosttrack2(path).equals(destination)) {
																																																																																																																																																path = getPosttrack2(path);
																																																																																																																																																correctPath.add(path);
																																																																																																																																																if(!getPosttrack2(path).equals(destination)) {
																																																																																																																																																	path = getPosttrack2(path);
																																																																																																																																																	correctPath.add(path);
																																																																																																																																																	if(!getPosttrack1(path).equals(destination)) {
																																																																																																																																																		path = getPosttrack1(path);
																																																																																																																																																		correctPath.add(path);
																																																																																																																																																		if(!getPosttrack1(path).equals(destination)) {
																																																																																																																																																			correctPath.clear();
																																																																																																																																																			
																																																																																																																																																			//fourteen
																																																																																																																																																			if(!getPosttrack2(location).equals(destination)) {
																																																																																																																																																				path = getPosttrack2(location);
																																																																																																																																																				correctPath.add(path);
																																																																																																																																																				if(!getPosttrack2(path).equals(destination)) {
																																																																																																																																																					path = getPosttrack2(path);
																																																																																																																																																					correctPath.add(path);
																																																																																																																																																					if(!getPosttrack2(path).equals(destination)) {
																																																																																																																																																						path = getPosttrack2(path);
																																																																																																																																																						correctPath.add(path);
																																																																																																																																																						if(!getPosttrack1(path).equals(destination)) {
																																																																																																																																																							path = getPosttrack1(path);
																																																																																																																																																							correctPath.add(path);
																																																																																																																																																							if(!getPosttrack2(path).equals(destination)) {
																																																																																																																																																								correctPath.clear();
																																																																																																																																																								
																																																																																																																																																								//fifteen
																																																																																																																																																								if(!getPosttrack2(location).equals(destination)) {
																																																																																																																																																									path = getPosttrack2(location);
																																																																																																																																																									correctPath.add(path);
																																																																																																																																																									if(!getPosttrack2(path).equals(destination)) {
																																																																																																																																																										path = getPosttrack2(path);
																																																																																																																																																										correctPath.add(path);
																																																																																																																																																										if(!getPosttrack2(path).equals(destination)) {
																																																																																																																																																											path = getPosttrack2(path);
																																																																																																																																																											correctPath.add(path);
																																																																																																																																																											if(!getPosttrack2(path).equals(destination)) {
																																																																																																																																																												path = getPosttrack2(path);
																																																																																																																																																												correctPath.add(path);
																																																																																																																																																												if(!getPosttrack1(path).equals(destination)) {
																																																																																																																																																													correctPath.clear();
																																																																																																																																																													
																																																																																																																																																													//sixteen
																																																																																																																																																													if(!getPosttrack2(location).equals(destination)) {
																																																																																																																																																														path = getPosttrack2(location);
																																																																																																																																																														correctPath.add(path);
																																																																																																																																																														if(!getPosttrack2(path).equals(destination)) {
																																																																																																																																																															path = getPosttrack2(path);
																																																																																																																																																															correctPath.add(path);
																																																																																																																																																															if(!getPosttrack2(path).equals(destination)) {
																																																																																																																																																																path = getPosttrack2(path);
																																																																																																																																																																correctPath.add(path);
																																																																																																																																																																if(!getPosttrack2(path).equals(destination)) {
																																																																																																																																																																	path = getPosttrack2(path);
																																																																																																																																																																	correctPath.add(path);
																																																																																																																																																																	if(!getPosttrack2(path).equals(destination)) {
																																																																																																																																																																		correctPath.clear();
																																																																																																																																																																		System.out.println("Something is wrong");
																																																																																																																																																																		} else {System.out.println("PATH FOUND");;}
																																																																																																																																																																	} else {System.out.println("PATH FOUND");;}
																																																																																																																																																																} else {System.out.println("PATH FOUND");;}
																																																																																																																																																															} else {System.out.println("PATH FOUND");;}
																																																																																																																																																														} else {System.out.println("PATH FOUND");;}
																																																																																																																																																													} else {System.out.println("PATH FOUND");;}
																																																																																																																																																												} else {System.out.println("PATH FOUND");;}
																																																																																																																																																											} else {System.out.println("PATH FOUND");;}
																																																																																																																																																										} else {System.out.println("PATH FOUND");;}
																																																																																																																																																									} else {System.out.println("PATH FOUND");;}
																																																																																																																																																								} else {System.out.println("PATH FOUND");;}
																																																																																																																																																							} else {System.out.println("PATH FOUND");;}
																																																																																																																																																						} else {System.out.println("PATH FOUND");;}
																																																																																																																																																					} else {System.out.println("PATH FOUND");;}
																																																																																																																																																				} else {System.out.println("PATH FOUND");;}
																																																																																																																																																			} else {System.out.println("PATH FOUND");;}
																																																																																																																																																		} else {System.out.println("PATH FOUND");;}
																																																																																																																																																	} else {System.out.println("PATH FOUND");;}
																																																																																																																																																} else {System.out.println("PATH FOUND");;}
																																																																																																																																															} else {System.out.println("PATH FOUND");;}
																																																																																																																																														} else {System.out.println("PATH FOUND");;}
																																																																																																																																													} else {System.out.println("PATH FOUND");;}
																																																																																																																																												} else {System.out.println("PATH FOUND");;}
																																																																																																																																											} else {System.out.println("PATH FOUND");;}
																																																																																																																																										} else {System.out.println("PATH FOUND");;}
																																																																																																																																									} else {System.out.println("PATH FOUND");;}
																																																																																																																																								} else {System.out.println("PATH FOUND");;}
																																																																																																																																							} else {System.out.println("PATH FOUND");;}
																																																																																																																																						} else {System.out.println("PATH FOUND");;}
																																																																																																																																					} else {System.out.println("PATH FOUND");;}
																																																																																																																																				} else {System.out.println("PATH FOUND");;}
																																																																																																																																			} else {System.out.println("PATH FOUND");;}
																																																																																																																																		} else {System.out.println("PATH FOUND");;}
																																																																																																																																	} else {System.out.println("PATH FOUND");;}
																																																																																																																																} else {System.out.println("PATH FOUND");;}
																																																																																																																															} else {System.out.println("PATH FOUND");;}
																																																																																																																														} else {System.out.println("PATH FOUND");;}
																																																																																																																													} else {System.out.println("PATH FOUND");;}
																																																																																																																												} else {System.out.println("PATH FOUND");;}
																																																																																																																											} else {System.out.println("PATH FOUND");;}
																																																																																																																										} else {System.out.println("PATH FOUND");;}
																																																																																																																									} else {System.out.println("PATH FOUND");;}
																																																																																																																								} else {System.out.println("PATH FOUND");;}
																																																																																																																							} else {System.out.println("PATH FOUND");;}
																																																																																																																						} else {System.out.println("PATH FOUND");;}
																																																																																																																					} else {System.out.println("PATH FOUND");;}
																																																																																																																				} else {System.out.println("PATH FOUND");;}
																																																																																																																			} else {System.out.println("PATH FOUND");;}
																																																																																																																		} else {System.out.println("PATH FOUND");;}
																																																																																																																	} else {System.out.println("PATH FOUND");;}
																																																																																																																} else {System.out.println("PATH FOUND");;}
																																																																																																															} else {System.out.println("PATH FOUND");;}
																																																																																																														} else {System.out.println("PATH FOUND");;}
																																																																																																													} else {System.out.println("PATH FOUND");;}
																																																																																																												} else {System.out.println("PATH FOUND");;}
																																																																																																											} else {System.out.println("PATH FOUND");;}
																																																																																																										} else {System.out.println("PATH FOUND");;}
																																																																																																									} else {System.out.println("PATH FOUND");;}
																																																																																																								} else {System.out.println("PATH FOUND");;}
																																																																																																							} else {System.out.println("PATH FOUND");;}
																																																																																																						} else {System.out.println("PATH FOUND");;}
																																																																																																					} else {System.out.println("PATH FOUND");;}
																																																																																																				} else {System.out.println("PATH FOUND");;}
																																																																																																			} else {System.out.println("PATH FOUND");;}
																																																																																																		} else {System.out.println("PATH FOUND");;}
																																																																																																	} else {System.out.println("PATH FOUND");;}
																																																																																																} else {System.out.println("PATH FOUND");;}
																																																																																															} else {System.out.println("PATH FOUND");;}
																																																																																														} else {System.out.println("PATH FOUND");;}
																																																																																													} else {System.out.println("PATH FOUND");;}
																																																																																												} else {System.out.println("PATH FOUND");;}
																																																																																											} else {System.out.println("PATH FOUND");;}
																																																																																										} else {System.out.println("PATH FOUND");;}
																																																																																									} else {System.out.println("PATH FOUND");;}
																																																																																								} else {System.out.println("PATH FOUND");;}
																																																																																							} else {System.out.println("PATH FOUND");;}
																																																																																						} else {System.out.println("PATH FOUND");;}
																																																																																					} else {System.out.println("PATH FOUND");;}
																																																																																				} else {System.out.println("PATH FOUND");;}
																																																																																			} else {System.out.println("PATH FOUND");;}
																																																																																		} else {System.out.println("PATH FOUND");;}
																																																																																	} else {System.out.println("PATH FOUND");;}
																																																																																} else {System.out.println("PATH FOUND");;}
																																																																															} else {System.out.println("PATH FOUND");;}
																																																																														} else {System.out.println("PATH FOUND");;}
																																																																													} else {System.out.println("PATH FOUND");;}
																																																																												} else {System.out.println("PATH FOUND");;}
																																																																											} else {System.out.println("PATH FOUND");;}
																																																																										} else {System.out.println("PATH FOUND");;}
																																																																									} else {System.out.println("PATH FOUND");;}
																																																																								} else {System.out.println("PATH FOUND");;}
																																																																							} else {System.out.println("PATH FOUND");;}
																																																																						} else {System.out.println("PATH FOUND");;}
																																																																					} else {System.out.println("PATH FOUND");;}
																																																																				} else {System.out.println("PATH FOUND");;}
																																																																			} else {System.out.println("PATH FOUND");;}
																																																																		} else {System.out.println("PATH FOUND");;}
																																																																	} else {System.out.println("PATH FOUND");;}
																																																																} else {System.out.println("PATH FOUND");;}
																																																															} else {System.out.println("PATH FOUND");;}
																																																														} else {System.out.println("PATH FOUND");;}
																																																													} else {System.out.println("PATH FOUND");;}
																																																												} else {System.out.println("PATH FOUND");;}
																																																											} else {System.out.println("PATH FOUND");;}
																																																										} else {System.out.println("PATH FOUND");;}
																																																									} else {System.out.println("PATH FOUND");;}
																																																								} else {System.out.println("PATH FOUND");;}
																																																							} else {System.out.println("PATH FOUND");;}
																																																						} else {System.out.println("PATH FOUND");;}
																																																					} else {System.out.println("PATH FOUND");;}
																																																				} else {System.out.println("PATH FOUND");;}
																																																			} else {System.out.println("PATH FOUND");;}
																																																		} else {System.out.println("PATH FOUND");;}
																																																	} else {System.out.println("PATH FOUND");;}
																																																} else {System.out.println("PATH FOUND");;}
																																															} else {System.out.println("PATH FOUND");;}
																																														} else {System.out.println("PATH FOUND");;}
																																													} else {System.out.println("PATH FOUND");;}
																																												} else {System.out.println("PATH FOUND");;}
																																											} else {System.out.println("PATH FOUND");;}
																																										} else {System.out.println("PATH FOUND");;}
																																									} else {System.out.println("PATH FOUND");;}
																																								} else {System.out.println("PATH FOUND");;}
																																							} else {System.out.println("PATH FOUND");;}
																																						} else {System.out.println("PATH FOUND");;}
																																					} else {System.out.println("PATH FOUND");;}
																																				} else {System.out.println("PATH FOUND");;}
																																			} else {System.out.println("PATH FOUND");;}
																																		} else {System.out.println("PATH FOUND");;}
																																	} else {System.out.println("PATH FOUND");;}
																																} else {System.out.println("PATH FOUND");;}
																															} else {System.out.println("PATH FOUND");;}
																														} else {System.out.println("PATH FOUND");;}
																													} else {System.out.println("PATH FOUND");;}
																												} else {System.out.println("PATH FOUND");;}
																											} else {System.out.println("PATH FOUND");;}
																										} else {System.out.println("PATH FOUND");;}
																									} else {System.out.println("PATH FOUND");;}
																								} else {System.out.println("PATH FOUND");;}
																							} else {System.out.println("PATH FOUND");;}
																						} else {System.out.println("PATH FOUND");;}
																					} else {System.out.println("PATH FOUND");;}
																				} else {System.out.println("PATH FOUND");;}
																			} else {System.out.println("PATH FOUND");;}
																		} else {System.out.println("PATH FOUND");;}
																	} else {System.out.println("PATH FOUND");;}
																} else {System.out.println("PATH FOUND");;}
															} else {System.out.println("PATH FOUND");;}
														} else {System.out.println("PATH FOUND");;}
													} else {System.out.println("PATH FOUND");;}
												} else {System.out.println("PATH FOUND");;}
											} else {System.out.println("PATH FOUND");;}
										} else {System.out.println("PATH FOUND");;}
									} else {System.out.println("PATH FOUND");;}
								} else {System.out.println("PATH FOUND");;}
							} else {System.out.println("PATH FOUND");;}
						} else {System.out.println("PATH FOUND");;}
					} else {System.out.println("PATH FOUND");;}
				} else {System.out.println("PATH FOUND");;}
			} else {System.out.println("PATH FOUND");;}
		
		System.out.println(correctPath);
		}
	
	@Override
	public String toString() {
		return "train [id=" + id + ", location=" + location + ", isAlive="
				+ isAlive + ", destination=" + destination + "]";
	}

	public void executePath() {
		Tracks tracks = new Tracks();
		tracks.executePath();
		
	}
}








