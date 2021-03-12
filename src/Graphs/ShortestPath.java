package Graphs;

public class ShortestPath {

    public static void main(String[] args)
    {
        /* Let us create the example graph discussed above */
        int max=Integer.MAX_VALUE;
        int[][] graph = new int[][] { { max, 4, max, max, max, max, max, 8, max },
                                      { 4, max, 8, max, max, max,max, 11, max },
                                      { max, 8, max, 7, max, 4, max, max, 2 },
                                      { max, max, 7, max, 9, 14, max, max, max },
                                      { max, max, max, 9, max, 10, max, max, max },
                                      { max, max, 4, 14, 10, max, 2, max, max},
                                      { max, max, max, max, max, 2, max, 1, 6 },
                                      { max, 11, max, max, max, max, 1, max, 7 },
                                      { max, max, 2, max, max, max, 6, 7, max } };
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
    }

    private void dijkstra(int[][] graph, int i) {
        
    }
}
