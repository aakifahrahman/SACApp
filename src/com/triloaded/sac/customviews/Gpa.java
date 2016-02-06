package com.triloaded.sac.customviews;

public class Gpa {
	
	private int credit;
	private int gradepoint;
	private boolean isValid;
	
	public Gpa(int credit, int gradepoint,boolean isValid){
		this.setCredit(credit);
		this.setGradepoint(gradepoint);
		this.setValid(isValid);
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getGradepoint() {
		return gradepoint;
	}

	public void setGradepoint(int gradepoint) {
		this.gradepoint = gradepoint;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	

}
