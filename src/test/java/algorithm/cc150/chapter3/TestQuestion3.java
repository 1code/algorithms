package algorithm.cc150.chapter3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high,
 * it might topple. 
 * Therefore, in real life, we would likely start a new stack when the previous stack
 * exceeds some threshold. Implement a data structure SetOfStacks that mimics this.
 * SetOfStacks should be composed of several stacks and should create a new stack once the
 * previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack 
 * (that is, pop() should return the same values as it would if there were just a single stack).
 * 
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
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
		question.push("g");	
		assertEquals("g", question.pop());		//	[[a b c] <- top [d e f] <- top [g] <- top] <- top
		assertEquals("c", question.popAt(0));	//	[[a b d] <- top [e f g] <- top] <- top
		assertEquals("d", question.popAt(0));	//	[[a b e] <- top [f g] <- top] <- top
		assertEquals("g", question.pop());		//	[[a b e] <- top [f] <- top] <- top
		question.push("h");										//	[[a b e] <- top [f h] <- top] <- top
		question.push("i");										//	[[a b e] <- top [f h i] <- top] <- top
		question.push("j");										//	[[a b e] <- top [f h i] <- top [j] <- top] <- top
		question.push("k");										//	[[a b e] <- top [f h i] <- top [j k] <- top] <- top
		assertEquals("i", question.popAt(1));	//	[[a b e] <- top [f h j] <- top [k] <- top] <- top
		assertEquals("k", question.pop());
	}

	@Override
	@Test
	public void testNegCase() {
	}
	
}
