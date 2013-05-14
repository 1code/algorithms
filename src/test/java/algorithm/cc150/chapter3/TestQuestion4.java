package algorithm.cc150.chapter3;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

import algorithm.TestBase;
import algorithm.cc150.chapter3.Question4.Action;

public class TestQuestion4 extends TestBase {

	private Question4 question;
	@Override
	protected void initInstance() {
		// TODO Auto-generated method stub
		question = new Question4();
	}

	@Override
	@Test
	public void testPosCase() {
		// TODO Auto-generated method stub
		List<Action> threeDisks = question.hanoi(3);
		Action[] expectedThreeDisks = new Action[] {
				new Action(1, 3), new Action(1, 2), new Action(3, 2), new Action(1, 3),
				new Action(2, 1), new Action(2, 3), new Action(1, 3)
		};
		assertArrayEquals(expectedThreeDisks, threeDisks.toArray());
	}

	@Override
	@Test
	public void testNegCase() {
		// TODO Auto-generated method stub
		
	}
	
}
