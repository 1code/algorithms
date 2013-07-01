package algorithm.cc150.chapter9;

/**
 *	A magic index in an array A[0...n-1] is defined to be an index 
 *	such that A[i] = i. Given a sorted array, write a method to 
 *	find a magic index, if one exists, in array A.
 *
 * 	FOLLOW UP
 * 	What if the values are not distinct?
 *
 */
public class Question3 {
	
	/**
	 * Return the index of the array that is the magic index.
	 * If there are multiple, return the first one.
	 * If there is none, return -1.
	 * 
	 * @param array
	 * @return
	 */
	public int findMagicIndex(int[] array) {
		//	write implement here
		
		for (int i = 0; i < array.length; ++i) {
			if (array[i] == i) {
				return i;
			}
		}

		return -1;
	}

}
