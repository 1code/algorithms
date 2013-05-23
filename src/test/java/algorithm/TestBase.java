package algorithm;

import org.junit.Before;
import org.junit.Test;


/**
 * TestBase defines the sketch of the test cases.
 *
 */
public abstract class TestBase{
	
	@Before
	public void beforeTestCase() {
		initInstance();
	}

	protected abstract void initInstance();
	
	@Test
	public abstract void testPosCase();
	
	@Test
	public abstract void testNegCase();
}
