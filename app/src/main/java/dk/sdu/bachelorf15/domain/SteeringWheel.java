package dk.sdu.bachelorf15.domain;

import java.util.HashMap;

import dk.sdu.bachelorf15.help.CommandInterface;
import dk.sdu.bachelorf15.help.Commands;

public class SteeringWheel implements CommandInterface
{
    private HashMap<Integer, Commands> steer = new HashMap<>();
    private int steerIndex = 1;

    public HashMap<Integer, Commands> getSteeringMap()
    {
        return this.steer;
    }

    @Override
    public void addCommand(Commands com)
    {
        if(steerIndex <= MAX_COMMANDO_LENGTH)
        {
            this.steer.put(steerIndex, com);
            this.steerIndex++;
        }
    }

    @Override
    public void addCommand(HashMap<Integer, Commands> map, Commands com)
    {

    }

    @Override
    public Commands getCommand(int i) {
        return steer.get(i);
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
