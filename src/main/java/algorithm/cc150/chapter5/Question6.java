package algorithm.cc150.chapter5;

/**
 * Write a program to swap odd and even bits in an integer with as few
 * instructions as possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3
 * are swapped, and so on).
 * 
 */
public class Question6 {

  public int numInstructions(int num) {
    // write implementation here.
    int evenBits = num & 0xaaaaaaaa; // keep the even bits
    int oddBits = num & 0x55555555; // keep the odd bits
    return evenBits >> 1 | oddBits << 1;
  }

}
