package server.model.task;

import server.model.Sensor;
import server.Simulator;
import server.model.task.RegionTask;
import server.model.Coordinate;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.List;
import java.util.ArrayList;

public class RegionTaskTest{

    @Test
    @DisplayName("Test createTask() method")
    void createTaskTest() {
        Coordinate nw = new Coordinate(1, 2);
        Coordinate ne = new Coordinate(2, 2);
        Coordinate se = new Coordinate(2, 1);
        Coordinate sw = new Coordinate(1, 1);

        try {

            RegionTask task = RegionTask.createTask("task123", nw, ne, se, sw);
            assertEquals("task123", task.getId());

            Field nwField = RegionTask.class.getDeclaredField("nw");
            nwField.setAccessible(true);
            Coordinate actualNw = (Coordinate) nwField.get(task);
            assertEquals(nw, actualNw);

            Field neField = RegionTask.class.getDeclaredField("ne");
            neField.setAccessible(true);
            Coordinate actualNe = (Coordinate) neField.get(task);
            assertEquals(ne, actualNe);

            Field seField = RegionTask.class.getDeclaredField("se");
            seField.setAccessible(true);
            Coordinate actualSe = (Coordinate) seField.get(task);
            assertEquals(se, actualSe);

            Field swField = RegionTask.class.getDeclaredField("sw");
            swField.setAccessible(true);
            Coordinate actualSw = (Coordinate) swField.get(task);
            assertEquals(sw, actualSw);
        } catch (Exception e) {
            fail("Exception occurred while testing createTask(): " + e.getMessage());
        }
    }

    // @Test
    // @DisplayName("Test create route")
    // void createRouteTest()
    // {
    //     try {
    //         Method createRouteMethod = RegionTask.class.getDeclaredMethod("createRoute", Coordinate.class, Coordinate.class, Coordinate.class, Coordinate.class);
    //         createRouteMethod.setAccessible(true);

    //         Coordinate nw = new Coordinate(0, 0);
    //         Coordinate ne = new Coordinate(0, 10);
    //         Coordinate se = new Coordinate(10, 10);
    //         Coordinate sw = new Coordinate(10, 0);
    //         List<Coordinate> route = (List<Coordinate>) createRouteMethod.invoke(null, nw, ne, se, sw);

    //         assertEquals(nw, route.get(0));
    //         assertEquals(ne, route.get(1));
    //         assertEquals(se, route.get(6));
    //         assertEquals(sw, route.get(11));
    //         assertEquals(nw, route.get(12));
    //         assertEquals(nw, route.get(15));
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }
}