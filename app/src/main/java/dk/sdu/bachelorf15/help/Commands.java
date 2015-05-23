package dk.sdu.bachelorf15.help;

import java.io.Serializable;

/**
 * Created by Mette on 16/04/15.
 */
public enum Commands implements Serializable
{
    TIRE_MOVE_FORWARD,
    TIRE_MOVE_BACKWARD,
    STEER_TURN_LEFT,
    STEER_TURN_RIGHT,
    CRANE_TURN_LEFT,
    CRANE_TURN_RIGHT,
    CRANE_BOX_PICKUP,
    CRANE_BOX_PUTDOWN;
}
