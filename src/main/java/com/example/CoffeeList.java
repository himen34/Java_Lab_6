package com.example;
import java.util.*;

/**
 * Custom list implementation for managing a collection of Coffee objects.
 * <p>
 * This collection allows for storing and manipulating coffee objects, supporting
 * all methods specified in the List interface. The internal structure uses an
 * array with an initial capacity of 15 elements, which grows by 30% whenever the
 * list reaches capacity.
 * </p>
 */
public class CoffeeList implements List<Coffee> {
    private Coffee[] elements;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 15;
    private static final double GROWTH_FACTOR = 1.3;

    /**
     * Default constructor that initializes the CoffeeList with an initial capacity.
     */
    public CoffeeList() {
        this.elements = new Coffee[INITIAL_CAPACITY];
    }

    /**
     * Constructor that initializes the CoffeeList with a single Coffee object.
     *
     * @param coffee A Coffee object to add to the collection upon initialization.
     */
    public CoffeeList(Coffee coffee) {
        this();
        if (coffee == null) throw new NullPointerException("Coffee cannot be null.");
        add(coffee);
    }

    /**
     * Constructor that initializes the CoffeeList with a collection of Coffee objects.
     *
     * @param coffees A collection of Coffee objects to add to the CoffeeList.
     */
    public CoffeeList(Collection<? extends Coffee> coffees) {
        this();
        if (coffees == null) throw new NullPointerException("Collection of coffees cannot be null.");
        addAll(coffees);
    }

    /**
     * Ensures there is sufficient capacity in the internal array.
     * If the current size reaches the array's capacity, the array size is increased
     * by 30% of its current size.
     */
    private void ensureCapacity() {
        if (size >= elements.length) {
            int newCapacity = (int) (elements.length * GROWTH_FACTOR);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    /**
     * Returns the current number of elements in the CoffeeList.
     *
     * @return the number of elements in this list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the CoffeeList is empty.
     *
     * @return true if the list contains no elements, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the CoffeeList contains a specific Coffee object.
     *
     * @param o the object to check for containment.
     * @return true if the list contains the specified element, false otherwise.
     */
    @Override
    public boolean contains(Object o) {
        if (o == null) throw new NullPointerException("The checked parameter cannot be null.");
        return indexOf(o) >= 0;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the Coffee objects in the CoffeeList.
     */
    @Override
    public Iterator<Coffee> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public Coffee next() {
                if (!hasNext()) throw new NoSuchElementException();
                return elements[currentIndex++];
            }
        };
    }

    /**
     * Returns an array containing all elements in this list in proper sequence.
     *
     * @return an array containing all elements in the CoffeeList.
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    /**
     * Returns an array containing all elements in this list in proper sequence; 
     * the runtime type of the returned array is that of the specified array.
     *
     * @param a the array into which the elements of the list are to be stored, if it is big enough.
     * @return an array containing the elements of this list.
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(elements, size, a.getClass());
        }
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    /**
     * Adds a new Coffee object to the CoffeeList.
     *
     * @param coffee the Coffee object to be added.
     * @return true (as specified by Collection.add).
     */
    @Override
    public boolean add(Coffee coffee) {
        if (coffee == null) throw new NullPointerException("Coffee cannot be null.");
        ensureCapacity();
        elements[size++] = coffee;
        return true;
    }

    /**
     * Removes a specific object from the CoffeeList if it exists.
     *
     * @param o the object to be removed.
     * @return true if the list contained the specified element, false otherwise.
     */
    @Override
    public boolean remove(Object o) {
        if (o == null) return false;
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }
    /**
     * Checks if the CoffeeList contains all elements in the specified collection.
     *
     * @param c the collection to check for containment in this list.
     * @return true if this list contains all elements in the specified collection.
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) throw new NullPointerException("Collection cannot be null.");
        for (Object e : c) {
            if (!contains(e)) return false;
        }
        return true;
    }

    /**
     * Adds all elements in the specified collection to this list.
     *
     * @param c the collection containing elements to be added.
     * @return true if the list changed as a result of the call.
     */
    @Override
    public boolean addAll(Collection<? extends Coffee> c) {
        if (c == null) throw new NullPointerException("Collection of coffees cannot be null.");
        boolean modified = false;
        for (Coffee coffee : c) {
            if (coffee != null) {
                add(coffee);
                modified = true;
            }
        }
        return modified;
    }
    /**
     * Inserts all of the elements in the specified collection into this list,
     * starting at the specified position. Shifts the element currently at that
     * position (if any) and any subsequent elements to the right (optional operation).
     *
     * @param index the index at which to insert the first element from the specified collection
     * @param c the collection of Coffee elements to be inserted
     * @return true if the list changed as a result of the call.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     */
    @Override
    public boolean addAll(int index, Collection<? extends Coffee> c) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (c == null) throw new NullPointerException("Collection of coffees cannot be null.");
        boolean modified = false;
        for (Coffee coffee : c) {
            if (coffee != null) {
                add(index++, coffee);
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Removes from this list all elements that are contained in the specified collection.
     *
     * @param c collection containing elements to be removed from this list.
     * @return true if this list changed as a result of the call.
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) throw new NullPointerException("Collection cannot be null.");
        boolean modified = false;
        for (Object e : c) {
            modified |= remove(e);
        }
        return modified;
    }

    /**
     * Retains only the elements in this list that are contained in the specified collection.
     *
     * @param c collection containing elements to be retained in this list.
     * @return true if this list changed as a result of the call.
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) throw new NullPointerException("Collection cannot be null.");
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(elements[i])) {
                remove(i--);
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Removes all elements from the CoffeeList, leaving it empty.
     */
    @Override
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    /**
     * Retrieves the Coffee element at the specified index in the list.
     *
     * @param index the index of the Coffee element to retrieve
     * @return the Coffee element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    @Override
    public Coffee get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return elements[index];
    }

    /**
     * Replaces the Coffee element at the specified index with the specified element.
     *
     * @param index the index of the element to replace
     * @param element the Coffee element to be stored at the specified index
     * @return the Coffee element previously at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    @Override
    public Coffee set(int index, Coffee element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (element == null) throw new NullPointerException("Coffee cannot be null.");
        Coffee oldValue = elements[index];
        elements[index] = element;
        return oldValue;
    }

    /**
     * Inserts the specified Coffee element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right.
     *
     * @param index the index at which the specified element is to be inserted
     * @param element the Coffee element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     */
    @Override
    public void add(int index, Coffee element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (element == null) throw new NullPointerException("Coffee cannot be null.");
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }
    /**
     * Removes the Coffee element at the specified position in this list.
     * Shifts any subsequent elements to the left.
     *
     * @param index the index of the element to be removed
     * @return the Coffee element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    @Override
    public Coffee remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Coffee removed = elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) System.arraycopy(elements, index + 1, elements, index, numMoved);
        elements[--size] = null;
        return removed;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param o the element to search for
     * @return the index of the first occurrence of the specified element, or -1 if not found
     */
    @Override
    public int indexOf(Object o) {
        if (o == null) return -1;
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) return i;
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param o the element to search for
     * @return the index of the last occurrence of the specified element, or -1 if not found
     */
    @Override
    public int lastIndexOf(Object o) {
        if (o == null) return -1;
        for (int i = size - 1; i >= 0; i--) {
            if (o.equals(elements[i])) return i;
        }
        return -1;
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence).
     *
     * @return a ListIterator over the elements in this list
     */
    @Override
    public ListIterator<Coffee> listIterator() {
        return new ListIterator<Coffee>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public Coffee next() {
                if (!hasNext()) throw new NoSuchElementException();
                return elements[currentIndex++];
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > 0;
            }

            @Override
            public Coffee previous() {
                if (!hasPrevious()) throw new NoSuchElementException();
                return elements[--currentIndex];
            }

            @Override
            public int nextIndex() {
                return currentIndex;
            }

            @Override
            public int previousIndex() {
                return currentIndex - 1;
            }

            @Override
            public void remove() {
                if (currentIndex <= 0) throw new IllegalStateException();
                CoffeeList.this.remove(--currentIndex);
            }

            @Override
            public void set(Coffee e) {
                if (currentIndex <= 0) throw new IllegalStateException();
                CoffeeList.this.set(currentIndex - 1, e);
            }

            @Override
            public void add(Coffee e) {
                CoffeeList.this.add(currentIndex++, e);
            }
        };
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence),
     * starting at the specified position in this list.
     *
     * @param index the index of the element to start the iterator at
     * @return a ListIterator over the elements in this list starting at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     */
    @Override
    public ListIterator<Coffee> listIterator(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        return new ListIterator<Coffee>() {
            private int currentIndex = index;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public Coffee next() {
                if (!hasNext()) throw new NoSuchElementException();
                return elements[currentIndex++];
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > 0;
            }

            @Override
            public Coffee previous() {
                if (!hasPrevious()) throw new NoSuchElementException();
                return elements[--currentIndex];
            }

            @Override
            public int nextIndex() {
                return currentIndex;
            }

            @Override
            public int previousIndex() {
                return currentIndex - 1;
            }

            @Override
            public void remove() {
                if (currentIndex <= 0) throw new IllegalStateException();
                CoffeeList.this.remove(--currentIndex);
            }

            @Override
            public void set(Coffee e) {
                if (currentIndex <= 0) throw new IllegalStateException();
                CoffeeList.this.set(currentIndex - 1, e);
            }

            @Override
            public void add(Coffee e) {
                CoffeeList.this.add(currentIndex++, e);
            }
        };
    }

    /**
     * Returns a view of the portion of this list between the specified fromIndex,
     * inclusive, and toIndex, exclusive. (If fromIndex and toIndex are equal,
     * the returned list is empty.) The returned list is backed by this list,
     * so changes in the returned list are reflected in this list, and vice-versa.
     *
     * @param fromIndex index of the first element (inclusive) in the sublist
     * @param toIndex index of the last element (exclusive) in the sublist
     * @return a view of the specified range within this list
     * @throws IndexOutOfBoundsException if the specified indices are out of range
     *         (fromIndex < 0 || toIndex > size || fromIndex > toIndex)
     */
    @Override
    public List<Coffee> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        CoffeeList subList = new CoffeeList();
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(elements[i]);
        }
        return subList;
    }

}
