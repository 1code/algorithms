package algorithm.cc150.chapter18;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Given a string s and an array of smaller strings T, design a method to search
 * s for each small string in T.
 * 
 */
public class TestQuestion8 extends TestBase {
  
  private Question8 question;

  @Override
  protected void initInstance() {
    question = new Question8();
  }

  @Override
  @Test
  public void testPosCase() {
    String str1 = "a not long string";
    String[] T1 = {"not", "a", "string"};
    int[] indices1 = {2, 0, 11};
    assertArrayEquals(indices1, question.searchAll(str1, T1));
    
    String str2 = "this one looks like a string with medium length, and it is tedious.";
    String[] T2 = {"tedious", "and", ".", "a", "is", "with"};
    int[] results = question.searchAll(str2, T2);
    for (int i = 0; i < T2.length; ++i) {
      assertEquals(str2.indexOf(T2[i]), results[i]);
    }
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

  
}
