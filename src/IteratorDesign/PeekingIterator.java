package IteratorDesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {

    private Integer nextElement;
    private Iterator<Integer> customIterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        customIterator = iterator;
        if (customIterator.hasNext()) {
            nextElement = customIterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer temp = nextElement;
        nextElement = customIterator.hasNext() ? customIterator.next() : null;
        return temp;
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        PeekingIterator pk = new PeekingIterator(list.iterator());
        System.out.println(pk.next());
        System.out.println(pk.peek());
        System.out.println(pk.next());
        System.out.println(pk.peek());
        System.out.println(pk.peek());
        System.out.println(pk.next());

    }
}