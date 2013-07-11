package algorithm.cc150.chapter9;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.cc150.chapter9.Question10.Box;

/**
 * You have a stack of n boxes, with widths w_i, heights h_i and depths d_i. The
 * boxes cannot be rotated and can only be stacked on top of one another if each
 * box in the stack is strictly larger than the box above it in width, height,
 * and depth. Implement a method to build the tallest stack possible, where the
 * height of a stack is the sum of the heights of each box.
 * 
 */
public class TestQuesiton10 extends TestBase {

  private Question10 question;

  @Override
  protected void initInstance() {
    question = new Question10();
  }

  @Override
  @Test
  public void testPosCase() {
    // one box
    Box box1 = new Box(1, 2, 3);
    List<Box> boxList1 = new ArrayList<Box>();
    boxList1.add(box1);
    assertEquals(3, question.talleast(boxList1));

    // two boxes
    Box[] boxes2 = new Box[] { new Box(1, 1, 3), new Box(2, 1, 3) };
    List<Box> boxList2 = new ArrayList<Box>();
    boxList2.addAll(Arrays.asList(boxes2));
    assertEquals(6, question.talleast(boxList2));

    // three boxes
    Box[] boxes3 = new Box[] { new Box(3, 5, 2), new Box(2, 1, 1),
        new Box(5, 3, 1) };
    List<Box> boxList3 = new ArrayList<Box>();
    boxList3.addAll(Arrays.asList(boxes3));
    assertEquals(12, question.talleast(boxList3));

    // ten boxes, for performance testing
    Random rnd = new Random();
    List<Box> boxList4 = new ArrayList<Box>();
    for (int b = 0; b < 16; ++b) {
      boxList4.add(new Box(rnd.nextInt(10), rnd.nextInt(10), rnd.nextInt(10)));
    }
    System.out.println(question.talleast(boxList4));
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
