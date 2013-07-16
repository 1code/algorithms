package algorithm.cc150.chapter18;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Numbers are randomly generated and passed to a method. Write a program to
 * find and maintain the median value as new values are generated.
 * 
 */
public class TestQuestion9 extends TestBase {

  private Question9 question;

  @Override
  protected void initInstance() {
    question = new Question9();
  }

  @Override
  @Test
  public void testPosCase() {
    
    Random rnd = new Random();
    List<Integer> stream = new ArrayList<Integer>();
    int len = rnd.nextInt(1000);
    for (int i = 0; i < len; ++i) {
      int newData = rnd.nextInt();
      Collections.sort(stream);
      int realMedian = stream.get(stream.size() / 2);
      if (stream.size() % 2 == 0) {
        realMedian = (realMedian + stream.get(stream.size() / 2 + 1)) / 2;
      }
      assertEquals(realMedian, question.median(newData));
    }
    
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
