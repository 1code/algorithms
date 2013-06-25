package algorithm.cc150.chapter2;

/**
 * Write code to partition a linked list around a value x, such that all nodes
 * less than x come before all nodes greater than or equal to x.
 * 
 */
public class Question4 {

  public static class Node<T> {
    public T elem;
    public Node<T> next;

    public Node(T elem) {
      this.elem = elem;
    }
  }

  public static class Pair<T> {
    public Node<T> first;
    public Node<T> second;

    public Pair(Node<T> first, Node<T> second) {
      this.first = first;
      this.second = second;
    }
  }

  /**
   * Return a pair of lists, where the first list contains the nodes whose
   * elements are less than x, and the second list contains the nodes whose
   * elements are greater or equal than x.
   * 
   * @param head
   * @param x
   * @return
   */
  public <T> Pair<T> partition(Node<T> head, T x) {
    // write implementation here
    return null;
  }

}
