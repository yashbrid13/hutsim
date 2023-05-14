package server.model;

import static org.junit.jupiter.api.Assertions.*;
import server.model.Sensor;
import server.model.State;
import server.Simulator;
import server.model.target.Target;
import server.model.task.Task;
import server.model.hazard.Hazard;
import server.model.Agent;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.beans.Transient;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.*;

public class StateTest {
 State state = new State();
 Field fields[] = State.class.getDeclaredFields();
    // @Test
    // @DisplayName("Get target for current State")
    // void getTargetTest()
    // {
    //     assertTrue(state.getTarget("1") instanceof Target);
    // }

    // @Test
    // @DisplayName("Get tasks for current State")
    // void getTaskTest()
    // {
    //     assertTrue(state.getTask("1") instanceof Task);
    // }

    // @Test
    // @DisplayName("Get agent for current State")
    // void getAgentTest() {
    //     assertTrue(state.getAgent("1") instanceof Agent);
    // }

    // @Test
    // @DisplayName("Get hazard for current State")
    // void getHazardTest() {
    //     assertTrue(state.getHazard("1") instanceof Hazard);
    // }

    @Test
    @DisplayName("Get time for current state")
    void getTimeTest()
    {
        assertTrue(Double.class.isInstance(state.getTime()));
    }

    @Test
    @DisplayName("Set time test")
    void setTimeTest() {
        state.setTime(3.5);
        assertEquals(3.5, state.getTime(), 0.001);
    }

    @Test
    @DisplayName("Increment time test")
    public void incrementTimeTest() {
        state.setTime(0.0);
        state.incrementTime(2.5);
        assertEquals(2.5, state.getTime(), 0.001);
        state.incrementTime(1.5);
        assertEquals(4.0, state.getTime(), 0.001);
    }

    @Test
    @DisplayName("Is edit mode test")
    public void isEditModeTest() {
        state.setEditMode(true);
        assertTrue(state.isEditMode());
        state.setEditMode(false);
        assertFalse(state.isEditMode());
    }

    @Test
    @DisplayName("Set edit mode test")
    void setEditModeTest() {
        state.setEditMode(true);
        assertTrue(state.isEditMode());
    }

    @Test
    @DisplayName("Get game ID test")
    public void getGameIdTest() {
        state.setGameId("ABCD1234");
        assertEquals("ABCD1234", state.getGameId());
    }

    @Test
    @DisplayName("Set game ID test")
    void setGameIdTest() {
        state.setGameId("test-game-id");
        assertEquals("test-game-id", state.getGameId());
    }

    @Test
    @DisplayName("Get game type test")
    public void getGameTypeTest() {
        state.setGameType(2);
        assertEquals(2, state.getGameType());
    }

    @Test
    @DisplayName("Get game description test")
    void getGameDescriptionTest() {
        state.setGameDescription("This is a test game");
        assertEquals("This is a test game", state.getGameDescription());
    }

    @Test
    @DisplayName("Set game description test")
    void setGameDescriptionTest() {
        state.setGameDescription("This is a test game");
        assertEquals("This is a test game", state.getGameDescription());
    }

    @Test
    @DisplayName("Set game type test")
    void setGameTypeTest() {
        state.setGameType(2);
        assertEquals(2, state.getGameType());
    }

    @Test
    @DisplayName("Set allocation method test")
    void setAllocationMethodTest() {
        state.setAllocationMethod("random");
        assertEquals("random", state.getAllocationMethod());
    }

    @Test
    @DisplayName("Set flocking enabled test")
    void setFlockingEnabledTest() {
        state.setFlockingEnabled(true);
        assertTrue(state.isFlockingEnabled());
    }

    // @Test
    // @DisplayName("Get targets for current state")
    // void getTargetsTest()
    // {
    //     assertTrue(state.getTargets() instanceof Target);
    // }

    @Test
    @DisplayName("Get targets for current state")
    void getTargetsTest() {
        Collection<Target> targets = state.getTargets();
        assertNotNull(targets);
        assertEquals(0, targets.size()); 
    }

    @Test
    @DisplayName("Get tasks for current state")
    void getTasksTest() {
        Collection<Task> tasks = state.getTasks();
        assertNotNull(tasks);
        assertEquals(0, tasks.size()); 
    }

    @Test
    @DisplayName("Get agents for current state")
    void getAgentsTest() {
        Collection<Agent> agents = state.getAgents();
        assertNotNull(agents);
        assertEquals(0, agents.size()); 
    }
    
    @Test
    @DisplayName("Get allocation for current state")
    void getAllocationTest() {
        Map<String, String> allocation = state.getAllocation();
        assertNotNull(allocation);
        assertTrue(allocation instanceof Map);
    }

    @Test
    @DisplayName("Get hazards for current state")
    void getHazardsTest() {
        Collection<Hazard> hazards = state.getHazards();
        assertNotNull(hazards);
        assertTrue(hazards instanceof Collection);
    }

    @Test
    @DisplayName("Set and get allocation for current state")
    void setAndGetAllocationTest() {
        Map<String, String> allocation = new HashMap<>();
        allocation.put("agent1", "task1");
        state.setAllocation(allocation);
        assertEquals(allocation, state.getAllocation());
    }

    @Test
    @DisplayName("Set and get temporary allocation for current state")
    void setAndGetTempAllocationTest() {
        Map<String, String> tempAllocation = new HashMap<>();
        tempAllocation.put("agent1", "task1");
        state.setTempAllocation(tempAllocation);
        assertEquals(tempAllocation, state.getTempAllocation());
    }

    @Test
    @DisplayName("Get dropped allocations")
    void getDroppedAllocationTest() {
        assertTrue(state.getDroppedAllocation() instanceof Map);
    }

    @Test
    @DisplayName("Set prov doc test")
    void setProvDocTest() {
        state.setProvDoc("prov_doc");
        try {
            Field prov_doc = state.getClass().getDeclaredField("prov_doc");
            prov_doc.setAccessible(true);
            Object obj = prov_doc.get(state);
            assertEquals("prov_doc", obj);
        } catch (Exception e) {
            fail("Exception thrown: " + e);
        }
    }


    @Test
    @DisplayName("Set Allocation Undo Availability Test")
    void setAllocationUndoAvailableTest() {
        state.setAllocationUndoAvailable(true);
        try {
            Field field = state.getClass().getDeclaredField("allocationUndoAvailable");
            field.setAccessible(true);
            boolean value = field.getBoolean(state);
            assertTrue(value);
        } catch (Exception e) {
            fail("Exception: " + e);
        }
    }

    @Test
    @DisplayName("Set allocation redo available test")
    void setAllocationRedoAvailableTest() {
        state.setAllocationRedoAvailable(true);
        try {
            Field allocationRedoAvailableField = state.getClass().getDeclaredField("allocationRedoAvailable");
            allocationRedoAvailableField.setAccessible(true);
            boolean actualValue = (boolean) allocationRedoAvailableField.get(state);
            assertTrue(actualValue);
        } catch (Exception e) {
            fail("Exception: " + e);
        }
    }

    @Test
    @DisplayName("Test whether state is in progress")
    void isInProgressTest() {
        state.setInProgress(true);
        assertTrue(state.isInProgress());

        state.setInProgress(false);
        assertFalse(state.isInProgress());
    }

    //TODO: Write tests for HazardHits
}
