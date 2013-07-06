package algorithm.cc150.chapter5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a
 * double, print the binary representation. If the number cannot be represented
 * accurately in binary with less than 32 characters, print "ERROR".
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
    assertEquals("ERROR", question.binary(0.72));
    assertEquals("0.1", question.binary(0.5));
    assertEquals("0.11", question.binary(0.75));
    assertEquals("0.101", question.binary(0.625));
    assertEquals("0.001", question.binary(0.125));
    assertEquals("0.0001", question.binary(0.0625));
    assertEquals("0.1001", question.binary(0.5625));
    assertEquals("0.00001", question.binary(0.03125));
    assertEquals("0.10101", question.binary(0.65625));
    assertEquals("0.000001", question.binary(0.015625));
    assertEquals("0.0000001", question.binary(0.0078125));
    assertEquals("0.00000001", question.binary(0.00390625));
    assertEquals("0.10101001", question.binary(0.66015625));
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
