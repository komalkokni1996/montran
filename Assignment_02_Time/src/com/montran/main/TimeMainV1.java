package com.montran.main;

import com.montran.pojo.Time;

public class TimeMainV1 {

	public static void main(String[] args) {
		
		Time time1 = new Time();
		Time time2 = new Time();
		Time time3 = new Time();
		
		System.out.println(time1);
		System.out.println("\n-------------------Time 1-------------------------");
		time1.setTime(12, 30);
		time1.showTime();
		System.out.println("-------------------Time 2-------------------------");
		time2.setTime(01, 30);
		time2.showTime();
		
		System.out.println("\n---------------SUM of 2 Times---------------------");
		time3 = time2.sum(time1);
		time3.showTime();
		
		System.out.println("--------------------------------------------------");
		
	}

}
