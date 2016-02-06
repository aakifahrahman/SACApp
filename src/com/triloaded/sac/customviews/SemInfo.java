package com.triloaded.sac.customviews;

public class SemInfo {
	
	private float points;
	private float credits;
	private boolean isValid;

	public SemInfo(float point, int credits, Boolean isValid){
		this.setPoints(point);
		this.setCredits(credits);
		this.setValid(this.isValid());
	}

	public float getPoints() {
		return points;
	}

	public void setPoints(float points) {
		this.points = points;
	}

	public float getCredits() {
		return credits;
	}

	public void setCredits(float credits) {
		this.credits = credits;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	@Override
	public String toString() {
		return "Points: "+ points+ " Credits: "+credits+" Valid: "+isValid;
	}
	
}
