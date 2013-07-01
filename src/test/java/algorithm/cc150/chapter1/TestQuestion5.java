package algorithm.cc150.chapter1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Ignore;
import org.junit.Test;

import algorithm.TestBase;

/**
 * Implement a method to perform basic string compression using the counts of
 * repeated characters.
 * 
 * For example, the string 'aabcccccaaa' would become a2b1c5a3. If the
 * "compressed" string would not become smaller than the original string, your
 * method should return the original string.
 * 
 */
public class TestQuestion5 extends TestBase {

  private Question5 question;

  @Override
  protected void initInstance() {
    question = new Question5();
  }

  @Override
  @Test
  @Ignore
  public void testPosCase() {
    assertEquals("a2b1c5a3", question.encoding("aabcccccaaa"));
    assertEquals("abcde", question.encoding("abcde"));
    assertEquals("aabbccddee", question.encoding("aabbccddee"));
    assertEquals("aaabcddde", question.encoding("aaabcddde"));
  }

  @Override
  @Test
  public void testNegCase() {
    assertNotEquals("a1b1c1d1e1", question.encoding("abcde"));
    assertNotEquals("a2b2c2d2e2", question.encoding("aabbccddee"));
    assertNotEquals("a3b1c1d3e1", question.encoding("aaabcddde"));
  }

}
