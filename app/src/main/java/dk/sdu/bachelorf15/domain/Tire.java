package dk.sdu.bachelorf15.domain;

import java.util.HashMap;

import dk.sdu.bachelorf15.help.CommandInterface;
import dk.sdu.bachelorf15.help.Commands;
import dk.sdu.bachelorf15.help.TruckObjects;

public class Tire implements CommandInterface
{
	private HashMap<Integer, Commands> tire = new HashMap<>();

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

    @Override
    public Commands getCommand(int i)
    {
        return tire.get(i);
    }
}
