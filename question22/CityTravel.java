/*
 * Name: Jiachen Zhang
 * Student number: 2098620
 */

import java.util.*;
import java.io.*;
import java.util.Vector;

public class CityTravel {

	public static void PrintNearestCity(Vector<String> cities,String query) {
		int length = cities.size();
		City city1 = new City(cities, query, 0, length/2);
		City city2 = new City(cities, query, length/2 -1, length-1);
		Thread thread1 = new Thread(city1);
		thread1.start();
		Thread thread2 = new Thread(city2);
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();

			if(city1.getValue() < city2.getValue()) {
				System.out.println("The nearest city is "+ city1.getNearest());
			}else {
				System.out.println("The nearest city is "+ city2.getNearest());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
}
class City implements Runnable {
	
	private Vector<String> cities;
	
	private String query;
	
	private String neast;
	
	private double value;
	private int i;
	private int j;
	
	public City(Vector<String> cities, String query,int i,int j) {
		this.cities = cities;
		this.query = query;
		value = Integer.MAX_VALUE;
		this.i = i;
		this.j = j;
	}

	public void run() {
		
		for(int k = i; k<=j; k++) {
			String s = cities.get(k);
			if(s.equals(query)) {
				continue;
			}
			
			double distance = DistCalc.getDistance(s, query);
			if(distance<value) {
				neast = s;
				value = distance;
			}
		}
		
	}

	public String getNearest() {
		return neast;
	}


	public double getValue() {
		return value;
	}
	
}
