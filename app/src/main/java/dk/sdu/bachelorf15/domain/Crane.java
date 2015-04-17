package dk.sdu.bachelorf15.domain;

import java.util.HashMap;

import dk.sdu.bachelorf15.help.CommandInterface;
import dk.sdu.bachelorf15.help.Commands;
import dk.sdu.bachelorf15.help.TruckObjects;

public class Crane implements CommandInterface
{
    private HashMap<Integer, Commands> crane = new HashMap<>();
    private int craneIndex = 1;

    public HashMap<Integer, Commands> getCraneMap()
    {
        return this.crane;
    }

    @Override
    public void addCommand(int index, HashMap<Integer, Commands> map, Commands com)
    {
        crane = map;
        if(index <= MAX_COMMANDO_LENGTH)
        {
            crane.put(index, com);
        }

    }

    @Override
    public Commands getCommand(int i) {
        return crane.get(i);
    }


    // TODO REMOVE UNUSED
    @Override
    public void addCommand(Commands com)
    {
        if(craneIndex <= MAX_COMMANDO_LENGTH)
        {
            this.crane.put(craneIndex, com);
            this.craneIndex++;
        }
    }

    // TODO REMOVE UNUSED
    @Override
    public void addCommand(HashMap<Integer, Commands> map, Commands com)
    {
        crane = map;
        if(craneIndex <= MAX_COMMANDO_LENGTH)
        {
            crane.put(craneIndex, com);
            craneIndex++;
        }
    }

    // TODO REMOVE UNUSED
    @Override
    public void addCommand(TruckObjects truckObject, HashMap<Integer, Commands> map, Commands com)
    {
        if(truckObject == TruckObjects.CRANE)
        {
            crane = map;
            if(craneIndex <= MAX_COMMANDO_LENGTH)
            {
                crane.put(craneIndex, com);
                craneIndex++;
            }
        }

    }


    public void pickBoxUp()
	{
		//TODO
	}
	
	public void putBoxDown()
	{
		// TODO
	}
	
	public void turnLeft()
	{
		//TODO
	}
	
	public void turnRight()
	{
		// TODO
	}
}
