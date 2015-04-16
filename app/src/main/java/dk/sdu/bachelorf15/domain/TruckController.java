package dk.sdu.bachelorf15.domain;

import java.util.HashMap;

import dk.sdu.bachelorf15.help.Commands;
import dk.sdu.bachelorf15.help.TruckObjects;

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
	
/*	private HashMap<Integer, HashMap<Integer, Commands>> truck = new HashMap<>();
    private HashMap<Integer, Commands[]> truckMap = new HashMap<>();
    private int mapIndex = 1;
*/

    private Truck t = new Truck();

    private Commands command;
    private TruckObjects truckObjects;

	public void addObject(TruckObjects obj)
	{
        t.addObject(obj);
	}

    // TODO
    public void addCommand(TruckObjects obj, Commands com)
    {

    }
	
	// TODO Implement addCommand - check return value
/*	public void addCommand()
	{
        Commands[] commandArray = new Commands[3];
        truckMap.put(mapIndex, commandArray);
        mapIndex++;

    }*/
}
