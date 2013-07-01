package algorithm.cc150.chapter2;

/**
 * Given a circular linked list, implement an algorithm which returns the node
 * at the beginning of the loop.
 * 
 * DEFINITION Circular linked list: A (corrupt) linked list in which a node's
 * next pointer points to an earlier node, so as to make a loop in the linked
 * list.
 * 
 * EXAMPLE Input: A-> B -> C -> D -> E -> C [the same C as earlier Output: C
 * 
 */
public class Question6 {

  public static class Node<T> {
    public T elem;
    public Node<T> next;

    public Node(T elem) {
      this.elem = elem;
    }
  }

  public <T> Node<T> findLoop(Node<T> list) {
    // write implementation here

    return null;
  }

}
