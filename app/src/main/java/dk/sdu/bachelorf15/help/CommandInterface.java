package dk.sdu.bachelorf15.help;

import java.util.HashMap;

/**
 * Created by Mette on 16/04/15.
 */
public interface CommandInterface
{
    static final int MAX_COMMANDO_LENGTH = 3;

    void addCommand(int index, HashMap<Integer, Commands> map, Commands com);
    Commands getCommand(int i);
}
