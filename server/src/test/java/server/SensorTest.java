package server.model;

import static org.junit.jupiter.api.Assertions.*;
import server.model.Sensor;
import java.util.List;

import server.Simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;

public class SensorTest {
    Simulator sim = new Simulator();
    Sensor sensor = new Sensor(sim);
    Coordinate cd = new Coordinate(88,-56);
    AgentVirtual agv = new AgentVirtual("1", cd, sensor);

    @Test
    @DisplayName("Sense its neighbours")
    void senseNeighboursTest()
    {
        assertTrue(sensor.senseNeighbours(agv, 10.0) instanceof List);
    }
}
