package algorithm.cc150.chapter3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.cc150.chapter3.Question1;

public class TestQuestion1 extends TestBase {

	private Question1 question;
	
	@Override
	protected void initInstance() {
		// TODO Auto-generated method stub
		question = new Question1();
	}

	@Override
	@Test
	public void testPosCase() {
		// TODO Auto-generated method stub
		question.push(0, 1);	//	push 1 to first stack
		assertEquals(1, question.size(0));
		assertEquals(1, question.top(0));
		question.push(0, 2);	//	push 2 to first stack
		assertEquals(2, question.size(0));
		assertEquals(2, question.top(0));
		assertEquals(2, question.pop(0));
		
		question.push(1, 10);
		assertEquals(1, question.size(1));
		question.push(1, 20);
		assertEquals(20, question.top(1));
		assertEquals(2, question.size(1));
		question.push(1, 30);
		assertEquals(3, question.size(1));
		assertEquals(30, question.top(1));
		assertEquals(30, question.pop(1));
		assertEquals(2, question.size(1));
		assertEquals(20, question.pop(1));
		assertEquals(1, question.size(1));
		
		question.push(2, 100);
		assertEquals(1, question.size(2));
		question.push(2, 200);
		assertEquals(2, question.size(2));
		question.push(2, 300);
		assertEquals(3, question.size(2));
		question.push(2, 400);
		assertEquals(4, question.size(2));
	}

	@Override
	@Test
	public void testNegCase() {
		// TODO Auto-generated method stub
		
	}

}
