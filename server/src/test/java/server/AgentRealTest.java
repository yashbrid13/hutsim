package server.model;

import server.QueueManager.MessagePublisher;
import server.QueueManager;
import server.Simulator;
import server.model.task.Task;

import static org.junit.jupiter.api.Assertions.*;


import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import java.beans.Transient;
import java.io.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.*;
import java.nio.channels.Channel;

public class AgentRealTest {
    Simulator sim = new Simulator();
    QueueManager qm = new QueueManager(sim);
    QueueManager.MessagePublisher mp = qm.new MessagePublisher();
    Coordinate cd = new Coordinate(80,-105);
    AgentReal ag = new AgentReal("1",cd,mp);

    Method agrpm[] = AgentReal.class.getDeclaredMethods();
    // Method lsff = lsffa[14];

    //TODO: moveTowardsDestinationTest

    @Test
    @DisplayName("Return route task in JSON form")
    void getRouteTaskJsonPreScanTest()
    {
        Method grtj = agrpm[3];
        grtj.setAccessible(true);
        try{
            Object o = grtj.invoke(ag,true);
            System.out.println("OBJECTSAMSOA: "+o);
            assertNotNull(o);
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e);
        }
    }

    @Test
    @DisplayName("Return route task in JSON form")
    void getRouteTaskJsonScanTest()
    {
        Method grtj = agrpm[3];
        grtj.setAccessible(true);
        try{
            Object o = grtj.invoke(ag,false);
            assertNotNull(o);
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e);
        }
    }

    @Test
    @DisplayName("Check that Agent is not stopped")
    void isStoppedTestFalse()
    {
        assertFalse(ag.isStopped());
    }

    @Test
    @DisplayName("Check if Agent is stopped")
    void isStoppedTestTrue()
    {
        ag.stop();
        assertTrue(ag.isStopped());
    }

    @Test
    @DisplayName("Check if Agent is Resumed")
    void isResumedTest()
    {
        ag.resume();
        assertFalse(ag.isStopped());
    }

    @Test
    @DisplayName("Check if Agent is a simulated agent")
    void isSimulatedTest()
    {
        assertFalse(ag.isSimulated());
    }

    @Test
    @DisplayName("Check time since last heartbeat")
    void getMillisSinceLastHeartbeatTest()
    {
        assertTrue(Long.class.isInstance(ag.getMillisSinceLastHeartbeat()));
    }

    @Test
    @DisplayName("Check if agent is manually controlled")
    void isManuallyControlledTest()
    {
        assertFalse(ag.isManuallyControlled()); 
    }

    @Test
    @DisplayName("Test if agent is working")
    void isWorking()
    {
        assertFalse(ag.isWorking());
    }

    @Test
    @DisplayName("Fetch Time for Drone to move from one point to Other")
    void getTimeTest()
    {
        Coordinate st = new Coordinate(80,-105);
        Coordinate en = new Coordinate(100,-105);
        assertTrue(Double.class.isInstance(ag.getTime(st,en)));
    }

    @Test
    @DisplayName("Should calculate energy consumption of the drone")
    void getEnergyConsumptionTest()
    {
        Coordinate st = new Coordinate(80,-105);
        Coordinate en = new Coordinate(100,-105);
        assertTrue(Double.class.isInstance(ag.getEnergyConsumption(st,en)));
    }

    //TODO: Initialize and test
    // @Test
    // @DisplayName("Return current destination of the drone")
    // void getCurrentDestination()
    // {
        // assertTrue(ag.getCurrentDestination() instanceof Coordinate);
    // }

    @Test
    @DisplayName("Return allocated task id")
    void getAllocatedTaskIdTest()
    {
        assertTrue(String.class.isInstance(ag.getAllocatedTaskId()));
    }

    //TODO: Is Instance of
    // @Test
    // @DisplayName("Get Allocated task for the agent")
    // void getAllocatedTaskTest()
    // {
    //     assertTrue(ag.getTask() instanceof Task);
    // }

    @Test
    @DisplayName("Return speed of the agent")
    void getSpeedTest()
    {
        assertTrue(Double.class.isInstance(ag.getSpeed()));
    }

    @Test
    @DisplayName("Return altitude of agent")
    void getAltitudeTest()
    {
        assertTrue(Double.class.isInstance(ag.getAltitude()));
    }

    @Test
    @DisplayName("Return Heading of agent")
    void getHeadingTest() {
        assertTrue(Double.class.isInstance(ag.getHeading()));
    }

    @Test
    @DisplayName("Return Searching of agent")
    void testGetSearchingReturnType() {
        assertTrue(Boolean.class.isInstance(ag.getSearching()));
    }

    @Test
    @DisplayName("Get Allocated task for the agent")
    void getRouteTest()
    {
        assertTrue(ag.getRoute() instanceof List);
    }

    @Test
    @DisplayName("Get Allocated task for the agent")
    void getTempRouteTest()
    {
        assertTrue(ag.getTempRoute() instanceof List);
    }

    @Test
    @DisplayName("Check if current destination is reached")
    void isCurrentDestinationReachedTest()
    {
        assertTrue(ag.isCurrentDestinationReached());
    }
}
