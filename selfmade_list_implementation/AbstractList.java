package selfmade_list_implementation;

import java.util.Iterator;

public abstract class AbstractList<E> implements selfmade_list_implementation.List<E> {
	
	protected int size;
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(E element) {
		add(size(), element);
	}
	
	public void add(int idx, E element) {
		if (checkIdx(idx, true)) {
			addCorrectIdx(idx, element);
		}
	}
	
	protected abstract void addCorrectIdx(int idx, E element);
	
	protected boolean checkIdx(int idx, boolean forAdd) {
		if (idx < 0 || (forAdd ? idx > size() : idx > size() - 1)) {
			IndexOutOfBoundsException err = new IndexOutOfBoundsException();
			throw err;
		} else {
			return true;
		}
	}
	
	@Override
	public E set(int idx, E element) {
		E temp = get(idx);
		remove(idx);
		add(idx, element);
		return temp;
	}

	protected abstract int findIdx(Object o, boolean returnFirst);
	
	@Override
	public int indexOf(Object o) {
		if (!isEmpty()) {
			return findIdx(o,true);
		}
		return -1;
	}

	
	
	@Override
	public int lastIndexOf(Object o) {
		if (!isEmpty()) {
			return findIdx(o,false);
		}
		return -1;
	}

	
	
	@Override
	public boolean contains(Object o) {
		if (!isEmpty()) {
			return findIdx(o,true) != -1;
		}
		return false;
	}

	protected abstract List<E> createSubList(int fromIdx, int toIdx);
	
	@Override
	public List<E> subList(int fromIdx, int toIdx) {
		if (checkIdx(fromIdx, false) && checkIdx(toIdx, true)) {
			if (fromIdx < toIdx) {
				return createSubList(fromIdx, toIdx);
			} else {
				IndexOutOfBoundsException err = new IndexOutOfBoundsException("Starting index of sublist is lager or equals index of the last element!");
				throw err;
			}
		}
		return null;
	}

	@Override
	public void clear() {
		
		while (!isEmpty()) {
			remove(size() - 1);
		}
		
	}

	@Override
	public boolean addAll(List<? extends E> list) {
		return addAll(size(), list);
	}

	@Override
	public boolean addAll(int idx, selfmade_list_implementation.List<? extends E> list) {
		if (list.size() == 0) {
			return false;
		} else {
			if (checkIdx(idx, true)) {
				for (int i=0;i<list.size();i++){
					addCorrectIdx(idx, list.get(i));
					idx++;
				}
			}
		}
		return true;
	}
	
	public abstract String toString();
	
	@Override
	public boolean getAll(selfmade_list_implementation.List<? super E> stock) {
		stock = subList(0, size());
		System.out.println(stock.toString());
		return true;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return size;
	}
	
}
