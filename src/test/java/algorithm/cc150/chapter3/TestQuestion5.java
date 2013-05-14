package algorithm.cc150.chapter3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Implement a class which implements a queue using two stacks.
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
		assertTrue(question.empty());
		int[] randomSequence = new int[10];
		Random rnd = new Random();
		for (int i = 0; i < randomSequence.length; ++i) {
			randomSequence[i] = rnd.nextInt();
			question.enqueue(randomSequence[i]);
		}
		
		for (int i = 0; i < randomSequence.length; ++i) {
			assertEquals(randomSequence.length - i, question.size());
			assertEquals(randomSequence[i], question.dequeue());
		}
		assertTrue(question.empty());
		
		question.enqueue(10);
		assertFalse(question.empty());
		assertEquals(1, question.size());
		question.enqueue(50);
		assertEquals(10, question.dequeue());
		question.enqueue(20);
		assertEquals(2, question.size());
	}

	@Override
	@Test
	public void testNegCase() {
	}

}
