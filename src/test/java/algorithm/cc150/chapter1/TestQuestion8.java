package algorithm.cc150.chapter1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algorithm.TestBase;

public class TestQuestion8 extends TestBase {

  private Question8 question;

  @Override
  protected void initInstance() {
    question = new Question8();
  }

  @Override
  @Test
  public void testPosCase() {
    assertTrue(question.isRotation("waterbottle", "erbottlewat"));
    assertTrue(question.isRotation("hello world", "worldhello "));
    assertTrue(question
        .isRotation("just a test this is", "this is just a test "));
  }

  @Override
  @Test
  public void testNegCase() {
    assertFalse(question.isRotation("waterbottle", "awterbottle"));
    assertFalse(question.isRotation("hello world", "wolrd hello"));
    assertFalse(question.isRotation("just a test is this",
        "this is just a test"));
  }

}
