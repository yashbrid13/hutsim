package server;

import static org.junit.jupiter.api.Assertions.*;
import server.QueueManager;
import server.Simulator;
import server.QueueManager.MessagePublisher;
import server.model.State;
import java.beans.Transient;
import java.lang.annotation.Target;

import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
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

public class AllocatorTest {
    Simulator sim = new Simulator();
    Allocator alloc = new Allocator(sim);

    @Test
    @DisplayName("Should return Map of Strings")
    void getOldResultTest()
    {
        System.out.println("SAMSOATEST:"+alloc.getOldResult());
        assertNotNull(alloc.getOldResult());
    }
   
}
