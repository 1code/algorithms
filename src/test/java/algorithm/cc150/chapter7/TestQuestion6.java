package algorithm.cc150.chapter7;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.cc150.chapter7.Question6.Line;
import algorithm.cc150.chapter7.Question6.Point;

/**
 * Given a two-dimensional graph with points on it, find a line which passes the
 * most number of points.
 * 
 */
public class TestQuestion6 extends TestBase {

  private Question6 question;

  @Override
  protected void initInstance() {
    question = new Question6();
  }

  @Override
  @Test
  public void testPosCase() {
    List<Point> points = new ArrayList<Point>();
    Random rnd = new Random();
    
    for (int i = 0; i < 10; ++i) {
      points.add(new Point(i, i));
    }
    // add random points
    for (int i = 0; i < 10; ++i) {
      points.add(new Point(rnd.nextInt(100), rnd.nextInt(100)));
    }
    
    assertEquals(new Line(new Point(5, 5), new Point(6, 6)), question.findLine(points));
    
    
    // test lines with infinite slope
    points.clear();
    for (int i = 0; i < 10; ++i) {
      points.add(new Point(i, 5));
    }
    // add random points
    for (int i = 0; i < 10; ++i) {
      points.add(new Point(rnd.nextInt(100), rnd.nextInt(100)));
    }
    
    assertEquals(new Line(new Point(5, 5), new Point(6, 5)), question.findLine(points));
  }

  @Override
  @Test
  public void testNegCase() {
    //  no negative points
  }

}
