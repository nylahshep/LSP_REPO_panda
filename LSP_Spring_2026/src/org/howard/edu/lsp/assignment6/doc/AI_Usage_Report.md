please explain and walk me through: CSCI 363 / CSCI 540 – Assignment 6: IntegerSet JUnit Testing
Due: April 14, 2026 by 6PM

Overview
In Assignment 5, you implemented a Java class called IntegerSet.

In this assignment, you will copy your Assignment 5 implementation into a new package and write JUnit 5 test cases to verify correctness. This assignment focuses on testing completeness and correctness.
Important Requirements
•	Copy your Assignment 5 IntegerSet.java into the Assignment 6 package
•	Write JUnit 5 test cases for every method
•	Do NOT use Driver.java
•	Your code and tests must compile and run
•	If your code does not compile or tests do not run, the assignment grade is 0
Required Package Structure (STRICT)
src/org/howard/edu/lsp/assignment6/IntegerSet.java
src/org/howard/edu/lsp/assignment6/IntegerSetTest.java
package org.howard.edu.lsp.assignment6;
Test Coverage Requirement (STRICT)
Each method must include BOTH:
1.	1. Normal case
2.	2. Edge case(s)
Required Edge Cases
•	add(): duplicate values
•	remove(): value not present
•	equals(): same elements different order
•	union(): with empty set
•	intersect(): no common elements
•	diff(): identical sets
•	complement(): disjoint sets
•	contains(): value not present
•	isEmpty(): empty vs non-empty
•	toString(): empty set
•	largest(): single element + empty (exception)
•	smallest(): single element + empty (exception)
JUnit Requirements
Use JUnit 5 and include assertions such as (but not limited to):
•	assertEquals
•	assertTrue
•	assertFalse
•	assertThrows
toString() Requirement
Format must be exactly:
[1, 2, 3]
AI Usage and External References
Submit AI_Usage_Report.md in org/howard/edu/lsp/assignment6/doc/
If nothing used: "nothing used"
Grading Rubric
Category	Points
clear() (normal + edge)	5
length() (normal + edge)	5
equals() (order + mismatch)	10
contains() (present + absent)	5
largest() (normal + exception)	5
smallest() (normal + exception)	5
add() (normal + duplicate)	5
remove() (normal + missing)	5
union() (normal + empty)	10
intersect() (normal + no overlap)	10
diff() (normal + identical)	10
complement() (normal + disjoint)	5
isEmpty() (empty + non-empty)	5
toString() (normal + empty)	5
Exception tests	5
AI_Usage_Report.md	10

Total: 100 points
how to push work from assigment 5 to 6 and what needs to change
Good question — this is the last conceptual piece you need to fully understand 

You’re basically asking:

“What exactly did I move from Assignment 5 → Assignment 6, and what did I have to change?”
🧠 Big picture (super simple)
Assignment 5 = implementation

You built:

IntegerSet.java
Assignment 6 = testing

You:

copied that same class
modified it slightly
added JUnit tests
🔁 What you “pushed” from 5 → 6
✅ You copied this file:
assignment5/IntegerSet.java

into:

assignment6/IntegerSet.java

NOT moved — copied

🔧 What needed to change
1. Package name (REQUIRED)
Assignment 5:
package org.howard.edu.lsp.assignment5;
Assignment 6:
package org.howard.edu.lsp.assignment6;
2. Method behavior change (VERY IMPORTANT)

Your original Assignment 5 methods returned new sets:

public IntegerSet union(IntegerSet intSetb) {
    return result;
}
❌ That does NOT work for Assignment 6 tests

Your tests expect:

set1.union(set2); // modifies set1
✅ So you changed them to VOID methods
BEFORE (Assignment 5 style)
public IntegerSet union(IntegerSet intSetb)
AFTER (Assignment 6 style)
public void union(IntegerSet intSetb)
Same change for these methods:

You updated all of these:

union()
intersect()
diff()
complement()

👉 Instead of returning a new set, they now:

modify this.set
return nothing (void)
3. No Driver.java

Assignment 5 used:

Driver.java

Assignment 6:

DO NOT USE Driver.java ❌

You replaced that with:

IntegerSetTest.java ✅
4. Added JUnit testing

This is the main difference

You created:

IntegerSetTest.java

And tested:

every method
normal cases
edge cases
exceptions
5. Added AI report

New requirement in Assignment 6:

doc/AI_Usage_Report.md
📦 What you should push to GitHub

Only this:

src/
  org/howard/edu/lsp/assignment6/
      IntegerSet.java
      IntegerSetTest.java
      doc/
          AI_Usage_Report.md
🚀 How to push in Eclipse (quick steps)

If you haven’t pushed yet:

Open Git Staging tab
Drag:
assignment6 files → Staged Changes

Add commit message:

Assignment 6 - IntegerSet JUnit Testing
Click:
👉 Commit and Push
🧠 Final summary
You did 3 main things:

Copied code

assignment5 → assignment6
Modified behavior
changed set operations to void
made them modify current set
Added testing
JUnit file
edge cases
exception tests
how would that code be constructed
Like this:

Assignment 5 version

Your Assignment 5 code was built so the set operations return a new IntegerSet.

Example idea:

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

That means:

this stays the same
a new object is created
that new object gets returned

So you would use it like:

IntegerSet c = a.union(b);
Assignment 6 version

For Assignment 6, the tests were constructed to use methods like this:

set1.union(set2);

So the method has to change set1 itself.

That means the method should be:

public void union(IntegerSet intSetb) {
    for (int num : intSetb.set) {
        if (!this.set.contains(num)) {
            this.set.add(num);
        }
    }
}

Now:

no new IntegerSet result is returned
the current object is updated directly
return type becomes void
The pattern for all 4 set-operation methods
1. union

Take everything from the other set that is not already in this set.

public void union(IntegerSet intSetb) {
    for (int num : intSetb.set) {
        if (!this.set.contains(num)) {
            this.set.add(num);
        }
    }
}
2. intersect

Keep only values that appear in both sets.

public void intersect(IntegerSet intSetb) {
    ArrayList<Integer> result = new ArrayList<>();

    for (int num : this.set) {
        if (intSetb.set.contains(num)) {
            result.add(num);
        }
    }

    this.set = result;
}

Why use result first?

Because if you remove from this.set while looping through it, Java can act weird or throw errors. So you build a new list, then replace the old one.

3. diff

Keep values in this.set that are not in the other set.

public void diff(IntegerSet intSetb) {
    ArrayList<Integer> result = new ArrayList<>();

    for (int num : this.set) {
        if (!intSetb.set.contains(num)) {
            result.add(num);
        }
    }

    this.set = result;
}
4. complement

For your assignment setup, this was treated as:
take elements in intSetb that are not in this set, then replace this set with that result.

public void complement(IntegerSet intSetb) {
    ArrayList<Integer> result = new ArrayList<>();

    for (int num : intSetb.set) {
        if (!this.set.contains(num)) {
            result.add(num);
        }
    }

    this.set = result;
}
Full structure idea

So the Assignment 6 IntegerSet.java is basically:

package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;

public class IntegerSet {
    private ArrayList<Integer> set = new ArrayList<>();

    public void clear() {
        set.clear();
    }

    public int length() {
        return set.size();
    }

    public boolean equals(IntegerSet b) {
        ArrayList<Integer> aList = new ArrayList<>(set);
        ArrayList<Integer> bList = new ArrayList<>(b.set);

        Collections.sort(aList);
        Collections.sort(bList);

        return aList.equals(bList);
    }

    public boolean contains(int value) {
        return set.contains(value);
    }

    public int largest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.max(set);
    }

    public int smallest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.min(set);
    }

    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    public void union(IntegerSet intSetb) {
        for (int num : intSetb.set) {
            if (!this.set.contains(num)) {
                this.set.add(num);
            }
        }
    }

    public void intersect(IntegerSet intSetb) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : this.set) {
            if (intSetb.set.contains(num)) {
                result.add(num);
            }
        }

        this.set = result;
    }

    public void diff(IntegerSet intSetb) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : this.set) {
            if (!intSetb.set.contains(num)) {
                result.add(num);
            }
        }

        this.set = result;
    }

    public void complement(IntegerSet intSetb) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : intSetb.set) {
            if (!this.set.contains(num)) {
                result.add(num);
            }
        }

        this.set = result;
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}
The main construction idea

The code is constructed around this field:

private ArrayList<Integer> set = new ArrayList<>();

Every method works on that one list.

add() adds to it
remove() removes from it
contains() checks it
largest() and smallest() scan it
union/intersect/diff/complement update it
toString() sorts a copy of it for display