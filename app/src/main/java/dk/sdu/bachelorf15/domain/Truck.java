package dk.sdu.bachelorf15.domain;

import java.util.HashMap;

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

    private Commands[][] truckCommands;

    private static final int MAX_OBJECT_LENGTH = 8;
    private static final int MAX_COMMAND_LENGTH = 3;

    private Tire tire;
    private SteeringWheel steeringWheel;
    private Crane crane;

    public Truck()
    {
        truckCommands = new Commands[MAX_OBJECT_LENGTH][MAX_COMMAND_LENGTH];
    }

    public void addCommand(int objectIndex, int commandIndex, Commands command)
    {
        truckCommands[objectIndex][commandIndex] = command;
    }

    public Commands getCommands(int truckObjectIndex, int commandIndex)
    {
        return truckCommands[truckObjectIndex][commandIndex];
    }

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

    public Commands getCommand(int index, int mapIndex, TruckObjects truckObject)
    {
        Commands com = truckCommands[index][mapIndex];
        return com;
    }

    public String toString()
    {
        return truck.toString();
    }
}
