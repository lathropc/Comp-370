package trains;

import java.util.ArrayList;

public class train {
	
	public String id;
	public String location;
	public boolean isAlive;
	public String destination;
	
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
	
	public void planPath() {
		
		String path;
		ArrayList<String> correctPath = new ArrayList<String>(); 
		System.out.println("Starting location" +location);
		//first
		if(getPosttrack1(location) != destination) {
			path = getPosttrack1(location);
			System.out.println("Path is : " +path);
			correctPath.add(path);
			System.out.println(correctPath);
			if(getPosttrack1(path) != destination) {
				System.out.println("initial Path is : " +path);
				path = getPosttrack1(path);
				System.out.println("Path is : " +path);
				correctPath.add(path);
				System.out.println(correctPath);
				if(getPosttrack1(path) != destination) {
					path = getPosttrack1(path);
					correctPath.add(path);
					System.out.println(correctPath);
					if(getPosttrack1(path) != destination) {
						path = getPosttrack1(path);
						correctPath.add(path);
						if(getPosttrack1(path) != destination) {
							correctPath.clear();
							
							//second
							if(getPosttrack1(location) != destination) {
								path = getPosttrack1(location);
								correctPath.add(path);
								if(getPosttrack1(path) != destination) {
									path = getPosttrack1(path);
									correctPath.add(path);
									if(getPosttrack1(path) != destination) {
										path = getPosttrack1(path);
										correctPath.add(path);
										if(getPosttrack1(path) != destination) {
											path = getPosttrack1(path);
											correctPath.add(path);
											if(getPosttrack2(path) != destination) {
												correctPath.clear();
												
												//third
												if(getPosttrack1(location) != destination) {
													path = getPosttrack1(location);
													correctPath.add(path);
													if(getPosttrack1(path) != destination) {
														path = getPosttrack1(path);
														correctPath.add(path);
														if(getPosttrack1(path) != destination) {
															path = getPosttrack1(path);
															correctPath.add(path);
															if(getPosttrack2(path) != destination) {
																path = getPosttrack2(path);
																correctPath.add(path);
																if(getPosttrack1(path) != destination) {
																	correctPath.clear();
																	
																	//fourth
																	if(getPosttrack1(location) != destination) {
																		path = getPosttrack1(location);
																		correctPath.add(path);
																		if(getPosttrack1(path) != destination) {
																			path = getPosttrack1(path);
																			correctPath.add(path);
																			if(getPosttrack1(path) != destination) {
																				path = getPosttrack1(path);
																				correctPath.add(path);
																				if(getPosttrack2(path) != destination) {
																					path = getPosttrack2(path);
																					correctPath.add(path);
																					if(getPosttrack2(path) != destination) {
																						correctPath.clear();
																						
																						//fifth
																						if(getPosttrack1(location) != destination) {
																							path = getPosttrack1(location);
																							correctPath.add(path);
																							if(getPosttrack1(path) != destination) {
																								path = getPosttrack1(path);
																								correctPath.add(path);
																								if(getPosttrack2(path) != destination) {
																									path = getPosttrack2(path);
																									correctPath.add(path);
																									if(getPosttrack1(path) != destination) {
																										path = getPosttrack1(path);
																										correctPath.add(path);
																										if(getPosttrack1(path) != destination) {
																											correctPath.clear();
																											
																											//sixth
																											if(getPosttrack1(location) != destination) {
																												path = getPosttrack1(location);
																												correctPath.add(path);
																												if(getPosttrack1(path) != destination) {
																													path = getPosttrack1(path);
																													correctPath.add(path);
																													if(getPosttrack2(path) != destination) {
																														path = getPosttrack2(path);
																														correctPath.add(path);
																														if(getPosttrack1(path) != destination) {
																															path = getPosttrack1(path);
																															correctPath.add(path);
																															if(getPosttrack2(path) != destination) {
																																correctPath.clear();
																																
																																//seventh
																																if(getPosttrack1(location) != destination) {
																																	path = getPosttrack1(location);
																																	correctPath.add(path);
																																	if(getPosttrack1(path) != destination) {
																																		path = getPosttrack1(path);
																																		correctPath.add(path);
																																		if(getPosttrack2(path) != destination) {
																																			path = getPosttrack2(path);
																																			correctPath.add(path);
																																			if(getPosttrack2(path) != destination) {
																																				path = getPosttrack2(path);
																																				correctPath.add(path);
																																				if(getPosttrack1(path) != destination) {
																																					correctPath.clear();
																																					
																																					//eight
																																					if(getPosttrack1(location) != destination) {
																																						path = getPosttrack1(location);
																																						correctPath.add(path);
																																						if(getPosttrack1(path) != destination) {
																																							path = getPosttrack1(path);
																																							correctPath.add(path);
																																							if(getPosttrack2(path) != destination) {
																																								path = getPosttrack2(path);
																																								correctPath.add(path);
																																								if(getPosttrack2(path) != destination) {
																																									path = getPosttrack2(path);
																																									correctPath.add(path);
																																									if(getPosttrack2(path) != destination) {
																																										correctPath.clear();
																																										
																																										//nine
																																										if(getPosttrack1(location) != destination) {
																																											path = getPosttrack1(location);
																																											correctPath.add(path);
																																											if(getPosttrack2(path) != destination) {
																																												path = getPosttrack2(path);
																																												correctPath.add(path);
																																												if(getPosttrack1(path) != destination) {
																																													path = getPosttrack1(path);
																																													correctPath.add(path);
																																													if(getPosttrack1(path) != destination) {
																																														path = getPosttrack1(path);
																																														correctPath.add(path);
																																														if(getPosttrack1(path) != destination) {
																																															correctPath.clear();
																																															
																																															//ten
																																															if(getPosttrack1(location) != destination) {
																																																path = getPosttrack1(location);
																																																correctPath.add(path);
																																																if(getPosttrack2(path) != destination) {
																																																	path = getPosttrack2(path);
																																																	correctPath.add(path);
																																																	if(getPosttrack1(path) != destination) {
																																																		path = getPosttrack1(path);
																																																		correctPath.add(path);
																																																		if(getPosttrack1(path) != destination) {
																																																			path = getPosttrack1(path);
																																																			correctPath.add(path);
																																																			if(getPosttrack2(path) != destination) {
																																																				correctPath.clear();
																																																				
																																																				//eleven
																																																				if(getPosttrack1(location) != destination) {
																																																					path = getPosttrack1(location);
																																																					correctPath.add(path);
																																																					if(getPosttrack2(path) != destination) {
																																																						path = getPosttrack2(path);
																																																						correctPath.add(path);
																																																						if(getPosttrack1(path) != destination) {
																																																							path = getPosttrack1(path);
																																																							correctPath.add(path);
																																																							if(getPosttrack2(path) != destination) {
																																																								path = getPosttrack2(path);
																																																								correctPath.add(path);
																																																								if(getPosttrack1(path) != destination) {
																																																									correctPath.clear();
																																																									
																																																									//twelve
																																																									if(getPosttrack1(location) != destination) {
																																																										path = getPosttrack1(location);
																																																										correctPath.add(path);
																																																										if(getPosttrack2(path) != destination) {
																																																											path = getPosttrack2(path);
																																																											correctPath.add(path);
																																																											if(getPosttrack1(path) != destination) {
																																																												path = getPosttrack1(path);
																																																												correctPath.add(path);
																																																												if(getPosttrack2(path) != destination) {
																																																													path = getPosttrack2(path);
																																																													correctPath.add(path);
																																																													if(getPosttrack2(path) != destination) {
																																																														correctPath.clear();
																																																														
																																																														//thirteen
																																																														if(getPosttrack1(location) != destination) {
																																																															path = getPosttrack1(location);
																																																															correctPath.add(path);
																																																															if(getPosttrack2(path) != destination) {
																																																																path = getPosttrack2(path);
																																																																correctPath.add(path);
																																																																if(getPosttrack2(path) != destination) {
																																																																	path = getPosttrack2(path);
																																																																	correctPath.add(path);
																																																																	if(getPosttrack1(path) != destination) {
																																																																		path = getPosttrack1(path);
																																																																		correctPath.add(path);
																																																																		if(getPosttrack1(path) != destination) {
																																																																			correctPath.clear();
																																																																			
																																																																			//fourteen
																																																																			if(getPosttrack1(location) != destination) {
																																																																				path = getPosttrack1(location);
																																																																				correctPath.add(path);
																																																																				if(getPosttrack2(path) != destination) {
																																																																					path = getPosttrack2(path);
																																																																					correctPath.add(path);
																																																																					if(getPosttrack2(path) != destination) {
																																																																						path = getPosttrack2(path);
																																																																						correctPath.add(path);
																																																																						if(getPosttrack1(path) != destination) {
																																																																							path = getPosttrack1(path);
																																																																							correctPath.add(path);
																																																																							if(getPosttrack2(path) != destination) {
																																																																								correctPath.clear();
																																																																								
																																																																								//fifteen
																																																																								if(getPosttrack1(location) != destination) {
																																																																									path = getPosttrack1(location);
																																																																									correctPath.add(path);
																																																																									if(getPosttrack2(path) != destination) {
																																																																										path = getPosttrack2(path);
																																																																										correctPath.add(path);
																																																																										if(getPosttrack2(path) != destination) {
																																																																											path = getPosttrack2(path);
																																																																											correctPath.add(path);
																																																																											if(getPosttrack2(path) != destination) {
																																																																												path = getPosttrack2(path);
																																																																												correctPath.add(path);
																																																																												if(getPosttrack1(path) != destination) {
																																																																													correctPath.clear();
																																																																													
																																																																													//sixteen
																																																																													if(getPosttrack1(location) != destination) {
																																																																														path = getPosttrack1(location);
																																																																														correctPath.add(path);
																																																																														if(getPosttrack2(path) != destination) {
																																																																															path = getPosttrack2(path);
																																																																															correctPath.add(path);
																																																																															if(getPosttrack2(path) != destination) {
																																																																																path = getPosttrack2(path);
																																																																																correctPath.add(path);
																																																																																if(getPosttrack2(path) != destination) {
																																																																																	path = getPosttrack2(path);
																																																																																	correctPath.add(path);
																																																																																	if(getPosttrack2(path) != destination) {
																																																																																		correctPath.clear();
																																																																																		
																																																																																		//first
																																																																																		if(getPosttrack2(location) != destination) {
																																																																																			path = getPosttrack2(location);
																																																																																			correctPath.add(path);
																																																																																			if(getPosttrack1(path) != destination) {
																																																																																				path = getPosttrack1(path);
																																																																																				correctPath.add(path);
																																																																																				if(getPosttrack1(path) != destination) {
																																																																																					path = getPosttrack1(path);
																																																																																					correctPath.add(path);
																																																																																					if(getPosttrack1(path) != destination) {
																																																																																						path = getPosttrack1(path);
																																																																																						correctPath.add(path);
																																																																																						if(getPosttrack1(path) != destination) {
																																																																																							correctPath.clear();
																																																																																							
																																																																																							//second
																																																																																							if(getPosttrack2(location) != destination) {
																																																																																								path = getPosttrack2(location);
																																																																																								correctPath.add(path);
																																																																																								if(getPosttrack1(path) != destination) {
																																																																																									path = getPosttrack1(path);
																																																																																									correctPath.add(path);
																																																																																									if(getPosttrack1(path) != destination) {
																																																																																										path = getPosttrack1(path);
																																																																																										correctPath.add(path);
																																																																																										if(getPosttrack1(path) != destination) {
																																																																																											path = getPosttrack1(path);
																																																																																											correctPath.add(path);
																																																																																											if(getPosttrack2(path) != destination) {
																																																																																												correctPath.clear();
																																																																																												
																																																																																												//third
																																																																																												if(getPosttrack2(location) != destination) {
																																																																																													path = getPosttrack2(location);
																																																																																													correctPath.add(path);
																																																																																													if(getPosttrack1(path) != destination) {
																																																																																														path = getPosttrack1(path);
																																																																																														correctPath.add(path);
																																																																																														if(getPosttrack1(path) != destination) {
																																																																																															path = getPosttrack1(path);
																																																																																															correctPath.add(path);
																																																																																															if(getPosttrack2(path) != destination) {
																																																																																																path = getPosttrack2(path);
																																																																																																correctPath.add(path);
																																																																																																if(getPosttrack1(path) != destination) {
																																																																																																	correctPath.clear();
																																																																																																	
																																																																																																	//fourth
																																																																																																	if(getPosttrack2(location) != destination) {
																																																																																																		path = getPosttrack2(location);
																																																																																																		correctPath.add(path);
																																																																																																		if(getPosttrack1(path) != destination) {
																																																																																																			path = getPosttrack1(path);
																																																																																																			correctPath.add(path);
																																																																																																			if(getPosttrack1(path) != destination) {
																																																																																																				path = getPosttrack1(path);
																																																																																																				correctPath.add(path);
																																																																																																				if(getPosttrack2(path) != destination) {
																																																																																																					path = getPosttrack2(path);
																																																																																																					correctPath.add(path);
																																																																																																					if(getPosttrack2(path) != destination) {
																																																																																																						correctPath.clear();
																																																																																																						
																																																																																																						//fifth
																																																																																																						if(getPosttrack2(location) != destination) {
																																																																																																							path = getPosttrack2(location);
																																																																																																							correctPath.add(path);
																																																																																																							if(getPosttrack1(path) != destination) {
																																																																																																								path = getPosttrack1(path);
																																																																																																								correctPath.add(path);
																																																																																																								if(getPosttrack2(path) != destination) {
																																																																																																									path = getPosttrack2(path);
																																																																																																									correctPath.add(path);
																																																																																																									if(getPosttrack1(path) != destination) {
																																																																																																										path = getPosttrack1(path);
																																																																																																										correctPath.add(path);
																																																																																																										if(getPosttrack1(path) != destination) {
																																																																																																											correctPath.clear();
																																																																																																											
																																																																																																											//sixth
																																																																																																											if(getPosttrack2(location) != destination) {
																																																																																																												path = getPosttrack2(location);
																																																																																																												correctPath.add(path);
																																																																																																												if(getPosttrack1(path) != destination) {
																																																																																																													path = getPosttrack1(path);
																																																																																																													correctPath.add(path);
																																																																																																													if(getPosttrack2(path) != destination) {
																																																																																																														path = getPosttrack2(path);
																																																																																																														correctPath.add(path);
																																																																																																														if(getPosttrack1(path) != destination) {
																																																																																																															path = getPosttrack1(path);
																																																																																																															correctPath.add(path);
																																																																																																															if(getPosttrack2(path) != destination) {
																																																																																																																correctPath.clear();
																																																																																																																
																																																																																																																//seventh
																																																																																																																if(getPosttrack2(location) != destination) {
																																																																																																																	path = getPosttrack2(location);
																																																																																																																	correctPath.add(path);
																																																																																																																	if(getPosttrack1(path) != destination) {
																																																																																																																		path = getPosttrack1(path);
																																																																																																																		correctPath.add(path);
																																																																																																																		if(getPosttrack2(path) != destination) {
																																																																																																																			path = getPosttrack2(path);
																																																																																																																			correctPath.add(path);
																																																																																																																			if(getPosttrack2(path) != destination) {
																																																																																																																				path = getPosttrack2(path);
																																																																																																																				correctPath.add(path);
																																																																																																																				if(getPosttrack1(path) != destination) {
																																																																																																																					correctPath.clear();
																																																																																																																					
																																																																																																																					//eight
																																																																																																																					if(getPosttrack2(location) != destination) {
																																																																																																																						path = getPosttrack2(location);
																																																																																																																						correctPath.add(path);
																																																																																																																						if(getPosttrack1(path) != destination) {
																																																																																																																							path = getPosttrack1(path);
																																																																																																																							correctPath.add(path);
																																																																																																																							if(getPosttrack2(path) != destination) {
																																																																																																																								path = getPosttrack2(path);
																																																																																																																								correctPath.add(path);
																																																																																																																								if(getPosttrack2(path) != destination) {
																																																																																																																									path = getPosttrack2(path);
																																																																																																																									correctPath.add(path);
																																																																																																																									if(getPosttrack2(path) != destination) {
																																																																																																																										correctPath.clear();
																																																																																																																										
																																																																																																																										//nine
																																																																																																																										if(getPosttrack2(location) != destination) {
																																																																																																																											path = getPosttrack2(location);
																																																																																																																											correctPath.add(path);
																																																																																																																											if(getPosttrack2(path) != destination) {
																																																																																																																												path = getPosttrack2(path);
																																																																																																																												correctPath.add(path);
																																																																																																																												if(getPosttrack1(path) != destination) {
																																																																																																																													path = getPosttrack1(path);
																																																																																																																													correctPath.add(path);
																																																																																																																													if(getPosttrack1(path) != destination) {
																																																																																																																														path = getPosttrack1(path);
																																																																																																																														correctPath.add(path);
																																																																																																																														if(getPosttrack1(path) != destination) {
																																																																																																																															correctPath.clear();
																																																																																																																															
																																																																																																																															//ten
																																																																																																																															if(getPosttrack2(location) != destination) {
																																																																																																																																path = getPosttrack2(location);
																																																																																																																																correctPath.add(path);
																																																																																																																																if(getPosttrack2(path) != destination) {
																																																																																																																																	path = getPosttrack2(path);
																																																																																																																																	correctPath.add(path);
																																																																																																																																	if(getPosttrack1(path) != destination) {
																																																																																																																																		path = getPosttrack1(path);
																																																																																																																																		correctPath.add(path);
																																																																																																																																		if(getPosttrack1(path) != destination) {
																																																																																																																																			path = getPosttrack1(path);
																																																																																																																																			correctPath.add(path);
																																																																																																																																			if(getPosttrack2(path) != destination) {
																																																																																																																																				correctPath.clear();
																																																																																																																																				
																																																																																																																																				//eleven
																																																																																																																																				if(getPosttrack2(location) != destination) {
																																																																																																																																					path = getPosttrack2(location);
																																																																																																																																					correctPath.add(path);
																																																																																																																																					if(getPosttrack2(path) != destination) {
																																																																																																																																						path = getPosttrack2(path);
																																																																																																																																						correctPath.add(path);
																																																																																																																																						if(getPosttrack1(path) != destination) {
																																																																																																																																							path = getPosttrack1(path);
																																																																																																																																							correctPath.add(path);
																																																																																																																																							if(getPosttrack2(path) != destination) {
																																																																																																																																								path = getPosttrack2(path);
																																																																																																																																								correctPath.add(path);
																																																																																																																																								if(getPosttrack1(path) != destination) {
																																																																																																																																									correctPath.clear();
																																																																																																																																									
																																																																																																																																									//twelve
																																																																																																																																									if(getPosttrack2(location) != destination) {
																																																																																																																																										path = getPosttrack2(location);
																																																																																																																																										correctPath.add(path);
																																																																																																																																										if(getPosttrack2(path) != destination) {
																																																																																																																																											path = getPosttrack2(path);
																																																																																																																																											correctPath.add(path);
																																																																																																																																											if(getPosttrack1(path) != destination) {
																																																																																																																																												path = getPosttrack1(path);
																																																																																																																																												correctPath.add(path);
																																																																																																																																												if(getPosttrack2(path) != destination) {
																																																																																																																																													path = getPosttrack2(path);
																																																																																																																																													correctPath.add(path);
																																																																																																																																													if(getPosttrack2(path) != destination) {
																																																																																																																																														correctPath.clear();
																																																																																																																																														
																																																																																																																																														//thirteen
																																																																																																																																														if(getPosttrack2(location) != destination) {
																																																																																																																																															path = getPosttrack2(location);
																																																																																																																																															correctPath.add(path);
																																																																																																																																															if(getPosttrack2(path) != destination) {
																																																																																																																																																path = getPosttrack2(path);
																																																																																																																																																correctPath.add(path);
																																																																																																																																																if(getPosttrack2(path) != destination) {
																																																																																																																																																	path = getPosttrack2(path);
																																																																																																																																																	correctPath.add(path);
																																																																																																																																																	if(getPosttrack1(path) != destination) {
																																																																																																																																																		path = getPosttrack1(path);
																																																																																																																																																		correctPath.add(path);
																																																																																																																																																		if(getPosttrack1(path) != destination) {
																																																																																																																																																			correctPath.clear();
																																																																																																																																																			
																																																																																																																																																			//fourteen
																																																																																																																																																			if(getPosttrack2(location) != destination) {
																																																																																																																																																				path = getPosttrack2(location);
																																																																																																																																																				correctPath.add(path);
																																																																																																																																																				if(getPosttrack2(path) != destination) {
																																																																																																																																																					path = getPosttrack2(path);
																																																																																																																																																					correctPath.add(path);
																																																																																																																																																					if(getPosttrack2(path) != destination) {
																																																																																																																																																						path = getPosttrack2(path);
																																																																																																																																																						correctPath.add(path);
																																																																																																																																																						if(getPosttrack1(path) != destination) {
																																																																																																																																																							path = getPosttrack1(path);
																																																																																																																																																							correctPath.add(path);
																																																																																																																																																							if(getPosttrack2(path) != destination) {
																																																																																																																																																								correctPath.clear();
																																																																																																																																																								
																																																																																																																																																								//fifteen
																																																																																																																																																								if(getPosttrack2(location) != destination) {
																																																																																																																																																									path = getPosttrack2(location);
																																																																																																																																																									correctPath.add(path);
																																																																																																																																																									if(getPosttrack2(path) != destination) {
																																																																																																																																																										path = getPosttrack2(path);
																																																																																																																																																										correctPath.add(path);
																																																																																																																																																										if(getPosttrack2(path) != destination) {
																																																																																																																																																											path = getPosttrack2(path);
																																																																																																																																																											correctPath.add(path);
																																																																																																																																																											if(getPosttrack2(path) != destination) {
																																																																																																																																																												path = getPosttrack2(path);
																																																																																																																																																												correctPath.add(path);
																																																																																																																																																												if(getPosttrack1(path) != destination) {
																																																																																																																																																													correctPath.clear();
																																																																																																																																																													
																																																																																																																																																													//sixteen
																																																																																																																																																													if(getPosttrack2(location) != destination) {
																																																																																																																																																														path = getPosttrack2(location);
																																																																																																																																																														correctPath.add(path);
																																																																																																																																																														if(getPosttrack2(path) != destination) {
																																																																																																																																																															path = getPosttrack2(path);
																																																																																																																																																															correctPath.add(path);
																																																																																																																																																															if(getPosttrack2(path) != destination) {
																																																																																																																																																																path = getPosttrack2(path);
																																																																																																																																																																correctPath.add(path);
																																																																																																																																																																if(getPosttrack2(path) != destination) {
																																																																																																																																																																	path = getPosttrack2(path);
																																																																																																																																																																	correctPath.add(path);
																																																																																																																																																																	if(getPosttrack2(path) != destination) {
																																																																																																																																																																		correctPath.clear();
																																																																																																																																																																		System.out.println("Something is wrong");
																																																																																																																																																																		} else {return;}
																																																																																																																																																																	} else {return;}
																																																																																																																																																																} else {return;}
																																																																																																																																																															} else {return;}
																																																																																																																																																														} else {return;}
																																																																																																																																																													} else {return;}
																																																																																																																																																												} else {return;}
																																																																																																																																																											} else {return;}
																																																																																																																																																										} else {return;}
																																																																																																																																																									} else {return;}
																																																																																																																																																								} else {return;}
																																																																																																																																																							} else {return;}
																																																																																																																																																						} else {return;}
																																																																																																																																																					} else {return;}
																																																																																																																																																				} else {return;}
																																																																																																																																																			} else {return;}
																																																																																																																																																		} else {return;}
																																																																																																																																																	} else {return;}
																																																																																																																																																} else {return;}
																																																																																																																																															} else {return;}
																																																																																																																																														} else {return;}
																																																																																																																																													} else {return;}
																																																																																																																																												} else {return;}
																																																																																																																																											} else {return;}
																																																																																																																																										} else {return;}
																																																																																																																																									} else {return;}
																																																																																																																																								} else {return;}
																																																																																																																																							} else {return;}
																																																																																																																																						} else {return;}
																																																																																																																																					} else {return;}
																																																																																																																																				} else {return;}
																																																																																																																																			} else {return;}
																																																																																																																																		} else {return;}
																																																																																																																																	} else {return;}
																																																																																																																																} else {return;}
																																																																																																																															} else {return;}
																																																																																																																														} else {return;}
																																																																																																																													} else {return;}
																																																																																																																												} else {return;}
																																																																																																																											} else {return;}
																																																																																																																										} else {return;}
																																																																																																																									} else {return;}
																																																																																																																								} else {return;}
																																																																																																																							} else {return;}
																																																																																																																						} else {return;}
																																																																																																																					} else {return;}
																																																																																																																				} else {return;}
																																																																																																																			} else {return;}
																																																																																																																		} else {return;}
																																																																																																																	} else {return;}
																																																																																																																} else {return;}
																																																																																																															} else {return;}
																																																																																																														} else {return;}
																																																																																																													} else {return;}
																																																																																																												} else {return;}
																																																																																																											} else {return;}
																																																																																																										} else {return;}
																																																																																																									} else {return;}
																																																																																																								} else {return;}
																																																																																																							} else {return;}
																																																																																																						} else {return;}
																																																																																																					} else {return;}
																																																																																																				} else {return;}
																																																																																																			} else {return;}
																																																																																																		} else {return;}
																																																																																																	} else {return;}
																																																																																																} else {return;}
																																																																																															} else {return;}
																																																																																														} else {return;}
																																																																																													} else {return;}
																																																																																												} else {return;}
																																																																																											} else {return;}
																																																																																										} else {return;}
																																																																																									} else {return;}
																																																																																								} else {return;}
																																																																																							} else {return;}
																																																																																						} else {return;}
																																																																																					} else {return;}
																																																																																				} else {return;}
																																																																																			} else {return;}
																																																																																		} else {return;}
																																																																																	} else {return;}
																																																																																} else {return;}
																																																																															} else {return;}
																																																																														} else {return;}
																																																																													} else {return;}
																																																																												} else {return;}
																																																																											} else {return;}
																																																																										} else {return;}
																																																																									} else {return;}
																																																																								} else {return;}
																																																																							} else {return;}
																																																																						} else {return;}
																																																																					} else {return;}
																																																																				} else {return;}
																																																																			} else {return;}
																																																																		} else {return;}
																																																																	} else {return;}
																																																																} else {return;}
																																																															} else {return;}
																																																														} else {return;}
																																																													} else {return;}
																																																												} else {return;}
																																																											} else {return;}
																																																										} else {return;}
																																																									} else {return;}
																																																								} else {return;}
																																																							} else {return;}
																																																						} else {return;}
																																																					} else {return;}
																																																				} else {return;}
																																																			} else {return;}
																																																		} else {return;}
																																																	} else {return;}
																																																} else {return;}
																																															} else {return;}
																																														} else {return;}
																																													} else {return;}
																																												} else {return;}
																																											} else {return;}
																																										} else {return;}
																																									} else {return;}
																																								} else {return;}
																																							} else {return;}
																																						} else {return;}
																																					} else {return;}
																																				} else {return;}
																																			} else {return;}
																																		} else {return;}
																																	} else {return;}
																																} else {return;}
																															} else {return;}
																														} else {return;}
																													} else {return;}
																												} else {return;}
																											} else {return;}
																										} else {return;}
																									} else {return;}
																								} else {return;}
																							} else {return;}
																						} else {return;}
																					} else {return;}
																				} else {return;}
																			} else {return;}
																		} else {return;}
																	} else {return;}
																} else {return;}
															} else {return;}
														} else {return;}
													} else {return;}
												} else {return;}
											} else {return;}
										} else {return;}
									} else {return;}
								} else {return;}
							} else {return;}
						} else {return;}
					} else {return;}
				} else {return;}
			} else {return;}
		
		System.out.println(correctPath);
		}
	
	@Override
	public String toString() {
		return "train [id=" + id + ", location=" + location + ", isAlive="
				+ isAlive + ", destination=" + destination + "]";
	}


}