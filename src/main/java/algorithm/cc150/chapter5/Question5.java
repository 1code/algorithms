package algorithm.cc150.chapter5;

/**
 * Write a function to determine the number of bits required to convert integer
 * A to integer B.
 * 
 */
public class Question5 {

  public int convertSteps(int A, int B) {
    // write implementation here.
    int res = A ^ B;
    int numOf1 = 0;
    while (res > 0) {
      ++numOf1;
      res &= res - 1;
    }
    return numOf1;
  }

}
