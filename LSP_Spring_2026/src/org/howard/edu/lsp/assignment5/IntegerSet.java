package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * IntegerSet represents a mathematical set of integers with no duplicates, 
 * which supports standard set operations.
 */

public class IntegerSet {

    private ArrayList<Integer> set = new ArrayList<>();

    /**
     * Removes all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return the size of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Compares this set with another IntegerSet for equality.
     * Two sets are equal if they contain exactly the same elements.
     *
     * @param b the other IntegerSet to compare
     * @return true if both sets contain the same elements, false otherwise
     */
    public boolean equals(IntegerSet b) {
        ArrayList<Integer> aList = new ArrayList<>(set);
        ArrayList<Integer> bList = new ArrayList<>(b.set);

        Collections.sort(aList);
        Collections.sort(bList);

        return aList.equals(bList);
    }

    /**
     * Checks whether the set contains a given value.
     *
     * @param value the value to search for
     * @return true if the value is in the set, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest value in the set.
     *
     * @return the largest integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest value in the set.
     *
     * @return the smallest integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if it is not already present.
     *
     * @param item the integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it exists.
     *
     * @param item the integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new set that is the union of this set and another set.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet containing all unique elements from both sets
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        result.set.addAll(this.set);

        for (int num : intSetb.set) {
            if (!result.set.contains(num)) {
                result.set.add(num);
            }
        }

        return result;
    }

    /**
     * Returns a new set containing only the elements common to this set
     * and another set.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet containing the intersection of both sets
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int num : this.set) {
            if (intSetb.set.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }

    /**
     * Returns a new set containing elements that are in this set
     * but not in the other set.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet containing the difference of the sets
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int num : this.set) {
            if (!intSetb.set.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }

    /**
     * Returns a new set containing elements that are in the other set
     * but not in this set.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet containing the complement of this set in the other set
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int num : intSetb.set) {
            if (!this.set.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }

    /**
     * Checks whether the set is empty.
     *
     * @return true if the set has no elements, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set in ascending order.
     *
     * @return the set as a sorted string in bracket format
     */
    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}