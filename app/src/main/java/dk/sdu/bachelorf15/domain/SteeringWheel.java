package dk.sdu.bachelorf15.domain;

import java.util.HashMap;

import dk.sdu.bachelorf15.help.CommandInterface;
import dk.sdu.bachelorf15.help.Commands;
import dk.sdu.bachelorf15.help.TruckObjects;

public class SteeringWheel implements CommandInterface
{
    private HashMap<Integer, Commands> steer = new HashMap<>();
    private int steerIndex = 1;

    public HashMap<Integer, Commands> getSteeringMap()
    {
        return this.steer;
    }

    @Override
    public void addCommand(int index, HashMap<Integer, Commands> map, Commands com)
    {
        steer = map;
        if(index <= MAX_COMMANDO_LENGTH)
        {
            steer.put(index, com);
        }
    }

    @Override
    public Commands getCommand(int i) {
        return steer.get(i);
    }



    // TODO REMOVE UNUSED
    @Override
    public void addCommand(Commands com)
    {
        if(steerIndex <= MAX_COMMANDO_LENGTH)
        {
            this.steer.put(steerIndex, com);
            this.steerIndex++;
        }
    }

    // TODO REMOVE UNUSED
    @Override
    public void addCommand(HashMap<Integer, Commands> map, Commands com)
    {
        steer = map;
        if(steerIndex <= MAX_COMMANDO_LENGTH)
        {
            steer.put(steerIndex, com);
            steerIndex++;
        }

    }

    // TODO REMOVE UNUSED
    @Override
    public void addCommand(TruckObjects truckObject, HashMap<Integer, Commands> map, Commands com)
    {
        if(truckObject == TruckObjects.STEERINGWHEEL)
        {
            steer = map;
            if(steerIndex <= MAX_COMMANDO_LENGTH)
            {
                steer.put(steerIndex, com);
                steerIndex++;
            }
        }
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
