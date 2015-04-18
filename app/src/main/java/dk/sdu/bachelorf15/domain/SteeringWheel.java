package dk.sdu.bachelorf15.domain;

import java.util.HashMap;

import dk.sdu.bachelorf15.help.CommandInterface;
import dk.sdu.bachelorf15.help.Commands;
import dk.sdu.bachelorf15.help.TruckObjects;

public class SteeringWheel implements CommandInterface
{
    private HashMap<Integer, Commands> steer = new HashMap<>();

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
    public Commands getCommand(int i)
    {
        return steer.get(i);
    }
}
