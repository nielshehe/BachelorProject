package dk.sdu.bachelorf15.domain;

import java.util.HashMap;

import dk.sdu.bachelorf15.help.CommandInterface;
import dk.sdu.bachelorf15.help.Commands;
import dk.sdu.bachelorf15.help.TruckObjects;

public class Tire implements CommandInterface
{
	private HashMap<Integer, Commands> tire = new HashMap<>();
    private int tireIndex = 1;

    public HashMap<Integer, Commands> getTireMap()
    {
        return this.tire;
    }

    @Override
    public void addCommand(int index, HashMap<Integer, Commands> map, Commands com)
    {
        tire = map;
        if(index <= MAX_COMMANDO_LENGTH)
        {
            tire.put(index, com);
        }
    }


    // TODO REMOVE UNUSED
    @Override
    public void addCommand(Commands com)
    {
        if(tireIndex <= MAX_COMMANDO_LENGTH)
        {
            this.tire.put(tireIndex, com);
            this.tireIndex++;
        }
    }

    // TODO REMOVE UNUSED
    @Override
    public void addCommand(HashMap<Integer, Commands> map, Commands com)
    {
        tire = map;
        if(tireIndex <= MAX_COMMANDO_LENGTH)
        {
            tire.put(tireIndex, com);
            tireIndex++;
        }
    }

    // TODO REMOVE UNUSED
    @Override
    public void addCommand(TruckObjects truckObject, HashMap<Integer, Commands> map, Commands com)
    {
        if(truckObject == TruckObjects.TIRE)
        {
            tire = map;
            if(tireIndex <= MAX_COMMANDO_LENGTH)
            {
                tire.put(tireIndex, com);
                tireIndex++;
            }
        }
    }

    @Override
    public Commands getCommand(int i)
    {
        return tire.get(i);
    }


    public void moveForward()
	{
		//TODO
	}
	
	public void moveBackward()
	{
		// TODO
	}
}
