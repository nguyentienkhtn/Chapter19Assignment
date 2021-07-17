import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void readGraph() {
        Map<String, List<String>> expected = new HashMap<>();
        List<String>list1 = new LinkedList<>();
        list1.add("B");
        list1.add("C");
        expected.put("A", list1);
        list1 = new LinkedList<>();
        list1.add("C");
        list1.add("D");
        list1.add("E");
        expected.put("B", list1);
        list1 = new LinkedList<>();
        list1.add("A");
        list1.add("D");
        expected.put("C", list1);
        list1 = new LinkedList<>();
        list1.add("E");
        expected.put("D", list1);

        list1 = new LinkedList<>();
        expected.put("E", list1);

        list1 = new LinkedList<>();
        list1.add("G");
        expected.put("F", list1);

        list1 = new LinkedList<>();
        expected.put("G", list1);

        Map<String, List<String>> actual = Graph.readGraph(new File("nodes.txt"));

        Assertions.assertEquals(expected, actual);


    }

    @Test
    void reachableFrom1() {
        Map<String, List<String>> graph = Graph.readGraph(new File("nodes.txt"));
        String expected = "A B C D E";
        String actual = Graph.reachableFrom("A", graph);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void reachableFrom2() {
        Map<String, List<String>> graph = Graph.readGraph(new File("nodes.txt"));
        String expected = "F G";
        String actual = Graph.reachableFrom("F", graph);
        Assertions.assertEquals(expected, actual);
    }
}