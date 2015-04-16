package dk.sdu.bachelorf15.domain;

import java.util.HashMap;

import dk.sdu.bachelorf15.help.CommandInterface;
import dk.sdu.bachelorf15.help.Commands;

public class Tire implements CommandInterface
{
	private HashMap<Integer, Commands> tire = new HashMap<>();
    private int tireIndex = 1;

    public HashMap<Integer, Commands> getTireMap()
    {
        return this.tire;
    }

    @Override
    public void addCommand(Commands com)
    {
        if(tireIndex <= MAX_COMMANDO_LENGTH)
        {
            this.tire.put(tireIndex, com);
            this.tireIndex++;
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
