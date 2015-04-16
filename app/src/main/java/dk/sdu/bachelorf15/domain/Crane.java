package dk.sdu.bachelorf15.domain;

import java.util.HashMap;

import dk.sdu.bachelorf15.help.CommandInterface;
import dk.sdu.bachelorf15.help.Commands;

public class Crane implements CommandInterface
{
    private HashMap<Integer, Commands> crane = new HashMap<>();
    private int craneIndex = 1;

    public HashMap<Integer, Commands> getCraneMap()
    {
        return this.crane;
    }

    @Override
    public void addCommand(Commands com)
    {
        if(craneIndex <= MAX_COMMANDO_LENGTH)
        {
            this.crane.put(craneIndex, com);
            this.craneIndex++;
        }
    }

    @Override
    public Commands getCommand(int i) {
        return crane.get(i);
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
