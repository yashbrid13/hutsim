package server.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import server.model.task.WaypointTask;
import server.model.Coordinate;

public class WaypointTaskTest {

    Coordinate cd = new Coordinate(88,-56);
    WaypointTask wpt = new WaypointTask(null, null);

    @Test
    @DisplayName("Perform the Waypoint task")
    void performTest()
    {
        assertTrue(wpt.perform());
    }

    //TODO: Write tests after contoller tests for Task class
}