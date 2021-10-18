import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class GraphTest {

    MotkuGraph g;

    @Test public void
    class_accepts_empty_array_of_inys_in_constructor(){
        g = new MotkuGraph(new int[0]);
    }

    @Test public void
    class_accepts_array_of_one_int_in_constructor(){
        g = new MotkuGraph(new int[]{1});
    }

    @Test public void
    class_accepts_array_of_two_ints_in_constructor(){
        g = new MotkuGraph(new int[]{1, 2});
    }


    @Test public void
    you_may_add_a_link_between_two_nodes(){
        g = new MotkuGraph(new int[]{1, 2});
        g.addEdge(1,2);
    }

    @Test(expected = IllegalArgumentException.class) public void
    you_cannot_add_link_twice(){
        g = new MotkuGraph(new int[]{1, 2});
        g.addEdge(1,2);
        g.addEdge(1,2);
    }

    @Test(expected = IllegalArgumentException.class) public void
    you_cannot_add_a_link_to_yourself() {
        g = new MotkuGraph(new int[]{1, 2});
        g.addEdge(1, 1);
    }

        @Test public void
    you_may_check_if_nodes_are_connected(){
        g = new MotkuGraph(new int[]{1, 2});
        g.addEdge(1,2);
        assertTrue(g.isConnected(1,2));
    }

    @Test public void
    you_may_get_list_of_edges(){
        g = new MotkuGraph(new int[]{1, 2});
        g.addEdge(1,2);
        int[] edges1 = g.getEdges(1);
        int[] edges2 = g.getEdges(2);
        assertEquals(1, edges1.length);
        assertEquals(1, edges2.length);
        assertEquals(2, edges1[0]);
        assertEquals(1, edges2[0]);

    }

    @Test(expected = IllegalArgumentException.class) public void
    one_based_node_ids(){
        g = new MotkuGraph(new int[]{1, 2});
        g.addEdge(0,1);
    }

    @Test(expected = IllegalArgumentException.class) public void
    exception_if_out_of_bounds_node_id(){
        g = new MotkuGraph(new int[]{1, 2});
        g.addEdge(3,1);
    }

    @Test
    public void FiveNodesTest(){
        g = new MotkuGraph(new int[]{1, 2, 3, 50});

        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(1, 3);

        int[] edges1 = g.getEdges(1);
        int[] edges2 = g.getEdges(2);
        int[] edges3 = g.getEdges(3);
        int[] edges4 = g.getEdges(4);
        assertEquals(2, edges1.length);
        assertEquals(2, edges2.length);
        assertEquals(2, edges3.length);
        assertEquals(0, edges4.length);
        assertArrayEquals(new int[]{2,3}, edges1);
        assertArrayEquals(new int[]{1,3}, edges2);
        assertArrayEquals(new int[]{1,2}, edges3);
        assertArrayEquals(new int[0], edges4);

    }


}