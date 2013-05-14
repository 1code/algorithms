package algorithm.cc150.chapter3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Write a program to sort a stack in ascending order (with biggest items on top).
 * You may use additional stacks to hold items, but you may not copy the elements into
 * any other data structure (such as an array). The stack supports the following operations:
 * push, pop, peek, and isEmpty.
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
		//	test basic operation of stack
		assertTrue(question.isEmpty());
		question.push(1);
		assertFalse(question.isEmpty());
		question.push(2);
		question.push(3);
		assertEquals(3, question.peek());
		assertEquals(3, question.pop());
		while (!question.isEmpty()) {
			question.pop();
		}
		
		//	test the sort function
		Random rnd = new Random();
		int size = 100;
		for (int i = 0; i < size; ++i) {
			question.push(rnd.nextInt());
		}
		question.sort();
		int last = question.pop();
		for (int i = 0; i < size - 1; ++i) {
			assertTrue(last > question.peek());
			last = question.pop();
		}
	}

	@Override
	@Test
	public void testNegCase() {
		
	}

}
