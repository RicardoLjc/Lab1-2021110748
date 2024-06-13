import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArcNodeTest {
    private ArcNode graph;

    @BeforeEach
    public void setUp() throws IOException {
        MyFile file = new MyFile("3.txt");
        ArrayList<String> fileData = file.GetNodedata();
        graph = new ArcNode();
        graph.creatGraph(fileData);
    }

    @Test
    public void testFindShortestPath_1() {
        List<String> path = graph.findShortestPath("Over", "is");
        assertEquals(List.of("Over", "the", "past", "three", "decades", "Chinese", "economy", "is"), path);
        assertEquals(7, graph.getPathWeight(path));
    }

    @Test
    public void testFindShortestPath_2() {
        List<String> path = graph.findShortestPath("is", "over");
        assertTrue(path.isEmpty());
    }

    @Test
    public void testFindShortestPath_3() {
        List<String> path = graph.findShortestPath("past", "future");
        assertTrue(path.isEmpty());
    }

    @Test
    public void testFindShortestPath_4() {
        List<String> path = graph.findShortestPath("past", ",");
        assertTrue(path.isEmpty());
    }

    @Test
    public void testFindShortestPath_5() {
        List<String> path = graph.findShortestPath("past", "watch");
        assertTrue(path.isEmpty());
    }
}
