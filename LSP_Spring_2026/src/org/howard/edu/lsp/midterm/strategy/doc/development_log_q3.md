EXPLAIN SIM PLY: Question 3 - Refactoring to Use a Design Pattern (30 points)
The following class calculates final prices for customer purchases. Although the code works, the design makes the system difficult to extend and maintain. Study the code carefully and answer the questions that follow.
Provided Class

package org.howard.edu.lsp.midterm.strategy;

public class PriceCalculator {

    public double calculatePrice(String customerType, double price) {

        double finalPrice = price;

        if (customerType.equals("REGULAR")) {
            finalPrice = price;
        }

        if (customerType.equals("MEMBER")) {
            finalPrice = price * 0.90;
        }

        if (customerType.equals("VIP")) {
            finalPrice = price * 0.80;
        }

        if (customerType.equals("HOLIDAY")) {
            finalPrice = price * 0.85;
        }

        return finalPrice;
    }
}

Part 1 - Design Evaluation (8 points)
Evaluate the design of the PriceCalculator class. Explain why the current implementation may lead to maintenance or extensibility problems as the system evolves.
Your answer must be written in a Markdown file named: design_evaluation.md
Place the file in the package:
org.howard.edu.lsp.midterm.strategy.doc
Part 2 - Refactoring Using a Design Pattern (10 points)
Refactor the provided design to use the Strategy Pattern discussed during lecture.
Your refactored implementation must be placed in the package:
org.howard.edu.lsp.midterm.strategy
Each class must be placed in its own .java file. Your implementation should demonstrate the use of the Strategy design pattern to support different discount behaviors.
All classes and public methods must include Javadoc comments.
Part 3 - Driver Program (5 points)
Create a Driver class that demonstrates that your Strategy Pattern implementation works correctly.
Your Driver class must be placed in the package:
org.howard.edu.lsp.midterm.strategy
Your driver must demonstrate the following cases using a purchase price of 100.0:
• REGULAR customer
• MEMBER customer
• VIP customer
• HOLIDAY customer
Your driver must produce output in the following format:
REGULAR: 100.0
MEMBER: 90.0
VIP: 80.0
HOLIDAY: 85.0
The output must be produced by executing your Strategy-based implementation, not by hardcoding the results.
Part 4 - Development Log (5 points)
Create a Markdown file named development_log_q3.md
Place the file in the package:
org.howard.edu.lsp.midterm.strategy.doc
This file must document any external resources used while completing this question, including AI tools, internet searches, documentation, lecture notes, or textbooks.
For each resource used, include what you searched or asked and how the information helped you complete the problem. If no external assistance was used, clearly state that in the file.
Grading Rubric (30 points)
Component	Points
Design evaluation (design_evaluation.md)	8
Correct refactoring using Strategy Pattern	10
Driver execution and required output	5
Javadoc documentation in classes and public methods	2
Development log documenting AI/internet use	5


Got you — let’s make this super simple and clear so you actually understand what’s going on.

🧠 Big Idea of Question 3

You are taking bad code and turning it into better design using a pattern (Strategy Pattern).

✅ First: What’s wrong with the current code?
Current logic:
if (customerType.equals("REGULAR")) { ... }
if (customerType.equals("MEMBER")) { ... }
if (customerType.equals("VIP")) { ... }
if (customerType.equals("HOLIDAY")) { ... }
❌ Problems (in simple terms):

Too many if-statements

Every new customer type → you must edit this class

Example: adding "STUDENT" → add another if

Not easy to extend

You keep modifying the same method over and over

Breaks good design principle

Code should be open for extension, closed for modification

This code is the opposite

Messy + hard to maintain

Imagine 10+ customer types 😬

💡 Solution: Strategy Pattern (SUPER SIMPLE)

Instead of one class doing everything, you:

👉 Create separate classes for each pricing strategy

🧱 How Strategy Pattern works (easy version)
Step 1: Create an interface

This is like a rule everyone must follow

public interface DiscountStrategy {
    double applyDiscount(double price);
}
Step 2: Create one class per customer type
REGULAR
public class RegularStrategy implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price;
    }
}
MEMBER
public class MemberStrategy implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.90;
    }
}
VIP
public class VIPStrategy implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.80;
    }
}
HOLIDAY
public class HolidayStrategy implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.85;
    }
}
Step 3: Update PriceCalculator

Now it does NOT use if-statements anymore

public class PriceCalculator {

    private DiscountStrategy strategy;

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculatePrice(double price) {
        return strategy.applyDiscount(price);
    }
}
🧪 Driver Program (what runs everything)
public class Driver {
    public static void main(String[] args) {

        PriceCalculator calculator = new PriceCalculator();

        calculator.setStrategy(new RegularStrategy());
        System.out.println("REGULAR: " + calculator.calculatePrice(100.0));

        calculator.setStrategy(new MemberStrategy());
        System.out.println("MEMBER: " + calculator.calculatePrice(100.0));

        calculator.setStrategy(new VIPStrategy());
        System.out.println("VIP: " + calculator.calculatePrice(100.0));

        calculator.setStrategy(new HolidayStrategy());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(100.0));
    }
}
🎯 Why this is better (super simple)
Old Way ❌	New Way ✅
Big messy if statements	Clean separate classes
Hard to add new types	Just add a new class
Must edit existing code	No need to touch old code
Not scalable	Very scalable
🧾 What you actually need to submit
✔ Part 1

Explain:

Too many if statements

Hard to extend

Violates good design principles

✔ Part 2

Create:

DiscountStrategy interface

4 strategy classes

Updated PriceCalculator

✔ Part 3

Driver that prints:

REGULAR: 100.0
MEMBER: 90.0
VIP: 80.0
HOLIDAY: 85.0
✔ Part 4

Write what resources you used (ChatGPT, notes, etc.)

🚀 One-line summary

👉 You are replacing if-statements with separate classes so your code is cleaner and easier to extend.

If you want, I can give you a copy-paste-ready full solution with all files + Javadoc so you can drop it straight into Eclipse.

am I redesigning the code given based on evlautiuon: Part 2 - Refactoring Using a Design Pattern (10 points)
Refactor the provided design to use the Strategy Pattern discussed during lecture.
Your refactored implementation must be placed in the package:
org.howard.edu.lsp.midterm.strategy
Each class must be placed in its own .java file. Your implementation should demonstrate the use of the Strategy design pattern to support different discount behaviors.
All classes and public methods must include Javadoc comments

Yes — exactly 👍

You are redesigning (refactoring) the given code based on the problems you identified in Part 1.

🧠 Simple Explanation
🔹 What “refactor” means

👉 You are rewriting the code in a better way
👉 BUT keeping the same functionality

So:

Input: customer type + price

Output: correct discounted price

✅ That part must stay the same
❗ Only the design/structure changes

🔄 What you are changing
❌ OLD design (given to you)

One class (PriceCalculator)

Uses a bunch of if statements

Hard to extend

✅ NEW design (what you must create)

You will:

Remove the if-statements

Use Strategy Pattern

Split logic into multiple classes

🧱 What you are building (clear checklist)

You are NOT editing just one file — you are creating multiple files:

✔ 1. Interface
DiscountStrategy.java
✔ 2. Strategy Classes (each in its own file)

RegularStrategy.java

MemberStrategy.java

VIPStrategy.java

HolidayStrategy.java

Each one handles ONE type of discount

✔ 3. Updated PriceCalculator

Uses a strategy instead of if statements

✔ 4. Driver class

Tests everything

📦 Important Requirement

“Each class must be placed in its own .java file”

So your folder will look like:

org/howard/edu/lsp/midterm/strategy/
    DiscountStrategy.java
    RegularStrategy.java
    MemberStrategy.java
    VIPStrategy.java
    HolidayStrategy.java
    PriceCalculator.java
    Driver.java
🧾 Javadoc Requirement

Every class + method needs comments like:

/**
 * Applies discount to a price.
 * @param price original price
 * @return discounted price
 */
🎯 BIG PICTURE
Part	What you're doing
Part 1	Explain what’s wrong
Part 2	FIX it using Strategy Pattern
Part 3	Prove it works (Driver)
Part 4	Say what resources you used
🚀 One sentence answer to your question

👉 Yes — you are redesigning the given code based on your evaluation, using the Strategy Pattern to fix its problems.

If you want, I can:
✅ Check your implementation
✅ Or give you a perfect full solution (all files + Javadoc)

Just tell me 👍

can u give example

Yes — here’s a clean, simple full example of how your Strategy Pattern solution should look. You can literally use this as a model.

📁 1. DiscountStrategy.java (interface)
package org.howard.edu.lsp.midterm.strategy;

/**
 * Interface for discount strategies.
 */
public interface DiscountStrategy {

    /**
     * Applies a discount to the given price.
     * @param price the original price
     * @return the discounted price
     */
    double applyDiscount(double price);
}
📁 2. RegularStrategy.java
package org.howard.edu.lsp.midterm.strategy;

/**
 * No discount for regular customers.
 */
public class RegularStrategy implements DiscountStrategy {

    /**
     * Returns the original price.
     * @param price the original price
     * @return the same price
     */
    public double applyDiscount(double price) {
        return price;
    }
}
📁 3. MemberStrategy.java
package org.howard.edu.lsp.midterm.strategy;

/**
 * 10% discount for members.
 */
public class MemberStrategy implements DiscountStrategy {

    /**
     * Applies 10% discount.
     * @param price the original price
     * @return discounted price
     */
    public double applyDiscount(double price) {
        return price * 0.90;
    }
}
📁 4. VIPStrategy.java
package org.howard.edu.lsp.midterm.strategy;

/**
 * 20% discount for VIP customers.
 */
public class VIPStrategy implements DiscountStrategy {

    /**
     * Applies 20% discount.
     * @param price the original price
     * @return discounted price
     */
    public double applyDiscount(double price) {
        return price * 0.80;
    }
}
📁 5. HolidayStrategy.java
package org.howard.edu.lsp.midterm.strategy;

/**
 * 15% discount for holiday customers.
 */
public class HolidayStrategy implements DiscountStrategy {

    /**
     * Applies 15% discount.
     * @param price the original price
     * @return discounted price
     */
    public double applyDiscount(double price) {
        return price * 0.85;
    }
}
📁 6. PriceCalculator.java (refactored)
package org.howard.edu.lsp.midterm.strategy;

/**
 * Calculates price using a discount strategy.
 */
public class PriceCalculator {

    private DiscountStrategy strategy;

    /**
     * Sets the discount strategy.
     * @param strategy the discount strategy
     */
    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates final price using the selected strategy.
     * @param price the original price
     * @return the final price
     */
    public double calculatePrice(double price) {
        return strategy.applyDiscount(price);
    }
}
📁 7. Driver.java (TEST PROGRAM)
package org.howard.edu.lsp.midterm.strategy;

/**
 * Driver class to test pricing strategies.
 */
public class Driver {

    public static void main(String[] args) {

        PriceCalculator calculator = new PriceCalculator();

        calculator.setStrategy(new RegularStrategy());
        System.out.println("REGULAR: " + calculator.calculatePrice(100.0));

        calculator.setStrategy(new MemberStrategy());
        System.out.println("MEMBER: " + calculator.calculatePrice(100.0));

        calculator.setStrategy(new VIPStrategy());
        System.out.println("VIP: " + calculator.calculatePrice(100.0));

        calculator.setStrategy(new HolidayStrategy());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(100.0));
    }
}
✅ Expected Output
REGULAR: 100.0
MEMBER: 90.0
VIP: 80.0
HOLIDAY: 85.0
🧠 Why this works (quick recap)

Each discount = its own class

No more if statements ❌

Easy to add new types later ✅

Just create a new class like StudentStrategy

If you want, I can also:
✅ Help you write the design_evaluation.md
✅ Or check your code before you submit

Just send it 👍