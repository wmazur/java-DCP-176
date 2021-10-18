import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MotkuGraph {

    public static final int CONNECTED = 1;
    private final int[] nodeValues;
    private final int[] edgesCount;
//    private final MotkuNode[] nodes;
    private final int[][] edges;


    public MotkuGraph(int[] nodeValues) {

        this.nodeValues = rewriteFromZeroBasedToOneBased(nodeValues);

//        nodes = new MotkuNode[nodeValues.length+1];

        final int newNodeValueLength = nodeValues.length + 1;
        edgesCount = new int[newNodeValueLength];
        edges = new int[newNodeValueLength][newNodeValueLength];
    }

    private int[] rewriteFromZeroBasedToOneBased(int[] zeroBasedValues) {
        final int[] oneBasedValues = new int[zeroBasedValues.length + 1];
        System.arraycopy(zeroBasedValues, 0, oneBasedValues, 1, zeroBasedValues.length);
        return oneBasedValues;
    }

    public void addEdge(int node1, int node2) {
        validateConnection(node1, node2);
        edges[node1][node2] = CONNECTED;
        edges[node2][node1] = CONNECTED;
        edgesCount[node1]++;
        edgesCount[node2]++;
    }

    private void validateConnection(int node1, int node2) {
        if(node1 == node2)
            throw new IllegalArgumentException(""+ node1 +"->"+ node2 +" forbidden");
        if(node1 <= 0 || node2 <= 0)
            throw new IllegalArgumentException(""+ node1 +"->"+ node2 +" One-based Ids");
        if(node1 >= nodeValues.length || node2 >= nodeValues.length)
            throw new IllegalArgumentException(""+ node1 +"->"+ node2 +" One-based Ids");
        if(edges[node1][node2] == CONNECTED)
            throw new IllegalArgumentException(""+ node1 +"->"+ node2 +" already exists");
    }

    public boolean isConnected(int node1, int node2) {

        return edges[node1][node2] == CONNECTED;
    }

    public int[] getEdges(int nodeId) {
        int[] row = edges[nodeId];
        int[] retValue = new int[edgesCount[nodeId]];
        int internalEdgesCounter = 0;

        for(int i = 0; i < row.length; i++){
            if(row[i] == CONNECTED){
                retValue[internalEdgesCounter++] = i;
            }
        }
        return retValue;
    }

    public int getValue(int nodeId) {
        return nodeValues[nodeId];
    }

    public int size() {
        return nodeValues.length-1;
    }
}
