package com.yxcoach.common.request;

public class Address {
	private Location start;
	private Location end;
	
    private String[] userId;
    
    private String[] treasureId;
    
	public String[] getUserId() {
		return userId;
	}
	public void setUserId(String[] userId) {
		this.userId = userId;
	}
	public String[] getTreasureId() {
		return treasureId;
	}
	public void setTreasureId(String[] treasureId) {
		this.treasureId = treasureId;
	}
	public Location getStart() {
		return start;
	}
	public void setStart(Location start) {
		this.start = start;
	}
	public Location getEnd() {
		return end;
	}
	public void setEnd(Location end) {
		this.end = end;
	}
	
	
	
}
