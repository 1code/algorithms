package algorithm.cc150.chapter17;

/**
 * Write a function to swap two numbers in place (that is, without temporary
 * variables).
 * 
 */
public class Question1 {

  /**
   * 
   * @param a
   * @param b
   * @return first element is a, second element is b. (both after swap)
   */
  public int[] swap(int a, int b) {
    //  write implementation here
    a = a^b;
    b = a^b;
    a = a^b;
    return new int[] {a, b};
  }
  
}
