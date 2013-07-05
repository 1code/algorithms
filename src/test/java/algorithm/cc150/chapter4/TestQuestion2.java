package algorithm.cc150.chapter4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.cc150.chapter4.Question2.DirectedGraph;

/**
 * Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 * 
 */
public class TestQuestion2 extends TestBase {

  private Question2 question;

  @Override
  protected void initInstance() {
    question = new Question2();
  }

  @Override
  @Test
  public void testPosCase() {
    DirectedGraph g = new DirectedGraph(9);
    g.addEdge(0, 2);
    g.addEdge(2, 1);
    g.addEdge(1, 0);
    g.addEdge(1, 3);
    g.addEdge(3, 1);
    g.addEdge(1, 4);
    g.addEdge(4, 3);
    g.addEdge(5, 4);
    g.addEdge(6, 7);
    g.addEdge(7, 8);
    g.addEdge(6, 8);
    
    assertTrue(question.isRouteBetween(g, 0, 5));
    assertTrue(question.isRouteBetween(g, 5, 0));
    assertTrue(question.isRouteBetween(g, 6, 7));
    assertTrue(question.isRouteBetween(g, 6, 8));
  }

  @Override
  @Test
  public void testNegCase() {
    DirectedGraph g = new DirectedGraph(9);
    g.addEdge(0, 2);
    g.addEdge(2, 1);
    g.addEdge(1, 0);
    g.addEdge(1, 3);
    g.addEdge(3, 1);
    g.addEdge(1, 4);
    g.addEdge(4, 3);
    g.addEdge(5, 4);
    g.addEdge(6, 7);
    g.addEdge(7, 8);
    g.addEdge(6, 8);
    
    assertFalse(question.isRouteBetween(g, 1, 6));
    assertFalse(question.isRouteBetween(g, 5, 6));
  }

}
