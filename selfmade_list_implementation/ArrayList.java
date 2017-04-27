package selfmade_list_implementation;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> extends AbstractList<E> implements List<E> {
	
	private E[]	data;

	private static final int INITIAL_CAPACITY = 10;
	
	public ArrayList() {
		this(INITIAL_CAPACITY);
	}
	
	public ArrayList(int capacity) {
		data = (E[]) new Object[capacity];
	}
	
	@Override
	protected void addCorrectIdx(int idx, E element) {
		
		checkArrayCapacity();
		
		System.arraycopy(data, idx, data, idx + 1, size() - idx);
		data[idx] = element;
		size++;
	}
	
	private void checkArrayCapacity() {
		if (data.length == size()) {
			moreLengthForArray();
		}
	}
	
	private void moreLengthForArray() {
		E[] tmp = (E[]) new Object[data.length*3/2 + 1];
		System.arraycopy(data, 0, tmp, 0, data.length);
		data = tmp;
	}

	@Override
	public E get(int idx) {
		if (checkIdx(idx, false)) {
			return data[idx];
		} else {
			return null;
		}
	}

	@Override
	public E remove(int idx) {
		E tmp = get(idx);
		System.arraycopy(data, idx + 1, data, idx, data.length - idx - 1);
		size--;
		data[size] = null;
		return tmp;
	}

	@Override
	protected int findIdx(Object o, boolean returnFirst) {
		int idx = -1;
		if (o == null) {
			for (int i=0;i<size();i++){
				if (data[i]==o) {
					if (returnFirst) {
						return i;
					} else {
						idx = i;
					}
				}
			}
		} else {
			for (int i=0;i<size();i++){
				if (o.equals(data[i])) {
					if (returnFirst) {
						return i;
					} else {
						idx = i;
					}
				}
			}
		}
		
		return idx;
	}

	@Override
	protected List<E> createSubList(int fromIdx, int toIdx) {
		ArrayList<E> subList = new ArrayList<E>(toIdx - fromIdx);
//		data.clone();
		System.arraycopy(data, fromIdx, subList.data, 0, toIdx - fromIdx);
		subList.size = toIdx - fromIdx;
		return subList;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size(); i++) {
			sb.append(data[i]);
			if (i != size() - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		
		return sb.toString();
	}

	@Override
	public void clear() {
		super.clear();
		data = (E[]) new Object[INITIAL_CAPACITY];
	}
	
	@Override
	public Iterator<E> iterator() {
		return this.new MyIter2();
	}

	private class MyIter2 implements Iterator<E> {

		int idx;
		boolean checkNext = true;
		
		@Override
		public boolean hasNext() {
			return idx < size;
		}

		@Override
		public E next() {
			if (!this.hasNext()) {
				NoSuchElementException err = new NoSuchElementException();
				throw err;
			} else {
				checkNext = true;
				return data[idx++];				
			}
		}

		@Override
		public void remove() {
			
//			ÈËÈ ÂÛÇÂÀÒÜ remove() èç ArrayList
			ArrayList.this.remove(--idx);
			
//			if (!checkNext) {
//				IllegalStateException err = new IllegalStateException();
//				throw err;
//			} else {
//				checkNext = false;
//				System.arraycopy(data, idx + 1, data, idx, size - idx - 1);
//				data[size] = null;
//				size--;
//			}
			
		}
		
	}
	
	private static class MyIter<E> implements Iterator<E> {

		int idx;
		ArrayList<E> list;
		
		public MyIter(ArrayList<E> list) {
			this.list = list;
		}
		
		@Override
		public boolean hasNext() {
			return idx < list.size;
		}

		@Override
		public E next() {
			return list.data[idx++];
		}
		
	}
	
}
