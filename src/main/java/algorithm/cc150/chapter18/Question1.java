package algorithm.cc150.chapter18;

/**
 * Write a function to add two number without add operation.
 * 
 */
public class Question1 {

  public int add(int a, int b) {
    // write implementation here
    int sum = a ^ b; // add but not consider carry
    int carry = (a & b) << 1;  // record positions with carry
    if (carry != 0) {
      return add(sum, carry);
    }
    return sum;
  }

}

