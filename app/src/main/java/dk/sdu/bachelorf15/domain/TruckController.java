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

    public void addObject(int index, TruckObjects obj)
    {
        t.addObject(index, obj);
    }

    // TODO REMOVE UNUSED
    /*public void addCommand(int index, TruckObjects obj, Commands com)
    {
        t.addCommand(index, obj, com);

    }*/

    public void addCommand(int objectIndex, int commandIndex, TruckObjects obj, Commands com)
    {
        t.addCommand(objectIndex, commandIndex, obj, com);

    }

    @Override
    public String toString() {
        return t.toString();
    }

    // TODO Implement addCommand - check return value
/*	public void addCommand()
	{
        Commands[] commandArray = new Commands[3];
        truckMap.put(mapIndex, commandArray);
        mapIndex++;

    }*/
}
