package algorithm.cc150.chapter5;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;

import org.junit.Test;

import algorithm.TestBase;

/**
 * You are given two 32-bit numbers, N and M, and two bit operations, i and j.
 * Write a method to insert M into N such that M starts at bit j and ends at bit
 * i. You can assume that the bits j through i have enough space to fit all of
 * M. That is, if M = 10011, you can assume that there are at least 5 bits
 * between j and i. You would not, for example, have j = 3 and i = 2, because M
 * could not fully fit between bit 3 and bit 2.
 * 
 * EXAMPLE Input: N = 10000000000, M = 10011, i = 2, j = 6 Output: N =
 * 1001001100
 */
public class TestQuestion1 extends TestBase {

  private Question1 question;

  @Override
  protected void initInstance() {
    question = new Question1();
  }

  @Override
  @Test
  public void testPosCase() {
    int b1 = 0b10000000000;
    int b2 = 0b000010011;
    int r1 = 0b10001001100;
    assertEquals(r1, question.insert(b1, b2, 2, 6));
    
    int b3 = 0b100000000000;
    int b4 = 0b0000100110;
    int r2 = 0b100010011000;
    assertEquals(r2, question.insert(b3, b4, 2, 7));
    
    int b5 = 0b0000110001;
    int b6 = 0b0000000101;
    int r3 = 0b0000101001;
    assertEquals(r3, question.insert(b5, b6, 3, 5));
    
    int b7 = 0b1010101010;
    int b8 = 0b0101010101;
    int r4 = 0b0101010101;
    assertEquals(r4, question.insert(b7, b8, 0, 9));
    
    int b9 =  0b1111100000;
    int b10 = 0b0000001100;
    int r5 =  0b1111110000;
    assertEquals(r5, question.insert(b9, b10, 2, 5));
  }

  @Override
  @Test
  public void testNegCase() {
    // no neg case need
  }

}
