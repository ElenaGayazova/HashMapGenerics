package mycollection;


import java.util.*;

public class MyList<V> implements List<V> {

    class MyListIterator<V> implements Iterator<V> {

        MyListEntry<V> item;

        public MyListIterator(MyListEntry<V> item) {
            this.item = item;
        }

        @Override
        public boolean hasNext() {
            return (item!=null);
        }

        @Override
        public V next() {
            if(item==null) return null;
            V result = item.getValue();
            item = item.getNext();
            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    MyListEntry<V> head;
    int         size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (head==null);
    }

    @Override
    public boolean contains(Object o) {
        MyListEntry<V> item = head;
        while(item!=null) {
            if(Common.equ(o, item.value)) return true;
            item = item.next;
        }
        return false;
    }

    @Override
    public Iterator<V> iterator() {
        return new MyListIterator<V>(head);
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        Arrays.fill(result, null);

        MyListEntry<V> item = head;
        for(int i=0; i<size && item!=null; i++, item=item.getNext()) {
            result[i] = item.getValue();
        }
        return result;
    }

    @Override
    public <V> V[] toArray(V[] a) {
        if(a==null) throw new NullPointerException();
        V[] res = (a.length>=size) ? a : ((V[])Arrays.copyOf(a,size,a.getClass()));
        MyListEntry item = head;
        for(int i=0; i<size; i++) {
            res[i] = (V)item.getValue();
            item=item.getNext();
        }
        return res;
    }

    @Override
    public boolean add(V o) {
        if(head==null) {
            head = new MyListEntry<>(o);
            head.setPrev(head); // pointer to last item
        } else {
            MyListEntry<V> last = head.getPrev();
            MyListEntry<V> item = new MyListEntry<>(o, last, null);
            last.setNext(item);
            head.setPrev(item);
        }
        size++;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("containsAll");
    }

    @Override
    public boolean addAll(Collection<? extends V> c) {
        throw new UnsupportedOperationException("addAll");
    }

    @Override
    public boolean addAll(int index, Collection<? extends V> c) {
        throw new UnsupportedOperationException("addAll");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("removeAll");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("retainAll");
    }

    private void removeEntry(MyListEntry<V> item) {
        MyListEntry<V> prev = item.getPrev();
        MyListEntry<V> next = item.getNext();

        if(next!=null) next.setPrev(item.getPrev());
        if(prev!=null) prev.setNext(item.getNext());

        if(item==head) { // first item
            head = next;
            prev.setNext(null); // restore end pointer
        } else if(item==head.getPrev()) { //last item
            prev.setNext(null); // restore end pointer
        }
        size--;
    }

    @Override
    public boolean remove(Object o) {
        MyListEntry<V> item = head;
        while(item!=null) {
            if(Common.equ(o, item.value)) break;
            item = item.next;
        }

        if(item==null) return false;

        removeEntry(item);

        return true;
    }

    @Override
    public void clear() {
        head=null;
        size=0;
    }

    private MyListEntry<V> getEntryAt(int index) {
        if(index<0 || size<index+1) throw new IndexOutOfBoundsException();
        MyListEntry<V> item = head;
        for(int i=0; i<index; i++) {
            item = item.getNext();
        }
        return item;
    }

    @Override
    public V get(int index) {
        MyListEntry<V> item = getEntryAt(index);
        return item.getValue();
    }

    @Override
    public V set(int index, V element) {
        MyListEntry<V> item = getEntryAt(index);
        V result = item.getValue();
        item.setValue(element);
        return result;
    }

    @Override
    public void add(int index, V element) {
        if(index<0 || index>size) throw new IndexOutOfBoundsException();
        if(index==size) add(element);

        MyListEntry<V> next = getEntryAt(index);
        MyListEntry<V> prev = next.getPrev();

        MyListEntry<V> item = new MyListEntry<V>(element, prev, next);
        if(prev.getNext()!=null ) prev.setNext(item);
        if(next!=null) next.setPrev(item);
    }

    @Override
    public V remove(int index) {
        MyListEntry<V> item = getEntryAt(index);
        removeEntry(item);
        return item.getValue();
    }

    @Override
    public ListIterator<V> listIterator() {
        throw new UnsupportedOperationException("listIterator");
    }

    @Override
    public ListIterator<V> listIterator(int index) {
        throw new UnsupportedOperationException("listIterator");
    }

    @Override
    public List<V> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("subList");
    }

    @Override
    public int indexOf(Object o) {
        MyListEntry<V> item = head;
        for(int i=0; i<size && item!=null; i++) {
            if(Common.equ(o, item.value)) return i;
            item = item.getNext();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        MyListEntry<V> item = head.getPrev(); // last item
        for(int i=size-1; i>00; i--) {
            if(Common.equ(o, item.value)) return i;
            item = item.getPrev();
        }
        return -1;
    }

}
