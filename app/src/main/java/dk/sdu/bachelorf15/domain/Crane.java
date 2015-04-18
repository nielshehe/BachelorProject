package dk.sdu.bachelorf15.domain;

import java.util.HashMap;

import dk.sdu.bachelorf15.help.CommandInterface;
import dk.sdu.bachelorf15.help.Commands;
import dk.sdu.bachelorf15.help.TruckObjects;

public class Crane implements CommandInterface
{
    private HashMap<Integer, Commands> crane = new HashMap<>();

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
    public Commands getCommand(int i)
    {
        return crane.get(i);
    }
}
