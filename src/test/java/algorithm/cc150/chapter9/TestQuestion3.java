package algorithm.cc150.chapter9;

import java.util.Random;

import org.junit.Test;

import algorithm.TestBase;

/**
 * A magic index in an array A[0...n-1] is defined to be an index such that A[i]
 * = i. Given a sorted array, write a method to find a magic index, if one
 * exists, in array A.
 * 
 * FOLLOW UP What if the values are not distinct?
 * 
 */
public class TestQuestion3 extends TestBase {

  private Question3 question;

  @Override
  protected void initInstance() {
    question = new Question3();
  }

  @Override
  @Test
  public void testPosCase() {
    // generate 100 test cases

  }

  @Override
  @Test
  public void testNegCase() {

  }

}
