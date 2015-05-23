package dk.sdu.bachelorf15.domain;

import java.util.HashMap;

import dk.sdu.bachelorf15.help.Commands;
import dk.sdu.bachelorf15.help.Helper;
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

    private Commands[][] truckCommands;

    private static final int MAX_OBJECT_LENGTH = 8;
    private static final int MAX_COMMAND_LENGTH = 3;


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

    public Commands getCommand(int index, int mapIndex)
    {
        Commands com = truckCommands[index][mapIndex];
        return com;
    }

    public void clearCommands()
    {
        for(int o = 0; o < MAX_OBJECT_LENGTH; o++)
        {
            for(int c = 0; c < MAX_COMMAND_LENGTH; c++)
            {
                truckCommands[o][c] = null;
            }
        }
    }
}
