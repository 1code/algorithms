package algorithm.cc150.chapter3;

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
public class Question7 {
	
	public static abstract class Animal {
		public int id;
		
		public Animal(int id) {
			this.id = id;
		}
	}
	
	public static class Dog extends Animal {
		public Dog(int id) {
			super(id);
		}
	}
	
	public static class Cat extends Animal {
		public Cat(int id) {
			super(id);
		}
	}
	
	public void enqueue(Animal animal) {
		//	write implementation here
	}
	
	public Animal dequeueDog() {
		//	write implementation here
		return null;
	}
	
	public Animal dequeueCat() {
		//	write implementation here
		return null;
	}
	
	public Animal dequeueAny() {
		//	write implementation here
		return null;
	}

}
