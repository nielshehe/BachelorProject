package dk.sdu.bachelorf15.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dk.sdu.bachelorf15.help.CommandInterface;
import dk.sdu.bachelorf15.help.Commands;
import dk.sdu.bachelorf15.help.TruckObjects;

public class Truck
{
    // Singleton pattern
    private static Truck instance;

    public static Truck getInstance()
    {
        if(instance == null)
            instance = new Truck();
        return instance;
    }

    private HashMap<Integer, HashMap<Integer, Commands>> truck = new HashMap<>();
    private static final int MAX_LENGTH = 8;

    private Tire tire;
    private SteeringWheel steeringWheel;
    private Crane crane;

    public void addObject(int mapIndex, TruckObjects obj)
    {
        if(mapIndex <= MAX_LENGTH)
        {
            if(obj == TruckObjects.TIRE)
            {
                tire = new Tire();
                truck.put(mapIndex, tire.getTireMap());
            }
            else if (obj == TruckObjects.STEERINGWHEEL)
            {
                steeringWheel = new SteeringWheel();
                truck.put(mapIndex, steeringWheel.getSteeringMap());
            }
            else if(obj == TruckObjects.CRANE)
            {
                crane = new Crane();
                truck.put(mapIndex, crane.getCraneMap());
            }
        }
    }

    public void addCommand(int truckIndex, int commandIndex, TruckObjects truckObjects, Commands com)
    {
        HashMap<Integer, Commands> map = truck.get(truckIndex);

        if(truckObjects == TruckObjects.TIRE)
        {
            tire.addCommand(commandIndex, map, com);
        } else if(truckObjects == TruckObjects.STEERINGWHEEL)
        {
            steeringWheel.addCommand(commandIndex, map, com);
        } else if(truckObjects == TruckObjects.CRANE)
        {
            crane.addCommand(commandIndex, map, com);
        }
    }

    public Commands[] getCommands(int index, TruckObjects truckObject)
    {
        Commands[] commands = new Commands[3];
        int arrayIndex = 0;

        if(truck.containsKey(index))
        {
            for(int i = 1; i <= 3; i++)
            {
                if(truckObject == TruckObjects.TIRE)
                {
                    commands[arrayIndex] = tire.getCommand(i);
                    arrayIndex++;
                }
                else if(truckObject == TruckObjects.STEERINGWHEEL)
                {
                    commands[arrayIndex] = steeringWheel.getCommand(i);
                    arrayIndex++;
                }
                else if(truckObject == TruckObjects.CRANE)
                {
                    commands[arrayIndex] = crane.getCommand(i);
                    arrayIndex++;
                }
            }
        }
        return commands;
    }

    public Commands getCommand(int index, int mapIndex, TruckObjects truckObject)
    {
        Commands com = null;

        if(truck.containsKey(index))
        {
            if(truckObject == TruckObjects.TIRE)
            {
                com = tire.getCommand(mapIndex);
            }
            else if(truckObject == TruckObjects.STEERINGWHEEL)
            {
                com = steeringWheel.getCommand(mapIndex);
            }
            else if(truckObject == TruckObjects.CRANE)
            {
                com = crane.getCommand(mapIndex);
            }
        }

        return com;
    }

    public String toString()
    {
        return truck.toString();
    }

    // TODO REMOVE UNUSED
    private int index = 1;

    // TODO REMOVE UNUSED
    /*public void addObject(TruckObjects obj)
    {
        if(index <= MAX_LENGTH)
        {
            if(obj == TruckObjects.TIRE)
            {
                tire = new Tire();
                truck.put(index, tire.getTireMap());
                //Tire t = new Tire();
                //truck.put(index, t.getTireMap());
                index++;
            }
            else if (obj == TruckObjects.STEERINGWHEEL)
            {
                steeringWheel = new SteeringWheel();
                truck.put(index, steeringWheel.getSteeringMap());
                //SteeringWheel s = new SteeringWheel();
                //truck.put(index, s.getSteeringMap());
                index++;
            }
            else if(obj == TruckObjects.CRANE)
            {
                crane = new Crane();
                truck.put(index, crane.getCraneMap());
                //Crane c = new Crane();
                //truck.put(index, c.getCraneMap());
                index++;
            }
        }
    }*/

    /*public void addCommand(int i, TruckObjects truckObjects, Commands com)
    {
        // TODO GET THE MAP VALUE AND ADD A COMMAND TO IT
        HashMap<Integer, Commands> map = truck.get(i);

        if(truckObjects == TruckObjects.TIRE)
        {
            tire.addCommand(map, com);
        } else if(truckObjects == TruckObjects.STEERINGWHEEL)
        {
            steeringWheel.addCommand(map, com);
        } else if(truckObjects == TruckObjects.CRANE)
        {
            crane.addCommand(map, com);
        }
    }*/
}
