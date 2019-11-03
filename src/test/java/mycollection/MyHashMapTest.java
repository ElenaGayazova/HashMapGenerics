package mycollection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class MyHashMapTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    public void size(Map<String, String > map) {
        assertEquals(0, map.size());

        map.put("first","value1");
        assertEquals(1, map.size());
    }

    @Test
    public void size() {
        MyHashMap<String, String> map = new MyHashMap<>();
        size(map);
        // HashMap
        HashMap<String, String> hmap = new HashMap<>();
        size(hmap);
    }

    public void isEmpty(Map<String, String > map) {
        assertEquals(true, map.isEmpty());

        map.put("first","value1");
        assertEquals(false, map.isEmpty());
    }

    @Test
    public void isEmpty() {
        MyHashMap<String, String> map = new MyHashMap<>();
        isEmpty(map);
        // HashMap
        HashMap<String, String> hmap = new HashMap<>();
        isEmpty(hmap);
    }

    public void containsKey(Map<String, String > map) {
        map.put("first","value1");

        assertEquals(true, map.containsKey("first"));
        assertEquals(false, map.containsKey("second"));

        map.clear();
        assertEquals(false, map.containsKey("first"));
    }
    @Test
    public void containsKey() {
        MyHashMap<String, String> map = new MyHashMap<>();
        containsKey(map);
        // HashMap
        HashMap<String, String> hmap = new HashMap<>();
        containsKey(hmap);
    }

    public void containsValue(Map<String, String > map) {
        map.put("first","value1");

        assertEquals(true, map.containsValue("value1"));
        assertEquals(false, map.containsValue("value2"));

        map.clear();
        assertEquals(false, map.containsValue("value1"));
    }

    @Test
    public void containsValue() {
        MyHashMap<String, String> map = new MyHashMap<>();
        containsValue(map);
        // HashMap
        HashMap<String, String> hmap = new HashMap<>();
        containsValue(hmap);
    }

    public void get(Map<String, String > map) {
        map.put("first","value1");

        assertEquals("value1", map.get("first"));
        assertEquals(null, map.get("second"));
    }

    @Test
    public void get() {
        MyHashMap<String, String> map = new MyHashMap<>();
        get(map);
        // HashMap
        HashMap<String, String> hmap = new HashMap<>();
        get(hmap);
    }

    public void put(Map<String, String > map) {
        assertEquals(null, map.get("first"));
        map.put("first","value1");
        assertEquals("value1", map.get("first"));
        map.put("first","value2");
        assertEquals("value2", map.get("first"));

        assertEquals(1, map.size());
    }

    @Test
    public void put() {
        MyHashMap<String, String> map = new MyHashMap<>();
        put(map);
        // HashMap
        HashMap<String, String> hmap = new HashMap<>();
        put(hmap);
    }

    public void remove(Map<String, String > map) {
        assertEquals(null, map.get("first"));
        map.put("first","value1");
        assertEquals("value1", map.get("first"));
        map.remove("first");
        assertEquals(null, map.get("first"));

        assertEquals(0, map.size());
    }

    @Test
    public void remove() {
        MyHashMap<String, String> map = new MyHashMap<>();
        remove(map);
        // HashMap
        HashMap<String, String> hmap = new HashMap<>();
        remove(hmap);
    }

    public void clear(Map<String, String > map) {
        map.put("first","value1");

        assertEquals(1, map.size());

        map.clear();

        assertEquals(0, map.size());
    }

    @Test
    public void clear() {
        MyHashMap<String, String> map = new MyHashMap<>();
        clear(map);
        // HashMap
        HashMap<String, String> hmap = new HashMap<>();
        clear(hmap);
    }

    public void putAll(Map<String, String > map) {
        HashMap<String, String> data = new HashMap<>();
        data.put("1st","value-1");
        data.put("2nd","value-2");

        map.put("first","value1");

        map.putAll(data);

        assertEquals(3, map.size());
        assertEquals("value-2", map.get("2nd"));
    }

    @Test
    public void putAll() {
        MyHashMap<String, String> map = new MyHashMap<>();
        putAll(map);
        // HashMap
        HashMap<String, String> hmap = new HashMap<>();
        putAll(hmap);
    }

    public void keySet(Map<String, String > map) {
        map.put("first","value1");
        map.put("second","value2");

        Set<String> keys = map.keySet();

        assertEquals(2, keys.size());
        assertEquals(true, keys.contains("first"));
    }

    @Test
    public void keySet() {
        MyHashMap<String, String> map = new MyHashMap<>();
        keySet(map);
        // HashMap
        HashMap<String, String> hmap = new HashMap<>();
        keySet(hmap);
    }

    public void values(Map<String, String > map) {
        map.put("first","value1");
        map.put("second","value2");

        Collection<String> values = map.values();
        assertEquals(2, values.size());
        assertEquals(true, values.contains("value1"));
    }

    @Test
    public void values() {
        MyHashMap<String, String> map = new MyHashMap<>();
        values(map);
        // HashMap
        HashMap<String, String> hmap = new HashMap<>();
        values(hmap);
    }

    public void entrySet(Map<String, String > map) {
        map.put("first","value1");
        map.put("second","value2");

        Set<Map.Entry<String,String>> entries = map.entrySet();
        assertEquals(2, entries.size());
    }

    @Test
    public void entrySet() {
        MyHashMap<String, String> map = new MyHashMap<>();
        entrySet(map);
        // HashMap
        HashMap<String, String> hmap = new HashMap<>();
        entrySet(hmap);
    }

}