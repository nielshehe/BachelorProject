package dk.sdu.bachelorf15.controller;

import dk.sdu.bachelorf15.domain.Crane;
import dk.sdu.bachelorf15.domain.SteeringWheel;
import dk.sdu.bachelorf15.domain.Tire;
import dk.sdu.bachelorf15.domain.Truck;

public class TruckController
{
	// Singleton pattern
	private static TruckController instance;
	
	public static TruckController getInstance()
	{
		if(instance == null)
			instance = new TruckController();
		return instance;
	}
	
	private Truck t;
	
	public TruckController()
	{
		t = new Truck();
	}
	
	public void addObject()
	{
		
	}
	
	// TODO Implement addTire - check return value
	public void addTire()
	{
		Tire t = new Tire();
	}
	
	// TODO Implement addSteeringWheel - check return value
	public void addSteeringWheel()
	{
		SteeringWheel sw = new SteeringWheel();
	}
	
	// TODO Implement addCrane - check return value
	public void addCrane()
	{
		Crane c = new Crane();
	}
	
	// TODO Implement addCommando - check return value
	public void addCommando()
	{}
}
