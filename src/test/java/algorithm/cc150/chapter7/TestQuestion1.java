package algorithm.cc150.chapter7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * You have a basketball hoop and someone says that you can play one of two
 * games. Game 1: You get one shot to make the hoop. Game 2: You get three shots
 * and you have to make two of three shots. If p is the probability of making a
 * particular shot, for which values of p should you pick one game or the other?
 * 
 */
public class TestQuestion1 extends TestBase {

  private Question1 question;

  @Override
  protected void initInstance() {
    question = new Question1();
  }

  @Override
  @Test
  public void testPosCase() {
    double p1 = 0.5;
    int g1 = 1;
    assertEquals(g1, question.chooseGame(p1));
    
    double p2 = 0.6;
    int g2 = 2;
    assertEquals(g2, question.chooseGame(p2));
    
    double p3 = 0.4;
    int g3 = 1;
    assertEquals(g3, question.chooseGame(p3));
  }

  @Override
  @Test
  public void testNegCase() {
    // TODO Auto-generated method stub

  }

}
