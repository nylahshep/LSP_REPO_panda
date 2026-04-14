package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {

    @Test
    public void testClearNormal() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.clear();
        assertEquals(0, set.length());
    }

    @Test
    public void testClearEdgeAlreadyEmpty() {
        IntegerSet set = new IntegerSet();
        set.clear();
        assertTrue(set.isEmpty());
    }

    @Test
    public void testLengthNormal() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        assertEquals(3, set.length());
    }

    @Test
    public void testLengthEdgeEmpty() {
        IntegerSet set = new IntegerSet();
        assertEquals(0, set.length());
    }

    @Test
    public void testEqualsNormalSameElements() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(1);
        set2.add(2);
        set2.add(3);

        assertTrue(set1.equals(set2));
    }

    @Test
    public void testEqualsEdgeDifferentOrder() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(1);
        set2.add(2);

        assertTrue(set1.equals(set2));
    }

    @Test
    public void testEqualsMismatch() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(1);
        set2.add(3);

        assertFalse(set1.equals(set2));
    }

    @Test
    public void testContainsNormalPresent() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(10);
        assertTrue(set.contains(5));
    }

    @Test
    public void testContainsEdgeAbsent() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(10);
        assertFalse(set.contains(99));
    }

    @Test
    public void testLargestNormal() {
        IntegerSet set = new IntegerSet();
        set.add(4);
        set.add(9);
        set.add(2);
        assertEquals(9, set.largest());
    }

    @Test
    public void testLargestEdgeSingleElement() {
        IntegerSet set = new IntegerSet();
        set.add(7);
        assertEquals(7, set.largest());
    }

    @Test
    public void testLargestExceptionEmpty() {
        IntegerSet set = new IntegerSet();
        assertThrows(RuntimeException.class, () -> {
            set.largest();
        });
    }

    @Test
    public void testSmallestNormal() {
        IntegerSet set = new IntegerSet();
        set.add(4);
        set.add(9);
        set.add(2);
        assertEquals(2, set.smallest());
    }

    @Test
    public void testSmallestEdgeSingleElement() {
        IntegerSet set = new IntegerSet();
        set.add(7);
        assertEquals(7, set.smallest());
    }

    @Test
    public void testSmallestExceptionEmpty() {
        IntegerSet set = new IntegerSet();
        assertThrows(RuntimeException.class, () -> {
            set.smallest();
        });
    }

    @Test
    public void testAddNormal() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        assertTrue(set.contains(5));
    }

    @Test
    public void testAddEdgeDuplicateValues() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(5);
        assertEquals(1, set.length());
    }

    @Test
    public void testRemoveNormal() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(10);
        set.remove(5);
        assertFalse(set.contains(5));
        assertEquals(1, set.length());
    }

    @Test
    public void testRemoveEdgeValueNotPresent() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.remove(99);
        assertEquals(1, set.length());
        assertTrue(set.contains(5));
    }

    @Test
    public void testUnionNormal() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(2);
        set2.add(3);

        set1.union(set2);

        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        assertEquals(3, set1.length());
    }

    @Test
    public void testUnionEdgeWithEmptySet() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet emptySet = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set1.union(emptySet);

        assertEquals("[1, 2]", set1.toString());
    }

    @Test
    public void testIntersectNormal() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(2);
        set2.add(3);
        set2.add(4);

        set1.intersect(set2);

        assertEquals(2, set1.length());
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
    }

    @Test
    public void testIntersectEdgeNoCommonElements() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(3);
        set2.add(4);

        set1.intersect(set2);

        assertTrue(set1.isEmpty());
    }

    @Test
    public void testDiffNormal() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(2);

        set1.diff(set2);

        assertTrue(set1.contains(1));
        assertTrue(set1.contains(3));
        assertFalse(set1.contains(2));
    }

    @Test
    public void testDiffEdgeIdenticalSets() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(1);
        set2.add(2);

        set1.diff(set2);

        assertTrue(set1.isEmpty());
    }

    @Test
    public void testComplementNormal() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(2);
        set2.add(4);

        set1.complement(set2);

        assertEquals("[4]", set1.toString());
    }

    @Test
    public void testComplementEdgeDisjointSets() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(3);
        set2.add(4);

        set1.complement(set2);

        assertEquals("[3, 4]", set1.toString());
    }

    @Test
    public void testIsEmptyNormalEmpty() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());
    }

    @Test
    public void testIsEmptyEdgeNonEmpty() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        assertFalse(set.isEmpty());
    }

    @Test
    public void testToStringNormal() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(1);
        set.add(2);
        assertEquals("[1, 2, 3]", set.toString());
    }

    @Test
    public void testToStringEdgeEmptySet() {
        IntegerSet set = new IntegerSet();
        assertEquals("[]", set.toString());
    }
}