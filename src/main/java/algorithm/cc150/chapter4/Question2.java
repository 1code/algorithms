package algorithm.cc150.chapter4;

import java.util.LinkedList;

/**
 * Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 * 
 */
public class Question2 {

  public static class DirectedGraph {

    private int v;
    private LinkedList<Integer> edges[];

    public DirectedGraph(int nodeSize) {
      this.edges = (LinkedList<Integer>[]) new LinkedList[nodeSize];
    }

    public void addEdge(int v, int w) {
      this.edges[v].add(w);
    }

    public Iterable<Integer> adj(int v) {
      return edges[v];
    }

    public int V() {
      return v;
    }

    public int E() {
      int e = 0;
      for (LinkedList<Integer> edge : edges)
        e += edge.size();
      return e;
    }

  }

  public boolean isRouteBetween(DirectedGraph g, int nodeIdx1, int nodeIdx2) {
    // write implementation here

    return true;
  }

}
