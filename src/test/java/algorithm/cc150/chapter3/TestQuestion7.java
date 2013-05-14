package algorithm.cc150.chapter3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algorithm.TestBase;
import algorithm.cc150.chapter3.Question7.Animal;
import algorithm.cc150.chapter3.Question7.Cat;
import algorithm.cc150.chapter3.Question7.Dog;

/**
 * An animal shelter holds only dogs and cats, and operates on a strictly
 * "first in, first out" basis. People must adopt either the "oldest" 
 * (based on arrival time) of all animals at the shelter, 
 * or they can select whether they would prefer a dog or a cat
 * (and will receive the oldest animal of that type).
 * They cannot select which specific animal they would like.
 * Create the data structures to maintain this system and implement operations
 * such as enqueue, dequeueAny, dequeueDog and dequeueCat.
 * You may use the built-in LinkedList data structure.
 *
 */
public class TestQuestion7 extends TestBase {

	private Question7 question;
	@Override
	protected void initInstance() {
		question = new Question7();
	}

	@Override
	@Test
	public void testPosCase() {
		question.enqueue(new Cat(1));
		question.enqueue(new Dog(2));
		question.enqueue(new Dog(3));
		question.enqueue(new Dog(4));
		question.enqueue(new Cat(5));
		Animal animal = question.dequeueDog();
		assertTrue(animal instanceof Dog);
		assertEquals(2, animal.id);
		animal = question.dequeueDog();
		assertEquals(3, animal.id);
		animal = question.dequeueAny();
		assertTrue(animal instanceof Cat);
		assertEquals(1, animal.id);
		animal = question.dequeueCat();
		assertTrue(animal instanceof Cat);
		assertEquals(5, animal.id);
		question.enqueue(new Cat(6));
		animal = question.dequeueCat();
		assertTrue(animal instanceof Cat);
		assertEquals(6, animal.id);
	}

	@Override
	@Test
	public void testNegCase() {
		
	}
	
}
