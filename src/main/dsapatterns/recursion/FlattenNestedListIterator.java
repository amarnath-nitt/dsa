package main.dsapatterns.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class NestedInteger {
    private Integer value;
    private List<NestedInteger> list;

    public NestedInteger(Integer value) {
        this.value = value;
        this.list = null;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.value = null;
        this.list = list;
    }

    public boolean isInteger() {
        return value != null;
    }

    public Integer getInteger() {
        return value;
    }

    public List<NestedInteger> getList() {
        return list;
    }
}

class NestedIteratorViaList{
    private List<Integer> values;
    public NestedIteratorViaList(List<NestedInteger> list) {
        this.values = new ArrayList<>();
        fill(list);
    }
    private void fill(List<NestedInteger> nestedList){
        for(NestedInteger nested: nestedList){
            if(nested.isInteger()){
                values.add(nested.getInteger());
            } else {
                fill(nested.getList());
            }
        }
    }

    public Integer next() {
        int val = values.get(0);
        values.remove(0);
        return val;
    }
    public boolean hasNext() {
        return !values.isEmpty();
    }
}
/**
 * NestedIterator class that implements an iterator to flatten a nested list of integers.
 * It uses a stack to keep track of the current position in the nested structure.
 * The iterator provides methods to check for the next integer and retrieve it.
 * The implementation ensures that the nested structure is traversed in a depth-first manner.
 * The hasNext() method checks if there are more integers to return, and the next() method retrieves the next integer in the flattened structure.
 * This class is useful for scenarios where a nested list of integers needs to be processed in a linear fashion, such as in algorithms that require sequential access to the integers.
 * The iterator handles both single integers and nested lists, allowing for flexible traversal of complex nested structures.
 * The implementation is efficient and avoids unnecessary recursion by using an explicit stack to manage the traversal state.
 * The NestedIterator class can be used in various applications, including parsing nested data structures, implementing algorithms that require flattening of nested lists, and providing a convenient interface for accessing integers in a nested format.
 * The class is designed to be easy to use, with clear methods for checking for the next integer and retrieving it, making it suitable for integration into larger systems that require processing of nested integer lists.
 * Overall, the NestedIterator class provides a robust and efficient solution for flattening nested lists of integers, enabling developers to work with complex data structures in a straightforward manner.
 * */
class NestedIterator implements Iterator<Integer> {
    private final Deque<Iterator<NestedInteger>> stack = new ArrayDeque<>();
    private Integer nextValue = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int value = nextValue;
        nextValue = null;
        return value;
    }

    @Override
    public boolean hasNext() {
        if (nextValue != null) {
            return true;
        }

        while (!stack.isEmpty()) {
            Iterator<NestedInteger> iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                continue;
            }

            NestedInteger item = iterator.next();
            if (item.isInteger()) {
                nextValue = item.getInteger();
                return true;
            }
            stack.push(item.getList().iterator());
        }

        return false;
    }
}
public class FlattenNestedListIterator {
    public static void main(String[] args) {
        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new NestedInteger(1));
        List<NestedInteger> sublist1 = new ArrayList<>();
        sublist1.add(new NestedInteger(2));
        sublist1.add(new NestedInteger(3));
        nestedList.add(new NestedInteger(sublist1));
        nestedList.add(new NestedInteger(4));

        NestedIterator iterator = new NestedIterator(nestedList);
        System.out.println("Flattened list: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
