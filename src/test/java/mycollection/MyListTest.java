package mycollection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class MyListTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void size() {
        MyList list = new MyList();
        assertEquals(0, list.size);

        list.add("first");
        assertEquals(1, list.size);
    }

    @Test
    public void isEmpty() {
        MyList list = new MyList();
        assertEquals(true, list.isEmpty());
        list.add("first");
        assertEquals(false, list.isEmpty());
    }

    @Test
    public void contains() {
        MyList list = new MyList();
        list.add("first");
        assertEquals(true, list.contains("first"));
        assertEquals(false, list.contains("second"));
    }

    @Test
    public void iterator() {
        MyList list = new MyList();
        list.add("first");
        list.add("second");

        Iterator it = list.iterator();
        assertNotNull(it);

        assertEquals(true, it.hasNext());
        assertEquals("first", it.next());

        assertEquals(true, it.hasNext());
        assertEquals("second", it.next());

        assertEquals(false, it.hasNext());
    }

    @Test
    public void toArray() {
        MyList list = new MyList();
        list.add("first");
        list.add("second");

        Object[] result = list.toArray();
        assertNotNull(result);

        assertEquals(2, result.length);

        assertEquals("first", result[0]);
        assertEquals("second", result[1]);
    }

    @Test
    public void add() {
        MyList list = new MyList();

        assertEquals(false, list.contains("second"));

        list.add("first");
        list.add("second");

        assertEquals("second", list.get(1));
    }

    @Test
    public void remove() {
        MyList list = new MyList();

        list.add("first");
        list.add("second");

        assertEquals(true, list.contains("first"));
        assertEquals(true, list.contains("second"));
        list.remove("second");
        assertEquals(1, list.size());
        assertEquals(true, list.contains("first"));
        assertEquals(false, list.contains("second"));
        list.remove(0);
        assertEquals(false, list.contains("first"));
        assertEquals(false, list.contains("second"));

        try{
            list.remove(2);
            fail("exception is expected");
        }catch(IndexOutOfBoundsException npe) {
            assertEquals(true, npe instanceof IndexOutOfBoundsException);
        }

    }

    @Test
    public void clear() {
        MyList list = new MyList();

        list.add("first");
        list.add("second");

        assertEquals(2, list.size());

        list.clear();

        assertEquals(0, list.size());
    }

    @Test
    public void get() {
        MyList list = new MyList();

        list.add("first");
        list.add("second");

        assertEquals("second", list.get(1));

        try{
            list.get(2);
            fail("exception is expected");
        }catch(IndexOutOfBoundsException npe) {
            assertEquals(true, npe instanceof IndexOutOfBoundsException);
        }

    }

    @Test
    public void set() {
        MyList list = new MyList();

        list.add("first");
        list.add("second");

        assertEquals("second", list.get(1));

        list.set(1, "new value");

        assertEquals("new value", list.get(1));

        try{
            list.set(2, "value");
            fail("exception is expected");
        }catch(IndexOutOfBoundsException npe) {
            assertEquals(true, npe instanceof IndexOutOfBoundsException);
        }
    }

    @Test
    public void indexOf() {
        MyList list = new MyList();

        list.add("first");
        list.add("second");

        assertEquals(1, list.indexOf("second"));
        assertEquals(-1, list.indexOf("third"));
    }

    @Test
    public void lastIndexOf() {
        MyList list = new MyList();

        list.add("first");
        list.add("second");
        list.add("first");

        assertEquals(2, list.lastIndexOf("first"));
        assertEquals(-1, list.lastIndexOf("third"));
    }


}