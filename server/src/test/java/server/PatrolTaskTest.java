package server.model.task;

import server.model.Sensor;
import server.Simulator;
import server.model.task.RegionTask;
import server.model.task.PatrolTask;
import server.model.Coordinate;
import server.model.Agent;
import server.model.AgentReal;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.List;
import java.util.ArrayList;

public class PatrolTaskTest {

    private PatrolTask patrolTask;
    Simulator sim = new Simulator();

    @Test
    @DisplayName("Create a Patrol task ")
    public void createTaskTest() {
        String taskId = "P001";
        List<Coordinate> points = new ArrayList<>();
        points.add(new Coordinate(0, 0));
        points.add(new Coordinate(0, 1));
        points.add(new Coordinate(1, 1));
        points.add(new Coordinate(1, 0));

        PatrolTask task = PatrolTask.createTask(taskId, points);

        assertNotNull(task);
        assertEquals(taskId, task.getId());
        assertEquals(Task.TASK_PATROL, task.getType());
        assertEquals(points, task.getPoints());
    }
    
    @Test
    public void testGetPreviousPoint() {
        Agent agent = new AgentReal("1", new Coordinate(0.25, 0.5), sim.getQueueManager().createMessagePublisher());
        try{
            Method gpp = PatrolTask.class.getDeclaredMethod("getPreviousPoint");
            gpp.setAccessible(true);
            Coordinate previousPoint = (Coordinate) gpp.invoke(patrolTask,agent);
            assertEquals(new Coordinate(0, 0.5), previousPoint);
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e);
        }
    }
}
