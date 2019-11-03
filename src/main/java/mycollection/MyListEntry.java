package mycollection;

public class MyListEntry<V> {
    V value;
    MyListEntry<V> prev, next;

    public MyListEntry(V value) {
        this.value = value;
    }

    public MyListEntry(V value, MyListEntry<V> prev, MyListEntry<V> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public MyListEntry<V> getPrev() {
        return prev;
    }

    public void setPrev(MyListEntry<V> prev) {
        this.prev = prev;
    }

    public MyListEntry<V> getNext() {
        return next;
    }

    public void setNext(MyListEntry<V> next) {
        this.next = next;
    }

}
