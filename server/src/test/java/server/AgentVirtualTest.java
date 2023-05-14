package server.model;

import static org.junit.jupiter.api.Assertions.*;
import server.model.Sensor;
import server.Simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;


public class AgentVirtualTest {
    Simulator sim = new Simulator();
    Sensor sensor = new Sensor(sim);
    Coordinate cd = new Coordinate(88,-56);
    AgentVirtual agv = new AgentVirtual("1", cd, sensor);
    
    Method agvpm[] = AgentVirtual.class.getDeclaredMethods();

    // @Test
    // @DisplayName("Check if agent is heading towards goal")
    // void adjustHeadingTowardsGoalTest()
    // {
    //     Method ahtg = agvpm[2];
    //     ahtg.setAccessible(true);
    //     try
    //     {
    //         Object obj = ahtg.invoke(agv);
    //         // assertTrue(obj);
    //         System.out.println("OBJ: "+obj);
    //     }
    //     catch(Exception e)
    //     {
    //         // Caused by: java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 0
    //         e.printStackTrace();
    //     }
    // }

    // 

    // @Test
    // @DisplayName("Check adjust heading")
    // void adjustHeadingTest()
    // {
    //     double angle = 12;
    //     Method m = agvpm[6];
    //     m.setAccessible(true);
    //     try{
    //         Object o = m.invoke(angle);
    //         // assertTrue(m.invoke(agv, angle));
    //         System.out.println("ONJ: "+o);
    //     }
    //     catch(Exception e)
    //     {
    //         System.out.println("Exception: "+e);
    //     }
    // }
}
