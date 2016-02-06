package com.triloaded.sac.calendar.db;

public class CalendarItem {

	private String date;
	private String event;

	public String getdate() {
		return date;
	}

	public void setdate(String date) {
		this.date = date;
	}

	public String getevent() {
		return event;
	}

	public void setevent(String event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "[ date=" + date + ", event=" + 
				event +  "]";
	}
}