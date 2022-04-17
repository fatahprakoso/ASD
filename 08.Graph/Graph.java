public class Graph {
  // vertex
  private AdjacencyList[] vertices;
  private int vertexCount;
  private int size;
  private boolean[] visited;

  public Graph(int size) {
    this.vertices = new AdjacencyList[size];
    this.visited = new boolean[size];
    this.vertexCount = 0;
    this.size = size;
  }

  public AdjacencyList searchVertex(int key) {
    for (AdjacencyList v : vertices) {
      if (v == null)
        return null;

      if (v.getHead().data == key)
        return v;
    }
    return null;
  }

  public boolean addEdge(int v1, int v2) {
    if (vertexCount >= size) {
      return false;
    }

    if (v1 == v2) {
      return false;
    }

    int indexV1, indexV2;
    AdjacencyList vertex1 = searchVertex(v1);
    AdjacencyList vertex2 = searchVertex(v2);

    if (vertex1 == null) {
      this.vertices[vertexCount] = new AdjacencyList(v1, vertexCount);
      indexV1 = vertexCount;
      vertexCount++;
    } else if (vertex1.search(v2) != null) {
      return false;
    } else {
      indexV1 = vertex1.getHead().index;
    }

    if (vertex2 == null) {
      this.vertices[vertexCount] = new AdjacencyList(v2, vertexCount);
      indexV2 = vertexCount;
      vertexCount++;
    } else {
      indexV2 = vertex2.getHead().index;
    }

    searchVertex(v1).insert(v2, indexV2);
    searchVertex(v2).insert(v1, indexV1);
    return true;
  }

  public void bfs(int start) {
    BFSQueue bfsQueue = new BFSQueue();

    AdjacencyList startVertex = searchVertex(start);
    if (startVertex == null)
      return;

    System.out.print("BFS: ");

    AdjacencyList.Vertex buffer = this.vertices[0].getHead();
    int indexBuffer = buffer.index;

    do {
      while (buffer != null) {
        if (!visited[indexBuffer]) {
          System.out.print(buffer.data + ",");
          bfsQueue.enqueue(searchVertex(buffer.data));
          visited[indexBuffer] = true;
        }

        buffer = buffer.next;
        if (buffer != null) {
          indexBuffer = buffer.index;
        }
      }

      if (bfsQueue.isEmpty())
        buffer = null;
      else
        buffer = bfsQueue.dequeue().getHead();

    } while (buffer != null);
  }

  public void printAdjacencyList() {
    System.out.println("AdjacencyList of Graph:");
    for (AdjacencyList adjacencyList : vertices) {
      adjacencyList.print();
    }
  }
}