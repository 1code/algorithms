package algorithm.cc150.chapter3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it might
 * topple. Therefore, in real life, we would likely start a new stack when the
 * previous stack exceeds some threshold. Implement a data structure SetOfStacks
 * that mimics this. SetOfStacks should be composed of several stacks and should
 * create a new stack once the previous one exceeds capacity. SetOfStacks.push()
 * and SetOfStacks.pop() should behave identically to a single stack (that is,
 * pop() should return the same values as it would if there were just a single
 * stack).
 * 
 * FOLLOW UP Implement a function popAt(int index) which performs a pop
 * operation on a specific sub-stack.
 */
public class TestQuestion3 extends TestBase {

  private Question3 question;

  @Override
  protected void initInstance() {
    question = new Question3(3);
  }

  @Override
  @Test
  public void testPosCase() {
    question.push("a");
    question.push("b");
    question.push("c");
    question.push("d");
    question.push("e");
    question.push("f");
    question.push("g"); // [[a b c] <- top [d e f] <- top [g] <- top] <- top
    assertEquals("g", question.pop()); // [[a b c] <- top [d e f] <- top] <- top
    assertEquals("c", question.popAt(0)); // [[a b d] <- top [e f] <- top] <-
                                          // top
    assertEquals("d", question.popAt(0)); // [[a b e] <- top [f] <- top] <-
                                          // top
    assertEquals("f", question.pop()); // [[a b e] <- top] <- top
    question.push("h"); // [[a b e] <- top [h] <- top] <- top
    question.push("i"); // [[a b e] <- top [h i] <- top] <- top
    question.push("j"); // [[a b e] <- top [h i j] <- top ] <- top
    question.push("k"); // [[a b e] <- top [h i j] <- top [k] <- top] <- top
    assertEquals("j", question.popAt(1)); // [[a b e] <- top [h i k] <- top] <- top
    assertEquals("k", question.pop());  // [[a b e] <- top [h i] <- top] <- top
    question.push("l"); // [[a b e] <- top [h i l] <- top] <- top
    question.push("m"); // [[a b e] <- top [h i l] <- top [m] <- top] <- top
    question.push("n"); // [[a b e] <- top [h i l] <- top [m n] <- top] <- top
    assertEquals("e", question.popAt(0));  // [[a b h] <- top [i l m] <- top [n] <- top] <- top
    assertEquals("h", question.popAt(0));  // [[a b i] <- top [l m n] <- top ] <- top
    assertEquals("n", question.pop());  // [[a b i] <- top [l m] <- top ] <- top
  }

  @Override
  @Test
  public void testNegCase() {
  }

}
