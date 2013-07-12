package algorithm.cc150.chapter11;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Given a sorted array of strings which is interspersed with empty strings,
 * write a method to find the location of a given string.
 * 
 * EXAMPLE Input: find "ball" in {"at", "", "", "", "ball", "", "", "car", "",
 * "", "dad", "", ""} Output: 4
 */
public class TestQuestion5 extends TestBase {

  private Question5 question;

  @Override
  protected void initInstance() {
    question = new Question5();
  }

  @Override
  @Test
  public void testPosCase() {
    String[] strs1 = new String[] {
        "", "", "ab", "ac", "", "ad", "", "", "ae", "ba", "bb", "bc", "", "bd"
    };
    String target1 = "ae";
    assertEquals(8, question.findString(strs1, target1));
    String target2 = "ab";
    assertEquals(2, question.findString(strs1, target2));
    String target3 = "ac";
    assertEquals(3, question.findString(strs1, target3));
    String target4 = "bb";
    assertEquals(10, question.findString(strs1, target4));
    String target5 = "cc";
    assertEquals(-1, question.findString(strs1, target5));

    String[] strs2 = new String[] {
        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j"
    };
    String target6 = "j";
    assertEquals(9, question.findString(strs2, target6));
    String target7 = "a";
    assertEquals(0, question.findString(strs2, target7));
    String target8 = "e";
    assertEquals(4, question.findString(strs2, target8));
    String target9 = "j";
    assertEquals(9, question.findString(strs2, target9));
    String target10 = "1";
    assertEquals(-1, question.findString(strs2, target10));
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
