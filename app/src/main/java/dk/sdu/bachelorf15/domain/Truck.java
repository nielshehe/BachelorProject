package dk.sdu.bachelorf15.domain;

import java.util.HashMap;

import dk.sdu.bachelorf15.help.CommandInterface;
import dk.sdu.bachelorf15.help.Commands;
import dk.sdu.bachelorf15.help.TruckObjects;

public class Truck
{
    private HashMap<Integer, HashMap<Integer, Commands>> truck = new HashMap<>();

    private int index = 1;
    private static final int MAX_LENGTH = 8;

    private CommandInterface commads;

    public void addObject(TruckObjects obj)
    {
        if(index <= MAX_LENGTH)
        {
            if(obj == TruckObjects.TIRE)
            {
                Tire t = new Tire();
                truck.put(index, t.getTireMap());
                index++;
            }
            // TODO implement functionality for steering and crane
            else if (obj == TruckObjects.STEERINGWHEEL)
            {
                SteeringWheel s = new SteeringWheel();
                truck.put(index, s.getSteeringMap());
                index++;
            }
            else if(obj == TruckObjects.CRANE)
            {
                Crane c = new Crane();
                truck.put(index, c.getCraneMap());
                index++;
            }
        }
    }

    public String toString()
    {
        return truck.toString();
    }
}
