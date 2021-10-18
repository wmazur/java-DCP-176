import java.util.Arrays;

public class Motku {

    private final MotkuGraph motkuGraph;

    public Motku(int[][] input) {
        validate(input);
        int rowsNumber = input[0][0];

        int[] nodeValues = input[1];

        motkuGraph = new MotkuGraph(nodeValues);
        for(int i = 2; i < 1+rowsNumber; i++){
            motkuGraph.addEdge(input[i][0], input[i][1]);
        }
    }

    private void validate(int[][] input) {
        if(input == null)
            throw new IllegalArgumentException("null");
        if(input.length > 1) {
            int N = input[0][0];
            if (input.length < N + 1)
                throw new IllegalArgumentException("Not Enough Rows");
        } else {
            throw new IllegalArgumentException("Empty Graph");
        }
    }

    public int result(int startNode, int distance) {
        boolean[] visited = new boolean[motkuGraph.size()+1];

        return subResult(visited, startNode, distance);

    }

    public int subResult(boolean[] visited, int startNode, int distance) {
        int result;
        visited[startNode] = true;
        if(distance == 0) {
            result = motkuGraph.getValue(startNode);
        } else {
            int[] neighbours = motkuGraph.getEdges(startNode);
            result = Arrays.stream(neighbours)
//                    .parallel() TODO: add parallel processing
                    .filter(nodeId -> !visited[nodeId])
                    .map(nodeId -> subResult(visited, nodeId, distance-1))
                    .filter(subResult -> subResult != -1)
                    .reduce(Math::min)
                    .orElse(-1);
            if(result >= 0){
                result += motkuGraph.getValue(startNode);
            }
        }
        return result;

    }

}
