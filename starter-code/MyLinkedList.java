
public class MyLinkedList<T>{

	private Node<T> head;
	private int size = 0;

	public int getSize() {
		return size;
	}

	public boolean remove(int index) {
        if(index < 0 || index > size) {
            return false;
        }
        Node<T> current = head;

        if(head != null) {
            while(index > 0) {
                if(current.getNext() == null) {
                    return false;
                }
                current = current.getNext();
                index--;
            }
            current.setNext(current.getNext().getNext());
            size--;
            return true;
        }
        return false;
	}

	public T get(int index) {
        if(index < 0 || index > size) {
            return null;
        }

        Node<T> current = head;

        if(head != null) {
            current = current.getNext();
            for(int i=0;i<index;i++) {
                if(current.getNext() == null) {
                    return null;
                }
                current = current.getNext();
            }
            return current.getData();
        }
        return null;
	}

	public void add(T obj) {
		if(head == null) {
            head = new Node<>(obj);
        }

        Node<T> added = new Node<>(obj);
        Node<T> current = head;

        if(current != null) {
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(added);
        }
        size++;
	}

	public void reverseList() {
        Node<T> node = head;
        Node<T> last = null;
        Node<T> current = node;
        Node<T> next;
        while(current != null) {
            next = current.getNext();
            current.next = last;
            last = current;
            current = next;
        }
        node = last;
        head = node;
    }

	//The methods below are bonus

//	public void add(int index, T obj){
//
//	}

//	@Override
//	public Iterator<T> iterator() {
//		// TODO Auto-generated method stub
//		return new MyIterator<T>(head);
//	}
//
//	private class MyIterator<T> implements Iterator<T> {
//
//		private Node<T> node;
//
//		public MyIterator(Node<T> node) {
//			//to-do
//		}
//		@Override
//		public boolean hasNext() {
//			//to-do
//		}
//
//		@Override
//		public T next() {
//			//to-do
//		}
//
//		@Override
//		public void remove() {
//
//		}
//
//	}
}
