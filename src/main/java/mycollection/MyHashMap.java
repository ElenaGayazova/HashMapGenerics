package mycollection;

import java.util.*;

public class MyHashMap<K, V> implements Map<K, V>  {

    private int size;
    private int base;
    private MyList<MyHashMapEntry<K,V>>[] data;

    public MyHashMap() {
        size=0;
        base=100;
        data = new MyList[base];
        Arrays.fill(data, null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size==0);
    }

    private int getIndex(K key) {
        if(key==null) return 0;
        int hash = key.hashCode();
        if(hash<0) hash=-hash;
        return hash % base;
    }

    private MyHashMapEntry<K,V> getEntryByKey(K key) {
        int idx = getIndex(key);
        if(data[idx]==null) return null;
        Iterator<MyHashMapEntry<K,V>> it = data[idx].iterator();
        while(it.hasNext()) {
            MyHashMapEntry entry = it.next();
            if(Common.equ(entry.getKey(), key)) return entry;
        }
        return null;
    }

    private MyHashMapEntry<K,V> getEntryByValue(V value) {
        for(int idx=0; idx<data.length; idx++) {
            if (data[idx] == null) continue;
            Iterator<MyHashMapEntry<K,V>> it = data[idx].iterator();
            while (it.hasNext()) {
                MyHashMapEntry<K,V> entry =  it.next();
                if (Common.equ(entry.getValue(), value)) return entry;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        MyHashMapEntry<K,V> entry = getEntryByKey((K)key);
        return (entry!=null);
    }

    @Override
    public boolean containsValue(Object value) {
        MyHashMapEntry<K,V> entry = getEntryByValue((V)value);
        return (entry!=null);
    }

    @Override
    public V get(Object key) {
        MyHashMapEntry<K,V> entry = getEntryByKey((K)key);
        return (entry!=null) ? entry.getValue() : null;
    }

    @Override
    public V put(K key, V value) {
        MyHashMapEntry<K,V> entry = getEntryByKey(key);
        V result = null;
        if(entry!=null) {
            result = entry.getValue();
            entry.setValue(value);
        } else {
            int idx = getIndex(key);
            entry = new MyHashMapEntry(key, value);
            if(data[idx]==null) data[idx] = new MyList<>();
            data[idx].add(entry);
            size++;
        }
        return result;
    }

    @Override
    public V remove(Object key) {
        MyHashMapEntry<K,V> entry = getEntryByKey((K)key);
        V result = null;
        if(entry!=null)  {
            result = entry.getValue();
            int idx = getIndex((K)key);
            data[idx].remove(entry);
            size--;
        }
        return result;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for(K key: m.keySet()) {
            put(key, m.get(key));
        }
    }

    @Override
    public void clear() {
        for(int i=0; i<data.length; i++) {
            if(data[i]!=null) data[i].clear();
        }
        Arrays.fill(data, null);
        size=0;
    }

    @Override
    public Set<K> keySet() {
        HashSet<K> keys = new HashSet<>();
        for(int i=0; i<data.length; i++) {
            if(data[i]==null) continue;
            for(MyHashMapEntry<K,V> entry : data[i]) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> list = new ArrayList<>();
        for(int i=0; i<data.length; i++) {
            if(data[i]==null) continue;
            for(MyHashMapEntry<K,V> entry : data[i]) {
                list.add(entry.getValue());
            }
        }
        return list;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        HashSet<Entry<K,V>> list = new HashSet<>();
        for(int i=0; i<data.length; i++) {
            if(data[i]==null) continue;
            for(MyHashMapEntry<K,V> entry : data[i]) {
                list.add(entry);
            }
        }
        return list;
    }

}
