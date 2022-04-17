public class Test {
  public static void main(String[] args) {
    Graph graph = new Graph(7);
    graph.addEdge(1, 2);
    graph.addEdge(1, 0);
    graph.addEdge(1, 3);
    graph.addEdge(1, 2);
    graph.addEdge(0, 2);
    graph.addEdge(2, 4);
    graph.addEdge(3, 4);
    graph.addEdge(5, 4);
    graph.addEdge(6, 5);
    graph.printAdjacencyList();
    graph.bfs(1);
  }
}
