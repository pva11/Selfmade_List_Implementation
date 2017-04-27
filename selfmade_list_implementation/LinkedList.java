package selfmade_list_implementation;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedList<E> extends AbstractList<E> implements List<E> {
	
	private Node<E> head;
	private Node<E> tail;
	
	public LinkedList() {
		head = tail = null;
		size = 0;
	}
	
	public Iterator<E> iterator() {
		return this.new Iter();
	}
	
	@Override
	protected void addCorrectIdx(int idx, E element) {
		if (size() == 0) {
			head = tail = new Node<E>(element, null, null);
		} else if (idx == size()) {
			Node<E> newNode = new Node<E>(element, null, tail);
			tail.next = newNode;
			tail = newNode;
		} else if (idx == 0) {
			Node <E>newNode = new Node<E>(element, head, null);
			head.prev = newNode;
			head = newNode;
		} else {
			Node<E> nd = find(idx);
			Node<E> newNode = new Node<E>(element, nd, nd.prev);
			nd.prev.next = newNode;
			nd.prev = newNode;
		}
		size++;
	}

	private Node<E> find(int idx){
		
		boolean fromTailToHead = (idx < size()/2) ? false : true;
		if (fromTailToHead) {
			Node<E> tempNode = tail;
			int temp_idx = size() - 1;
			while (temp_idx != idx) {
				tempNode = tempNode.prev;
				temp_idx--;
			}
			return tempNode;
		} else {
			Node<E> tempNode = head;
			int temp_idx = 0;
			while (temp_idx != idx) {
				tempNode = tempNode.next;
				temp_idx++;
			}
			return tempNode;
		}
				
	}
	
	@Override
	public E get(int idx) {
		if (checkIdx(idx, false)) {
			return find(idx).val;
		} else {
			return null;
		}
	}
	
	@Override
	public E set(int idx, E element) {
		if (checkIdx(idx, false)) {
			add(idx + 1, element);
			return remove(idx);
		} else {
			return null;
		}
	}

	@Override
	public E remove(int idx) {
		E tmp = get(idx);
		if (idx == size() - 1) {
			Node<E> tmpNode = tail.next;
			tail.next.prev = null;
			tail.next = null;
			tail = tmpNode;
		} else if (idx == 0) {
			Node<E> tmpNode = head.prev;
			head.prev.next = null;
			head.prev = null;
			head = tmpNode;
		} else {
			Node<E> nd = find(idx);
			nd.prev.next = nd.next;
			nd.next.prev = nd.prev;
			nd.next = null;
			nd.prev = null;
		}
		size--;
		return tmp;
	}

	@Override
	protected int findIdx(Object o, boolean returnFirst) {
		Node<E> nd = head;
		int idx = -1;
		int i = 0;
		while (nd != null) {
			if (nd.val.equals(o)) {
				if (returnFirst) {
					return i;
					} else {
						idx = i;
					};
			}
			i++;
			nd = nd.next;
		} 
		return idx;
	}

	@Override
	protected List<E> createSubList(int fromIdx, int toIdx) {
		List<E> subList = new LinkedList<E>();
		Node<E> nd = find(fromIdx);
		int i = fromIdx;
		do {
			subList.add(nd.val);
			nd = nd.next;
			i++;
		} while (i!=toIdx);
		return subList;
	}

	@Override
	public void clear() {
		super.clear();
		head = tail = null;
	}

	@Override
	public String toString() {
		StringBuilder st = new StringBuilder();
		st.append("[");
		Node<E> nd = tail;
		while (nd != null) {
			st.append(nd.val);
			if (nd!=head) {
				st.append(", ");
			}
			nd = nd.prev;
		}
		st.append("]");
		st.append(System.lineSeparator());
		st.append("[");
		nd = head;
		while (nd != null) {
			st.append(nd.val);
			if (nd!=tail) {
				st.append(", ");
			}
			nd = nd.next;
		}
		st.append("]");
		return st.toString();
	}
	
	private static class Node<E> {
		E val;
		Node<E> next;
		Node<E> prev;
		
		public Node(E val, Node<E> next, Node<E> prev) {
			this.val = val;
			this.next = next;
			this.prev = prev;
		}
	}
	
	public class Iter implements Iterator<E> {
		Node<E> nd = head;
		boolean checkNext = true;

		@Override
		public boolean hasNext() {
			return nd != null;
		}

		@Override
		public E next() {
			if (!this.hasNext()) {
				NoSuchElementException err = new NoSuchElementException();
				throw err;
			} else {
				E tmp = nd.val;
				nd = nd.next;
				checkNext = true;
				return tmp;
			}
		}

		@Override
		public void remove() {
			
			if (!checkNext) {
				IllegalStateException err = new IllegalStateException();
				throw err;
			} else if (size == 1) {
				head = tail = null;
			} else if (nd == head) {
				head.next.prev = null;
				head = head.next;
			} else if (nd == tail) {
				tail.prev.next = null;
				tail = tail.prev;
			} else {
				nd.prev.next = nd.next;
				nd.next.prev = nd.prev;
				nd.next = null;
				nd.prev = null;
			}
			checkNext = false;
			size--;
		}
		
		
		
//		new NoSuchElementException(); когда вызываешь некст не проверив hasNext()
		// new IllegalStateException() когда дважды ремув
	// на один некст может быть только один ремув
	// т.е. нельзя без вызова нектс 2 раза вызвать ремув
		
	}
	
}
