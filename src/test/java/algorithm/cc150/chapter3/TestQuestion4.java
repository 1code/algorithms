package algorithm.cc150.chapter3;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.cc150.chapter3.Question4.Action;

/**
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks
 * of different sizes which can slide onto any tower. The puzzle starts with
 * disks sorted in ascending order of size from top to bottom (i.e., each disk
 * sits on top of an even larger one). You have the following constraints: (1)
 * Only one disk can be moved at a time. (2) A disk is slid off the top of one
 * tower onto the next tower. (3) A disk can only be placed on top of a larger
 * disk. Write a program to move the disks from the first tower to the last
 * using stacks.
 * 
 * Note: the disks are numbered as 1, 2, and 3.
 */
public class TestQuestion4 extends TestBase {

  private Question4 question;

  @Override
  protected void initInstance() {
    question = new Question4();
  }

  @Override
  @Test
  public void testPosCase() {
    List<Action> threeDisks = question.hanoi(3);
    Action[] expectedThreeDisks = new Action[] { new Action(1, 3),
        new Action(1, 2), new Action(3, 2), new Action(1, 3), new Action(2, 1),
        new Action(2, 3), new Action(1, 3) };
    assertArrayEquals(expectedThreeDisks, threeDisks.toArray());
  }

  @Override
  @Test
  public void testNegCase() {
  }

}
