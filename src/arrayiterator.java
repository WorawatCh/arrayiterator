import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provide an iterator in array without knowing the structure of the array.
 * @author Worawat Chueajedton
 *
 */
public class arrayiterator<T> implements Iterator<T> {
	/** attribute for the array we want to iterate over */
	private T[] array;
	private int cursor;
	private boolean check;

	/***
	 * Initialize a new array iterator with the array to process.
	 * 
	 * @param array
	 *            is the array to iterate over
	 */
	public arrayiterator(T[] array) {
		this.array = array;
		this.cursor = 0;
		this.check = false;
	}

	/**
	 * Return the next non-null element from array, if any.
	 * 
	 * @return the next non-null element in the array.
	 * @throw NoSuchElementException if there are no more elements to return.
	 */
	@Override
	public T next() {
		if (hasNext()) {
			T next = array[cursor];
			cursor++;
			this.check = true;
			return array[cursor];
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * return true if next() can return another non-null array element.
	 * return false if no more elements.
	 */
	@Override
	public boolean hasNext() {
		for (int k = cursor; k < array.length; k++) {
			if (array[k] != null) {
				cursor = k;
				return true;
			}
		}
		return false;
	}

	/**
	 * Remove most recent element returned by next() from the array by setting
	 * it to null.
	 */
	public void remove() {
		if (this.check != false) {
			array[cursor - 1] = null;
			this.check = false;
		} else {
			throw new IllegalStateException();
		}
	}

}
