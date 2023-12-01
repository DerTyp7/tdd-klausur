package de.szut;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

public class MyArrayListTest {

    private MyArrayList list;

    @Before
    public void setUp() {
        list = new MyArrayList();
    }



    @Test
    public void add_ShouldReturnTrueAndIncreaseSize() {
        assertThat(list.size(), is(0));

        boolean added1 = list.add(5);
        assertThat(added1, is(true));
        assertThat(list.size(), is(1));
        assertThat(list.contains(5), is(true));

        boolean added2 = list.add(10);
        assertThat(added2, is(true));
        assertThat(list.size(), is(2));
        assertThat(list.contains(10), is(true));
    }

    @Test
    public void remove_ShouldRemoveElementAndDecreaseSize() {
        list.add(5);
        list.add(10);
        list.add(15);

        assertThat(list.size(), is(3));

        list.remove(1);

        assertThat(list.size(), is(2));
        assertThat(list.contains(5), is(true));
        assertThat(list.contains(10), is(false));
        assertThat(list.contains(15), is(true));
    }

    @Test
    public void remove_ShouldThrowExceptionForInvalidIndex() {
        list.add(5);

        assertThat(list.size(), is(1));

        try {
            list.remove(1);
            fail("Expected RuntimeException was not thrown");
        } catch (RuntimeException e) {
            assertThat(e.getMessage(), is("Dieser Index existiert nicht!"));
            assertThat(list.size(), is(1));
        }
    }

    @Test
    public void size_ShouldReturnZeroInitially() {
        assertThat(list.size(), is(0));
    }

    @Test
    public void size_ShouldBeZeroInitially() {

        assertThat(list.size(), is(0));
    }

    @Test
    public void size_ShouldIncreaseWhenElementAdded() {
        list.add(5);

        assertThat(list.size(), is(1));
    }

    @Test
    public void size_ShouldIncreaseProperlyWhenMultipleElementsAdded() {
        list.add(5);
        list.add(10);

        assertThat(list.size(), is(2));
    }

    @Test
    public void size_ShouldDecreaseWhenElementRemoved() {
        list.add(5);
        list.add(10);

        list.remove(0);

        assertThat(list.size(), is(1));
    }

    @Test
    public void size_ShouldNotDecreaseBelowZero() {
        list.add(5);

        list.remove(0);

        assertThat(list.size(), is(0));
    }


    @Test
    public void contains_ShouldReturnTrueIfElementPresent() {
        list.add(5);
        list.add(10);
        list.add(15);

        assertThat(list.contains(10), is(true));
    }

    @Test
    public void contains_ShouldReturnFalseIfElementNotPresent() {
        list.add(5);
        list.add(10);
        list.add(15);

        assertThat(list.contains(20), is(false));
    }

    @Test
    public void dynamicSize_ShouldIncreaseAsElementsAdded() {
        for (int i = 1; i <= 15; i++) {
            boolean added = list.add(i);
            assertThat(added, is(true));
        }

        assertThat(list.size(), is(15));

        for (int i = 1; i <= 15; i++) {
            assertThat(list.contains(i), is(true));
        }
    }
}
