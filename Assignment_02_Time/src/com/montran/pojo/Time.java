package com.montran.pojo;

public class Time {
	private int hour;
	private int minute;
	
	public void setTime(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}
	
	public void showTime() {
		System.out.println("Time: " + hour + "hr " + minute + " min");
	}
	
	public Time sum(Time time){
		 hour = hour + time.hour;
		 minute = minute + time.minute;
		
		 if(minute >=60) {
			// hour++;
			 hour= hour + minute/60;
			 minute = minute%60;
		 }
		
		 Time time1 = new Time();
		 time1.setTime(hour, minute);
		 
		 return time1;
	}
	
	public String toString() {
		return "      Time: [ Hours  Minutes ]";
	}
}
